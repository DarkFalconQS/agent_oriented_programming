/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import inventory.InventoryItem;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @todo Order Picker afmaken
 *
 */
public class OrderPickerAgent extends Agent {

    private ArrayList<ArrayList> m_orderList;
    private ArrayList<InventoryItem> m_items;

    protected void setup() {
        addBehaviour(new OrderPickerAgent.MyBehaviour(this));
    }

    public ArrayList getOrderList() {
        return m_orderList;
    }

    public void setOrderList(ArrayList orderList) {
        this.m_orderList = orderList;
    }

    public OrderPickerAgent(ArrayList list) {
        m_orderList = new ArrayList();
        if (list != null) {
            m_orderList.add(list);
        }
    }
    
    public OrderPickerAgent() {
        m_orderList = new ArrayList();
    }

    public class MyBehaviour extends CyclicBehaviour {

        private Agent m_a;
        private String m_msg;
        private String[] content_list;

        public MyBehaviour(Agent a) {
            super(a);
            m_a = a;
        }

        @Override
        public void action() {
            ACLMessage msg = m_a.receive();
            if (msg != null) {

                if (msg.getPerformative() == ACLMessage.PROPOSE) {
                    try {
                        if (!msg.getContent().isEmpty()) {
                            String content = msg.getContent();
                            try {

                                content_list = content.split("Name: ");
                                content_list = content_list[1].split(", Amount: ");

                                InventoryItem item = new InventoryItem(content_list[0], Integer.parseInt(content_list[1]), 0); //0 word Size?
                            } catch (Exception exc) {
                                System.out.println("RackAgent: Error > " + exc.toString());
                                done();
                            }
                            // System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());
                        } else {
                            System.out.println("RackAgent: ProposeMessage is Empty!");
                            done();
                        }
                    } catch (NullPointerException exc) {
                        System.out.println("RackAgent: Error " + exc.toString());
                        done();
                    }
                }
                if (msg.getPerformative() == ACLMessage.QUERY_IF) {

                    /* if (!getItems().isEmpty()) {
                     InventoryItem item = m_items.get(0); // This gets the first element of the list, the one we just added
                     //System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());

                     } else {
                     ACLMessage order = new ACLMessage(ACLMessage.INFORM_IF);
                     order.addReceiver(msg.getSender());
                     order.setContent("ANSWER: FALSE");
                     m_a.send(order);
                     System.out.println("Empty m_items");
                     } */
                }
                msg.setReplyWith("Hi " + msg.getSender() + " from " + getLocalName());
                m_a.send(msg);
                done();
            }
            block();
        }
    }

}

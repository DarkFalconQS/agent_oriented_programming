/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import inventory.InventoryItem;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 *
 * @todo Order Picker afmaken
 *
 */
public class OrderPickerAgent extends Agent {

    private ArrayList<ArrayList> m_orderList;
    private ArrayList<InventoryItem> m_items;
    public Behaviour orderBehaviour;
    private String[] content_list;

    protected void setup() {
        //addBehaviour(new AvailableBehaviour(this, 2, this.getAID()));
    }

    public ArrayList getOrderList() {
        return m_orderList;
    }

    public void setOrderList(ArrayList orderList) {
        this.m_orderList = orderList;
    }

    public OrderPickerAgent() {
        m_orderList = new ArrayList();
        m_items = new ArrayList();
        CreateOrder orderGui = new CreateOrder(this);
        orderGui.setVisible(true);
        Test test = new Test(getOrderList(), this, orderGui);
        test.run();
    }

    public void checkMessage(String content) {
        try {
            m_items.clear();
            String[] splitString = content.split(";");
            for (int i = 0; i < splitString.length - 1; i++) {
                content_list = splitString[i].split("Name: ");
                content_list = content_list[1].split(", Amount: ");
                String name = content_list[0].trim();
                int amount = Integer.parseInt(content_list[1].trim());
                InventoryItem item = new InventoryItem(name, amount, 0);
                m_items.add(item);
            }
            m_orderList.add(m_items);
        } catch (Exception exc) {
            System.out.println("OrderPickerAgent: Error 1 > " + exc.toString());
        }
    }

    private class Test implements Runnable {

        ArrayList<ArrayList> orderList;
        private Agent agent;
        private CreateOrder orderGui;

        Test(ArrayList list, Agent a, CreateOrder orderGui) {
            this.orderList = list;
            this.agent = a;
            this.orderGui = orderGui;
        }

        @Override

        public void run() {
                ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
                msg.addReceiver(new AID("Global", AID.ISLOCALNAME));
                agent.send(msg);

            while (true) {

                //ACLMessage message = agent.receive();
                //if (message != null) {
                    //if (message.getPerformative() == ACLMessage.INFORM) {
                //        orderGui.fillComboBox(message);
                    //}
                //}

                if (orderList.size() >= 0) {
                    while (orderList.isEmpty() == false) {
                        int itemCount = orderList.get(0).size();
                        for (int i = 0; i < itemCount; i++) {
                            //get item i

                            //report available items
                        }
                        // if all items packed:
                        // remove order list, since we are done!
                        orderList.remove(0);
                    }
                }
            }
        }

    }
}

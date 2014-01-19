/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

//import behaviours.PutBehaviour;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.*;

/**
 *
 * @author Nico en Michaël
 * @todo Externe Behaviors ?
 */
public class RackAgent extends Agent {

    private int m_route;
    private String m_name;
    private ArrayList<InventoryItem> m_items;
    private int m_slots;

    @Override
    public void setup() {

    //ArrayList lol = new ArrayList<>();
        // lol.add(new InventoryItem("Xbox", 5000, 0));
        //setItems(lol);
        addBehaviour(new MyBehaviour(this));
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
                                addItem(item);
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

                    if (!getItems().isEmpty()) {
                        InventoryItem item = reqItem(msg.getContent());
                        //InventoryItem item = m_items.get(0); // This gets the first element of the list, the one we just added
                        System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());
                        // putBehaviour(new PutBehaviour(,item, msg.getSender()));
                        //todo, fix externe behaviors
                        
                    } else {
                        ACLMessage order = new ACLMessage(ACLMessage.INFORM_IF);
                        order.addReceiver(msg.getSender());
                        order.setContent("ANSWER: FALSE");
                        m_a.send(order);
                        System.out.println("Empty m_items");
                    }

                }
                msg.setReplyWith("Hi " + msg.getSender() + " from " + getLocalName());
                m_a.send(msg);
                done();
            }
            block();
        }

        private InventoryItem reqItem(String content) {
            Iterator<InventoryItem> items = m_items.iterator();
         while (m_items.iterator().hasNext()){
      System.out.println(flavoursIter.next());
    }
            content.split("Name: ")
        }
    }

    public RackAgent() {
        m_name = "name";
        m_items = new ArrayList<>();
        m_route = 1;
    }

    public int getRoute() {
        return m_route;
    }

    public void setRoute(int route) {
        this.m_route = route;
    }

    public String getMyName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public int getSlots() {
        return m_slots;
    }

    public void setSlots(int slots) {
        this.m_slots = slots;
    }

    public ArrayList<InventoryItem> getItems() {
        return m_items;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.m_items = items;
    }

    public void addItem(InventoryItem item) {
        this.m_items.add(item);
    }

    // report item when amount is less then 50% of size
    private void checkItems() {
        for (InventoryItem item : m_items) {
            if ((item.getSize() / 2) > item.getAmount()) {
                reportItem();
            }
        }
    }

    private void reportItem() {

    }
}

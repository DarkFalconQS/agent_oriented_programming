/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michaël
 */
public class RackAgent extends Agent {

    private int m_route;
    private String m_name;
    private ArrayList<InventoryItem> m_items;
    private int m_slots;

    public void setup() {
        addBehaviour(new MyBehaviour(this));
    }

    public class MyBehaviour extends CyclicBehaviour {

        private Agent m_a;
        private String m_msg;

        public MyBehaviour(Agent a) {
            super(a);
            m_a = a;
        }

        public void action() {
            ACLMessage msg = m_a.receive();
            if (msg != null) {
                System.out.println(" - "
                        + getLocalName() + " <- "
                        + msg.getContent()
                );
                m_msg = msg.getContent();
                if (m_msg == "Connection working!") {
                    sendACLMessage("Hi " + msg.getSender() + " from " + getLocalName());
                }
            }
            block();
        }
    }

    public void sendACLMessage(String content) {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setContent(content);

        msg.addReceiver(new AID("Global", AID.ISLOCALNAME));
        this.send(msg);
    }

    public RackAgent() {
        m_name = "name";
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

    private void checkItems() {

    }

    private void reportItem() {

    }
}

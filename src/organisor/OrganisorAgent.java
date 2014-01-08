/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package organisor;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import inventory.InventoryItem;
import jade.core.Agent;
import java.util.ArrayList;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michaël
 */
public class OrganisorAgent extends Agent {
  private int m_slots;
  private ArrayList<InventoryItem> m_items;

  protected void setup() {
    addBehaviour( new MyBehaviour (this) );
  }

  private void getItem() {

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
    m_items.add(item);
  }

  private void findNewLocation() {

  }
public class MyBehaviour extends SimpleBehaviour {
        private Agent m_a;
        
        public MyBehaviour(Agent a) {
            super(a);
            m_a = a;
        }

        public void action() {
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContent("Connection working!");

            //for (int i = 1; i <= 2; i++) {
                msg.addReceiver(new AID("Items:" + OrganisorAgent.class.getName() , AID.ISLOCALNAME));
            //}
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrganisorAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
            m_a.send(msg);
        }

        private boolean finished = false;

        public boolean done() {
            return finished;
        }
    }
    
}

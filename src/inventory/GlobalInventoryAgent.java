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
import java.util.ArrayList;

/**
 *
 * @author Michaël
 */
public class GlobalInventoryAgent extends Agent {

    private ArrayList<RackAgent> m_racks;

    public GlobalInventoryAgent() {
        m_racks = new ArrayList<>();
    }

    protected void setup() {
        addBehaviour( new MyBehaviour (this) );
    }

    public ArrayList<RackAgent> getRacks() {
        return m_racks;
    }

    public void setRacks(ArrayList<RackAgent> racks) {
        this.m_racks = racks;
    }

    public void getInventory() {
        /*yet to be determined what it returns*/
    }

    public void getRackAgents() {
        /* check for all available rack agents */
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

            for (int i = 1; i <= 2; i++) {
                msg.addReceiver(new AID("Rack" + i, AID.ISLOCALNAME));
            }
            m_a.send(msg);
        }

        private boolean finished = false;

        public boolean done() {
            return finished;
        }
    }
}

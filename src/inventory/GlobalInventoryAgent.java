/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michaël
 */
public class GlobalInventoryAgent extends Agent {

  private ArrayList<RackAgent> m_racks;
  private ArrayList<InventoryItem> m_items;

  public GlobalInventoryAgent() {
    m_racks = new ArrayList<>();
  }

  protected void setup() {
    addBehaviour(new MyBehaviour(this));
  }

  public ArrayList<RackAgent> getRacks() {
    return m_racks;
  }

  public void setRacks(ArrayList<RackAgent> racks) {
    this.m_racks = racks;
  }

  public ArrayList<InventoryItem> getInventory() {
      return m_items;
  }

  public void getRackAgents() {
    /* check for all available rack agents */
  }

  public RackAgent getRackAgentFromItem(InventoryItem item){
      for (InventoryItem m_item : m_items) {
          if(m_item.equals(item)){
              return m_item.getLocation();
          }
      }
      return null;
  }

//    public void renderItems() {
//        InventoryItem item1 = enterItem("Refridgerator", 2, 2);
//        InventoryItem item2 = enterItem("Samsung USB 16GB", 50, 1);
//        InventoryItem item3 = enterItem("Philips Senseo", 8, 4);
//    }
  public InventoryItem enterItem(String name, int number_of, int size) {
    InventoryItem item = new InventoryItem(name, number_of, size);
    return item;
  }

  public class MyBehaviour extends SimpleBehaviour {

    private Agent m_a;
    private int step;
    private ACLMessage msg;

    public MyBehaviour(Agent a) {
      super(a);
      m_a = a;
      step = 0;
    }

    @Override
    public void action() {
      switch (step) {
	case 0:
	  msg = new ACLMessage(ACLMessage.INFORM);
	  InventoryItem item = enterItem("Samsung USB 16GB", 50, 1);
	  msg.setContent("Name: " + item.getItemName() + "; Amount: " + item.getAmount() + "; Size: " + item.getSize() + ";");

	  for (int i = 1; i <= 1; i++) {
	    msg.addReceiver(new AID("Rack" + i, AID.ISLOCALNAME));
	  }
	  try {
	    sleep(1000);
	  } catch (InterruptedException ex) {
	    Logger.getLogger(GlobalInventoryAgent.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  m_a.send(msg);
	  step = 1;

	case 1:
	  msg = m_a.receive();
	  if (msg != null) {
	    System.out.println(" - "
		+ getLocalName() + " <- "
		+ msg.getContent()
	    );
	  }
	  block();
         
        case 2:
            // get
            msg = new ACLMessage(ACLMessage.PROPOSE);
            msg.setContent(STATE_READY);
        case 3:
            // check
            msg = new ACLMessage(ACLMessage.REQUEST);
        case 4:
            // put
            msg = new ACLMessage(ACLMessage.CONFIRM);
        case 5:
            // available
            msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);

      }
    }

    private boolean finished = false;

    @Override
    public boolean done() {
      return finished;
    }
  }
}

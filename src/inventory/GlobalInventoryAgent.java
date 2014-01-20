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

public class GlobalInventoryAgent extends Agent {

  private ArrayList<RackAgent> m_racks;
  private ArrayList<InventoryItem> m_items;

  public GlobalInventoryAgent() {
    m_racks = new ArrayList<>();
  }

  protected void setup() {
    renderItems();
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

  public RackAgent getRackAgentFromItem(InventoryItem item) {
    for (InventoryItem m_item : m_items) {
      if (m_item.equals(item)) {
	return m_item.getLocation();
      }
    }
    return null;
  }

  public boolean checkItem(inventory.InventoryItem item) {
    for (inventory.InventoryItem m_item : m_items) {
      if (m_item.getItemName() == item.getItemName()) {
	return true;
      }
    }
    return false;
  }

  public ArrayList<InventoryItem> renderItems() {
    InventoryItem item1 = enterItem("Refridgerator", 2, 2);
    InventoryItem item2 = enterItem("Samsung USB 16GB", 50, 1);
    InventoryItem item3 = enterItem("Philips Senseo", 8, 4);
    ArrayList<InventoryItem> test = new ArrayList();
    test.add(item1);
    test.add(item2);
    test.add(item3);
    return test;

  }

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
      ACLMessage the_msg = m_a.receive();
      if (the_msg != null) {
	if (the_msg.getPerformative() == ACLMessage.SUBSCRIBE) {
	  ACLMessage new_msg = new ACLMessage(ACLMessage.INFORM);
	  new_msg.addReceiver(the_msg.getSender());
	  String string = "";
	  for (int i = 0; i <= m_items.size(); i++) {
	    string+=("[" + m_items.get(i).getItemName()+","+m_items.get(i).getAmount()+","+m_items.get(i).getSize() + "]");
	  }
	  new_msg.setContent(string);
	  m_a.send(new_msg);

	}
      }
      switch (step) {
	case 0:
	  msg = new ACLMessage(ACLMessage.INFORM);
	  InventoryItem item = enterItem("Samsung USB 16GB", 50, 1);
	  msg.setContent("Name: " + item.getItemName() + ", Amount: " + item.getAmount() + ", Size: " + item.getSize());
	  System.out.println("G>" + msg.getContent());
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
	  msg = new ACLMessage(ACLMessage.PROPOSE);
	  msg.setContent("Name: Samsung USB 16GB, Amount: 20");
	  for (int i = 1; i <= 1; i++) {
	    msg.addReceiver(new AID("Rack" + i, AID.ISLOCALNAME));

	  }
	  m_a.send(msg);
	case 1:
	  msg = m_a.receive();
	  if (msg != null) {
	    System.out.println(" - "
		+ getLocalName() + " <- "
		+ msg.getContent()
	    );

	  }
	  block();
      }
    }

    private boolean finished = false;

    @Override
    public boolean done() {
      return finished;
    }
  }
}

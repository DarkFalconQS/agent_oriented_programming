package inventory;

import behaviours.MessageBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 * This class has the purpose of sending, holding and recieving items Asswell
 * alerting a agent if the stock gets low
 *
 * @author Nico
 *
 */
public class RackAgent extends Agent {

  private String m_name;
  private ArrayList<InventoryItem> m_items;
  private int m_slots;
  private ACLMessage m_msg;
  private String[] content_list;

  @Override
  protected void setup() { //this runs once before starting behaviors
    // First set-up answering behaviour
  }

  public void action() {
    while(true){
      // Hier moet de magishe swith of if else bla bla
      addBehaviour(new MessageBehaviour(this, null, 10, null, null) {
	public void handleMessage(ACLMessage msg) {
	  m_msg = msg;
	}
      });
      if (m_msg != null) {
	if (m_msg.getPerformative() == ACLMessage.REQUEST) {
	  try {
	    content_list = m_msg.getContent().split("Name: ");
	    content_list = content_list[1].split(", Amount: ");
	  } catch (Exception ex) {

	  }

	  // Check
	}
	if (m_msg.getPerformative() == ACLMessage.PROPOSE) {
	  try {
	    AID reqAID = m_msg.getSender();
	    content_list = m_msg.getContent().split("Name: ");
	    content_list = content_list[1].split(", Amount: ");
	    if (content_list[0]) {

	    }
	  } catch (Exception e) {
	    System.err.println("RackAgent: Caught Exception: " + e.getMessage());
	  }
	  // Get
	}
      }
      // System.out.println("Agent: " + m_msg.toString());
    }
  }

  public RackAgent() {
    m_name = getLocalName();
    m_items = new ArrayList<>();
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

  public void checkItems(String name, int amount) {

  }

  public void setItems(ArrayList<InventoryItem> items) {
    this.m_items = items;
  }

  public void addItem(InventoryItem item) {
    this.m_items.add(item);
  }
  public void getItem(InventoryItem item) {
    this.m_items
            ;
  }

  private void reportItem() {
    //TODO Of we moete hier een behavior in doen, want anders maak ik hier een ACL req in.
  }
}

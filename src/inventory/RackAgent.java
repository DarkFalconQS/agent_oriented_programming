/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michaël
 */
public class RackAgent extends Agent {

  private int m_route;
  private String m_name;
  private ArrayList<InventoryItem> m_items;
  private int m_slots;

  @Override
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

    @Override
    public void action() {
      ACLMessage msg = m_a.receive();
      if (msg != null) {
	System.out.println(" - "
	    + getLocalName() + " <- "
	    + msg.getContent()
	);
	Pattern name = Pattern.compile("Name: \\w+(?:\\s*,\\s*\\w+)*");
	Pattern amount = Pattern.compile("Amount: \\w+(?:\\s*,\\s*\\w+)*");
	Matcher m = name.matcher((CharSequence) msg);
	Matcher a = amount.matcher((CharSequence) msg);
	System.out.println("Name: " + m.group(0) + ", Amount: " + a.group(0));
	msg.setReplyWith("Hi " + msg.getSender() + " from " + getLocalName());
	m_a.send(msg);
      }
      block();
    }
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

package inventory;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.*;
import jade.core.behaviours.*;
import java.util.ArrayList;

public class RackAgent extends Agent {
  private int m_route;
  private String m_name;
  private ArrayList<InventoryItem> m_items;

  public void setup() {
    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
        ACLMessage msg = receive();
        if(msg != null)
          System.out.println(" - " + 
            getLocalName() + " <- " +
            msg.getContent() 
          );
        block();
      }
    });
  }

  public RackAgent(String name, int route) {
    m_name = name;
    m_int = int;
  }

  public int getRoute() {
    return m_route;
  }

  public void setRoute(int route) {
    this.m_route = route;
  }

  public String getName() {
    return m_name;
  }

  public void setName(String name) {
    this.m_name = name;
  }

  public int getSlots() {
    return slots;
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
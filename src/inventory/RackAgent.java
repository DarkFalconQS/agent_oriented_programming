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
    m_route = route;
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
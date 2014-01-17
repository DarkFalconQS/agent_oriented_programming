/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organisor;

import behaviours.GetBehaviour;
import inventory.InventoryItem;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import java.util.ArrayList;

/**
 *
 * @author Michaël
 */
public class OrganisorAgent extends Agent {

  private int m_slots;
  private ArrayList<InventoryItem> m_items;
  private InventoryItem trade_item;
  private AID aid;

  public OrganisorAgent() {
    m_items = new ArrayList<>();
  }

  protected void setup() {
  }

  public class OrganisorBehaviour extends SimpleBehaviour{
    public OrganisorBehaviour(Agent a) {
      super(a);
    }

    @Override
    public void action() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean done() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  }


  private void getItem() {
    addBehaviour(new GetBehaviour(this, trade_item, aid));
  }

  public void setTradeItem(String name, int amount) {
    trade_item.setItemName(name);
    trade_item.setAmount(amount);
  }

  public InventoryItem getTradeItem() {
    return trade_item;
  }

  private void giveItem() {

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
}

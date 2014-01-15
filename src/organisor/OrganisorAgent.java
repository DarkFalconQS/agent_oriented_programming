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

  protected void setup() {
  }

  private void getItem() {
    setTradeItem("Samsung USB 16GB green", 20);
    AID aid = new AID("Rack1", AID.ISLOCALNAME);
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

  public class CheckBehaviour extends SimpleBehaviour {

    private Agent m_a;

    public CheckBehaviour(Agent a) {

    }

    @Override
    public void action() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean finished = false;

    @Override
    public boolean done() {
      return finished;
    }

  }

  public class PutBehaviour extends SimpleBehaviour {

    private Agent m_a;

    public PutBehaviour(Agent a) {
      super(a);
      m_a = a;
    }

    @Override
    public void action() {
    }

    private boolean finished = false;

    @Override
    public boolean done() {
      return finished;
    }
  }
}

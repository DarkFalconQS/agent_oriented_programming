package organisator;

import jade.core.Agent;
import java.util.ArrayList;

public class OrganisorAgent extends Agent{
  private int m_slots;
  private ArrayList<InventoryItem> m_items;

  protected void setup() {

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

}
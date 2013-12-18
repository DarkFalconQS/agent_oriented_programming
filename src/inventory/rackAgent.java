package inventory;

import jade.core.Agent;
import java.util.ArrayList;

public class RackAgent extends Agent {
  private Path m_route;
  private String m_name;
  private int m_slots;
  private ArrayList<InventoryItem> m_items;

  public RackAgent(String name, Path route) {
    m_name = name;
    m_path = path;
  }

  public Path getRoute() {
    return m_route;
  }

  public void setRoute(Path route) {
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

  protected void setup() {

  }

  private void checkItems() {

  }

  private void reportItem() {

  }
}
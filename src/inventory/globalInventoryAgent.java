package inventory;

import java.util.ArrayList;
import jade.core.Agent;

public class GlobalInventoryAgent extends Agent {
  private ArrayList<RackAgent> m_racks;

  public GlobalInventoryAgent() {
    m_racks = new ArrayList<RackAgent>();
  }

  protected void setup() {

  }

  public ArrayList<RackAgent> getRacks() {
    return m_racks;
  }

  public void setRacks(ArrayList<RackAgent> racks) {
    this.m_racks = racks;
  }

  public void getInventory() {
    /*yet to be determined what it returns*/ 
  }

  public void getRackAgents() {
    /* check for all available rack agents */
  }
}
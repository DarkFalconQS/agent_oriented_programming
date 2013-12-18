package inventory;

import java.util.ArrayList;
import jade.core.Agent;

public class GlobalInventoryAgent extends Agent {
  private ArrayList<Rack> racks;

  public GlobalInventoryAgent() {
    racks = new ArrayList<Rack>();
  }

  protected void setup() {

  }
}
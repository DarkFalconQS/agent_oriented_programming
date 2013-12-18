package order;

import jade.core.Agent;

public class OrderPickerAgent extends Agent {
  private Queue orderList;

  protected void setup() {
    
  }

  public OrderPickerAgent(Queue list = null) {
    if (list != null) {
      orderList = list;
    }
  }
}
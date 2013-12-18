package order;

import jade.core.Agent;

public class OrderPickerAgent extends Agent {
  private Queue orderList;

  protected void setup() {
    
  }

    public Queue getOrderList() {
        return orderList;
    }

    public void setOrderList(Queue orderList) {
        this.orderList = orderList;
    }

  public OrderPickerAgent(Queue list = null) {
    if (list != null) {
      orderList = list;
    }
  }
}
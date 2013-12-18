package order;

import jade.core.Agent;

public class OrderPickerAgent extends Agent {
  private Queue m_orderList;

  protected void setup() {
    
  }

  public Queue getOrderList() {
    return m_orderList;
  }

  public void setOrderList(Queue orderList) {
    this.m_orderList = orderList;
  }

  public OrderPickerAgent(Queue list = null) {
    if (list != null) {
      m_orderList = list;
    }
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package order;

import jade.core.Agent;
import java.util.Queue;

/**
 *
 * @author Michaël
 */

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

  public OrderPickerAgent(Queue list) {
    if (list != null) {
      m_orderList = list;
    }
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import inventory.InventoryItem;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 *
 * @todo Order Picker afmaken
 *
 */
public class OrderPickerAgent extends Agent {

  private ArrayList<ArrayList> m_orderList;
  private ArrayList<InventoryItem> m_items;
  public Behaviour orderBehaviour;
  private String[] content_list;

  protected void setup() {
    //addBehaviour(new AvailableBehaviour(this, 2, this.getAID()));
  }

  public ArrayList getOrderList() {
    return m_orderList;
  }

  public void setOrderList(ArrayList orderList) {
    this.m_orderList = orderList;
  }

  public OrderPickerAgent() {
    m_orderList = new ArrayList();
    m_items = new ArrayList();
//    orderBehaviour = new MyBehaviour(this);
//    addBehaviour(orderBehaviour);
    CreateOrder orderGui = new CreateOrder();
    orderGui.setVisible(true);
  }

  public void checkMessage(String content) {
    try {
      m_items.clear();
      String[] splitString = content.split(";");
      for (int i = 0; i < splitString.length; i++) {
	content_list = splitString[i].split("Name: ");
	content_list = content_list[1].split(", Amount: ");
	InventoryItem item = new InventoryItem(content_list[0], Integer.parseInt(content_list[1]), 0);
	m_items.add(item);
      }
      m_orderList.add(m_items);

    } catch (Exception exc) {
      System.out.println("OrderPickerAgent: Error 1 > " + exc.toString());
    }
  }

  public class MyBehaviour extends CyclicBehaviour {

    private Agent m_a;
    private String m_msg;
    private String[] content_list;

    public MyBehaviour(Agent a) {
      super(a);
      m_a = a;
    }

    @Override
    public void action() {
      ACLMessage msg = m_a.receive();
      if (msg != null) {
	try {
	  if (!msg.getContent().isEmpty()) {
	    String content = msg.getContent();
	    System.out.println(content);
	    checkMessage(content);
	  } else {
	    System.out.println("OrderPickerAgent: Message is Empty!");
	    done();
	  }
	} catch (NullPointerException exc) {
	  System.out.println("OrderPickerAgent: Error 2 " + exc.toString());
	  done();
	}
	done();
      }
      block();
    }
  }

}

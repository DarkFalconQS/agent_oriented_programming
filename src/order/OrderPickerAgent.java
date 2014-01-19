/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import inventory.InventoryItem;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @todo Order Picker afmaken
 *
 */
public class OrderPickerAgent extends Agent {

  private ArrayList<ArrayList> m_orderList;
  private ArrayList<InventoryItem> m_items;

  protected void setup() {
    addBehaviour(new OrderPickerAgent.MyBehaviour(this));
    //addBehaviour(new AvailableBehaviour(this, 2, this.getAID()));
  }

  public ArrayList getOrderList() {
    return m_orderList;
  }

  public void setOrderList(ArrayList orderList) {
    this.m_orderList = orderList;
  }

  public OrderPickerAgent(ArrayList list) {
    m_orderList = new ArrayList();
    m_items = new ArrayList();
    if (list != null) {
      m_orderList.add(list);
    }
  }

  public OrderPickerAgent() {
    m_orderList = new ArrayList();
    m_items = new ArrayList();
    CreateOrder orderGui = new CreateOrder();
    orderGui.setVisible(true);
  }

  public class MyBehaviour extends CyclicBehaviour {

    private Agent m_a;
    private String m_msg;
    private String[] content_list;

    public MyBehaviour(Agent a) {
      super(a);
      m_a = a;
    }

    public void checkMessage(String content) {
      try {
	m_items.clear();
	String[] splitString = content.split(",");
	ArrayBlockingQueue nameQueue = new ArrayBlockingQueue(999);
	ArrayBlockingQueue amountQueue = new ArrayBlockingQueue(999);
	for (int i = 0; i < splitString.length; i++) {
	  String[] name;
	  String[] amount;

	  if (i % 2 == 0) {
	    name = splitString[i].split("Name: ");
	    nameQueue.add(name[1].trim());
	  } else if (i % 1 == 0) {
	    amount = splitString[i].split("Amount: ");
	    if (amount[1].contains("]") == true) {
	      amount[1] = amount[1].substring(0, (amount[1].length() - 1));
	    }
	    amountQueue.add(Integer.parseInt(amount[1]));
	  }
	}
	while ((nameQueue.isEmpty() == false) && (amountQueue.isEmpty() == false)) {
	  // Extra security not to hang here.
	  if (amountQueue.isEmpty() == true) {
	    break;
	  }
	  int amount = (int) amountQueue.poll();
	  String name = (String) nameQueue.poll();
	  InventoryItem item = new InventoryItem(name, amount, 1); //0 word Size?
	  m_items.add(item);
	}
	m_orderList.add(m_items);
	block();
	done();

      } catch (Exception exc) {
	System.out.println("OrderPickerAgent: Error 1 > " + exc.toString());
	done();
      }
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

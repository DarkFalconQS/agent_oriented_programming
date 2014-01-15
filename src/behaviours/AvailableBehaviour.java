/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import inventory.InventoryItem;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Michaël
 */
public class AvailableBehaviour extends SimpleBehaviour {

  private Agent m_a;
  private ACLMessage msg;
  private InventoryItem m_item;
  private AID m_aid;
  private String[] content_list;

  public AvailableBehaviour(Agent a, InventoryItem item, AID aid) {
    super(a);
    m_a = a;
    m_aid = aid;
    m_item = item;
  }

  @Override
  public void action() {
    ACLMessage m_msg = receive_msg();
    msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
    msg.setContent("Name: " + m_item.getItemName() + "; Amount: " + m_item.getAmount() + ";");
    System.out.println("Protocol: " + msg.getProtocol());
    msg.addReceiver(m_aid);
    m_a.send(msg);
    System.out.println(msg);
  }

  private boolean finished = false;

  @Override
  public boolean done() {
    return finished;
  }

  private ACLMessage receive_msg() {
    ACLMessage msg = m_a.receive();
    if (msg != null) {
      String content = msg.getContent();
      content_list = content.split("Name: ");
      content_list = content_list[1].split(", Amount: ");
      InventoryItem item = new InventoryItem(content_list[0], Integer.parseInt(content_list[1]), 0);
      System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());
    }
    block();
    return msg;
  }
}

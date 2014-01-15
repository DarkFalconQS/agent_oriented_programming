/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import inventory.InventoryItem;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Michaël
 */
public class MessageBehaviour extends CyclicBehaviour {

  private final Agent m_a;

  public MessageBehaviour(Agent a) {
    super(a);
    m_a = a;
  }

  @Override
  public void action() {
    ACLMessage msg = m_a.receive();
    if (msg != null) {
      if (msg.getPerformative() == ACLMessage.REQUEST) {
	String content = msg.getContent();
	String[] content_list = content.split("Name: ");
	content_list = content_list[1].split(", Amount: ");
	InventoryItem item = new InventoryItem(content_list[0], Integer.parseInt(content_list[1]), 0);
      }
      else if(true){

      }
//      System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());
//      msg.setReplyWith("Hi " + msg.getSender() + " from " + m_a.getLocalName());
//      m_a.send(msg);
    }
    block();
  }

}

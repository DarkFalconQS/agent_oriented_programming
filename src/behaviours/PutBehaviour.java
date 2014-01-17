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
public class PutBehaviour extends SimpleBehaviour {

  private Agent m_a;
  private InventoryItem m_item;
  private AID m_aid;

  public PutBehaviour(Agent a) {
    super(a);
    m_a = a;
  }

  @Override
  public void action() {
    ACLMessage msg = new ACLMessage(ACLMessage.CONFIRM);
    msg.setContent("Name: " + m_item.getItemName() + ", Amount: " + m_item.getAmount() + ", Size: " + m_item.getSize());
    msg.addReceiver(m_aid);
    m_a.send(msg);
    done();
  }

  private boolean finished = false;

  @Override
  public boolean done() {
    return finished;
  }

  private ACLMessage receive_msg() {
    ACLMessage msg = m_a.receive();
    if (msg != null) {
      System.out.println(" - "
	  + m_a.getLocalName() + " <- "
	  + msg.getContent()
      );
    }
    return msg;
  }
}

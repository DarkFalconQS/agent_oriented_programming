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
public class CheckBehaviour extends SimpleBehaviour {

  private Agent m_a;
  private ACLMessage msg;
  private InventoryItem m_item;
  private AID m_aid;

  public CheckBehaviour(Agent a, InventoryItem item, AID aid) {
    super(a);
    m_a = a;
    m_aid = aid;
    m_item = item;
  }

  @Override
  public void action() {
    msg = new ACLMessage(ACLMessage.REQUEST);
    msg.setContent("Name: " + m_item.getItemName() + "; Amount: " + m_item.getAmount() + ";");
    msg.addReceiver(m_aid);
    m_a.send(msg);
  }

  private boolean finished = false;

  @Override
  public boolean done() {
    return finished;
  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Michaël
 */
public class PutBehaviour extends SimpleBehaviour {

  private Agent m_a;

  public PutBehaviour(Agent a) {
    super(a);
    m_a = a;
  }

  @Override
  public void action() {
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

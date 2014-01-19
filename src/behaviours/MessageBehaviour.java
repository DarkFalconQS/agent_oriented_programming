/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Michaël
 */

public class MessageBehaviour extends CyclicBehaviour {

  private final Agent m_a;
  private Object m_msg;

  public MessageBehaviour(Agent a) {
    super(a);
    m_a = a;
    m_msg = null;
  }

  @Override
  public void action() {
    ACLMessage msg = m_a.receive();
    if (msg != null) {
        // To test my new RackAgent
			System.out.println("Receiver: I am  " + myAgent.getLocalName()
					+ " and I have received: " + msg.getContent() +" from "+msg.getSender().getLocalName());

      m_msg = msg;
    }
    block();
  }

  public Object finish() {
    return m_msg;
  }

}

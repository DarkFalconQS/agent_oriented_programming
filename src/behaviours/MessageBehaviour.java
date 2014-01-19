/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.Agent;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.states.MsgReceiver;

/**
 *
 * @author Michaël
 */
public class MessageBehaviour extends MsgReceiver {

  private final Agent m_a;
  private Object m_msg;

  /**
   *
   * @param a a reference to the Agent
   * @param mt the MessageTemplate of the message to be received, if null the first received message is returned by this behaviour
   * @param deadline a timeout for waiting until a message arrives. It must be expressed as an absolute time, as it would be returned by System.currentTimeMillisec()
   * @param s the dataStore for this behaviour
   * @param msgKey he key where the behaviour must put the received message into the DataStore.
   */
    public MessageBehaviour(Agent a, MessageTemplate mt, long deadline, DataStore s, java.lang.Object msgKey) {
      m_a = a;
      m_msg =  null;
  }

  @Override
  public void action() {
    ACLMessage msg = m_a.receive();
    if (msg != null) {
      // To test my new RackAgent
      System.out.println("Receiver: I am  " + myAgent.getLocalName()
	  + " and I have received: " + msg.getContent() + " from " + msg.getSender().getLocalName());

      m_msg = msg;
    }
    block();
    finish();
  }

  public Object finish() {
    return m_msg;
  }

}

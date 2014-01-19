/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class AvailableBehaviour extends SimpleBehaviour {

  private final Agent m_a;
  private ACLMessage msg;
  private final AID m_aid;
  private final int m_accept;

  public AvailableBehaviour(Agent a, int accept, AID aid) {
    super(a);
    m_a = a;
    m_aid = aid;
    m_accept = accept;
  }

  @Override
  public void action() {
    msg.addReceiver(m_aid);
    if (m_accept == 1) /* Available and accept */ {
      msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
      msg.setContent("Accepted Proposal");
      m_a.send(msg);
    } else if (m_accept == 0 || m_accept == 2) /* Not accepted */ {
      msg = new ACLMessage(ACLMessage.REJECT_PROPOSAL);
      if (m_accept == 0) {
	msg.setContent("Item Unavailable");
      } else if (m_accept == 2) {
	msg.setContent("Not Accepted");
      }
      msg.addReceiver(m_aid);
      m_a.send(msg);
    }
    done();
  }

  private boolean finished = false;

  @Override
  public boolean done() {
    return finished;
  }
}

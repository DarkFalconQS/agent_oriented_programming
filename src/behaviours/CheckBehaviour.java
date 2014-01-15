/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author Michaël
 */
public class CheckBehaviour extends SimpleBehaviour {

  private Agent m_a;

  public CheckBehaviour(Agent a) {

  }

  @Override
  public void action() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private boolean finished = false;

  @Override
  public boolean done() {
    return finished;
  }

}

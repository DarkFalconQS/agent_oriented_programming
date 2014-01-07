package inventory;

import java.util.ArrayList;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;
import jade.core.behaviours.*;

public class GlobalInventoryAgent extends Agent {
  private ArrayList<RackAgent> m_racks;

  public GlobalInventoryAgent() {
    m_racks = new ArrayList<RackAgent>();
  }

  protected void setup() {
    addBehaviour( new myBehaviour( this ) );
  }

  public ArrayList<RackAgent> getRacks() {
    return m_racks;
  }

  public void setRacks(ArrayList<RackAgent> racks) {
    this.m_racks = racks;
  }

  public void getInventory() {
    /*yet to be determined what it returns*/ 
  }

  public void getRackAgents() {
    /* check for all available rack agents */
  }

  public class myBehaviour extends SimpleBehaviour {
    public myBehaviour(Agent a) { 
        super(a);  
    }
    
    public void action() 
    {
      ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
      msg.setContent("Connection working!");

      for (int i = 1; i<=2; i++)
        msg.addReceiver( new AID( "store" + i, AID.ISLOCALNAME) );
      send(msg);
    }
    
    private boolean finished = false;
    
    public boolean done() {  
        return finished;  
    }
  }
}
package inventory;

import behaviours.MessageBehaviour;
import behaviours.PutBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;


/**
 * This class has the purpose of sending, holding and recieving items
 * Asswell alerting a agent if the stock gets low
 * @author Nico
 *
 */
public class RackAgent extends Agent {
    
@Override
protected void setup() { //this runs once before starting behaviors

		// First set-up answering behaviour
		addBehaviour(new MessageBehaviour(this) );


	}	

}

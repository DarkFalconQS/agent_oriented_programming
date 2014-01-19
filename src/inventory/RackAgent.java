package inventory;

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

    private Agent m_a ;
//    private int m_route;
//    private String m_name;
//    private ArrayList<InventoryItem> m_items;
//    private int m_slots;
    
	/**
	 * To send a message we will need a reference to the sender agent
	 * @param a the reference to the sender agent
	 */	
	public RackAgent(Agent a){
		m_a=a;		
	}

	/**
	 * this is how to reply to a message
	 * */
	public void SendReply(ACLMessage msg,String content){
		ACLMessage reply = msg.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		reply.setContent(content);
		m_a.send(reply);

	}
	/**
	 * this is how to send a message
	 * */
	public void SendMessage(String receiver, String content, String convId){
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent(content);
		msg.setConversationId(convId);
		msg.addReceiver(new AID(receiver, AID.ISLOCALNAME));

		m_a.send(msg);

	}
	
	/*
	 //a little demonstration of how to broadcast to many agents
	 void BroadcastMessage( String content){
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent(content);

		for (int i = 1; i <= totaal_agents; i++)
			msg.addReceiver(new AID("a" + i, AID.ISLOCALNAME));
		
		m_a.send(msg); 	

	}

	 */
	

}

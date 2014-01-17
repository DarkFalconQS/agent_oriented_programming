/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;

/**
 *
 * @author Michaël
 */
public class RackAgent extends Agent {

  private int m_route;
  private String m_name;
  private ArrayList<InventoryItem> m_items;
  private int m_slots;

  @Override
  public void setup() {
    addBehaviour(new MyBehaviour(this));
    ArrayList lol = new ArrayList<>();
   	 lol.add(new InventoryItem("Xbox", 5000, 0));
     setItems(lol);
  }

  public class MyBehaviour extends CyclicBehaviour {

    private Agent m_a;
    private String m_msg;
    private String[] content_list;

    public MyBehaviour(Agent a) {
      super(a);
      m_a = a;
    }

    @Override
    public void action() {
      ACLMessage msg = m_a.receive();
      if (msg != null) {
        String content = msg.getContent();
	content_list = content.split("Name: ");
	content_list = content_list[1].split(", Amount: ");
        if (msg.getPerformative() == ACLMessage.PROPOSE) {
              // We worden hier een Item geboden. Past hij, willen we hem?
              // Response moet worde ACLMessage.ACCEPT_PROPOSAL zodat de ander niet een andere rack hoefd te zoeken
             // vervolgens het nieuwe totaal melden... denk ik. ~nico
            InventoryItem item = new InventoryItem(content_list[0], Integer.parseInt(content_list[1]), 0);
            addItem(item);
           // System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());

        }
        if (msg.getPerformative() == ACLMessage.QUERY_IF) {
              // Hebben wij dit? het mooiste is als het verschillende vragen kunnen worden
              // Denk bijvoorbeeld aan die Switch in het boek voorbeeld ~nico
           // ArrayList lol = getItems();
            if(!getItems().isEmpty()){
                InventoryItem item = m_items.get(0); // This gets the first element of the list, the one we just added
                System.out.println("Name: " + item.getItemName() + ", Amount: " + item.getAmount());

            }else{
                ACLMessage order = new ACLMessage(ACLMessage.INFORM_IF);
                order.addReceiver(msg.getSender());
                order.setContent("ANSWER: FALSE");
                m_a.send(order);
                System.out.println("Empty m_items");
            }

        }
	msg.setReplyWith("Hi " + msg.getSender() + " from " + getLocalName());
	m_a.send(msg);


      }
      block();
    }
  }

  public RackAgent() {
    m_name = "name";
    m_items = new ArrayList<>();
    m_route = 1;
  }

  public int getRoute() {
    return m_route;
  }

  public void setRoute(int route) {
    this.m_route = route;
  }

  public String getMyName() {
    return m_name;
  }

  public void setName(String name) {
    this.m_name = name;
  }

  public int getSlots() {
    return m_slots;
  }

  public void setSlots(int slots) {
    this.m_slots = slots;
  }

  public ArrayList<InventoryItem> getItems() {
    return m_items;
  }

  public void setItems(ArrayList<InventoryItem> items) {
    this.m_items = items;
  }
  public void addItem(InventoryItem item) {
    this.m_items.add(item);
  }

  // report item when amount is less then 50% of size
  private void checkItems() {
      for (InventoryItem item : m_items) {
          if((item.getSize()/2) > item.getAmount()){
              reportItem();
          }
      }
  }

  private void reportItem() {

  }
}

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
    private String m_name;
    private ArrayList<InventoryItem> m_items;
    private int m_route;
    private int m_slots;
    
@Override
protected void setup() { //this runs once before starting behaviors

		// First set-up answering behaviour
		addBehaviour(new MessageBehaviour(this) );


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
            if ((item.getSize() / 2) > item.getAmount()) {
                reportItem();
            }
        }
    }

    private void reportItem() {
        //TODO Of we moete hier een behavior in doen, want anders maak ik hier een ACL req in.
    }
}

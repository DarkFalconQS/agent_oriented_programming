package inventory;

import jade.core.Agent;
import java.util.ArrayList;

public class RackAgent extends Agent {
  private Path m_route;
  private String m_name;
  private int m_slots;
  private ArrayList<Item> m_items;

  public RackAgent(String name, Path route) {
    init();
    run();
  }

   private void init(){
      m_name = name;
      m_path = path;
   }

   private void run(){

   }

    public Path getM_route() {
        return m_route;
    }

    public void setM_route(Path m_route) {
        this.m_route = m_route;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_slots() {
        return m_slots;
    }

    public void setM_slots(int m_slots) {
        this.m_slots = m_slots;
    }

    public ArrayList<Item> getM_items() {
        return m_items;
    }

    public void setM_items(ArrayList<Item> m_items) {
        this.m_items = m_items;
    }

  protected void setup() {

  }

  private void checkItems() {

  }

  private void reportItem() {

  }
}

package inventory;

public class InventoryItem {
  private String m_itemName;
  private int m_amount;
  private RackAgent m_location;
  private int m_size;

  public InventoryItem(String name, int number_of, Rack new_location) {
    m_itemName = name;
    m_amount = number_of;
    m_location = new_location;
  }

  public int getSize() {
    return m_size;
  }

  public String getItemName() {
    return m_itemName;
  }

  public int getAmount() {
    return m_amount;
  }

  public Rack getLocation() {
    return m_location;
  }

  public void setItemName(String name) {
    this.m_itemName = name;
  }

  public void setAmount(int amount) {
    this.m_amount = amount;
  }

  public void setLocation(RackAgent location) {
    this.m_location = location;
  }

  public void setSize(int size) {
    this.m_size = size;
  }

}
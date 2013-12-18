package inventory;

public class InventoryItem {
  private String itemName;
  private int amount;
  private Rack location;
  private int size;

  public InventoryItem(String name, int number_of, Rack new_location) {
    itemName = name;
    amount = number_of;
    location = new_location;
  }

  public String getItemName() {
    return itemName;
  }

  public int getAmount() {
    return amount;
  }

  public Rack getLocation() {
    return location;
  }

  public int size getSize() {
    return size;
  }

  public void setItemName(String name) {
    itemName = name;
  }

  public void setAmount(int number_of) {
    amount = number_of;
  }

  public void setLocation(Rack new_location) {
    location = new_location;
  }

  public void setSize(int new_size) {
    size = new_size;
  }

}
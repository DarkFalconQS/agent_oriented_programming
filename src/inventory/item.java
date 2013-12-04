package inventory;

public class InventoryItem {
  private String itemName;
  private int amount;
  private Rack location;

  public String getItemName() {
    return itemName;
  }

  public int getAmount() {
    return amount;
  }

  public Rack getLocation() {
    return location;
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

}
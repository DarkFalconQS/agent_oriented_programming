package order;

public class OrderPickerAgent {
  private Queue orderList;

  public OrderPickerAgent(Queue list = null) {
    if (list != null) {
      orderList = list;
    }
  }
}
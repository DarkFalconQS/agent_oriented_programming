/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Dark_Falcon
 */

public class TestList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ArrayList> m_orderList = new ArrayList();
        ArrayList<InventoryItem> items = new ArrayList();
        ArrayList<String> items2 = new ArrayList();

        items2.add("Name: test naam , Amount: 1");
        items2.add("Name: tadaa , Amount: 2");
        items2.add("Name: stront , Amount: 3");
        items2.add("Name: aan , Amount: 4");
        items2.add("Name: de , Amount: 5");
        items2.add("Name: knikker , Amount: 6");
        items2.add("Name: pffft , Amount: 7");

        String test = items2.toString();
        System.out.println(test);
        String[] test2 = test.split(",");

        ArrayBlockingQueue nameQueue = new ArrayBlockingQueue(999);
        ArrayBlockingQueue amountQueue = new ArrayBlockingQueue(999);

        for (int i = 0; i < test2.length; i++) {
            String[] name;
            String[] amount;

            if (i % 2 == 0) {
                name = test2[i].split("Name: ");
                nameQueue.add(name[1].trim());
            } else if (i % 1 == 0) {
                amount = test2[i].split("Amount: ");
                if (amount[1].contains("]") == true) {
                    amount[1] = amount[1].substring(0, (amount[1].length() - 1));
                }
                amountQueue.add(Integer.parseInt(amount[1]));
            }
        }
        while ((nameQueue.isEmpty() == false) && (amountQueue.isEmpty() == false)) {
            int amount = (int) amountQueue.poll();
            String name = (String) nameQueue.poll();
            InventoryItem item = new InventoryItem(name, amount, 1); //0 word Size?
            items.add(item);
        }
        m_orderList.add(items);
        m_orderList.add(items);
        System.out.println(m_orderList.toString());
    }
}

 class InventoryItem {
  private String m_itemName;
  private int m_amount;
  private int m_size;

  public InventoryItem(String name, int number_of, int size) {
    m_itemName = name;
    m_amount = number_of;
    m_size = size;
  }

    InventoryItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

  public void setItemName(String name) {
    this.m_itemName = name;
  }

  public void setAmount(int amount) {
    this.m_amount = amount;
  }

  public void setSize(int size) {
    this.m_size = size;
  }

}

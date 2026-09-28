package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
    }

    public Item getItem(String name)  throws Exception {
        return items.stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new Exception("Item not found"));
    }
    public Item addItem(String name, int qty, double price) throws Exception {
        Item item= new Item(name,qty,price);
        items.add(item);
        return item;
    }

    public List<Item> getItems() {
        return items;
    }

    public void viewItems() {
        System.out.println("View items");
        for (Item item : items) {
            System.out.println(item.getName()+" : "+item.getPrice()+" : "+item.getCount());
        }
    }
}

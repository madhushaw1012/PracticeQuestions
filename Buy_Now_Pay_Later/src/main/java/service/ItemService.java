package service;

import model.Item;
import repository.ItemRepository;

import java.util.List;

public class ItemService {
    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(String name, int quantity, double price) throws Exception {
        return itemRepository.addItem(name,quantity,price);
    }

    public Item getItem(String name) throws Exception {
        return itemRepository.getItem(name);
    }

    public List<Item> getItems() throws Exception {
        return itemRepository.getItems();
    }

    public void viewItems() {
        itemRepository.viewItems();
    }
}

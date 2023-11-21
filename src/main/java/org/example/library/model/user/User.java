package org.example.library.model.user;

import lombok.*;
import org.example.library.model.catalogue.inventory.abstracts.InventoryItem;

import java.util.Comparator;
import java.util.TreeSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private TreeSet<InventoryItem> borrowedItems;

    public User(long id, String name){
        this.id = id;
        this.name = name;
        this.borrowedItems = new TreeSet<>();
    }

    public void recordItemBorrowed(InventoryItem inventoryItem) {
        borrowedItems.add(inventoryItem);
    }

    public void recordItemReturned(InventoryItem inventoryItem) {
        borrowedItems.remove(inventoryItem);
    }

    public void listBorrowedItems() {
        System.out.println("List of items borrowed by user " + name + ", sorted alphabetically by title");
        borrowedItems.stream()
                .sorted(Comparator.comparing(InventoryItem::getTitle))
                .forEach(item ->
                        System.out.println("Title: " + item.getTitle() + " \n Item Type: " + item.getClass().getName() + "\n\n")
                );
    }

}

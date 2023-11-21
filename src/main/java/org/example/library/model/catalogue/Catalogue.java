package org.example.library.model.catalogue;

import lombok.Getter;
import lombok.Setter;
import org.example.library.model.catalogue.inventory.abstracts.InventoryItem;

import java.util.TreeSet;

@Getter
@Setter
public class Catalogue {

    TreeSet<InventoryItem> inventory;
    TreeSet<Author> authors;

    public void addNewInventoryItem(InventoryItem inventoryItem){
        inventory.add(inventoryItem);
    }

    public void addNewAuthor(Author author){
        authors.add(author);
    }

}

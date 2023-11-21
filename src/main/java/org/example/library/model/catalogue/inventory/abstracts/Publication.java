package org.example.library.model.catalogue.inventory.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Publication extends InventoryItem {

    private String authorName;
    private String isbn;

}

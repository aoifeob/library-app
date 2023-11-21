package org.example.library.model.catalogue.inventory;

import lombok.Getter;
import lombok.Setter;
import org.example.library.model.catalogue.AvailabilityStatus;
import org.example.library.model.catalogue.inventory.abstracts.InventoryItem;

@Getter
@Setter
public class CD extends InventoryItem {

    private String producer;
    private String director;
    private int playTimeMins;

}
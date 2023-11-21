package org.example.library.model.catalogue.inventory;

import lombok.Getter;
import lombok.Setter;
import org.example.library.model.catalogue.AvailabilityStatus;
import org.example.library.model.catalogue.inventory.abstracts.InventoryItem;

import java.util.Date;

@Getter
@Setter
public class Thesis extends InventoryItem {

    private String topic;
    private String abstractText;
    private Date datePublished;

}

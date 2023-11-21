package org.example.library.model.catalogue.inventory;

import lombok.Getter;
import lombok.Setter;
import org.example.library.model.catalogue.inventory.abstracts.Publication;

@Getter
@Setter
public class AudioBook extends Publication {

    private String readBy;

}

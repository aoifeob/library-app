package org.example.library.model.catalogue.inventory.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.library.model.catalogue.AvailabilityStatus;
import org.example.library.model.catalogue.inventory.interfaces.Borrowable;
import org.example.library.model.exception.BorrowItemException;
import org.example.library.model.exception.ReturnItemException;
import org.example.library.model.user.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class InventoryItem implements Borrowable, Comparable<InventoryItem> {

    private String title;
    private AvailabilityStatus availabilityStatus;

    public boolean isBorrowable() {
        return AvailabilityStatus.AVAILABLE == availabilityStatus;
    }

    @Override
    public int compareTo(InventoryItem o) {
        //TODO: implement logic
        return 0;
    }

    @Override
    public void borrow(User borrowingUser) throws BorrowItemException {
        if (AvailabilityStatus.AVAILABLE != this.getAvailabilityStatus()) {
            throw new BorrowItemException(getClass().getName() + " with title " + title + " cannot be borrowed");
        }
        this.setAvailabilityStatus(AvailabilityStatus.ON_LOAN);
        borrowingUser.recordItemBorrowed(this);
    }

    @Override
    public void returnItem(User borrowingUser) throws ReturnItemException {
        if (!borrowingUser.getBorrowedItems().contains(this)){
            throw new ReturnItemException(getClass().getName() + " with title " + title + " is not on this user's list of borrowed items");
        }
        borrowingUser.recordItemReturned(this);
        this.setAvailabilityStatus(AvailabilityStatus.AVAILABLE);
    }

}

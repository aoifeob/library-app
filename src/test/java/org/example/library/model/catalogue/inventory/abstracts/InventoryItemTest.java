package org.example.library.model.catalogue.inventory.abstracts;

import org.example.library.model.catalogue.AvailabilityStatus;
import org.example.library.model.exception.BorrowItemException;
import org.example.library.model.exception.ReturnItemException;
import org.example.library.model.user.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

public class InventoryItemTest {

    private static class TestInventoryItem extends InventoryItem {
        public TestInventoryItem(String title){
            super(title, AvailabilityStatus.AVAILABLE);
        }

        public TestInventoryItem(String title, AvailabilityStatus availabilityStatus){
            super(title, availabilityStatus);
        }
    }

    @Test
    public void shouldBorrowAvailableItem() throws BorrowItemException {
        User testUser = new User(12345, "My Test User");
        TestInventoryItem testItem = new TestInventoryItem("My Test Item");
        Assert.assertEquals(AvailabilityStatus.AVAILABLE, testItem.getAvailabilityStatus());

        testItem.borrow(testUser);
        Assert.assertEquals(AvailabilityStatus.ON_LOAN, testItem.getAvailabilityStatus());

        Assert.assertTrue(testUser.getBorrowedItems().contains(testItem));
    }

    @Test(expected = BorrowItemException.class)
    public void shouldThrowExceptionWhenAttemptingToBorrowUnavailableItem() throws BorrowItemException {
        User testUserToBorrow = new User(12345, "My First Test User");
        User testUserUnableToBorrow = new User(67890, "My Second Test User");
        TestInventoryItem testItem = new TestInventoryItem("My Test Item");
        testItem.borrow(testUserToBorrow);
        Assert.assertEquals(AvailabilityStatus.ON_LOAN, testItem.getAvailabilityStatus());

        testItem.borrow(testUserUnableToBorrow);
    }

    @Test
    public void shouldReturnBorrowedItem() throws ReturnItemException {
        TestInventoryItem testItem = new TestInventoryItem("My Test Item", AvailabilityStatus.ON_LOAN);
        TreeSet<InventoryItem> borrowedItems = new TreeSet<>();
        borrowedItems.add(testItem);
        User testUser = new User(12345, "My Test User", borrowedItems);
        Assert.assertTrue(testUser.getBorrowedItems().contains(testItem));

        testItem.returnItem(testUser);

        Assert.assertFalse(testUser.getBorrowedItems().contains(testItem));
    }

    @Test(expected = ReturnItemException.class)
    public void shouldThrowExceptionWhenAttemptingToReturnItemNotBorrowedByUser() throws ReturnItemException {
        User testUser = new User(12345, "My Test User");
        TestInventoryItem testItem = new TestInventoryItem("My Test Item");

        testItem.returnItem(testUser);
    }

}
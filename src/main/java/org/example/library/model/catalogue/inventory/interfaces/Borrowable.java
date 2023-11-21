package org.example.library.model.catalogue.inventory.interfaces;

import org.example.library.model.exception.BorrowItemException;
import org.example.library.model.exception.ReturnItemException;
import org.example.library.model.user.User;

public interface Borrowable {

    void borrow(User borrowingUser) throws BorrowItemException;

    void returnItem(User borrowingUser) throws ReturnItemException;
}

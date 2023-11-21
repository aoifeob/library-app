package org.example.library.model.catalogue;

import lombok.Getter;
import lombok.Setter;
import org.example.library.model.catalogue.inventory.abstracts.Publication;

import java.util.Comparator;
import java.util.TreeSet;

@Getter
@Setter
public class Author {

    private String name;
    private TreeSet<Publication> publishedWorks;

    public void listPublishedWorksByTitle() {
        System.out.println("List of works by " + name + ", sorted alphabetically by title");
        publishedWorks.stream()
                .sorted(Comparator.comparing(Publication::getTitle))
                .forEach(publication ->
                        System.out.println("Title: " + publication.getTitle() + " \n ISBN: " + publication.getIsbn() + "\n\n")
                );
    }

    public void listPublishedWorksAvailableToBorrow() {
        System.out.println("List of works by " + name + " which are available to borrow, sorted alphabetically by title");
        publishedWorks.stream()
                .filter(Publication::isBorrowable)
                .sorted(Comparator.comparing(Publication::getTitle))
                .forEach(publication ->
                        System.out.println("Title: " + publication.getTitle() + " \n ISBN: " + publication.getIsbn() + "\n\n")
                );
    }

}

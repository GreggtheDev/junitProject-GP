package org.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private BookService bookService;
    private Book book1;
    private Book book2;
    private User user;

    @Before
    public void setUp() {
        bookService = new BookService();
        // Updated constructor calls to match the available constructors in the Book class
        book1 = new Book("Effective Java", "Joshua Bloch", "Programming", 45.0, new ArrayList<>());
        book2 = new Book("Clean Code", "Robert C. Martin", "Programming", 40.0, new ArrayList<>());
        bookService.addBook(book1);
        bookService.addBook(book2);

        user = mock(User.class);
        when(user.getPurchasedBooks()).thenReturn(List.of(book1));
    }

    // Tests for searchBook method
    @Test
    public void testSearchBook_positive() {
        List<Book> result = bookService.searchBook("Effective");
        assertEquals(1, result.size());
        assertTrue(result.contains(book1));
    }

    @Test
    public void testSearchBook_negative() {
        List<Book> result = bookService.searchBook("Nonexistent Book");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchBook_edge() {
        List<Book> result = bookService.searchBook("");
        assertEquals(2, result.size()); // Both books match the empty string
    }

    // Tests for purchaseBook method
    @Test
    public void testPurchaseBook_positive() {
        assertTrue(bookService.purchaseBook(user, book1));
    }

    @Test
    public void testPurchaseBook_negative() {
        Book nonExistentBook = new Book("Nonexistent Book", "Unknown", "Fiction", 0.0, new ArrayList<>());
        assertFalse(bookService.purchaseBook(user, nonExistentBook));
    }

    @Test
    public void testPurchaseBook_edge() {
        assertFalse(bookService.purchaseBook(null, book1));
    }

    // Tests for addBookReview method
    @Test
    public void testAddBookReview_positive() {
        boolean result = bookService.addBookReview(user, book1, "Great book!");
        assertTrue(result);
        assertTrue(book1.getReviews().contains("Great book!"));
    }

    @Test
    public void testAddBookReview_negative() {
        Book nonPurchasedBook = new Book("Clean Code", "Robert C. Martin", "Programming", 40.0, new ArrayList<>());
        boolean result = bookService.addBookReview(user, nonPurchasedBook, "Good book");
        assertFalse(result);
    }

    @Test
    public void testAddBookReview_edge() {
        boolean result = bookService.addBookReview(user, book1, "");
        assertTrue(result);
        assertTrue(book1.getReviews().contains("")); // Empty string added as a review

        result = bookService.addBookReview(user, book1, null);
        assertFalse(result); // Null review should not be added
    }

    // Tests for addBook method
    @Test
    public void testAddBook_positive() {
        Book newBook = new Book("Java Concurrency in Practice", "Brian Goetz", "Programming", 55.0, new ArrayList<>());
        boolean result = bookService.addBook(newBook);
        assertTrue(result);
        assertTrue(bookService.searchBook("Java Concurrency").contains(newBook));
    }

    @Test
    public void testAddBook_negative() {
        boolean result = bookService.addBook(book1); // book1 is already added in setUp()
        assertFalse(result);
    }

    @Test
    public void testAddBook_edge() {
        boolean result = bookService.addBook(null);
        assertFalse(result); // Null book should not be added
    }

    // Tests for removeBook method
    @Test
    public void testRemoveBook_positive() {
        boolean result = bookService.removeBook(book1);
        assertTrue(result);
        assertFalse(bookService.searchBook("Effective Java").contains(book1));
    }

    @Test
    public void testRemoveBook_negative() {
        Book nonExistentBook = new Book("Nonexistent Book", "Unknown", "Fiction", 0.0, new ArrayList<>());
        boolean result = bookService.removeBook(nonExistentBook);
        assertFalse(result);
    }

    @Test
    public void testRemoveBook_edge() {
        boolean result = bookService.removeBook(null);
        assertFalse(result); // Null book should not be removed
    }
}

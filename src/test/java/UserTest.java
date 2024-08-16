package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        book1 = new Book("Effective Java", "Joshua Bloch", "Programming", 45.0, new ArrayList<>());
        book2 = new Book("Clean Code", "Robert C. Martin", "Programming", 40.0, new ArrayList<>());
        List<Book> purchasedBooks = new ArrayList<>();
        purchasedBooks.add(book1);

        user = new User("testuser", "password123", "testuser@example.com", purchasedBooks);
    }

    // Tests for getUsername method
    @Test
    public void testGetUsername_positive() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testGetUsername_edge() {
        user.setUsername("");
        assertEquals("", user.getUsername());
    }

    @Test
    public void testGetUsername_negative() {
        user.setUsername(null);
        assertNull(user.getUsername());
    }

    // Tests for setUsername method
    @Test
    public void testSetUsername_positive() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    public void testSetUsername_edge() {
        user.setUsername("");
        assertEquals("", user.getUsername());
    }

    @Test
    public void testSetUsername_negative() {
        user.setUsername(null);
        assertNull(user.getUsername());
    }

    // Tests for getPassword method
    @Test
    public void testGetPassword_positive() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testGetPassword_edge() {
        user.setPassword("");
        assertEquals("", user.getPassword());
    }

    @Test
    public void testGetPassword_negative() {
        user.setPassword(null);
        assertNull(user.getPassword());
    }

    // Tests for setPassword method
    @Test
    public void testSetPassword_positive() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testSetPassword_edge() {
        user.setPassword("");
        assertEquals("", user.getPassword());
    }

    @Test
    public void testSetPassword_negative() {
        user.setPassword(null);
        assertNull(user.getPassword());
    }

    // Tests for getEmail method
    @Test
    public void testGetEmail_positive() {
        assertEquals("testuser@example.com", user.getEmail());
    }

    @Test
    public void testGetEmail_edge() {
        user.setEmail("");
        assertEquals("", user.getEmail());
    }

    @Test
    public void testGetEmail_negative() {
        user.setEmail(null);
        assertNull(user.getEmail());
    }

    // Tests for setEmail method
    @Test
    public void testSetEmail_positive() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail_edge() {
        user.setEmail("");
        assertEquals("", user.getEmail());
    }

    @Test
    public void testSetEmail_negative() {
        user.setEmail(null);
        assertNull(user.getEmail());
    }

    // Tests for getPurchasedBooks method
    @Test
    public void testGetPurchasedBooks_positive() {
        assertEquals(1, user.getPurchasedBooks().size());
        assertTrue(user.getPurchasedBooks().contains(book1));
    }

    @Test
    public void testGetPurchasedBooks_edge() {
        user.setPurchasedBooks(new ArrayList<>());
        assertEquals(0, user.getPurchasedBooks().size());
    }

    @Test
    public void testGetPurchasedBooks_negative() {
        user.setPurchasedBooks(null);
        assertNull(user.getPurchasedBooks());
    }

    // Tests for setPurchasedBooks method
    @Test
    public void testSetPurchasedBooks_positive() {
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book2);
        user.setPurchasedBooks(newBooks);
        assertEquals(1, user.getPurchasedBooks().size());
        assertTrue(user.getPurchasedBooks().contains(book2));
    }

    @Test
    public void testSetPurchasedBooks_edge() {
        user.setPurchasedBooks(new ArrayList<>());
        assertEquals(0, user.getPurchasedBooks().size());
    }

    @Test
    public void testSetPurchasedBooks_negative() {
        user.setPurchasedBooks(null);
        assertNull(user.getPurchasedBooks());
    }
}

package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;
    private List<String> reviews;

    @Before
    public void setUp() {
        reviews = new ArrayList<>();
        reviews.add("Great book!");
        reviews.add("Must-read for developers.");
        book = new Book("Effective Java", "Joshua Bloch", "Programming", 45.0, reviews);
    }

    @After
    public void tearDown() {
        // Resetting the book object to ensure each test starts with a clean state
        book = null;
        reviews = null;
    }

    // Tests for getTitle method
    @Test
    public void testGetTitle_positive() {
        assertEquals("Effective Java", book.getTitle());
    }

    @Test
    public void testGetTitle_edge() {
        book.setTitle("");
        assertEquals("", book.getTitle());
    }

    @Test
    public void testGetTitle_negative() {
        book.setTitle(null);
        assertNull(book.getTitle());
    }

    // Tests for setTitle method
    @Test
    public void testSetTitle_positive() {
        book.setTitle("Java Concurrency in Practice");
        assertEquals("Java Concurrency in Practice", book.getTitle());
    }

    @Test
    public void testSetTitle_edge() {
        book.setTitle("");
        assertEquals("", book.getTitle());
    }

    @Test
    public void testSetTitle_negative() {
        book.setTitle(null);
        assertNull(book.getTitle());
    }

    // Tests for getAuthor method
    @Test
    public void testGetAuthor_positive() {
        assertEquals("Joshua Bloch", book.getAuthor());
    }

    @Test
    public void testGetAuthor_edge() {
        book.setAuthor("");
        assertEquals("", book.getAuthor());
    }

    @Test
    public void testGetAuthor_negative() {
        book.setAuthor(null);
        assertNull(book.getAuthor());
    }

    // Tests for setAuthor method
    @Test
    public void testSetAuthor_positive() {
        book.setAuthor("Robert C. Martin");
        assertEquals("Robert C. Martin", book.getAuthor());
    }

    @Test
    public void testSetAuthor_edge() {
        book.setAuthor("");
        assertEquals("", book.getAuthor());
    }

    @Test
    public void testSetAuthor_negative() {
        book.setAuthor(null);
        assertNull(book.getAuthor());
    }

    // Tests for getGenre method
    @Test
    public void testGetGenre_positive() {
        assertEquals("Programming", book.getGenre());
    }

    @Test
    public void testGetGenre_edge() {
        book.setGenre("");
        assertEquals("", book.getGenre());
    }

    @Test
    public void testGetGenre_negative() {
        book.setGenre(null);
        assertNull(book.getGenre());
    }

    // Tests for setGenre method
    @Test
    public void testSetGenre_positive() {
        book.setGenre("Software Development");
        assertEquals("Software Development", book.getGenre());
    }

    @Test
    public void testSetGenre_edge() {
        book.setGenre("");
        assertEquals("", book.getGenre());
    }

    @Test
    public void testSetGenre_negative() {
        book.setGenre(null);
        assertNull(book.getGenre());
    }

    // Tests for getPrice method
    @Test
    public void testGetPrice_positive() {
        assertEquals(45.0, book.getPrice(), 0.01);
    }

    @Test
    public void testGetPrice_edge() {
        book.setPrice(0.0);
        assertEquals(0.0, book.getPrice(), 0.01);
    }

    @Test
    public void testGetPrice_negative() {
        book.setPrice(-10.0);
        assertEquals(-10.0, book.getPrice(), 0.01);
    }

    // Tests for setPrice method
    @Test
    public void testSetPrice_positive() {
        book.setPrice(50.0);
        assertEquals(50.0, book.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice_edge() {
        book.setPrice(0.0);
        assertEquals(0.0, book.getPrice(), 0.01);
    }

    @Test
    public void testSetPrice_negative() {
        book.setPrice(-5.0);
        assertEquals(-5.0, book.getPrice(), 0.01);
    }

    // Tests for getReviews method
    @Test
    public void testGetReviews_positive() {
        assertEquals(2, book.getReviews().size());
        assertTrue(book.getReviews().contains("Great book!"));
    }

    @Test
    public void testGetReviews_edge() {
        book.setReviews(new ArrayList<>());
        assertEquals(0, book.getReviews().size());
    }

    @Test
    public void testGetReviews_negative() {
        book.setReviews(null);
        assertNull(book.getReviews());
    }

    // Tests for setReviews method
    @Test
    public void testSetReviews_positive() {
        List<String> newReviews = new ArrayList<>();
        newReviews.add("Excellent!");
        book.setReviews(newReviews);
        assertEquals(1, book.getReviews().size());
        assertTrue(book.getReviews().contains("Excellent!"));
    }

    @Test
    public void testSetReviews_edge() {
        book.setReviews(new ArrayList<>());
        assertEquals(0, book.getReviews().size());
    }

    @Test
    public void testSetReviews_negative() {
        book.setReviews(null);
        assertNull(book.getReviews());
    }
}

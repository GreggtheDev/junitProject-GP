package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;
    private User user;

    @Before
    public void setUp() {
        userService = new UserService();
        user = new User("testuser", "password123", "testuser@example.com");
        userService.registerUser(user);
    }

    @Test
    public void testUpdateUserProfile_positive() {
        boolean result = userService.updateUserProfile(user, "newuser", "newpassword123", "newemail@example.com");
        assertTrue(result);

        // Verify that the user's details were updated
        User updatedUser = userService.loginUser("newuser", "newpassword123");
        assertNotNull(updatedUser);
        assertEquals("newuser", updatedUser.getUsername());
        assertEquals("newpassword123", updatedUser.getPassword());
        assertEquals("newemail@example.com", updatedUser.getEmail());
    }

    @Test
    public void testUpdateUserProfile_negative_newUsernameAlreadyExists() {
        // Register another user with the new username
        User anotherUser = new User("existinguser", "password456", "existinguser@example.com");
        userService.registerUser(anotherUser);

        // Try updating the first user to use the same username as anotherUser
        boolean result = userService.updateUserProfile(user, "existinguser", "newpassword123", "newemail@example.com");
        assertFalse(result);

        // Verify that the user's details were NOT updated
        User updatedUser = userService.loginUser("existinguser", "newpassword123");
        assertNull(updatedUser); // Should not log in because the update should have failed

        updatedUser = userService.loginUser("testuser", "password123");
        assertNotNull(updatedUser);
        assertEquals("testuser", updatedUser.getUsername());
        assertEquals("password123", updatedUser.getPassword());
        assertEquals("testuser@example.com", updatedUser.getEmail());
    }

    @Test
    public void testUpdateUserProfile_edge_nullUsername() {
        // Attempt to update the user with a null username
        boolean result = userService.updateUserProfile(user, null, "newpassword123", "newemail@example.com");
        assertTrue(result);

        // Since the username is now null, attempting to login with null should succeed
        User updatedUser = userService.loginUser(null, "newpassword123");
        assertNotNull(updatedUser);
        assertEquals(null, updatedUser.getUsername());
        assertEquals("newpassword123", updatedUser.getPassword());
        assertEquals("newemail@example.com", updatedUser.getEmail());
    }
}

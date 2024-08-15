package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;
    private User user1;

    @Before
    public void setUp() {
        userService = new UserService();
        user1 = new User("john_doe", "password123", "john@example.com");
        userService.registerUser(user1);
    }

    // Tests for registerUser method

    @org.junit.jupiter.api.Test
    public void testRegisterUser_positive() {
        User newUser = new User("jane_doe", "password456", "jane@example.com");
        boolean result = userService.registerUser(newUser);
        assertTrue(result);
    }

    @Test
    public void testRegisterUser_negative() {
        boolean result = userService.registerUser(user1); // user1 is already registered in setUp()
        assertFalse(result);
    }

    @Test
    public void testRegisterUser_edge() {
        User nullUser = null;
        boolean result = userService.registerUser(nullUser);
        assertFalse(result); // Null user should not be registered
    }

    // Tests for loginUser method

    @org.testng.annotations.Test
    public void testLoginUser_positive() {
        User result = userService.loginUser("john_doe", "password123");
        assertNotNull(result);
        assertEquals("john_doe", result.getUsername());
    }

    @Test
    public void testLoginUser_negative_wrongPassword() {
        User result = userService.loginUser("john_doe", "wrongpassword");
        assertNull(result); // Should return null due to wrong password
    }

    @Test
    public void testLoginUser_negative_nonexistentUser() {
        User result = userService.loginUser("nonexistent_user", "password");
        assertNull(result); // Should return null since the user doesn't exist
    }

    @Test
    public void testLoginUser_edge_nullValues() {
        User result = userService.loginUser(null, null);
        assertNull(result); // Null values should not log in any user
    }

    // Tests for updateUserProfile method

    @Test
    public void testUpdateUserProfile_positive() {
        boolean result = userService.updateUserProfile(user1, "johnny_doe", "newpassword123", "johnny@example.com");
        assertTrue(result);

        User updatedUser = userService.loginUser("johnny_doe", "newpassword123");
        assertNotNull(updatedUser);
        assertEquals("johnny@example.com", updatedUser.getEmail());
    }

    @Test
    public void testUpdateUserProfile_negative_usernameTaken() {
        User existingUser = new User("jane_doe", "password456", "jane@example.com");
        userService.registerUser(existingUser);

        boolean result = userService.updateUserProfile(user1, "jane_doe", "newpassword123", "johnny@example.com");
        assertFalse(result); // Username "jane_doe" is already taken
    }

    @Test
    public void testUpdateUserProfile_edge_nullValues() {
        boolean result = userService.updateUserProfile(user1, null, null, null);
        assertFalse(result); // Null values should not update the profile
    }
}

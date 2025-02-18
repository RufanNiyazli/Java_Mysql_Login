package com.loginapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.loginapp.service.UserService;
import org.loginapp.dao.UserDAO;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class) // Mockito testlər üçün Runner
public class UserServiceTest {

    @Mock
    private UserDAO userDAO; // UserDAO-nu mock edirik

    @InjectMocks
    private UserService userService; // UserService-ə mock-ı inject edirik

    @Before
    public void setUp() {
        // Hər testdən əvvəl bu metodu çalışdırırıq, mock-u burda konfiqurasiya edə bilərik
    }

    @Test
    public void testRegisterUser_Success() {
        // Arrange (Mocking)
        when(userDAO.registerUser("testUser", "testPass")).thenReturn(true);

        // Act
        boolean result = userService.registerUser("testUser", "testPass");

        // Assert
        assertTrue("Registration should be successful", result);

        // Verify that the registerUser method was called once with the expected parameters
        verify(userDAO, times(1)).registerUser("testUser", "testPass");
    }

    @Test
    public void testLoginUser_Success() {
        // Arrange
        when(userDAO.loginUser("loginUser", "loginPass")).thenReturn(true);

        // Act
        boolean result = userService.loginUser("loginUser", "loginPass");

        // Assert
        assertTrue("Login should be successful", result);
    }

    @Test
    public void testLoginUser_Fail_NonExistingUser() {
        // Arrange
        when(userDAO.loginUser("nonExistingUser", "password")).thenReturn(false);

        // Act
        boolean result = userService.loginUser("nonExistingUser", "password");

        // Assert
        assertFalse("Login should fail for non-existing user", result);
    }
}

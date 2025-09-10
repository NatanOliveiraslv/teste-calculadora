package org.example.authenticaition;

import org.example.authentication.AuthService;
import org.example.authentication.LoginManger;
import org.junit.jupiter.api.Test;

import java.net.Authenticator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginManagerTest {

    @Test
    public void shouldLogin(){

        // Arrange

        AuthService mockAuthService = mock(AuthService.class);

        when(mockAuthService.authenticate("dickvigarista", "12345")).thenReturn(true);

        LoginManger loginManger = new LoginManger(mockAuthService);

        // Action

        String result = loginManger.login("dickvigarista", "12345");

        // Assert

        verify(mockAuthService).authenticate("dickvigarista", "12345");
        assertEquals("Login sucessful", result);

    }

}

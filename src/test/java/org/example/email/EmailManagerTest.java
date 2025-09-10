package org.example.email;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EmailManagerTest {

    @Test
    public void shouldSendWelcomeEmail(){
        // Arrange - Preparar
        EmailService mockEmailService = mock(EmailService.class);

        EmailManager emailManager = new EmailManager(mockEmailService);

        // Action - Executar
        emailManager.sendWelcomEmail("dickvigarista@gmail.com");

        // Assert - Verificar
        verify(mockEmailService).sendEmail("dickvigarista@gmail.com", "Welcome!", "Welcome to our plataform.");
    }
}

package org.example.email;

import static org.mockito.Mockito.mock;

public class EmailManagerTest {

    EmailService mockEmailService = mock(EmailService.class);

    EmailManager emailManager = new EmailManager(mockEmailService);

    emailManager.sendWelcomEmail("natanoliveiraslv14@gmail.com");
}

package com.example.igaming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//@SpringBootTest
//the following annotation exclude loading oauth2 security
//when using the above @SpringBootTest annotation
//@EnableAutoConfiguration(exclude = OAuth2ClientAutoConfiguration.class)
@ActiveProfiles("test")
//The following annotation loads only the connection parts isolating from security aspects
@DataR2dbcTest
class IgamingDiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

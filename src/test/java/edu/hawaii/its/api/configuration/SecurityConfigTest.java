package edu.hawaii.its.api.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("localTest")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class SecurityConfigTest {

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    public void construction() {
        assertNotNull(securityConfig);
        assertNotNull(securityConfig.singleLogoutFilter());
        assertNotNull(securityConfig.logoutFilter());
    }

}
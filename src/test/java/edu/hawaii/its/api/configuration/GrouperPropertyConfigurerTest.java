package edu.hawaii.its.api.configuration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import edu.internet2.middleware.grouperClient.util.GrouperClientConfig;


@SpringBootTest(classes = {SpringBootWebApplication.class})
@TestPropertySource(properties = {"grouperClient.webService.url=test-url-b"})
public class GrouperPropertyConfigurerTest {

    @Autowired
    private GrouperPropertyConfigurer grouperPropertyConfigurer;

    @Test
    public void construction() {
        assertNotNull(grouperPropertyConfigurer);
    }

    @Test
    public void testingOverrideProperty() {
        GrouperClientConfig config = GrouperClientConfig.retrieveConfig();

        // Define the key and the expected test value.
        String key = "grouperClient.webService.url";
        String testUrl = "test-url-b";

        // Now perform the initialization that overrides the value.
        grouperPropertyConfigurer.init();

        // Check that the override worked as expected.
        String overriddenValue = config.propertiesOverrideMap().get(key);
        assertThat(overriddenValue, equalTo(testUrl));
    }
}

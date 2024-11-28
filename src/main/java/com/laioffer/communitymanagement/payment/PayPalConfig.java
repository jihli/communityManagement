package com.laioffer.communitymanagement.paymetn;

import com.paypal.base.rest.APIContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayPalConfig {

    @Bean
    public APIContext apiContext() {
        String clientId = "YOUR_CLIENT_ID";
        String clientSecret = "YOUR_CLIENT_SECRET";
        return new APIContext(clientId, clientSecret, "sandbox");
    }
}

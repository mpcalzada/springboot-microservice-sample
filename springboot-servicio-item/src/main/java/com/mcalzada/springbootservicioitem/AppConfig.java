package com.mcalzada.springbootservicioitem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * {@link AppConfig}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Configuration
public class AppConfig
{
    @Bean("clienteRest")
    public RestTemplate registarRestTemplate()
    {
        return new RestTemplate();
    }
}

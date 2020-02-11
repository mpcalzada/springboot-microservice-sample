package com.mcalzada.springbootservicioitem;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    public RestTemplate registarRestTemplate()
    {
        return new RestTemplate();
    }
}

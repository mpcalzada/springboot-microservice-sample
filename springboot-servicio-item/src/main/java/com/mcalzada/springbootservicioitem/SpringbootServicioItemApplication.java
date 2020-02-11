package com.mcalzada.springbootservicioitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "servicio-productos")
@EnableEurekaClient
public class SpringbootServicioItemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootServicioItemApplication.class, args);
    }
}

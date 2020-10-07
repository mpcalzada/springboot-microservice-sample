package com.mcalzada.springbootservicioitem.controller;

import com.mcalzada.springbootservicioitem.models.Item;
import com.mcalzada.springbootservicioitem.models.Producto;
import com.mcalzada.springbootservicioitem.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link ItemController}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@RefreshScope
@RestController
@Log4j2
public class ItemController
{
    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    @Value("${configuracion.texto}")
    private String texto;

    @GetMapping("/listar")
    public List<Item> listar()
    {
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "detalleErrorHandling")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad)
    {
        return itemService.findById(id, cantidad);
    }

    public Item detalleErrorHandling(Long id, Integer cantidad)
    {
        return new Item(new Producto(), cantidad);
    }

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String port)
    {
        log.info(texto);
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);
        json.put("port", port);

        if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev"))
        {
            json.put("nombre", env.getProperty("configuracion.autor.nombre"));
            json.put("email", env.getProperty("configuracion.autor.correo"));
        }

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}

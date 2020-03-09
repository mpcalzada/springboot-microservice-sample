package com.mcalzada.springbootservicioitem.controller;

import com.mcalzada.springbootservicioitem.models.Item;
import com.mcalzada.springbootservicioitem.models.Producto;
import com.mcalzada.springbootservicioitem.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link ItemController}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@RestController
public class ItemController
{
    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

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
}

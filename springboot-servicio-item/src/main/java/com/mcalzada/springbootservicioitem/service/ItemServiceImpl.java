package com.mcalzada.springbootservicioitem.service;

import com.mcalzada.springbootservicioitem.models.Item;
import com.mcalzada.springbootservicioitem.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * {@link ItemServiceImpl}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Service
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll()
    {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad)
    {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        return new Item(clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables), cantidad);
    }
}

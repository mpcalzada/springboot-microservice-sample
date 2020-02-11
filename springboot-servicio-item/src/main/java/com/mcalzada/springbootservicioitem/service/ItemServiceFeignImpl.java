package com.mcalzada.springbootservicioitem.service;

import com.mcalzada.springbootservicioitem.clientes.ProductoClienteRest;
import com.mcalzada.springbootservicioitem.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link ItemServiceFeignImpl}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Service("serviceFeign")
@Primary
public class ItemServiceFeignImpl implements ItemService
{
    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Item> findAll()
    {
        return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad)
    {
        return new Item(clienteFeign.detalle(id), cantidad);
    }
}

package com.mcalzada.springbootservicioproductos.controllers;

import com.mcalzada.springbootservicioproductos.models.entity.Producto;
import com.mcalzada.springbootservicioproductos.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * {@link ProductoController}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@RestController
public class ProductoController
{
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar()
    {
        return productoService.findAll().stream().peek(p -> p.setPort(port)).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id)
    {
        Producto producto = productoService.findById(id);
        producto.setPort(port);
        return producto;
    }
}

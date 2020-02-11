package com.mcalzada.springbootservicioproductos.controllers;

import com.mcalzada.springbootservicioproductos.models.entity.Producto;
import com.mcalzada.springbootservicioproductos.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar()
    {
        return productoService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id)
    {
        return productoService.findById(id);
    }
}

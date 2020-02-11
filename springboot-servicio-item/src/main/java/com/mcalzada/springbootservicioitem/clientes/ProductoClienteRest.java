package com.mcalzada.springbootservicioitem.clientes;

import com.mcalzada.springbootservicioitem.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * {@link ProductoClienteRest}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest
{
    @GetMapping("/listar")
    List<Producto> listar();

    @GetMapping("/ver/{id}")
    Producto detalle(@PathVariable Long id);
}

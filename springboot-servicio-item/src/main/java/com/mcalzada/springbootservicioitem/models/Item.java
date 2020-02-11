package com.mcalzada.springbootservicioitem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * {@link Item}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item
{
    private Producto producto;
    private Integer cantidad;

    public Double getTotal()
    {
        return producto.getPrecio() * cantidad.doubleValue();
    }
}

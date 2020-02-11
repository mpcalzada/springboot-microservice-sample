package com.mcalzada.springbootservicioitem.models;

import lombok.Data;

import java.util.Date;

/**
 * {@link Producto}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Data
public class Producto
{
    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
    private Integer port;
}

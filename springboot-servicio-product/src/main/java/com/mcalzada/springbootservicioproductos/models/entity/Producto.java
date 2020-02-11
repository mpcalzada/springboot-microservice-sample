package com.mcalzada.springbootservicioproductos.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * {@link Producto}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Transient
    private Integer port;
}

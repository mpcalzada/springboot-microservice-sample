package com.mcalzada.springbootservicioproductos.models.service;

import com.mcalzada.springbootservicioproductos.models.entity.Producto;

import java.util.List;

public interface ProductoService
{
    List<Producto> findAll();

    Producto findById(Long id);
}

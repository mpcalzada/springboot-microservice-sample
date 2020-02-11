package com.mcalzada.springbootservicioproductos.models.service;

import com.mcalzada.springbootservicioproductos.models.entity.Producto;
import com.mcalzada.springbootservicioproductos.models.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link ProductoServiceImpl}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
@Service
public class ProductoServiceImpl implements ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll()
    {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id)
    {
        return productoRepository.findById(id).orElse(null);
    }
}

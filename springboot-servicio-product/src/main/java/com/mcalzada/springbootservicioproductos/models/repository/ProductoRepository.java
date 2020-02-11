package com.mcalzada.springbootservicioproductos.models.repository;

import com.mcalzada.springbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long>
{

}

package com.mcalzada.springbootservicioitem.service;

import com.mcalzada.springbootservicioitem.models.Item;

import java.util.List;

public interface ItemService
{
    List<Item> findAll();

    Item findById(Long id, Integer cantidad);
}

package com.notasprogramacion.pv.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notasprogramacion.pv.api.model.Producto;
import com.notasprogramacion.pv.api.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> getAll() {
		return productoRepository.getAll();
	}

	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	public void update(Producto producto) {
		productoRepository.update(producto);
	}

	public void delete(Long idProducto) {
		productoRepository.delete(idProducto);
	}
}

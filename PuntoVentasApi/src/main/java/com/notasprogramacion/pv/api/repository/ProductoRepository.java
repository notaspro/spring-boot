package com.notasprogramacion.pv.api.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.notasprogramacion.pv.api.model.Producto;

@Repository
public class ProductoRepository {

	private List<Producto> productosList = new ArrayList<Producto>();
	{
		productosList.add(new Producto(1L, "Jabon", "Jabon de Baño 1pza, 200gr", "Abarrotes", new BigDecimal(15.50)));
		productosList.add(new Producto(2L, "Azucar", "Azucar refinada 1kg", "Abarrotes", new BigDecimal(22.0)));
		productosList.add(new Producto(3L, "Leche", "Leche Deslactosada 1Lt", "Abarrotes", new BigDecimal(19.0)));
	}

	public List<Producto> getAll() {
		return productosList;
	}

	public void save(Producto producto) {
		producto.setId(new Long(productosList.size()) + 1);
		productosList.add(producto);
	}

	public void update(Producto producto) {
		productosList.stream().forEach(productoUpdated -> {
			if (productoUpdated.getId().equals(producto.getId())) {
				productoUpdated.setNombre(producto.getNombre());
				productoUpdated.setDescripcion(producto.getDescripcion());
				productoUpdated.setCategoria(producto.getCategoria());
				productoUpdated.setPrecio(producto.getPrecio());
			}
		});
	}

	public void delete(Long idProducto) {
		for (Producto producto : productosList) {
			if (idProducto.equals(producto.getId())) {
				productosList.remove(producto);
				break;
			}
		}
	}

}

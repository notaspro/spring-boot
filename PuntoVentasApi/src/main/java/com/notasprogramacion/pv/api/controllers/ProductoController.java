package com.notasprogramacion.pv.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notasprogramacion.pv.api.model.Producto;
import com.notasprogramacion.pv.api.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public ResponseEntity<List<Producto>> getAll() {
		return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<HttpStatus> save(@RequestBody(required = true) Producto producto) {
		productoService.save(producto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<HttpStatus> update(@RequestBody(required = true) Producto producto) {
		productoService.update(producto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{idProducto}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(required = true) Long idProducto) {
		productoService.delete(idProducto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

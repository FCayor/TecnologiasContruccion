package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
	
	List<Producto> productos=new ArrayList<Producto>();
	Producto auxiliar;

	@Bean
	CommandLineRunner iniciarBD() {
		return args ->{
			productos.add(new Producto((long) 1,"Cuarto","cama","mesa","silla"));
			productos.add(new Producto((long) 2,"Sala","sofa","televsir","radio"));
			productos.add(new Producto((long) 3,"taller","pintura","martillo","tuerca"));
		};
	}
	
	@GetMapping("/mensaje")
	public String mensaje(@RequestParam String categoria) {
		return "hola mundo";
		
	}
	@GetMapping("/productosmostrar")
	public List<Producto> mensajes() {
		return productos;
		
	}

	@GetMapping("/productos")
	public Producto productoss(@RequestParam String categoria) {
		for(int i=0;i<productos.size();i++) {
			auxiliar=productos.get(i);
			if(auxiliar.compare(categoria)) {
				return auxiliar;
			}	
		}
		return null;
	}
	
	@PostMapping("/productosagregar")
	public Producto productosAgregar(
			@RequestParam Long id,
			@RequestParam String name,
			@RequestParam String producto1,
			@RequestParam String producto2,
			@RequestParam String producto3
			) {

			auxiliar= new Producto(id,name,producto1,producto2,producto3);
			productos.add(auxiliar);
			return auxiliar;
	}
	
	@PutMapping("/producto/{id}")
	public Producto productomodificar(@PathVariable Long id,@RequestBody Producto productoe){
			for(int i=0;i<productos.size();i++) {
				auxiliar=productos.get(i);
				if(auxiliar.getId() ==id) {
					productos.remove(i);
					productos.add(i, productoe);
					return auxiliar;
				}	
			}
		return null;
	}
	
	@DeleteMapping("/productos/{id}")
	void productoeliminar(@PathVariable Long id) {
		if(id<=productos.size()) {
			for(int i=0;i<productos.size();i++) {
				auxiliar=productos.get(i);
				if(auxiliar.getId().equals(id)) {
					productos.remove(i);
				}	
			}
		}
	}
	
}	

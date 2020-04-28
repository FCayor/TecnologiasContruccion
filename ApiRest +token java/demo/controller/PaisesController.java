package com.example.demo.controller;

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
public class PaisesController {
	ArrayList<Departamento> departamentos=new ArrayList<Departamento>();
	ArrayList<Provincia> provincias=new ArrayList<Provincia>();
	ArrayList<Distrito> distritos=new ArrayList<Distrito>();
	Departamento auxiliar;
	
	@Bean
	CommandLineRunner iniciarrBD() {
		return args ->{
			distritos.add(new Distrito("Chivay"));
			Provincia provincia=new Provincia("Caylloma",distritos) ;

			provincias.add(provincia);
			
			departamentos.add(new Departamento("Arequipa",provincias));
		};
	}
	
	//-------------------------------------------------------------------
	
		@GetMapping("/mensaje")
		public String mensaje() {
			return "hola mundo";
			
		}
		@GetMapping("/departamentos")
		public ArrayList<Departamento> departamentos() {
			return departamentos;	
		}
		
		@PostMapping("/departamento")
		public Departamento departamentos(@RequestParam String departamento) {
			for(int i=0;i<departamentos.size();i++) {
				auxiliar=departamentos.get(i);
				if(auxiliar.getNombre().equals(departamento)) {
					return auxiliar;
				}	
			}
			return null;	
		}
		
		@PostMapping("/departamentos")
		public String paisesAgregar(
				@RequestBody Departamento departamentoEntrante) {
			departamentos.add(departamentoEntrante);
				return "Exito";
		}
		
		@PutMapping("/departamentos")
		public String paisesModificar(@RequestParam String departamento,
				@RequestBody Departamento paisEntrante) {
				for(int i=0;i<departamentos.size();i++) {
					auxiliar=departamentos.get(i);
					if(auxiliar.getNombre().equals(departamento)) {
						departamentos.set(i, paisEntrante);
						return "Exito";
					}	
				}	
				return "Error";
		}
		
		@DeleteMapping("/departamentos")
		void productoeliminar(@RequestParam String departamento) {
			for(int i=0;i<departamentos.size();i++) {
				auxiliar=departamentos.get(i);
				if(auxiliar.getNombre().equals(departamento)) {
					departamentos.remove(i);
				}	
			}
		}
}

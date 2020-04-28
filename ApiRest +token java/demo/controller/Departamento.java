package com.example.demo.controller;

import java.util.ArrayList;

public class Departamento {
	
	String nombre;

	ArrayList<Provincia> provincias;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(ArrayList<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Departamento(String nombre, ArrayList<Provincia> provincias) {
		super();
		this.nombre = nombre;
		this.provincias = provincias;
	}

	public Departamento() {
	}

	
	
	
}

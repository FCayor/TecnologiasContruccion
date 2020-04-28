package com.example.demo.controller;

import java.util.ArrayList;

public class Provincia {
	String nombre;
	ArrayList<Distrito> distritos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Distrito> getDistritos() {
		return distritos;
	}
	public void setDistritos(ArrayList<Distrito> distritos) {
		this.distritos = distritos;
	}
	public Provincia(String nombre, ArrayList<Distrito> distritos) {
		super();
		this.nombre = nombre;
		this.distritos = distritos;
	}

	public Provincia() {
	}



	
	
}

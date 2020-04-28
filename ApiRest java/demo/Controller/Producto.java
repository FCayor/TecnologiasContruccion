package com.example.demo.Controller;

public class Producto {
	long id;
	String nombre;
	String Producto1;
	String Producto2;
	String Producto3;
	
	public Producto(Long id,String nombre,String Producto1,String Producto2,String Producto3) {
		this.id=id;
		this.nombre = nombre;
		this.Producto1 = Producto1;
		this.Producto2 = Producto2;
		this.Producto3 = Producto3;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public boolean compare(String nombre2) {
		if(nombre.equals(nombre2)) {
			return true;
		}
		return false;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProducto1() {
		return Producto1;
	}
	public void setProducto1(String producto1) {
		Producto1 = producto1;
	}
	public String getProducto2() {
		return Producto2;
	}
	public void setProducto2(String producto2) {
		Producto2 = producto2;
	}
	public String getProducto3() {
		return Producto3;
	}
	public void setProducto3(String producto3) {
		Producto3 = producto3;
	}
}

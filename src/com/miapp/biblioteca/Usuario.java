package com.miapp.biblioteca;

import java.util.ArrayList;



public class Usuario {
	private String Nombre;
	private String Id;
	private ArrayList<Libro> LibrosPrestados;
	
	
	public Usuario(){
		
	}
	
	public Usuario(String Nombre, String Id) {
		this.Nombre = Nombre;
		this.Id = Id;
		this.LibrosPrestados = new ArrayList<>();	
	}



	public String getNombre() {
		 return Nombre;
	}
	
	public void setNombre(String Nombre) {
		 this.Nombre = Nombre;
	}
	
	
	 public String getId() {
		 return Id;
	 }
	 
	 public void setId(String Id) {
		 this.Id = Id;
	 }
	 
	 public ArrayList<Libro> getLibrosPrestados() {
		 return LibrosPrestados;
	 }
	 
	 public String toString() {
		 return "Usuario [Nombre: "+ Nombre + ", Id: "+ Id + "]";
	 }
	 
}

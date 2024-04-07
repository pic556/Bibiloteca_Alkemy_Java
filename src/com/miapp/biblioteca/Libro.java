package com.miapp.biblioteca;

import java.util.Scanner;



public class Libro {
    private String Titulo;
    private String Autor;
	private String ISBN;
    private String Genero;
    private boolean Disponibilidad;
    
    
    
    public Libro( String Titulo, String Autor, String ISBN,String Genero ) {
		 this.Titulo = Titulo;
	     this.Autor = Autor;
		 this.ISBN = ISBN;
		 this.Genero = Genero;
		 this.Disponibilidad = true;
	 }// constructor por parametro
    
    
	 public Libro() {
	        
	    }// constructor por defecto

	 

	 
	
	 
	 public String getTitulo() {
		 return Titulo;
	 }
	 
	 public void setTitulo(String Titulo) {
		 this.Titulo = Titulo;
	 }
	 
	 public String getAutor() {
		 return Autor	;
	 }
	 
	 public void setAutor(String Autor) {
		 this.Autor = Autor;
	 }	 
	 
	 public String getISBN() {
		 return ISBN;
	 }
	 
	 public void setISBN(String ISBN) {
		 this.ISBN = ISBN;
	 }	 
	 
	 public String getGenero() {
		 return Genero;
	 }
	 
	 public void setGenero(String Genero) {
		 this.Genero = Genero;
	 }	 
	 
	 public boolean getDisponibilidad() {
		 return Disponibilidad;
	 }
	 
	 public void setDisponibilidad(boolean Disponibilidad) {
		 this.Disponibilidad = Disponibilidad;
	 }
	 
	 
	 
	 public String toString() {
		return "Libro [Titulo: " + Titulo + " "+
				 " Autor: "+ Autor + " "+
				 " ISBN: " + ISBN + " "+
				 "Genero: "+ Genero+ " "+
				 "Disponibilidad: "+ Disponibilidad +" ]";
	 } 
}
	 

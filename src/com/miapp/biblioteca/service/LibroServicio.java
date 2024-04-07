package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.miapp.biblioteca.Libro;

public class LibroServicio {
	
	private  ArrayList<Libro> biblioteca;
	
	
	
	public LibroServicio(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public void crearLibro(String Titulo, String Autor , String ISBN ,String Genero) {
		Libro nuevoLibro = new Libro(Titulo,Autor,ISBN,Genero);
		biblioteca.add(nuevoLibro);
	}
	
	
	public ArrayList<Libro> obtenerTodosLoslibros(){
		return biblioteca;
	}
	
	public void actuliazarLibro(String ISBN, String nuevoTitulo, String nuevoAutor, 
								String nuevoGenero) {
		for(Libro libro:biblioteca) {
			if(libro.getISBN().equals(ISBN)) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setGenero(nuevoGenero);
			}
			
			
		}
	}
	
	
	public void eliminarLibro(String ISBN) {
		
		Iterator<Libro> it = biblioteca.iterator();
		
		while (it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {
				it.remove();
			}
			
		}
		
	}
	
	
	public Libro buscarLibroPorISBN(String ISBN) {
		for(Libro libro:biblioteca) {
			if(libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}
	
	
	public ArrayList<Libro> buscarLibrosPorTitutlo(String titulo){
		ArrayList<Libro> librosEncontrados = new ArrayList<Libro>();
		for(Libro libro: biblioteca) {
			if(libro.getTitulo().equals(titulo)) {
				librosEncontrados.add(libro);
			}
		}
		return librosEncontrados;
	}
	
	
	public boolean verificarDisponibilidad(Libro libro) {
		return libro.getDisponibilidad();
	}
	
	
	
	

}

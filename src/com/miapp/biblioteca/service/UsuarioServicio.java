package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class UsuarioServicio {
	
	private ArrayList<Usuario> usuarios;
	
	public  UsuarioServicio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void crearUsuario(String nombre,String id) {
		Usuario nuevoUsuario = new Usuario(nombre,id);
		usuarios.add(nuevoUsuario);
	}
	
	public ArrayList<Usuario> obtenerTodosLosUsuarios(){
		return usuarios;
	}
	
	public void actulizarUsuario(String id, String nuevoNombre) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId().equals(id)) {
				usuario.setNombre(nuevoNombre);
			}
		}
	}
	
	public void eliminarUsuarios(String id) {
		Iterator<Usuario> it = usuarios.iterator();
		
		while(it.hasNext()) {
			
			if(it.next().getId().equals(id)) {
				it.remove();
				System.out.println("Se elimino un usuario");
			}
		}
	}
	
	public void prestarLibro(Usuario usuario, Libro libro) {
		if (libro.getDisponibilidad()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponibilidad(false);
		}else {
			System.out.println("El libro no esta disponible para prestamo.");
		}
	}
	
	public Usuario buscarUsuarioPorID(String id) {
		for(Usuario usuario: usuarios) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}
	
	
	public void devolverLibro(Usuario usuario, Libro libro) {
		if(usuario.getLibrosPrestados().contains(libro)) {
			usuario.getLibrosPrestados().remove(libro);
			libro.setDisponibilidad(true);
		}
		else {
			System.out.println("Este libro no fue prestado por este usuario");
		}
	}

	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
}

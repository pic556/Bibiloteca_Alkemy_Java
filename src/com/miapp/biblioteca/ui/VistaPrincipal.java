package com.miapp.biblioteca.ui;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;


import java.util.ArrayList;
import java.util.Scanner;

public class VistaPrincipal {

	public static void main(String[] args) {
		
		ArrayList<Libro> biblioteca = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		LibroServicio libroServicio = new LibroServicio(biblioteca);
		UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
		Scanner scanner = new Scanner(System.in).useDelimiter("\r\n");
		
		int opcion;
		do {
            System.out.println("\n===== Biblioteca Digital =====");
            System.out.println("1. crear Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Buscar Libro por ISBN");
            System.out.println("4. Buscar libro por TITULO");            
            System.out.println("5. Listar Libros");
            System.out.println("6. Eliminar Libro");
            System.out.println("7. Prestamos");
            System.out.println("8. Devoluciones");
            System.out.println("9. Crear Usuario");
            System.out.println("10. Actualizar Usuario");
            System.out.println("11. Listar Usuario");
            System.out.println("12. Remover Usuario");
            System.out.println("13. Salir");
            System.out.println("\nIngrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
            case 1:
            	System.out.println("\n=== creamos libro ===");           	
     	    	System.out.println("INGRESAR TITULO: ");
     	    	String Titulo = scanner.nextLine();
     	    	System.out.println("\nINGRESAR AUTOR: ");
     	    	String Autor = scanner.nextLine();
     	    	System.out.println("\nINGRESAR ISBN : ");
     	    	String ISBN = scanner.nextLine();
     	    	System.out.println("\nINGRESAR GENERO : ");
     	    	String Genero = scanner.nextLine();
     	    	libroServicio.crearLibro(Titulo, Autor, ISBN, Genero);
     	    	break;
     	    
            case 2:
            	System.out.println("\n=== Actualizar libro ===");
            	System.out.println("\n Ingrese el ISBN de libro a actualizar ");
            	String ISBN_Ac = scanner.nextLine();
    	    	System.out.println("\nIngrese nuevo titulo: ");
    	    	String Titulo_Ac = scanner.nextLine();
    	    	System.out.println("\nIngrese nuevo autor: ");
    	    	String Autor_Ac = scanner.nextLine();
    	    	System.out.println("\nIngrese nuevo genero: ");
    	    	String Genero_Ac = scanner.nextLine();
    	    	libroServicio.actuliazarLibro(ISBN_Ac, Titulo_Ac, Autor_Ac, Genero_Ac);
            	break;
            	
            case 3:
            	System.out.println("\n=== Buscar libro por ISBN ===");
            	System.out.println("\nIngrese el ISBN: ");
            	String ISBN_bu = scanner.nextLine();
            	Libro libroISBN_bu = libroServicio.buscarLibroPorISBN(ISBN_bu);
            	if (libroISBN_bu != null) {
            		System.out.println("\nLibro encontrado: " + libroISBN_bu.getTitulo());
            	} else {
            		System.out.println("\nLibro no encontrado");
            	}            	
            	break;
            	
            case 4:
            	System.out.println("\n=== Buscar libro por ISBN ===");
            	System.out.println("\nIngrese el Titulo: ");
            	String Titulo_bu = scanner.nextLine();
            	ArrayList<Libro> librosTitulo_bu= libroServicio.buscarLibrosPorTitutlo(Titulo_bu);
            	if (!librosTitulo_bu.isEmpty()) {
            		System.out.println("\nLibros encontrados:");
            		for(Libro libro: librosTitulo_bu) {
            			System.out.println(libro.getTitulo());
            		}
            	}else {
            		System.out.println("\nningun libro encontrado con ese titulo");
            	}
            	break;
            case 5:
            	System.out.println("\n=== Listar Libros ===");
            	ArrayList<Libro> librosObt = libroServicio.obtenerTodosLoslibros();
            	for(Libro libro:librosObt) {
            		System.out.println(libro.getTitulo() + " ( " + libro.getISBN() + " ) ");
            	}
            	break;
            	
            case 6:
            	System.out.println("\n=== Eliminar libro ===");
            	System.out.println("\nIngrese el ISBN de libro a eliminar: ");
            	String ISBN_el = scanner.nextLine();
            	libroServicio.eliminarLibro(ISBN_el);           	
            	break;
            	
            case 7:
            	System.out.println("\n=== Prestamos ===");
            	System.out.println("\nIngrese el numero de identificacion de usuario: ");
            	String idUs_pr = scanner.nextLine();
            	Usuario us_pr = usuarioServicio.buscarUsuarioPorID(idUs_pr);
            	if(us_pr != null) {
            		System.out.println("\nIngrese el ISBN del libro a prestar: ");
            		String isbn_pr = scanner.nextLine();
            		Libro libro_pr = libroServicio.buscarLibroPorISBN(isbn_pr);
            		if(libro_pr != null) {
            			if(libroServicio.verificarDisponibilidad(libro_pr)) {
            				usuarioServicio.prestarLibro(us_pr, libro_pr);
            				System.out.println("\nPrestamo exitoso. libro prestado a "+ us_pr.getNombre());
            			}else {
            				System.out.println("\nEl libro no esta disponible para prestamo");
            				}
          
            		}else {
            			System.out.println("\nLibro NO ENCONTRADO");
            			}
            	}else {
            		System.out.println("\nusuario no encontrado");
            	}
            	break;
            	
            case 8:
            	System.out.println("\n=== Devoluciones ===");
            	System.out.println("\nIngrese el numero de identificacion del usuario: ");
            	String id_us_de = scanner.nextLine();
            	Usuario us_de = usuarioServicio.buscarUsuarioPorID(id_us_de);
            	if (us_de !=null) {
            		System.out.println("\nIngrese el ISBN del libro a devolver: ");
            		String isbn_de = scanner.nextLine();
            		Libro lib_de = libroServicio.buscarLibroPorISBN(isbn_de);
            		if(lib_de !=null) {
            			usuarioServicio.devolverLibro(us_de, lib_de);
            			System.out.println("\nDevolucion exitosa. libro devuelto por" + us_de.getNombre());
            		}else {
            			System.out.println("\nLibro no encontrado");
            		}
            	}else {
            		System.out.println("\nUsuario no encotrado");
            	}
            	break;
            	
            case 9:
            	System.out.println("\n=== creamos Usuario ===");
     	    	System.out.println("\nINGRESAR Nombre: ");
     	    	String Nombre = scanner.nextLine();
     	    	System.out.println("\nINGRESAR Id: ");
     	    	String id = scanner.nextLine();
     	    	usuarioServicio.crearUsuario(Nombre, id);
            	break;
            	
            case 10:
            	System.out.println("\n=== Actualizar Usuario ===");
            	System.out.println("\nIngrese el id del usuario a actualizar ");
            	String Id_Ac = scanner.nextLine();
    	    	System.out.println("\nIngrese nuevo nombre: ");
    	    	String nombre_Ac = scanner.nextLine();
    	    	usuarioServicio.actulizarUsuario(Id_Ac, nombre_Ac);
    	    	break;
    	    	
            case 11:
            	System.out.println("\n=== Listar Usuario ===");
            	ArrayList<Usuario> UsuariosOb = usuarioServicio.obtenerTodosLosUsuarios();
            	for(Usuario us:UsuariosOb) {
            		System.out.println(us.getNombre() + " ( " + us.getId()+ " ) ");
            	}
            	break;
            	
            case 12:
            	System.out.println("\n=== Remover Usuario ===");
            	System.out.println("\nIngrese el ID del Usuario a remover: ");
            	String id_re = scanner.nextLine();
            	usuarioServicio.eliminarUsuarios(id_re);           	
            	break;
            case 13:
            	 System.out.println("\nGracias por utilizar la Biblioteca Digital. ¡Hasta luego!");
                 break;
            default:
                System.out.println("\nOpción inválida. Por favor, seleccione una opción válida.");
                break;
  
            	}
            }while (opcion != 13);
        scanner.close(); // Cerrar el Scanner al salir del programa

	}

}

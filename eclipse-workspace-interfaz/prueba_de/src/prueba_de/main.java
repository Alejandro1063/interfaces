package prueba_de;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	
	public static void main(String[] args) {
		ArrayList<Persona> lista = new ArrayList<>();
		Scanner scanne = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			Persona p = new Persona();
			System.out.println("Dime el dni");
			
			p.setDni(scanne.nextLine());
			
			System.out.println("Dime el nombre");
			p.setNombre(scanne.nextLine());
			
			lista.add(p);
		}
		
		for (int i = 0; i < lista.size(); i++) {
		System.out.println(lista.get(i).getDni());
		System.out.println(lista.get(i).getNombre());
}
		scanne.close();
			
		}
	
	}



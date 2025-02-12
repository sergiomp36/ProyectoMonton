package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
	

	// MÉTODOS
	public static void mostrarReglasInformacion(int opcion) {
		System.out.println("Método mostrarReglasInformacion llamado con opción: " + opcion);
		if (opcion == 2) {
			leerReglas();
		}
		else if (opcion == 3) {
			leerInformacion();
		}
	}

	public static void mostrarGanador() {
		
	}
	
	
	public static void leerReglas() {//SE LEE DOS VECES Y NO ENCUENTRO EL FALLO
		try {
            File archivo = new File("reglas.txt");
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) { 
                System.out.println(scanner.nextLine());
            }

            scanner.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
            e.printStackTrace();
        }
	}
	
	
	public static void leerInformacion() {
		try {
            File archivo = new File("informacion.txt"); // Ruta del archivo
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) { // Leer línea por línea
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
            scanner.close(); // Cerrar el scanner
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
            e.printStackTrace();
        }
	}
	
	
	
	public static boolean contains(int[] array, int valor) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == valor) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean contains(String[] array, String valor) {
        for (String elemento : array) {
            if (elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }

	public static boolean contains(ArrayList<String> array, String valor) {
        for (String elemento : array) {
            if (elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }
	
	public static int indexOf(String[] array, String valor) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(valor)) {
				return i;
			}
		}
		return -1; // si no encontrara el valor, retornaria menis 1
	}
	
	public static boolean comprobarPaisesRegex(String texto) {
        Pattern pattern = Pattern.compile("^(ALEMANIA|FRANCIA|AUSTRIA|YUGOSLAVIA|ITALIA|HUNGRIA|POLONIA|BELGICA|DINAMARCA|SUIZA)$"); // Compilar la expresión regular
        Matcher matcher = pattern.matcher(texto); // Crear el matcher para la cadena
        return matcher.matches(); // Verificar si el texto coincide completamente con la regex
    }

}
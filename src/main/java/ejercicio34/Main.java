/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio34;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author tomas
 */
public class Main {

    public static void main(String[] args) {
        // Creo el directorio donde leeré el fichero. 
        crearDirectorios("./datos");
        String rutaArchivo = "./datos/RelEmpCenAus.csv";
        String elementoSeparador = ",";
        
        // Creo la lista POJO donde guardare los datos obtenidos del fichero que deseo leer. 
        List<POJO> listaPOJO = new ArrayList<>();
        
        leerFichero(rutaArchivo, elementoSeparador, listaPOJO);
        System.out.println("\n Muestro la lista con los datos del CSV \n");
        listaPOJO.forEach(System.out::println);
        
        // Métodos del Ejercicio 4. 
        // A)
        ej1_4(listaPOJO);
        // B)
         ej2_4(listaPOJO);
        // C)
        ej3_4(listaPOJO);
        
        
        
        

    }
    // Método para crear un directorio donde leeremos el fichero. 

    public static void crearDirectorios(String ruta) {
        Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
            System.out.println("El directorio se ha creado correctamente");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + e.getMessage());
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

//     //Método para leer el fichero dado. 
    public static List<POJO> leerFichero(String rutaFichero, String elemento_Separador, List<POJO> lista) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String idFichero = rutaFichero;
        String[] tokens;
        String linea;

        try ( Scanner teclado = new Scanner(new File(idFichero), "ISO_8859_1")) {
            // Como el fichero tiene las primeras lineas con datos que no nos interesan salto esas lineas. 
            teclado.nextLine();

            // Ahora voy recorriendo cada una de las lineas y quedandome con 
            // los datos que me interesan de cada una de ellas. 
            while (teclado.hasNextLine()) {
                //Empleado e1 = new Empleado();
                POJO p1 = new POJO();

                // Guarda la línea completa en un String
                linea = teclado.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                // Convierte en String tokens
                tokens = linea.split(elemento_Separador);

                // Quito espacios en blanco.
                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].replaceAll("\"", "");
                }

                p1.setNombre(tokens[0]);
                p1.setDni_pasaporte(tokens[1]);
                p1.setTipoPersonal(tokens[2]);
                p1.setPuestoTrabajo(tokens[3]);
                p1.setHorarioPersonalizado(tokens[4].equalsIgnoreCase("Si"));

                // para las fechas tengo que usar un try catch
                try {
                    p1.setFechaAlta(LocalDate.parse(tokens[5], formatter));
                } catch (DateTimeParseException dtpe) {
                    p1.setFechaAlta(null);
                }

                try {
                    p1.setFechaBaja(LocalDate.parse(tokens[6], formatter));
                } catch (DateTimeParseException dtpe) {
                    p1.setFechaBaja(null);
                }
                
                
                p1.setHorasIniciales(tokens[7]);
                p1.setTotalHoras(tokens[8]);
                p1.setActivo(tokens[9]);
                lista.add(p1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    // Métodos ejercicio 4
    public static List<POJO> ej1_4(List<POJO>lista){
        lista.stream().distinct().filter(p -> p.getPuestoTrabajo().contains("Docente Funcionario | No Docente Laboral | Docente Laboral "));
        return lista;
    }
    
    public static void ej2_4(List<POJO>lista){
        int num = (int)lista.stream().distinct().count();
        System.out.println("Hay " + num + " trabajadores");
    }
    
    public static void ej3_4(List<POJO> lista){
        Comparator<POJO> porNombre = (e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre());
        lista.stream().distinct().filter(p -> p.getDni_pasaporte().matches("[0-9]{8}[A-Z]{1}")).sorted(porNombre).filter(p2 -> p2.getActivo().contains("N"));
    }
}

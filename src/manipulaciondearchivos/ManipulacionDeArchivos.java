package manipulaciondearchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulacionDeArchivos {
    
    public static int countFileLines(String name){
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        int numLineas = 0;
        
        try{
            //crear un apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name + ".txt");          
            reader = new FileReader(archivo);            
            bufer = new BufferedReader(reader);
            //contar las lineas que tiene el archivo
            while((bufer.readLine())!= null ){
                numLineas++;
            }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        
        return numLineas;
    }
    
    public static String[] fileToStringArray(String name) throws IOException{
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        String linea;
        String[] array = null;
        int t;
        int i = 0;
        
        try{
            //obtener tamaño archivo
            t = countFileLines(name);
            //con el tamaño del archivo, contruimos arreglos
            array = new String[t];
            //crear un apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name + ".txt");
            //abrir el archivo para lectura
            reader = new FileReader(archivo);
            //configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            //lectura de contenido del archivo
            while((linea = bufer.readLine())!= null ){
                //System.out.println("Linea leida: "+ linea);
                array[i] = linea;
                i++;
        }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        return array;
    }
    
    public static int[] fileToInArray(String name) throws IOException{
        File archivo; //apunta a un archivo fisico del dd
        FileReader reader; //llave con permiso de solo lectura
        BufferedReader bufer; //recuperar info. del archivo
        String linea;
        int[] array = null;
        int t;
        int i = 0;
        
        try{
            
            t = countFileLines(name);
            array = new int[t];
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            //configurar el  para leer datos del archivo
            bufer = new BufferedReader(reader);
            while((linea = bufer.readLine())!= null ){
                array[i] = Integer.parseInt(linea);
                i++;
        }
            reader.close();
        } catch( Exception e ){
            System.out.println("Error al leer el archivo: "+ e.toString());
        }
        return array;
    }
    
    public static void writerKeyboardFile(String name){
        FileWriter archivo; //apuntador a espacio fisico de DD
        //llave de acceso para escribir archivo
        PrintWriter writer;
        //para escibir de teclado a dd
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada = null;
        char respuesta;
        
        try{
            //apuntador al archivo por crear
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            //abrir el archivo en modo escritura
            writer = new PrintWriter(archivo);
            do {
                System.out.println("Escribe datos para guardar al archivo: ");
                //guardar lo recuperado desde teclado al archivo
                writer.println(entrada);
                System.out.println("Escribe x para salir, cualquier otra tecla para continuar");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            }while( respuesta != 'x' );
            archivo.close();
        } catch( Exception e ){
            System.out.println("Error al escribir el archivo " + e.toString());
        }
    }
    
    //crear un archivo con info de un arreglo
    public static void writerArrayToFile(String name, int[] array){
        
        FileWriter archivo; 
        PrintWriter writer;
        
        
        
        try{
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            writer = new PrintWriter(archivo);
            
            //guardar el arreglo a un archivo
            for ( int unDato : array ){
            writer.println(unDato);
            }
            archivo.close();
        } catch( Exception e ){
            System.out.println("Error al escribir el archivo " + e.toString());
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        
        String fileName;
        String[] mascotass;
        int[] numeros;
        int[] numerosX3;
        
        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        mascotass = fileToStringArray(fileName);   
        System.out.println("Contenido del arreglo de mascotas: ");
        for (String unaMascota : mascotass ){
            System.out.println(unaMascota);
        }
        
        System.out.println("");
        System.out.println("Lectura de datos numericos");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        numeros = fileToInArray(fileName);
        System.out.println("Contenido del arreglo de numeros");
        for ( int unNumber : numeros ){
            System.out.println(unNumber);
        }
        
        //crear y llenar array numerosX3
        System.out.println("Numeros por 3");
        numerosX3 = new int [numeros.length];
        for ( int i = 0; i < numeros.length; i++ ){
            numerosX3[i] = numeros[i] * 3;
            System.out.println("numerosX3[" + i + "]: " + numerosX3[i]);
        }
        
        System.out.println("Escribe el nombre del archivo numerosX3: ");
        fileName = bufer.readLine();
        writerArrayToFile(fileName, numerosX3);
        
        /*System.out.println("");
        System.out.println("Crear un archivo de texto");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = bufer.readLine();
        writerFile(fileName);
        */
        
        
}}
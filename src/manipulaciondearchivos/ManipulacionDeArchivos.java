/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipulaciondearchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author ashkh
 */
public class ManipulacionDeArchivos {
    
    public static int countFileLine(String name){
    File archivo;
    FileReader reader;
    BufferedReader bufer;
    
    int numLinea=0; 
    
     try{
    //  crear un apuntar al archovo fisico
    archivo = new File("C:\\archivos\\"+ name + ".txt");
    reader = new FileReader(archivo);
    bufer = new BufferedReader(reader);
    // ContR Las lineas que contiene el ArChiBO
    while((bufer.readLine())!=null){
        numLinea++;
        }
     reader.close();
    } catch (Exception e){
        System.out.println("Error al leer el archivo" + e.toString());
    }
    
        return numLinea;
    }
   

public static String[] fileToStringArray(String name) throws IOException{

    File archivo;
    FileReader reader;
    BufferedReader bufer;
    String linea;
    String[] array=null;
    int t;
    int i=0;
    try{ 
        // obtener el tamaño del archivo
        t=countFileLine(name);
        // con el tamaño del archivo, contruir el arrelgo 
        array= new String[t];     
    //  crear un apuntar al archovo fisico
    archivo = new File("C:\\archivos\\"+ name + ".txt");
    // abrir le archivo para lectura 
    reader = new FileReader(archivo);
    // configurar el buffer
    bufer = new BufferedReader(reader);
    // Lectura de contenido del ArChiBO
    while((linea = bufer.readLine())!=null){
       // System.out.println("Linea leida: "+ linea);
       array[i]=linea;
       i++;
        }
     reader.close();
    } catch (Exception e){
        System.out.println("Error al leer el archivo" + e.toString());
    }
    return array;
    
}
public static int[] fileToIntArray(String name) throws IOException{
    
    File archivo;
    FileReader reader;
    BufferedReader bufer;
    String linea;
    int[] array=null;
    int t;
    int i=0;
    try{ 
        t=countFileLine(name);
        array= new int[t];     
    //  crear un apuntar al archovo fisico
    archivo = new File("C:\\archivos\\"+ name + ".txt");
    reader = new FileReader(archivo);
    bufer = new BufferedReader(reader);
    while((linea = bufer.readLine())!=null){
       array[i]=Integer.parseInt(linea);
       i++;
        }
     reader.close();
    } catch (Exception e){
        System.out.println("Error al leer el archivo" + e.toString());
    }
    return array;
    
}

public static void writeFile(String name){
   
   
// apuntador a un espacio fisico del disco duro
    FileWriter archivo; 
    //llave de acceso de escritura
    PrintWriter writer;
    
    //Escribir del teclado al discoduro
    BufferedReader bufer= new BufferedReader(new InputStreamReader(System.in));
    String entrada;
    char respuesta;
    
    try{
        //apuntador al archivo a crear
        archivo = new FileWriter("C:\\archivos\\"+name+".txt");
        writer = new PrintWriter(archivo);
        do{
            System.out.println("Escribe el contenido del archivo");
            entrada=bufer.readLine();
            // guardar lo recuperado dle telcado al archivo
            writer.println(entrada);
            System.out.println("Escribe la letra X para detener, cualquier otra tecla llena el teclado");
            entrada=bufer.readLine();
            respuesta= entrada.charAt(0);
        } while (respuesta !='x');
        archivo.close();
    } catch (Exception e){
        System.out.println("Error al escribir el Archivo"+ e.toString);
    }
    
}

    public static void main(String[] args) throws IOException {
        BufferedReader bufer= new BufferedReader(new InputStreamReader(System.in));
        
        String fileName;   
        String[] juegos;
        int[] num;
        
        System.out.println("lectura del un archoivo de texto");
        System.out.println("Escribe el nombre del archivo");
        fileName= bufer.readLine();
        juegos= fileToStringArray(fileName);
        System.out.println("contenido del arreglo de juegos");
        for(String unlinea : juegos){
            System.out.println(unlinea);
        }
        System.out.println("lectura de datos numericos");
        System.out.println("Escribe el nombre del archivo");
        fileName= bufer.readLine();
        num=fileToIntArray(fileName);
        System.out.println("contenido del array de numeros");
        for(int numi : num){
        System.out.println(numi);
    }
        
        System.out.println("crear un archivo de texto");
        System.out.println("ingresa el nombre del archivo");
        fileName= bufer.readLine();
        writeFile(fileName);
        
    }
    
}

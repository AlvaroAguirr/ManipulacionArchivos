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
    public static void main(String[] args) throws IOException {
        BufferedReader bufer= new BufferedReader(new InputStreamReader(System.in));
        
        String fileName;   
        String[] juegos;
        
        System.out.println("lectura del un archoivo de texto");
        System.out.println("Escribe el nombre del archivo");
        fileName= bufer.readLine();
        juegos= fileToStringArray(fileName);
        System.out.println("contenido del arreglo de juegos");
        for(String unlinea : juegos){
            System.out.println(unlinea);
        }
    }
    
}

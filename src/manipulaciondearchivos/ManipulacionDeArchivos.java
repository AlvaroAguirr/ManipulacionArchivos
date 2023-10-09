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
    
    public static int ContarLineasArchivo(String name){
    File archivo;
    FileReader reader;
    BufferedReader bufer;
    String linea;
    
    int numLinea=0; 
    
     try{
    //  crear un apuntar al archovo fisico
    archivo = new File("C:\\archivos\\"+ name + ".txt");
    reader = new FileReader(archivo);
    bufer = new BufferedReader(reader);
    // ContR Las lineas que contiene el ArChiBO
    while((linea = bufer.readLine())!=null){
        numLinea++;
        }
     reader.close();
    } catch (Exception e){
        System.out.println("Error al leer el archivo" + e.toString());
    }
    
        return numLinea;
    }
   

public static void leerArchivo(String name) throws IOException{
    
    File archivo;
    FileReader reader;
    BufferedReader bufer;
    String linea;
    
    try{
    //  crear un apuntar al archovo fisico
    archivo = new File("C:\\archivos\\"+ name + ".txt");
    // abrir le archivo para lectura 
    reader = new FileReader(archivo);
    // configurar el buffer
    bufer = new BufferedReader(reader);
    // Lectura de contenido del ArChiBO
    while((linea = bufer.readLine())!=null){
        System.out.println("Linea leida: "+ linea);
        }
     reader.close();
    } catch (Exception e){
        System.out.println("Error al leer el archivo" + e.toString());
    }
    
    
}
    public static void main(String[] args) throws IOException {
        BufferedReader bufer= new BufferedReader(new InputStreamReader(System.in));
        
        String fileName;
        int t;
        
        
        System.out.println("lectura del un archoivo de texto");
        System.out.println("Escribe el nombre del archivo");
        fileName= bufer.readLine();
        
        leerArchivo(fileName);
        t=ContarLineasArchivo(fileName);
        System.out.println("contar lineas de archivo "+fileName+" : "+ t);
    }
    
}

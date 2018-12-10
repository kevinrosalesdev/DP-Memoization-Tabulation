
package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class FileTextReader {
    
    /**
     * Lee de un archivo de fichero y devuelve una lista con cada una de las
     * líneas del fichero pasado por parámetro
     * @param fileName Fichero para leer líneas
     * @return lista de líneas en un fichero 
     */
    public static List<String> read(String fileName){
        List <String> vec = new LinkedList();
        File file= new File (fileName);
        try{
            try(FileReader fr = new FileReader (file)){
                BufferedReader br= new BufferedReader(fr);
                String aux;
                while((aux= br.readLine())!= null){
                    vec.add(aux);
                }
            }
        } catch(IOException e){
            System.out.println("Excepción al leer el archivo: " + e.getMessage());
        }
        return vec;
    }
    /**
     * Crea una lista con palabras separadas por espacios de una string
     * @param vec String que contiene las palabras
     * @return Lista con los nombres de la ristra pasada
     */
    public static List <String> toList(String vec){
        String [] aux= vec.split(" ");
        List <String> result = new LinkedList();
        for (String aux1 : aux) {
            result.add(aux1);
        }
        return  result;
    }
    
}

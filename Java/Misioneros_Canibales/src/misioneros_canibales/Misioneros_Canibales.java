
package misioneros_canibales;

import combinationsGenerator.IteradorCombinacion;
import combinationsGenerator.IteratorMi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;




public class Misioneros_Canibales {

    /**
     * Main en el que se invocan las llamadas al algoritmo de fuerza
     * bruta con los archivos especificados por parámetros
     * @param args Argumentos que se pasan al ejecutable
     */
    public static void main(String[] args) {
        
        List <String> argumentos= new LinkedList();
        
        for(int i =0; i< args.length;i++){
            argumentos.add(args[i]);
            System.out.println(args[i]);
        }
        
        boolean flag=false;
        if(argumentos.contains("-t")){
            argumentos.remove("-t");
            flag=true;
        }
        
        StockProcessor prueba= new StockProcessor();
        Iterator <String> iterador= argumentos.iterator();
        String aux="";
        
        while(iterador.hasNext()){
            aux= iterador.next();
            prueba.misioneros_Canibales(aux, flag);
        }
    }
}

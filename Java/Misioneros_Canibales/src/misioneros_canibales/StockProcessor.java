
package misioneros_canibales;

import Reader.FileTextReader;
import combinationsGenerator.IteradorCombinacion;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hector
 */
public class StockProcessor {
    
    
    /**
     * Calcula el número de misioneros que existen en una lista
     * @param lista Lista con misioneros expresado como "1"
     * @return Número de misioneros contenidos en lista
     */
    private static int numero_misioneros(List <String> lista){
        int result=0;
        result = lista.stream().filter((aux) -> ("1".equals(aux))).map((_item) -> 1).reduce(result, Integer::sum);
        return result;
    }
    /**
     * Calcula el número de caníbales que existen en una lista
     * @param lista Lista con caníbales expresado como "2"
     * @return Número de caníbales contenidos en lista
     */
    private static int numero_canibales(List <String> lista){
        int result=0;
        result = lista.stream().filter((aux) -> ("2".equals(aux))).map((_item) -> 1).reduce(result, Integer::sum);
        return result;
    }
    /**
     * Clona una lista en una lista nueva
     * @param lista Lista a copiar
     * @return Copia de lista
     */
    private List<String> clone(List<String> lista){
        List<String>result= new LinkedList();
        Iterator i= lista.iterator();
        while(i.hasNext()){
            result.add((String) i.next());
        }
        return result;
    }
    
    /**
     * 
     * Algoritmo de fuerza bruta para calcular el problema de los misioneros
     * y caníbales
     * @param fichero fichero de texto en el que se encuentran los misioneros y
     * los caníbales
     * @param timeFlag Si se desea ver solo el tiempo o ver solamente los pasos 
     */
    public void misioneros_Canibales(String fichero, boolean timeFlag){
        //Iniciación de variables
        List<String> a = FileTextReader.read(fichero);
        Iterator b= a.iterator();
        int iteraciones=0;
        //Iterador para recorrer todos los vectores
        List <Long> tiempos= new LinkedList();
        while(b.hasNext()){
            
            System.out.println("############################==" + 
                    iteraciones + "==#############################");
            System.out.println("Iteración: "+ iteraciones);
            iteraciones++;
            String aux= (String) b.next();
            List<String> orillaA= FileTextReader.toList(aux);
            List<String> orillaB= new LinkedList();
            
            //Condiciones para no seguir con la iteración
            if (numero_canibales(orillaA) > numero_misioneros(orillaA)){
                System.out.println("El número de canibales no puede superar al de misioneros");
                System.out.println("El número de misoneros: " + numero_misioneros(orillaA));
                System.out.println("El número de misoneros: " + numero_canibales(orillaA));
                continue;
            }
            if (orillaA.size()%3!=0){
                System.out.println("NO ES MULTIPLO DE 3");
                System.out.println(numero_misioneros(orillaA));
                System.out.println(numero_canibales(orillaB));
                continue;
            }
            
            System.out.println("El número de misoneros: " + numero_misioneros(orillaA));
            System.out.println("El número de canibles: " + numero_canibales(orillaA));
            

            Iterator p= orillaA.iterator();
            boolean flag= true;
            long tiempoInicio= System.nanoTime();
            
            //Empieza iteraciones del generador de combinaciones
            while(p.hasNext()){
                int sizeFlag=orillaA.size();
                if(!timeFlag){
                    System.out.println("ORILLA_A -->"+orillaA.size());
                    System.out.println("ORILLA_B -->"+orillaB.size());
                }
                IteradorCombinacion it = new IteradorCombinacion(orillaA, 3);
                Iterator s = it.iterator();
                /**
                 * Añade a una copia de las orillas para comprobar que la
                 * combinación es aceptable para resolver el problema
                 */ 
                while (s.hasNext()) {
                    List t= (List) s.next();
                    List<String> auxA= clone(orillaA);
                    List<String> auxB= clone(orillaB);
                    Iterator ti= t.iterator();
                    while(ti.hasNext()){
                        String auxTi= (String) ti.next();
                        auxA.remove(auxTi);
                        auxB.add(auxTi);
                    }
                    //Evalua si es una combinación aceptable
                    if ((numero_misioneros(t)>numero_canibales(t) || numero_misioneros(t)==0)
                            && numero_misioneros(auxA)!=1
                            && (numero_canibales(auxA)<= numero_misioneros(auxA) || numero_misioneros(auxA)==0)
                            && (numero_canibales(auxB) <= numero_misioneros(auxB))){
                        if (!timeFlag){
                            System.out.println("Combinacion ganadoras:"+ t);
                        }
                        Iterator ti2= t.iterator();
                        //Efectua el cambio teniendo ya la combinación aceptable
                        while(ti2.hasNext()){
                            String auxTi2=  (String) ti2.next();
                            orillaA.remove(auxTi2);
                            orillaB.add(auxTi2);
                        }
                        break;
                    }
                }
                /**
                 * Si se han iterado todas las combinaciones posibles y ninguna
                 * es aceptable es imposible de realizar la operación
                 */
            
                if (orillaA.size()==sizeFlag){
                        System.out.println("Combinación imposible");
                        flag=false;
                        break;
                    }
                
            }
            if (flag){
                //Imprime el tiempo de ejecución de la iteración si se especifica
                long tiempoIter= System.nanoTime()-tiempoInicio;
                if (!timeFlag){
                    System.out.println("Resultado de la orilla A: "+ orillaA);
                    System.out.println("Resultado de la orilla B: "+ orillaB);
                }else{
                    System.out.println("Tiempo en milisegundos: "+tiempoIter/1e6);
                }
                
                
                tiempos.add(tiempoIter);
            }
            
        }
        long tiempoFinal=0;
        Iterator tiempoIt= tiempos.iterator();
        while(tiempoIt.hasNext()){
            tiempoFinal+=(long)tiempoIt.next();
        }
        if(timeFlag){
            System.out.println("Tiempo final en segundos:" + tiempoFinal/1e9);
        }
        
        
    }
}

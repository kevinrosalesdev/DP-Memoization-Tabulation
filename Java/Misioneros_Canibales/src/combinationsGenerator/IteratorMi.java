
package combinationsGenerator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Clase en la cual saca iteraciones de un árbol evaluando las posibilidades y
 * dando como resultado una combinaciones de misioneros y caníbales apta para
 * entrar en la barca
 */
public class IteratorMi implements Iterable<List<String>> {
    
    private final Utility filtro;
    /**
     * Constructor de la clase IteratorMi en la que se inicia el filtro
     * @param list lista con la que se inicia el filtro
     */
    public IteratorMi(List<String> list) {
        filtro= new Utility(list);
    }
    
    @Override
    public Iterator<List<String>> iterator() {
        return new IterMi();
    }
    
    /**
     * Clase que implementa la interfaz iterator<T> para devolver valores válidos
     * para la barca
     */
     private class IterMi implements Iterator<List<String>> {
         
        private LinkedList <String> Olist= new LinkedList();
        private boolean flag=false;
        /**
         * Método para evaluar si existe siguiente combinación válida para la meter
         * en la barca partiendo desde la última iteración
         * @return true si existe, false si no existe
         */
        @Override
        public boolean hasNext() {
            int dos=0;
            if (flag){
                return false;
            }
            if(Olist.size()==3){
                dos = Olist.stream().filter((string) -> (string.equals("2"))).map((_item) -> 1).reduce(dos, Integer::sum);
                if (dos==3){
                    return false;
                }
            }
            return true;
        }
        

        /**
         * Método que devuelve siguiente iteración válida para meter en la barca
         * siempre devuelve una lista de 3 elementos
         * @return combinación válida
         */
        @Override
        public List<String> next() {
            //Condición cuando empieza la primera iteración
            if(Olist.isEmpty()){
                Olist.add("1");
                //Si [1] no es válido que empieze con [2]
                if(!filtro.available(Olist)){
                    Olist.removeLast();
                    Olist.addLast("2");
                    return next();
                }
                return next();
            }
            //Condición cuando es de tamaño 3 y llega el final a [x,x,1]
            if(Olist.size()==3 && Olist.getLast().equals("1")){
                Olist.removeLast();
                Olist.addLast("2");
                //Si el final no es válido se pasa al siguiente es decir [x,2]
                if(!filtro.available(Olist)){
                    Olist.removeLast();
                    Olist.removeLast();
                    Olist.addLast("2");
                    return next();
                }
                return Olist;
            }
            
            //Condición cuando es tamaño 3 y termina por [1,2,2] cambiandolo por [2]
            if(Olist.size()==3 && Olist.getLast().equals("2") && Olist.getFirst().equals("1") && Olist.get(1).equals("2")){
                Olist.removeLast();
                Olist.removeLast();
                Olist.removeLast();
                Olist.addLast("2");
                //Si no es válido quiere decir que no existen combinaciones válidas
                if(!filtro.available(Olist)){
                    Olist= new LinkedList();
                    flag=true;
                    return null;
                }
                return next();
            }
            //Si es [2] y no es válido para el bote no existe combinación
            if(Olist.size()==1 && Olist.getLast().equals("2")){
                if(!filtro.available(Olist)){
                    flag=true;
                    return null;
                }
                
            }
            //Si es de tamaño 3 y termina en [x,x,2] que lo cambie a [x,2]
            if(Olist.getLast().equals("2") && Olist.size()==3){
                Olist.removeLast();
                Olist.removeLast();
                Olist.addLast("2");
                //Si no es válido cambialo...
                if(!filtro.available(Olist)){
                    //...Si el  [2,x,2] no existe combinación
                    if(Olist.getFirst().equals("2")){
                        Olist= new LinkedList();
                        flag=true;
                        return null;
                        //...Si no cambialo a [x,2]
                    }else{
                        Olist.removeLast();
                        Olist.removeLast();
                        Olist.addLast("2");
                        return next();
                    }
                }
            //Se le añade un 1 al final
            }else{
                Olist.addLast("1");
                //Si no es válido cambia el 1 a 2
                if(!filtro.available(Olist)){
                    Olist.removeLast();
                    Olist.addLast("2");
                    //Si es final se devuelve todo
                    if(Olist.size()==3){
                        return Olist;
                    }else{
                        //Si no es final sigue iterando
                        return next();
                    }
                }
                
                if (Olist.size()==3){
                    return Olist;
                }
            }
            return next();
        }
    }
}

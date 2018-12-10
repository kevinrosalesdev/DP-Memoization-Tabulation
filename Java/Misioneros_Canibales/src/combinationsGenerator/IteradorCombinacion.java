
package combinationsGenerator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase obsoleta, no se usa en todo el programa por problema al intentar hacer
 * la poda del árbol, debido al recorrido que hace por el mismo. Esto quiere decir que
 * se salta valores que no debería podar o no poda valores que sí debería podar.
*/
public class IteradorCombinacion implements Iterable<List<String>> {
 
    private final List<String> list;
    private final int size;
       /**
        * Constructor de IteradorCombinacion
        * @param list Lista con los datos para combinar
        * @param size Tamaño de la combinación
        */
    public IteradorCombinacion(List<String> list,Integer size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public Iterator<List<String>> iterator() {
        return new IteradorCombn(list, size);
    }
    
    /**
     * Clase con la que creamos el iterador de combinaciones
     */
    private class IteradorCombn implements Iterator<List<String>> {
 
        private  int actualSize;
        private final int maxresult;
        private int curIndex;
        private String[] result;
        private int[] indices;
        private final String[] arrayList;
        private List<String> elem = null;
        private Utility comprobador = new Utility(list);
        /**
         * Constructor del iterador de combinaciones
         * @param s Lista en la cual estan los elementos para combinar
         * @param k Tamaño de la combinación
         */
        public IteradorCombn(List<String> s, Integer k) {
            actualSize = k;// desde dónde
            curIndex = 0;
            maxresult = k;
            arrayList = new String[s.size()];
            for (int i = 0; i < arrayList.length; i++) { // la lista s la vuelca en arrayList
                arrayList[i] = s.get(i);
            }
            this.result = new String[actualSize < s.size() ? actualSize : s.size()];
            for (int i = 0; i < result.length; i++) {
                result[i]="";
            }
            //el tamaño de result va a ser el valor menor entre actualSize y el tamaño de s
            indices = new int[result.length];
            //Se guardan los indices en orden inverso
            for (int i = 0; i < result.length; i++) {
                indices[i] = result.length - 2 - i;
            }
        }
 
        @Override
        public boolean hasNext() {
            elem = null;
            while ((elem == null && curIndex != -1)) {
 
                indices[curIndex]++;
                if (indices[curIndex] == (curIndex == 0 ? arrayList.length:indices [curIndex-1] )) {
                    indices[curIndex] = indices.length-curIndex - 2;
                    curIndex--;
                } else {
                    result[curIndex] = arrayList[indices[curIndex]];
                    /*
                    if(!comprobador.available(result)){
                        result[curIndex]="";
                        if (curIndex < indices.length -1 && indices[curIndex] == (curIndex == 0 ? arrayList.length:indices [curIndex-1] ) ){
                            indices[curIndex] = indices.length-curIndex - 2;
                            curIndex--;
                        }
                        continue;
                    }
                    */
                    if (curIndex < indices.length - 1) {
                        curIndex++;
                    } else {
                        elem = new LinkedList <> ();
                        for(String s:result) {
                            elem.add(s);
                        }
                    }
                }
            }
            if (elem == null) {
                if (actualSize < maxresult) {
                    actualSize++;
                    this.result = new String[actualSize < arrayList.length ? actualSize : arrayList.length];
                    indices = new int[result.length];
 
                    for (int i = 0; i < result.length; i++) {
 
                        indices[i] = result.length - 2 - i;
                    }
                    curIndex = 0;
 
                    return this.hasNext();
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
 
        @Override
        public List<String> next() {
            return elem;
        }
    }
}

package combinationsGenerator;


import java.util.List;
/**
 * 
 */
public class Utility {
    
    
    private int misionerosOrB=0;
    private int caníbalesOrB=0;
    private int misionerosOrA=0;
    private int caníbalesOrA=0;
    /**
     * Constructor de la clase Utility en la que se inicializa los valores de la
     * orillaA con el número de misioneros y caníbales que existen en la orilla.
     * @param list Lista que representa la orillaA en la que están contenidos los
     * misioneros y los caníbales.
     */
    public Utility(List <String> list){
        for (String string : list) {
            if (string.equals("1")){
                misionerosOrA++;
            }else{
                caníbalesOrA++;
            }
        }
    }
    /**
     * Método que evalúa si una combinación es válida para continuar y entrar en 
     * la barca y en caso negativo negarlo
     * @param a Combinación que se quiere evaluar de tamaño entre 1 y 3
     * @return true si es válido para continuar y entrar en la barca y false en
     * caso contrario
     */
    public  boolean available(List <String>  a){
        int m=0;
        int c=0;
        int nin=0;
        for (String i : a) {
            switch (i){
                case "1":
                    m++;
                    break;
                case "2":
                    c++;
                    break;
                default:
                    nin++;
                    break;
            }
        }
        nin=3-m-c;
        switch(nin){
            //Caso para cuando el tamaño de la combinación es 2
            case 1:
                if ((misionerosOrA<m || caníbalesOrA<c) 
                        || (misionerosOrA-m<caníbalesOrA-c && misionerosOrA-m>1) 
                        || (misionerosOrB +m< caníbalesOrB+c && caníbalesOrB+c<1)
                        || (misionerosOrA==caníbalesOrA && m==c )){
                    return false;
                }
                return true; 
            //Caso para cuando el tamaño de la combinación es 1    
            case 2:
                if((misionerosOrA-m<=0 && m==1) 
                        || (misionerosOrA-m<caníbalesOrA-c && misionerosOrA-m>2)){
                    return false;
                }
                return true;
            //caso para cuando el tamaño de la combinación fuese 3
            default:
                if (misionerosOrA-m!=1
                    && (caníbalesOrA-c<= misionerosOrA-m || misionerosOrA-m ==0)
                    && (caníbalesOrB+c <= misionerosOrB+m)){
                    //Se aumentan y disminuyen respectivas orillas para la siguiente iteración
                    misionerosOrB+=m;
                    caníbalesOrB+=c;
                    misionerosOrA-=m;
                    caníbalesOrA-=c;
                    return true;
                }
                return false;
            }
    }
}


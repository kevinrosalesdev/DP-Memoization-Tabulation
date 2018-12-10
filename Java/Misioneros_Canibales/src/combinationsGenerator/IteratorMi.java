/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationsGenerator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hector
 */
public class IteratorMi implements Iterable<List<String>> {
    
    private List<String> list;
    private Utility filtro;
    
    
    public IteratorMi(List<String> list) {
        this.list=list;
        filtro= new Utility(list);
    }
    
    
    
    
    
    @Override
    public Iterator<List<String>> iterator() {
        return new IterMi();
    }
    
     private class IterMi implements Iterator<List<String>> {
         
        private LinkedList <String> Olist= new LinkedList();

        private boolean flag=false;
        @Override
        public boolean hasNext() {
            int dos=0;
            if (flag){
                return false;
            }
            if(Olist.size()==3){
                for (String string : Olist) {
                    if(string.equals("2")){
                        dos++;
                    }
                }
                if (dos==3){
                    return false;
                }
            }
            
            return true;
        }
        


        @Override
        public List<String> next() {
            if(Olist.size()==0){
                Olist.add("1");
                //System.out.println("algo1");
                if(!filtro.available(Olist)){
                    //System.out.println("filtro");
                    Olist.removeLast();
                    Olist.addLast("2");
                    return next();
                }
                return next();
            }
            if(Olist.size()==3 && Olist.getLast().equals("1")){
                Olist.removeLast();
                Olist.addLast("2");
                //System.out.println("algo2");
                if(!filtro.available(Olist)){
                    Olist.removeLast();
                    Olist.removeLast();
                    Olist.addLast("2");
                    return next();
                }
                return Olist;
            }
            
            
            if(Olist.size()==3 && Olist.getLast().equals("2") && Olist.getFirst().equals("1") && Olist.get(1).equals("2")){
                Olist.removeLast();
                Olist.removeLast();
                Olist.removeLast();
                Olist.addLast("2");
                //System.out.println("algo3");
                if(!filtro.available(Olist)){
                    Olist= new LinkedList();
                    flag=true;
                    return null;
                }
                return next();
            }
            if(Olist.size()==1 && Olist.getLast().equals("2")){
                if(!filtro.available(Olist)){
                    flag=true;
                    return null;
                }
                
            }
            if(Olist.getLast().equals("2") && Olist.size()==3){
                Olist.removeLast();
                Olist.removeLast();
                Olist.addLast("2");
                //System.out.println("algo4");
                if(!filtro.available(Olist)){
                    if(Olist.getFirst().equals("2")){
                        Olist= new LinkedList();
                        flag=true;
                        return null;
                    }else{
                        Olist.removeLast();
                        Olist.removeLast();
                        Olist.addLast("2");
                        return next();
                    }
                }
            }else{
                Olist.addLast("1");
                //System.out.println("algo5");
                if(!filtro.available(Olist)){
                    Olist.removeLast();
                    Olist.addLast("2");
                    if(Olist.size()==3){
                        return Olist;
                    }else{
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

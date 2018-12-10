/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinationsGenerator;


import java.util.List;

/**
 *
 * @author Hector
 */
public class Utility {
    
    
    private int misionerosOrB=0;
    private int caníablesOrB=0;
    private int misionerosOrA=0;
    private int caníablesOrA=0;
    
    public Utility(List <String> list){
        for (String string : list) {
            if (string.equals("1")){
                misionerosOrA++;
            }else{
                caníablesOrA++;
            }
        }
    
    }
    
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
        /*
        if(misionerosOrA-m<0 ||caníablesOrA-c<0){
            return false;
        }
        */
        //System.out.println("misioneros "+m+" canibales "+c+" ninguno "+nin);
        
        switch(nin){
            case 1:
                
                if ((misionerosOrA<m || caníablesOrA<c) || (misionerosOrA-m<caníablesOrA-c && misionerosOrA-m>1)  ){
                    System.out.println("filtro 2");
                    return false;
                }
               /*
                if((c==2 &&caníablesOrA-c==0)
                        || (misionerosOrA-m< caníablesOrA-c-1)
                        || (c==1 && m==1 && misionerosOrA-m==0)
                        ){
                    return false;
                }
                /**
                if ((misionerosOrB+m >= caníablesOrB+c )
                      && (misionerosOrA-m >=caníablesOrA-c || misionerosOrA-m ==0)){
                    return true;
                }
                break;
                */
                return true; 
            case 2:
                //System.out.println("misioneros or A"+misionerosOrA);
                if((misionerosOrA-m<=0 && m==1) || (misionerosOrA-m<caníablesOrA-c && misionerosOrA-m>2)){
                    return false;
                }
                /**
                if ((misionerosOrB+m >= caníablesOrB+c )
                      && (misionerosOrA-m >=caníablesOrA-c || misionerosOrA-m ==0) ){
                    return true;
                }
                */
                //break;
                
                return true;
            default:
                if (
                    
                    (misionerosOrA-m>caníablesOrA-c || misionerosOrA-m==0)
                    && misionerosOrA-m!=1
                    && (caníablesOrA-c<= misionerosOrA-m || misionerosOrA-m ==0)
                    && (caníablesOrB+c <= misionerosOrB+m)
                    
                        
                        ){
                    
                    
                    
                        misionerosOrB+=m;
                        caníablesOrB+=c;
                        misionerosOrA-=m;
                        caníablesOrA-=c;
                        System.out.println("aaaaaaaaaa");
                        return true;
                    }
                

                return true;
                
                
            }
        
    
        //return true;
    }
        
        
}


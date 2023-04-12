/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author client
 */
public class Noued {
    
    public List<Integer> solutionTrouve ;
    public int difference ; 

    public Noued( Noued parent , List Ensemble , int i ) {
        if ( parent == null ) {
            this.solutionTrouve = new ArrayList<Integer>();
            this.solutionTrouve.add(i);
            this.difference = -1;
        }
        else {
            this.solutionTrouve = new ArrayList(parent.solutionTrouve);
            this.solutionTrouve.add(i);
            this.difference = this.calculeDiff(Ensemble);
        }       
        
    }
    
    private int calculeDiff(List<Integer> Ensemble){
        int somme1 , somme2;
        somme1 = 0;
        somme2 = 0;
        for ( int i = 0 ; i < this.solutionTrouve.size() && i < Ensemble.size() ; i++){
            if ( this.solutionTrouve.get(i) == 1 ) somme1 = somme1 + Ensemble.get(i);
            else somme2 = somme2 + Ensemble.get(i);            
        }
        return abs( somme1 - somme2 );      
    }
    
    public void addNouedSort(LinkedList<Noued> list){
       int i = 0 ;
       while ( i < list.size() && list.get(i).difference < this.difference ) i++;
       list.add( i , this);         
    }
    
    
}

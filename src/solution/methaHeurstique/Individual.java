/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.methaHeurstique;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;


public class Individual {
    
    private List<Integer> solution;
    private int fitness;    
    
    public Individual(List<Integer> ensemble) {
        int size = ensemble.size();
        this.generateSolution(size);
        this.fitness = this.evaluat(ensemble);       
        
    }

    public List<Integer> getSolution() {
        return solution;
    }

    public void setSolution(List<Integer> solution) {
        this.solution = solution;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
    

    
    private void generateSolution(int size ){
        int rand;
        this.solution = new ArrayList<Integer>();
        for ( int i =0; i < size; i++){
            rand =  (int) Math.random() * 2 + 1;
            this.solution.add(rand);
        }              
    }

    public int evaluat(List<Integer> ensemble){        
        int s1 = 0 , s2 = 0 ;
        int size = ensemble.size();
        for (int i = 0 ; i < size; i++ ){
            if ( this.solution.get(i) == 1 ) s1 = s1 + ensemble.get(i);
            else s2 = s2 + ensemble.get(i);      
      }
      return abs( s1 - s2 );        
    }

    
    
    
    
    
    
}

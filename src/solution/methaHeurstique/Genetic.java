/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.methaHeurstique;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author client
 */
public class Genetic {
    
    private final int maxIter;
    private final int sizePopulation;
    private final int sizeProblem;
    private final int mutationRate;
    private final int crossoverRate;

    public Genetic(int maxIter, int sizePopulation, int sizeProblem, int mutationRate, int crossoverRate) {
        this.maxIter = maxIter;
        this.sizePopulation = sizePopulation;
        this.sizeProblem = sizeProblem;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
    }
    
    
    public  List<Individual> generatePopulation(List<Integer> ensemble){
        
        List<Individual> population = new ArrayList<Individual>();        
        for ( int i = 0; i < this.sizePopulation; i++ ) 
             population.add(new Individual(ensemble));
        
        return population;
    }    
     
     
   
    
  
   

    
    
}

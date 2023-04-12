/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.methaHeurstique;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author client
 */
public class Genetic {
    
    private final int maxIter;
    private final int sizePopulation;
    private final int mutationRate;
    private final int crossoverRate;

    public Genetic(int maxIter, int sizePopulation, int sizeProblem, int mutationRate, int crossoverRate) {
        this.maxIter = maxIter;
        this.sizePopulation = sizePopulation;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
    }
    
    
    public static List<Individual> generatePopulation(List<Integer> ensemble, int sizePopulation){
        
        List<Individual> population = new ArrayList<Individual>();
        
        for ( int i = 0; i < sizePopulation; i++ ) 
            population.add(new Individual(ensemble, false));
        
        return population;
    }    
    
    public static Individual GetBestSolution ( List<Individual> population ){
        
        if ( population.isEmpty() ) return null;
        int imax = 0;
        for ( int i = 1; i < population.size(); i++)
            if (population.get(i).getFitness() < population.get(imax).getFitness())
                imax = i;
        
        return population.get(imax);
        
    }
     
    
    public static List<Individual> crossover (List<Integer> ensemble, Individual parent1 , Individual parent2 , int crossoverType){        
        int size;
        boolean genesFromParent1;
        Individual child1 , child2;
        List<Individual> children;
        NavigableSet<Integer> crossoverPoints = new TreeSet<>();
        int crossoverPoint;
        
        size = parent1.getGenes().size();
        child1 = new Individual (ensemble, true);
        child2 = new Individual (ensemble, true);
        children = new ArrayList<Individual>();
        
        // Générer des points de croisement uniques
        while ( crossoverPoints.size() < crossoverType  )
            crossoverPoints.add((int) (Math.random() * ( ( size - 1) - 1 ) ) );
        
        genesFromParent1 = true;
        crossoverPoint = crossoverPoints.pollFirst();
       
        for ( int i = 0; i < size; i++ ){
           if ( i == crossoverPoint && ! crossoverPoints.isEmpty() ) {
               crossoverPoint = crossoverPoints.pollFirst();
               genesFromParent1 = ! genesFromParent1;                
           } 
           if (genesFromParent1) {
               child1.getGenes().add(parent1.getGenes().get(i));           
               child2.getGenes().add(parent2.getGenes().get(i));
           }
           else {
               child1.getGenes().add(parent2.getGenes().get(i));           
               child2.getGenes().add(parent1.getGenes().get(i));
           }            
        }
        child1.setFitness(child1.evaluat(ensemble));
        child2.setFitness(child2.evaluat(ensemble)); 
        children.add(child1);
        children.add(child2);
        return children;
    }
    
     
   
    
  
   

    
    
}

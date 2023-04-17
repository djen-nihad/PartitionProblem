/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.methaHeurstique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private final double mutationRate;
    private final double crossoverRate;

    public Genetic(int maxIter, int sizePopulation, int sizeProblem, double mutationRate, double crossoverRate) {
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
     
    public static List<Individual> replace(List<Individual> population , List<Individual> children){
        
        int size = population.size();        
        population.addAll(children);
        // trie la liste du facon croissant
        Collections.sort(population, new Comparator<Individual>(){
            @Override
            public int compare(Individual o1, Individual o2) {
                 return o1.getFitness() - o2.getFitness();              
            }                 
        });
        for ( int i = size; i < population.size(); i++)
            population.remove(i);
        
        return population;       
    }

    public int getMaxIter() {
        return maxIter;
    }

    public int getSizePopulation() {
        return sizePopulation;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }
    
    

}

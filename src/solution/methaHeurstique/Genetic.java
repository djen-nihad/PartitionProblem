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
import partitionproblem.Partition;

/**
 *
 * @author client
 */
public class Genetic {
    
    private final int maxIter;
    private final int sizePopulation;
    private final double mutationRate;
    private final double crossoverRate;
   

    public Genetic(int maxIter, int sizePopulation, double mutationRate, double crossoverRate) {
        this.maxIter = maxIter;
        this.sizePopulation = sizePopulation;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
    }
    
    public  Individual GenticAlgorithm(Partition problem){
        int nbrIter = 0;
        List<Individual> population , newGeneration , children;
        Individual bestSolution , parent1 , parent2;
        List<Integer> parents;
        // Génère et evaluer une population initiale
        population = Genetic.generatePopulation(problem.getEnsemble(), this.sizePopulation);
        bestSolution = population.get(0);
        while ( bestSolution.getFitness() != 0 && nbrIter < this.maxIter ) {
            newGeneration = new ArrayList<Individual>();
            // Sélectionne deux parents de façon aléatoire
            parents = selectParentsUniforme(population, 1);
            while ( ! parents.isEmpty() ) {
                parent1 = population.get(parents.remove(0));
                parent2 = population.get(parents.remove(0));
                // Effectue le croisement et la mutation des deux parents sélectionnés pour créer des enfants
                children = Individual.crossover(problem.getEnsemble(), parent1, parent2, 1 , crossoverRate);
                children.get(0).mutate(mutationRate, 0);
                children.get(1).mutate(mutationRate, 0);  
                newGeneration.addAll(children);
            }
            // diminuer la taille de population en utilisant des techenique du remplacement
            population = replace(population , newGeneration);
            bestSolution = population.get(0);
            nbrIter++;
        }
         // Retourne la meilleure solution trouvée
        return bestSolution;
    }
    
    public static List<Individual> generatePopulation(List<Integer> ensemble, int sizePopulation){
        
        List<Individual> population = new ArrayList<Individual>();
        
        for ( int i = 0; i < sizePopulation; i++ ) 
            //genere des solution aleatoitres 
            population.add(new Individual(ensemble, false));
        
         // Trie la population de maniere croissante
        Collections.sort(population, new Comparator<Individual>(){
            @Override
            public int compare(Individual o1, Individual o2) {
                 return o1.getFitness() - o2.getFitness();              
            }                 
        });
        
        return population;
    }    
    
    public static List<Integer> selectParentsUniforme(List<Individual> population, int nbrParents) {  
        //Liste ordonné permettant de stocker des index uniques des individus sélectionnés
        NavigableSet<Integer> indexParents = new TreeSet<>(); 
        // Sélection de 2 * nbrParents individus aléatoirement
        while ( indexParents.size() < nbrParents * 2 )
            indexParents.add((int) (Math.random() * population.size() ) );        
        return new ArrayList<>(indexParents);

    }
       
    public static List<Individual> replace(List<Individual> population , List<Individual> children){
        // Obtenir la taille de la population existante
        int size = population.size();  
        // Ajouter les enfants ( new generation) à la population existante ( Old generation)
        population.addAll(children);
        // trie la liste du facon croissant
        Collections.sort(population, new Comparator<Individual>(){
            @Override
            public int compare(Individual o1, Individual o2) {
                 return o1.getFitness() - o2.getFitness();              
            }                 
        });
        // Garder les  meilleurs individus et enlever les autres
        population.subList(size, population.size()).clear();            
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.methaHeurstique;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;


public class Individual {
    
    private List<Integer> genes;
    private int fitness;    
    
    public Individual(List<Integer> ensemble, boolean empty) {
        //empty un booléen indiquant si l'objet "Individual" doit être initialisé avec une solution vide.
        if (empty) this.genes = new ArrayList<Integer>();
        else {
           int size = ensemble.size(); 
           // Génération d'une solution aléatoire
           this.generateSolution(size);
           // Évaluation de la solution
           this.fitness = this.evaluat(ensemble); 
        } 
    }

    public static List<Individual> crossover (List<Integer> ensemble, Individual parent1 , Individual parent2 , int crossoverType , double crossoverRate ){        
        List<Individual> newGeneration = new ArrayList<Individual>();
        if ( crossoverRate < Math.random() ) {
            newGeneration.add(parent1);
            newGeneration.add(parent2);
            return newGeneration;
        }
        int size , crossoverPoint;
        boolean genesFromParent1;
        Individual child1 , child2;
        NavigableSet<Integer> crossoverPoints = new TreeSet<>();
        
        size = parent1.getGenes().size();
        // creer des individu  avec des solution vide 
        child1 = new Individual (ensemble, true);
        child2 = new Individual (ensemble, true);
        
        
        // Générer des points de croisement uniques
        while ( crossoverPoints.size() < crossoverType && crossoverPoints.size() < size  )
            crossoverPoints.add((int) (Math.random() * ( ( size - 1) - 1 ) ) );
        
        genesFromParent1 = true;
        crossoverPoint = crossoverPoints.pollFirst();
       // Parcourir les gènes des parents et créer les enfants en utilisant les points de croisement
        for ( int i = 0; i < size; i++ ){
            // Si on atteint le point de croisement, on passe au parent suivant et on génère un nouveau point de croisement si il existe
           if ( i == crossoverPoint  ) {
               if ( ! crossoverPoints.isEmpty() )  crossoverPoint = crossoverPoints.pollFirst();
               genesFromParent1 = ! genesFromParent1;                
           } 
           if (genesFromParent1) {
               child1.getGenes().add(parent1.getGenes().get(i));           
               child2.getGenes().add(parent2.getGenes().get(i));
           }
           // Sinon, les gènes proviennent du parent 2
           else {
               child1.getGenes().add(parent2.getGenes().get(i));           
               child2.getGenes().add(parent1.getGenes().get(i));
           }            
        }
        // Évaluer les enfants et les ajouter à la nouvelle génération
        child1.setFitness(child1.evaluat(ensemble));
        child2.setFitness(child2.evaluat(ensemble)); 
        newGeneration.add(child1);
        newGeneration.add(child2);
        return newGeneration;
    }
    
    public  void mutate(double mutationRate, int pos){         
        if ( mutationRate < Math.random() ) return;
        // Obtient le gène à la position donnée
        int gene = this.getGenes().get(pos);
        // myter le gene
        if ( gene == 1 ) gene = 2;
        else gene = 1;
        // Met à jour le gène à la position donnée avec le nouveau gène muté
        this.getGenes().set(pos, gene);         
    }
    
    public List<Integer> getGenes() {
        return genes;
    }

    public void setGenes(List<Integer> solution) {
        this.genes = solution;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    
    private void generateSolution(int size ){
        int rand;
        this.genes = new ArrayList<Integer>();
        for ( int i =0; i < size; i++){
            rand =  (int) (Math.round(Math.random() * (2 - 1)) + 1);
            this.genes.add(rand);
        }              
    }

    public int evaluat(List<Integer> ensemble){        
        int s1 = 0 , s2 = 0 ;
        int size = ensemble.size();
        for (int i = 0 ; i < size; i++ ){
            if ( this.genes.get(i) == 1 ) s1 = s1 + ensemble.get(i);
            else s2 = s2 + ensemble.get(i);      
      }
      return abs( s1 - s2 );        
    }

    
    
    
    
    
    
}

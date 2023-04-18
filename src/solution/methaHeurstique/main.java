package solution.methaHeurstique;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import partitionproblem.Partition;

/**
 *
 * @author client
 */
public class main {
    
    public static void main(String[] args) {
        
        long startTime , endTime ;        
           
        Genetic test1 = new Genetic(100, 20 , 0.1 , 0.2);
        Genetic test2 = new Genetic(500, 50 , 0.4 , 0.5);
        Genetic test3 = new Genetic(1000, 20 , 0.8 , 0.9);
        Genetic test4 = new Genetic(1000, 20 , 0.4 , 0.53);
        Genetic test5 = new Genetic(1500, 100 , 0.7 , 0.75);

        Individual solutionG;
              
        Partition problem = new Partition();   
        
        problem.generateInst(10000);
        System.out.println("L'ensemble est  : ");
        problem.afficheEnsemble();
        
        startTime = System.currentTimeMillis(); 
        solutionG = test1.GenticAlgorithm(problem);
        endTime = System.currentTimeMillis();
        
        System.out.println(" Genetic :  ");
        problem.afficheSolution(solutionG.getGenes());
        System.out.println(" \n fitness : " + solutionG.getFitness());
        System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
        
        startTime = System.currentTimeMillis(); 
        solutionG = test2.GenticAlgorithm(problem);
        endTime = System.currentTimeMillis();
        
        System.out.println(" Genetic :  ");
        problem.afficheSolution(solutionG.getGenes());
        System.out.println(" \n fitness : " + solutionG.getFitness());
        System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
        
        startTime = System.currentTimeMillis(); 
        solutionG = test3.GenticAlgorithm(problem);
        endTime = System.currentTimeMillis();
        
        System.out.println(" Genetic :  ");
        problem.afficheSolution(solutionG.getGenes());
        System.out.println(" \n fitness : " + solutionG.getFitness());
        System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
        
        
        startTime = System.currentTimeMillis(); 
        solutionG = test4.GenticAlgorithm(problem);
        endTime = System.currentTimeMillis();
        
        System.out.println(" Genetic :  ");
        problem.afficheSolution(solutionG.getGenes());
        System.out.println(" \n fitness : " + solutionG.getFitness());
        System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
        
        
        startTime = System.currentTimeMillis(); 
        solutionG = test5.GenticAlgorithm(problem);
        endTime = System.currentTimeMillis();
        
        System.out.println(" Genetic :  ");
        problem.afficheSolution(solutionG.getGenes());
        System.out.println(" \n fitness : " + solutionG.getFitness());
        System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
    
    
    
    
    
    
    
    
    
    }
       
        
        
        
            
        
        
    }

            
   
    
    

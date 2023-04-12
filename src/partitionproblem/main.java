/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import solution.aveugle.AEtoile;
import solution.aveugle.DFSsolution;

/**
 *
 * @author client
 */
public class main {
    
    public static void main(String[] args) {
        
        long startTime , endTime ;
        
        List<Integer> ensemble =  new ArrayList<>(Arrays.asList(184 , 8 ,202 , 14 , 46 , 2 , 280 , 272));
              
        Partition problem = new Partition();
        AEtoile solution = new AEtoile();
        
        problem.generateInst(8);
        System.out.println("L'ensemble est  : ");
        problem.afficheEnsemble();
        
        startTime = System.currentTimeMillis(); 
               
        solution.solve_Partition(problem);
        
        endTime = System.currentTimeMillis();
        
        if ( problem.getSolution().isEmpty() ) 
            System.out.println(" Aucun solution trouve !  ");
        else {
            System.out.println(" Temps d'exeution est : " + (endTime - startTime) + "ms");
     //       System.out.println("\n Nombre de solutions  : " + solution.AllSolutions.size());
     //       System.out.println("\n Nombre de noued avant de trouve la 1 er solution  : " + solution.nouedGenre);
            System.out.println("Nombre de noued genere : " + solution.nbrNouedGenere);
            System.out.println("Nombre de noued developpe : " + solution.nbrNouedDeveloppe);
            System.out.println("\n Nombre de solution optimale trouve  : " + problem.getSolution().size());
            System.out.println("\n La difference minimum est : " + problem.difference);
            System.out.println(" Listes des  solutions optimale trouve : ");
            for ( int i = 0; i < problem.getSolution().size(); i++) {
                System.out.println(" Solution " + (i + 1 ) );
                problem.afficheSolution(problem.getSolution().get(i));
                System.out.println(" ");
            }
                
            
            
            
            
             
            
            
        }
       
        
        
        
            
        
        
    }

            
   
    
    
}

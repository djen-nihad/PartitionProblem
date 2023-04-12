/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.aveugle;

import java.util.ArrayList;
import java.util.List;
import partitionproblem.Partition;

/**
 *
 * @author client
 */
public class DFSsolution  {
    
    private List solutionTrouve ;
    private int difference ;    
        
    public int nouedGenre;
    public List< List<Integer> > AllSolutions; 

    public DFSsolution() {
        this.solutionTrouve = new ArrayList();
        this.AllSolutions = new ArrayList< List <Integer> > ();
        this.difference = -1 ;
        nouedGenre = -1 ;
    }   
    
    
    private boolean alreadyFound (Partition problem , List solution){
        for ( List list : this.AllSolutions){
            if (problem.equale(list, solution)) return true;
        }
        return false;
    }
 
    
   
    public void solve_Partition(Partition problem , int index ){
        
        if ( problem.difference == -1 ) this.nouedGenre++;
        
        if ( index == problem.getEnsemble().size()){          
            if( problem.validSolution(solutionTrouve) ) {
                
                if ( ! alreadyFound(problem , solutionTrouve)) 
                    this.AllSolutions.add(new ArrayList(solutionTrouve));
                this.difference = problem.Evaluation(solutionTrouve);
                
                if ( problem.difference == -1 ){
                    problem.addSolution(solutionTrouve);
                    problem.difference = this.difference;                   
                }                    
                else if ( this.difference == problem.difference && ! problem.alreadyFound(solutionTrouve) )
                    problem.addSolution(solutionTrouve);
                else if ( this.difference < problem.difference ){
                    problem.getSolution().clear();
                    problem.addSolution(solutionTrouve);
                    problem.difference = this.difference;                   
                }                                          
            }  
        }
        else {
            for ( int i = 1; i <= 2; i++){
                this.solutionTrouve.add(index , i );
                solve_Partition(problem , index + 1 );  
                this.solutionTrouve.remove(index);
            }
        }
                
        
    
    }
}

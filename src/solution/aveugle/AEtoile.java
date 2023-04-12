/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution.aveugle;

import java.util.LinkedList;
import partitionproblem.Partition;
import utile.Noued;

/**
 *
 * @author client
 */
public class AEtoile {
    
    public int nbrNouedGenere = 0;
    public int nbrNouedDeveloppe = 0;
    
    
    public void solve_Partition (Partition problem){
        
        Noued nouedCurrent;
        Noued tempNoued;
        LinkedList<Noued> listOvert = new LinkedList<Noued>(); 
        
        nouedCurrent = new Noued( null , problem.getEnsemble() , 1 );
        nouedCurrent.addNouedSort(listOvert);
        nouedCurrent = new Noued( null , problem.getEnsemble() , 2 );
        nouedCurrent.addNouedSort(listOvert);
        
        while ( ! listOvert.isEmpty() ){
            
            nouedCurrent = listOvert.removeFirst();
            this.nbrNouedDeveloppe++;
            
            if ( problem.validSolution( nouedCurrent.solutionTrouve) && nouedCurrent.difference == 0 ){
                System.out.println(" Solution trouvee");
                problem.addSolution(nouedCurrent.solutionTrouve);
                problem.difference = nouedCurrent.difference;
                return;               
            }
            else if ( nouedCurrent.solutionTrouve.size() == problem.getEnsemble().size() ) continue;
             tempNoued =  new Noued( nouedCurrent , problem.getEnsemble() , 1 );
             tempNoued.addNouedSort(listOvert);
             this.nbrNouedGenere++;
             
             tempNoued =  new Noued( nouedCurrent , problem.getEnsemble() , 2 );
             tempNoued.addNouedSort(listOvert);
             this.nbrNouedGenere++;
            
            
            
        }
        
        
    }
    
}

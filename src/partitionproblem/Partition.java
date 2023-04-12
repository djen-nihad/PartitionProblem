/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitionproblem;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author client
 */
public class Partition {

    
    private List<Integer> ensemble  ;
    private List< List<Integer> > solution  ;
    public int difference;
    
    public Partition(){
        ensemble = new ArrayList();
        solution = new ArrayList< List <Integer> > ();
        difference = -1;
    }
    
    public Partition(List<Integer> ensemble){
        this.ensemble = new ArrayList(ensemble);
        solution = new ArrayList(); 
        difference = -1;
    }
    
    public boolean alreadyFound (List solution){
        for ( List list : this.solution){
            if ( this.equale(solution, list)) return true ;
        }
        return false;
    }

    public List<Integer> getEnsemble() {
        return ensemble;
    }

    public List<List<Integer>> getSolution() {
        return solution;
    }

    public int getDifference() {
        return difference;
    }
    
    
    public boolean equale ( List<Integer> solution1 , List<Integer> solution2){
        if ( solution1 == null && solution2 == null ) return true;
        
        List Ensemble11 , Ensemble12 , Ensemble21 , Ensemble22;
        Ensemble11 = new ArrayList();
        Ensemble12 = new ArrayList();
        Ensemble21 = new ArrayList();
        Ensemble22 = new ArrayList();
        
        for ( int i = 0; i < this.ensemble.size(); i++){
            
            if ( solution1.get(i) == 1 ) Ensemble11.add(this.ensemble.get(i));
            else Ensemble12.add(this.ensemble.get(i));
            
            if ( solution2.get(i) == 1 ) Ensemble21.add(this.ensemble.get(i));
            else Ensemble22.add(this.ensemble.get(i));
            
        }
        
        if ( Ensemble11.equals(Ensemble21) && Ensemble12.equals(Ensemble22)  ) return true;
        if ( Ensemble11.equals(Ensemble22) && Ensemble12.equals(Ensemble21) ) return true;
        
        return false;        
               
    }
    
    
     
    
 // génération d’une instance du problème
    public void generateInst(int n ){        
        int valAleo;
        for ( int i = 0; i < n; i++){
            valAleo = (int)(Math.random() * ((300 - 10) + 1));
            ensemble.add(valAleo);
        } 
    }
    
    
// Solution 
    
    public void solutionAleo( List<Integer> solution ){
        int size = ensemble.size();
        for ( int i = 0; i < size; i++){
            if ( ensemble.get(i) % 2 == 0 ) solution.add(1);
            else solution.add(2);      
        }   
       
    }
    
// La vérification de la validité d’une solution
    
  public boolean  validSolution(List<Integer> solution){
    int nb1 = 0 , nb2 = 0 , size = solution.size();
        if ( size != ensemble.size() ) return false; 
        for (int i = 0; i < size; i++){
            if ( solution.get(i) == 1 ) nb1++;
            else if ( solution.get(i) == 2 )  nb2++;
            else return false;
        }
        if ( nb1 == 0 || nb2 == 0 ) return false;
        return true;  
}
  
  public void addSolution(List<Integer> solution) {
      this.getSolution().add(new ArrayList(solution));
  }
    
// L'Évaluation d’une solution 
  
  public int Evaluation(List<Integer> solution){
      int s1 = 0 , s2 = 0 ;
      int size = solution.size();
      for (int i = 0 ; i < size; i++ ){
          if ( solution.get(i) == 1 ) s1 = s1 + ensemble.get(i);
          else s2 = s2 + ensemble.get(i);      
      }
      return abs( s1 - s2 );
  }
  
    public  void afficheEnsemble(){
      for (Integer i : ensemble ){
            System.out.print( i + " || ");
      }
       System.out.print( "\n");
  }
  
   public void afficheSolution(List<Integer> solution){
       System.out.print( "    L'ensemble 1 : ");
       for ( int i = 0; i < solution.size(); i++){
           if (solution.get(i) == 1 )
               System.out.print( this.ensemble.get(i) + " || ");
       }              
      
       System.out.print( "\n    L'ensemble 2 : ");
       
       for ( int i = 0; i < solution.size(); i++){
           if (solution.get(i) == 2 )
               System.out.print( this.ensemble.get(i) + " || ");
       } 
  
       
       
       
   }
    
}

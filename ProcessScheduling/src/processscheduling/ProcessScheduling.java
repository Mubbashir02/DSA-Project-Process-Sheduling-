/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduling;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.Scanner;

/**
 *
 * @author User 1
 */
public class ProcessScheduling {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws FileNotFoundException  {
       int al;
       Style st = new Style();
       st.Header();
       

  while(true)
    {
       
        System.out.println("xx---------------xx------------xx---------------xx---------------xx------------xx---------------xxxx---------------xx------------xx--------------xx------------xx---------------xx");
        System.out.println("");
        System.out.println("Which Algorithm would you like to choose: ");
        System.out.println("Algorithms: ");
        System.out.println("(1) FCFS: ");
        System.out.println("(2) ROUND ROBIN: ");
        System.out.println("(3) SHORTEST JOB FIRST: ");
        System.out.println("(4) Round Robin Advance: ");
        System.out.println("(5) Exit: ");
    	System.out.println("\nCHOOSE : ");
         Scanner sc = new Scanner(System.in);  
         al=sc.nextInt();
       switch(al)
        {
        case 1:
            
        
        FCFS FS = new FCFS();
          FS.Fillingprocess();
          FS.Calculation();
            
            break;
            
        case 2:
       
        RoundRobin RR = new RoundRobin();
             RR.Fillingprocess();
             RR.Calculation();
            
              break;
              
        case 3:
       
        ShortestJobFirst SJ = new ShortestJobFirst();
             SJ.Fillingprocess();
             SJ.Calculation();
           
           break;
           
        case 4:
        
         RoundRobinAdvance RRA = new RoundRobinAdvance();
           RRA.Fillingprocess();
	   RRA.Calculation();
       
      break;
      
        case 5:
            exit(0);

        }
    }
    }
    
}

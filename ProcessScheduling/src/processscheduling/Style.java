/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduling;

import java.io.File;

/**
 *
 * @author Mubbashir
 */
public class Style {
    
        public static String msg = "READING PROCESSCES";
	public static String msg2 = "SCHEDULLING THE PROCESSES ACCORDING TO THE FCFS ALGORITHM";
        public static String msg2rr = "SCHEDULLING THE PROCESSES ACCORDING TO THE RoundRobin ALGORITHM";
        public static String msg2rrd = "SCHEDULLING THE PROCESSES ACCORDING TO THE RoundRobin Advance ALGORITHM";
        public static String msg2sjf = "SCHEDULLING THE PROCESSES ACCORDING TO THE ShortestJobFirst ALGORITHM";
	public static String msg3 = "ENTER NUMBER OF PROCESSCES = ";
	public static String msg1 = ".......";
        public static String msg4 = "ENTER TIME QUANTUM = ";
        public static String line = "||||||||||||||||||||||||||||||||||";
        
        public static String p_f = "P #  ";
	public static String bt_f = "BT ";
	public static String st_f = "ST";
	public static String At_f = "AT ";
	public static String CT_f = "CT ";
	public static String TAT_f = "TAT ";
	public static String WT_f = "WT ";
	public static String RT_f = "RT ";
        
        File filenumber = new File("C:\\Users\\Mubbashir\\Documents\\NetBeansProjects\\ProjectExta\\src\\projectexta/process.txt");
        File filenumber2 = new File("C:\\Users\\Mubbashir\\Documents\\NetBeansProjects\\ProjectExta\\src\\projectexta/Arrivaltime.txt");
        File filenumber3 = new File("C:\\Users\\Mubbashir\\Documents\\NetBeansProjects\\ProjectExta\\src\\projectexta/BurstTime.txt");
    void Header()
{
	   System.out.print("\n\n\n\t\t\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        System.out.print("\t\t\t@@ ____________________________________________________________________________________________________________________________@@\n");
        System.out.print("\t\t\t@@|                                                                                                                           |@@\n");
        System.out.print("\t\t\t@@|                                                     WELCOME TO                                                            |@@\n");
        System.out.print("\t\t\t@@|                                                                                                                           |@@\n");
        System.out.print("\t\t\t@@|                                                   Processing Sheduling                                                    |@@\n");
        System.out.print("\t\t\t@@|                                                                                                                           |@@\n");
        System.out.print("\t\t\t@@|                                                     Operating System                                                      |@@\n");                                                                                  
        System.out.print("\t\t\t@@ ____________________________________________________________________________________________________________________________@@\n");
        System.out.print("\t\t\t@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");
       
        System.out.print("\t\t                                          ___________________________________________________                                          \n\n");
        System.out.print("\t\t                                                   @@| Processing Sheduling|@@                                       \n");
        System.out.print("\t\t                                          ___________________________________________________                                        \n\n");
}
 void STYLE1()
{
    System.out.println("------------------------------------------------------------");
}
  void STYLE2()
{
    System.out.print("-------------------------------------------");
}
}

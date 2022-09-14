/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduling;

import java.io.FileNotFoundException;
import static java.lang.Integer.max;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author User 1
 */
public class RoundRobinAdvance {
    Style st = new Style();
    public static LinkedList<Integer> ReadyQueue_ra = new LinkedList<Integer>();
    public static int numberofprocess_ra;
    int[] processid = new int[100];
    int[] bursttime = new int[100];
    int[] arrivaltime = new int[100];
    int[] start_time = new int[100];
    int[] completion_time = new int[100];
    int[] turnaround_time = new int[100];
    int[] waiting_time = new int[100];
    int[] response_time = new int[100];
    public static int[] burst_remaining_ra = new int[100];
    public static int time_quantum_ra;
    public void Fillingprocess() throws FileNotFoundException
    {
        System.out.println(Style.msg3);
        Scanner sc = new Scanner(System.in);  
        numberofprocess_ra =Integer.parseInt(sc.nextLine());
        System.out.println(Style.msg);
        for(int j = 0 ; j < 4 ; j++ )
        {
            System.out.println(Style.msg1);
        }
        Scanner s = new Scanner(st.filenumber);
        Scanner s2 = new Scanner(st.filenumber2);
        Scanner s3 = new Scanner(st.filenumber3);
        for(int i=0; i<=numberofprocess_ra; i++)
        {
            processid[i] = s.nextInt();
            bursttime[i] = s3.nextInt();
            arrivaltime[i] = s2.nextInt();
            burst_remaining_ra[i] = bursttime[i];
            time_quantum_ra = bursttime[i];
        }
        }
    public void Calculation()
    {
       
        int total_turnaround_time = 0;
        int total_waiting_time = 0;
        int total_response_time = 0;
        int total_idle_time = 0;
        int X;
	int pid1[] = new int[numberofprocess_ra];
	int temp;
        
        for(int i = 0 ; i <numberofprocess_ra; i++)
            {
                for(int  j=0;  j < numberofprocess_ra-(i+1) ; j++)
                {
                    if( arrivaltime[j] > arrivaltime[j+1] )
                    {
                        temp = arrivaltime[j];
                        arrivaltime[j] = arrivaltime[j+1];
                        arrivaltime[j+1] = temp;
                    }
                }
            }

	int current_time = 0;
	ReadyQueue_ra.push(0);
	int completed = 0;
	int[] mark = new int[100];
        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        } 
	mark[0] = 1;

	while (completed != numberofprocess_ra)
	{
            X = ReadyQueue_ra.peek();
            ReadyQueue_ra.pop();

            if (burst_remaining_ra[X] == bursttime[X])
            {
                    start_time[X] = max(current_time,arrivaltime[X]);
                    total_idle_time += start_time[X] - current_time;
                    current_time = start_time[X];
            }

            if (burst_remaining_ra[X] - time_quantum_ra > 0)
            {
                    burst_remaining_ra[X] -= time_quantum_ra;
                    current_time += time_quantum_ra;
            }
            else
            {
                    current_time += burst_remaining_ra[X];
                    burst_remaining_ra[X] = 0;
                    completed++;

                    completion_time[X] = current_time;
                    turnaround_time[X] = completion_time[X] - arrivaltime[X];
                    waiting_time[X] = turnaround_time[X] - bursttime[X];
                    response_time[X] = start_time[X] - arrivaltime[X];

                    total_turnaround_time += turnaround_time[X];
                    total_waiting_time += waiting_time[X];
                    total_response_time += response_time[X];
            }
            for (int i = 1; i < numberofprocess_ra; i++)
            {      
                if (burst_remaining_ra[i] > 0 && arrivaltime[i] <= current_time  && mark[i] == 0)
                {    
                    ReadyQueue_ra.push(i);
                    mark[i] = 1;
                }    
            }
            if (burst_remaining_ra[X] > 0)
            {
                ReadyQueue_ra.push(X);
            }

            if (ReadyQueue_ra.isEmpty())
            {
                for (int i = 1; i < numberofprocess_ra; i++)
                {
                    if (burst_remaining_ra[i] > 0)
                    {
                            ReadyQueue_ra.push(i);
                            mark[i] = 1;
                            break;
                    }
                }
            }
	}

	float avg_turnaround_time = (float) total_turnaround_time / numberofprocess_ra;
	float avg_waiting_time = (float) total_waiting_time / numberofprocess_ra;
	float avg_response_time = (float) total_response_time / numberofprocess_ra;
	float cpu_utilisation = ((completion_time[numberofprocess_ra - 1] - total_idle_time) / (float) completion_time[numberofprocess_ra - 1]) * 100;
        for(int i = 0 ; i <numberofprocess_ra; i++)
            {
                for(int  j=0;  j < numberofprocess_ra-(i+1) ; j++)
                {
                    if( processid[j] > processid[j+1] )
                    {
                        temp = processid[j];
                        processid[j] = processid[j+1];
                        processid[j+1] = temp;
                        
                    }
                }
            }
        System.out.println(Style.line + Style.msg2rrd + Style.line);
        System.out.println();
        st.STYLE1();
        System.out.print(Style.p_f);
        System.out.print("\t" + Style.At_f);
        System.out.print("\t" + Style.bt_f);
        System.out.print("\t" + Style.st_f);
        System.out.print("\t"+ Style.CT_f);
        System.out.print("\t" + Style.TAT_f);
        System.out.print("\t" + Style.WT_f);
        System.out.print("\t" + Style.RT_f);
        System.out.println("");
        st.STYLE1();
        for (int i = 0; i < numberofprocess_ra; i++)
	{
            System.out.print(processid[i]);
            System.out.print("\t"+ arrivaltime[i]);
            System.out.print("\t"+ bursttime[i]); 
            System.out.print("\t"+ start_time[i]);
            System.out.print("\t"+ completion_time[i]);
            System.out.print("\t"+ turnaround_time[i]);
            System.out.print("\t"+ waiting_time[i]);
            System.out.print("\t"+ response_time[i]);
            System.out.println();
            st.STYLE1(); 
       
       }
        
            System.out.print("\nAverage Turnaround Time = ");
            System.out.print(" "+ avg_turnaround_time);
            System.out.print("\nAverage Waiting Time = ");
            System.out.print(" "+ avg_waiting_time);
            System.out.print("\nAverage Response Time = ");
            System.out.print(" "+ avg_response_time);
            System.out.print("\nCPU Utilization = ");
            System.out.print(" "+ cpu_utilisation);
            System.out.println("\n");
            System.out.print("xx---------------xx------------xx---------------xx");
            System.out.println("\n");

    }       
}



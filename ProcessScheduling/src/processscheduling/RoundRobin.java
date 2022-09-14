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
public class RoundRobin {
    Style st = new Style();
    public static LinkedList<Integer> ReadyQueue1 = new LinkedList<Integer>();
    public static int numberofprocessRR;
    int[] processid = new int[100];
    int[] bursttime = new int[100];
    int[] arrivaltime = new int[100];
    int[] start_time = new int[100];
    int[] completion_time = new int[100];
    int[] turnaround_time = new int[100];
    int[] waiting_time = new int[100];
    int[] response_time = new int[100];
    int[] burst_remaining1 = new int[100];
    public static int time_quantum1;
    
    public void Fillingprocess() throws FileNotFoundException
    {
        Scanner sc= new Scanner(System.in);
        System.out.println(Style.msg3);
        numberofprocessRR = Integer.parseInt(sc.nextLine());
        System.out.print("\n");
        System.out.println(Style.msg4);
        time_quantum1 = Integer.parseInt(sc.nextLine());
        System.out.print("\n");
        System.out.println(Style.msg);
        for (int j = 0 ; j < 4 ; j++)
        {
            System.out.println(Style.msg1);
        }
        Scanner s = new Scanner(st.filenumber);
        Scanner s2 = new Scanner(st.filenumber2);
        Scanner s3 = new Scanner(st.filenumber3);
        for(int i=0; i<=numberofprocessRR; i++)
        {
            processid[i] = s.nextInt();
            bursttime[i] = s3.nextInt();
            arrivaltime[i] = s2.nextInt();
            burst_remaining1[i] = bursttime[i];
        }
    }
   public void Calculation()
    {

        int total_turnaround_time = 0;
        int total_waiting_time = 0;
        int total_response_time = 0;
        int total_idle_time = 0;
        int X;
        int temp;
        
        for(int i = 0 ; i <numberofprocessRR; i++)
        {
            for(int  j=0;  j < numberofprocessRR-(i+1) ; j++)
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
	ReadyQueue1.push(0);
	int completed = 0;
	int[] mark = new int[100];
        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        } 
	mark[0] = 1;
	while (completed != numberofprocessRR)
	{
            X = ReadyQueue1.peek();
            ReadyQueue1.pop();
            if (burst_remaining1[X] == bursttime[X])
            {
                start_time[X] = max(current_time,arrivaltime[X]);
                total_idle_time +=start_time[X] - current_time;
                current_time = start_time[X];
            }
            if (burst_remaining1[X] - time_quantum1 > 0)
            {
                burst_remaining1[X] -= time_quantum1; //3
                current_time += time_quantum1;//2
            }
            else
            {
                current_time += burst_remaining1[X];
                burst_remaining1[X] = 0;
                completed++;

                completion_time[X] = current_time;
                turnaround_time[X] = completion_time[X] - arrivaltime[X];
                waiting_time[X] = turnaround_time[X] - bursttime[X];
                response_time[X] = start_time[X] - arrivaltime[X];

                total_turnaround_time += turnaround_time[X];
                total_waiting_time += waiting_time[X];
                total_response_time += response_time[X];
            }

            for (int i = 1; i < numberofprocessRR; i++)
            {
                if (burst_remaining1[i] > 0 && arrivaltime[i] <= current_time  && mark[i] == 0)
                {
                    ReadyQueue1.push(i);
                    mark[i] = 1;
                }
            }
            if (burst_remaining1[X] > 0)
            {
                ReadyQueue1.push(X);
            }

            if (ReadyQueue1.isEmpty())
            {
                for (int i = 1; i < numberofprocessRR; i++)
                {
                    if (burst_remaining1[i] > 0)
                    {
                        ReadyQueue1.push(i);
                        mark[i] = 1;
                        break;
                    }
                }
            }
	}
	float avg_turnaround_time = (float) total_turnaround_time / numberofprocessRR;
	float avg_waiting_time = (float) total_waiting_time / numberofprocessRR;
	float avg_response_time = (float) total_response_time / numberofprocessRR;
	
       float cpu_utilisation = ((completion_time[numberofprocessRR - 1] - total_idle_time) / (float)completion_time[numberofprocessRR - 1]) * 100;
	/*for(int i = 0 ; i <numberofprocessRR; i++)
        {
            for(int  j=0;  j < numberofprocessRR-(i+1) ; j++)
            {
                if( processid[j] > processid[j+1] )
                {
                    
                    temp = processid[j];
                    processid[j] = processid[j+1];
                    processid[j+1] = temp;
                }
            }
        }
        */
        System.out.println(Style.line + Style.msg2rr + Style.line);
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
        
    for (int i = 0; i < numberofprocessRR; i++)
    {   
        System.out.print(processid[i]);
        System.out.print("\t" + arrivaltime[i]);
        System.out.print("\t"+ bursttime[i]);
        System.out.print("\t"+ start_time[i]);
        System.out.print("\t "+ completion_time[i]);
        System.out.print("\t "+ turnaround_time[i]);
        System.out.print("\t "+ waiting_time[i]);
        System.out.print("\t "+ response_time[i]);
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
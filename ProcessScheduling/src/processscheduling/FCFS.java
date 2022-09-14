/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduling;

import static java.lang.Double.max;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 *
 * @author User 1
 */
public class FCFS{
    Style st = new Style();
    public static int numberofprocess1;
    int[] processid = new int[100];
    int[] bursttime = new int[100];
    int[] arrivaltime = new int[100];
    int[] start_time = new int[100];
    int[] completion_time = new int[100];
    int[] turnaround_time = new int[100];
    int[] waiting_time = new int[100];
    int[] response_time = new int[100];
    
    public static int[] burst_remaining = new int[100];

void Fillingprocess() throws FileNotFoundException
{

    System.out.println(Style.msg3);
    Scanner sc = new Scanner(System.in);  
    numberofprocess1 =sc.nextInt();
    System.out.println(Style.msg);

    for(int j = 0 ; j < 4 ; j++ )
    {
        System.out.println(Style.msg1);
    }
    
    Scanner s = new Scanner(st.filenumber);
    Scanner s2 = new Scanner(st.filenumber2);
    Scanner s3 = new Scanner(st.filenumber3);
        for(int i=0; i<=numberofprocess1; i++)
        {
            processid[i] = s.nextInt();
            bursttime[i] = s3.nextInt();
            arrivaltime[i] = s2.nextInt();
        }
}
public void Calculation()
{
    int pid[] = new int[numberofprocess1];
    int total_turnaround_time = 0;
    int total_waiting_time = 0;
    int total_response_time = 0;
    int total_idle_time = 0;
    int temp;
    
    for(int i = 0 ; i <numberofprocess1; i++)
    {
        for(int  j=0;  j < numberofprocess1-(i+1) ; j++)
        {
            if( arrivaltime[j] > arrivaltime[j+1] )
            {
                    temp = arrivaltime[j];
                    arrivaltime[j] = arrivaltime[j+1];
                    arrivaltime[j+1] = temp;
            }
        }
    }

    for (int i = 0; i < numberofprocess1; i++)
    {
        start_time[i] = (int) ((i == 0)?arrivaltime[i]:max(completion_time[i-1],arrivaltime[i]));
        completion_time[i] = start_time[i]+ bursttime[i];
        turnaround_time[i] = completion_time[i] - arrivaltime[i];
        waiting_time[i] = turnaround_time[i] - bursttime[i];
        response_time[i] = start_time[i] - arrivaltime[i];

        total_turnaround_time += turnaround_time[i];
        total_waiting_time += waiting_time[i];
        total_response_time += response_time[i];
        total_idle_time += (i == 0)?(arrivaltime[i]):(start_time[i] - completion_time[i-1]);
    }

        float avg_turnaround_time = (float) total_turnaround_time / numberofprocess1;
        float avg_waiting_time = (float) total_waiting_time / numberofprocess1;
        float avg_response_time = (float) total_response_time / numberofprocess1;
        float cpu_utilisation = ((completion_time[numberofprocess1 - 1] - total_idle_time) / (float) completion_time[numberofprocess1 - 1]) * 100;
        float throughput = (float)numberofprocess1 / (completion_time[numberofprocess1 - 1] - arrivaltime[0]);
        for(int i = 0 ; i <numberofprocess1; i++)
        {
            for(int  j=0;  j < numberofprocess1-(i+1) ; j++)
            {
                if( processid[j] > processid[j+1] )
                {
                        temp = processid[j];
                        processid[j] = processid[j+1];
                        processid[j+1] = temp;
                }
            }
        }
        System.out.println(Style.line + Style.msg2 + Style.line);
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
    
    for (int i = 0; i < numberofprocess1; i++)
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
        st.STYLE2();
        System.out.print("\nAverage Turnaround Time = ");
	System.out.print(" "+ avg_turnaround_time);
	System.out.print("\nAverage Waiting Time = ");
	System.out.print(" "+ avg_waiting_time);
	System.out.print("\nAverage Response Time = ");
	System.out.print(" "+ avg_response_time);
	System.out.print("\nCPU Utilization = ");
	System.out.println(" "+ cpu_utilisation);
        st.STYLE2();
        System.out.println("\n");
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processscheduling;

import java.io.FileNotFoundException;
import static java.lang.Double.max;
import static java.lang.Double.min;
import java.util.Scanner;

/**
 *
 * @author User 1
 */
public class ShortestJobFirst {
    Style st = new Style();
    public static int numberofprocess_s;
    int[] processid = new int[100];
    int[] bursttime = new int[100];
    int[] arrivaltime = new int[100];
    int[] start_time = new int[100];
    int[] completion_time = new int[100];
    int[] turnaround_time = new int[100];
    int[] waiting_time = new int[100];
    int[] response_time = new int[100];

void Fillingprocess() throws FileNotFoundException
{

    System.out.println(st.msg3);
    Scanner sc = new Scanner(System.in);  
    numberofprocess_s =sc.nextInt();
    System.out.println(Style.msg);
    for(int j = 0 ; j < 4 ; j++ )
    {
        System.out.println(Style.msg1);
    }
        Scanner s = new Scanner(st.filenumber);
        Scanner s2 = new Scanner(st.filenumber2);
        Scanner s3 = new Scanner(st.filenumber3);
        for(int i=0; i<=numberofprocess_s; i++)
        {
            processid[i] = s.nextInt();
            bursttime[i] = s3.nextInt();
            arrivaltime[i] = s2.nextInt();
        }
}
public void Calculation()
{
    int[] isCompleted = new int[100];
    for (int i = 0; i < isCompleted.length; i++) {
            isCompleted[i] = 0;
        } 
    int current_time = 0;
    int completed = 0;
    int previous = 0;
    int total_turnaround_time = 0;
    int total_waiting_time = 0;
    int total_response_time = 0;
    int total_idle_time = 0;

    while (completed != numberofprocess_s)
    {
        int XR = -1;
        int MR = 10000000;
        for (int i = 0 ; i < numberofprocess_s ; i++)
        {
          if (arrivaltime[i] <= current_time && isCompleted[i] == 0)
            {
                if (bursttime[i] < MR)
                {
                    MR = bursttime[i];
                    XR = i;
                }
                if (bursttime[i] == MR)
                {
                    if (arrivaltime[i] < arrivaltime[XR])
                    {
                            MR = bursttime[i];
                            XR = i;
                    }
                }
            }
        }
    if (XR != -1)
    {
        start_time[XR] = current_time;
        completion_time[XR] = start_time[XR] + bursttime[XR];
        turnaround_time[XR] = completion_time[XR] - arrivaltime[XR];
        waiting_time[XR] = turnaround_time[XR] - arrivaltime[XR];
        response_time[XR] = start_time[XR] - arrivaltime[XR];
        total_turnaround_time += turnaround_time[XR];
        total_waiting_time += waiting_time[XR];
        total_response_time += response_time[XR];
        isCompleted[XR] = 1;
        completed++;
        current_time = completion_time[XR];
        previous = current_time;
    }
    else
    {
        current_time++;
    }
    }
	int min_arrival_time = 10000000;
	int max_completion_time = -1;
	for (int i = 0 ; i < numberofprocess_s ; i++)
	{
		min_arrival_time = (int) min(min_arrival_time,arrivaltime[i]);
		max_completion_time = (int) max(max_completion_time,completion_time[i]);
	}
	float avg_turnaround_time = (float) total_turnaround_time / numberofprocess_s;
	float avg_waiting_time = (float) total_waiting_time / numberofprocess_s;
	float avg_response_time = (float) total_response_time / numberofprocess_s;
	float cpu_utilisation = ((completion_time[numberofprocess_s - 1] - total_idle_time) / (float) completion_time[numberofprocess_s - 1]) * 100;

        System.out.println(Style.line + Style.msg2sjf + Style.line);
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
        for (int i = 0; i < numberofprocess_s; i++)
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
	System.out.printf("\nAverage Turnaround Time = ");
	System.out.printf(" "+ avg_turnaround_time);
	System.out.printf("\nAverage Waiting Time = ");
	System.out.printf(" "+ avg_waiting_time);
	System.out.printf("\nAverage Response Time = ");
	System.out.printf(" "+ avg_response_time);
	System.out.printf("\nCPU Utilization = ");
	System.out.printf(" "+ cpu_utilisation);
        System.out.println("\n");
        System.out.print("xx---------------xx------------xx---------------xx");
        System.out.println("\n");
}
}
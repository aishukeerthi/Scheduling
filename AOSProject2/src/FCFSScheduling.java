import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FCFSScheduling {
	
	
	public static void FAFCScheduling(HashMap<String, ProcessObject> processMap) {

        List<Map.Entry<String, ProcessObject>> processList
                = new LinkedList<Map.Entry<String, ProcessObject>>(
                processMap.entrySet());

        Collections.sort(
                processList,
                (i1,
                 i2) -> i1.getValue().getEntryTime().compareTo(i2.getValue().getEntryTime()));

        HashMap<String, ProcessObject> finalmap
                = new LinkedHashMap<String, ProcessObject>();
        for (Map.Entry<String, ProcessObject> aa : processList) {
            finalmap.put(aa.getKey(), aa.getValue());
        }

        LinkedList<Integer> waitingTimeList = new LinkedList<>();
        int totalwt = 0;
        for (Map.Entry<String, ProcessObject> map :
                finalmap.entrySet()) {
            waitingTimeList.add(totalwt);
            totalwt += map.getValue().getBrustTime();

        }
        
        System.out.println("**************    FCFS Scheduling ************************");
        System.out.print("\n");

        System.out.println("Process " + "ArrivalTime " + "CpuBurstTime " + "WaitingTime " + "TurnAroundTime ");

        int index = 0;
        double tat = 0;
        for (Map.Entry<String, ProcessObject> map :
                finalmap.entrySet()) {

            if (index < waitingTimeList.size()) {

                System.out.println(map.getValue().getProcessNumber() + "\t\t" + map.getValue().getEntryTime() + "\t\t" + map.getValue().getBrustTime() + "\t\t" + waitingTimeList.get(index) + "\t\t " + (waitingTimeList.get(index) + map.getValue().getBrustTime()));

                tat += waitingTimeList.get(index) + map.getValue().getBrustTime();
                index++;
            }

        }
        double avg_waiting_time = 0.0, total_waiting_time = 0.0;
        for (int i = 0; i < waitingTimeList.size(); i++) {
            total_waiting_time += waitingTimeList.get(i);
        }
        avg_waiting_time = total_waiting_time / waitingTimeList.size();
        System.out.println(" The Average value of waiting time =" + avg_waiting_time);
        System.out.print("\n");


    }

}

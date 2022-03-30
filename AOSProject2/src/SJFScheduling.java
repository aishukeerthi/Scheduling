import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class SJFScheduling {
    public static void getSJFScheduling(HashMap<String, ProcessObject> processMap) {

        List<Map.Entry<String, ProcessObject>> processList
                = new LinkedList<Map.Entry<String, ProcessObject>>(
                processMap.entrySet());

        Collections.sort(
                processList,
                (i1,
                 i2) -> i1.getValue().getBrustTime().compareTo(i2.getValue().getBrustTime()));

        HashMap<String, ProcessObject> sortedMap
                = new LinkedHashMap<String, ProcessObject>();
        for (Map.Entry<String, ProcessObject> aa : processList) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }

        LinkedList<Integer> waitingTimeList = new LinkedList<>();
        int totalWaitingTime = 0;
        for (Map.Entry<String, ProcessObject> map :
                sortedMap.entrySet()) {
            waitingTimeList.add(totalWaitingTime);
            totalWaitingTime += map.getValue().getBrustTime();

        }
        
        System.out.println("**************    SJFS Scheduling ************************");
        System.out.print("\n");

        System.out.println("Process " + "ArrivalTime " + "CpuBurstTime " + "WaitingTime " + "TurnAroundTime ");

        int index = 0;
        double totalTurnAroundTime = 0;
        for (Map.Entry<String, ProcessObject> map :
                sortedMap.entrySet()) {

            if (index < waitingTimeList.size()) {

                System.out.println(map.getValue().getProcessNumber() + "\t\t" + map.getValue().getEntryTime() + "\t\t" + map.getValue().getBrustTime() + "\t\t" + waitingTimeList.get(index) + "\t\t " + (waitingTimeList.get(index) + map.getValue().getBrustTime()));

                totalTurnAroundTime += waitingTimeList.get(index) + map.getValue().getBrustTime();
                index++;
            }

        }
        double averageWaitingTime = 0.0, total_WaitingTime = 0.0;
        for (int i = 0; i < waitingTimeList.size(); i++) {
            total_WaitingTime += waitingTimeList.get(i);
        }
        averageWaitingTime = total_WaitingTime / waitingTimeList.size();
        System.out.println("Average value of waiting time =" + averageWaitingTime);
        double avgTurnAroundTime = totalTurnAroundTime / waitingTimeList.size();
        System.out.println("Average value of  TurnaroundTime time =" + avgTurnAroundTime);
        System.out.print("\n");

    }

}

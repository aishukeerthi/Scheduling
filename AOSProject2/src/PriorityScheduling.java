import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class PriorityScheduling {
    public static void getPriorityBasedScheduling(HashMap<String, ProcessObject> processMap) {
        List<Map.Entry<String, ProcessObject>> processList
                = new LinkedList<Map.Entry<String, ProcessObject>>(
                (Collection<? extends Map.Entry<String, ProcessObject>>) processMap.entrySet());
        Collections.sort(
                processList,
                (i1,
                 i2) -> i1.getValue().getProcess_priority().compareTo(i2.getValue().getProcess_priority()));

        HashMap<String, ProcessObject> sortedMap
                = new LinkedHashMap<String, ProcessObject>();
        for (Map.Entry<String, ProcessObject> aa : processList) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }

        LinkedList<Integer> wt_list = new LinkedList<>();
        int totalWaitingTime =0 ;
        for (Map.Entry<String, ProcessObject> map :
                sortedMap.entrySet()) {
            wt_list.add(totalWaitingTime);
            totalWaitingTime += map.getValue().getBrustTime();

        }
        
        System.out.println("**************    Priority Scheduling ************************");
        System.out.print("\n");

        System.out.println("Process " +  "Priority "+ " ArrivalTime " + "CpuBurstTime " + "WaitingTime " + "TurnAroundTime ");

        int index = 0;
        for (Map.Entry<String, ProcessObject> map :
                sortedMap.entrySet()) {

            if (index < wt_list.size()) {

                System.out.println(map.getValue().getProcessNumber() + "\t\t" + map.getValue().getProcess_priority() +"\t\t" + map.getValue().getEntryTime() + "\t\t" + map.getValue().getBrustTime() + "\t\t" + wt_list.get(index) + "\t\t " + (wt_list.get(index) + map.getValue().getBrustTime()));

                index++;
            }

        }
        double avgWT = 0.0, totAL_WT = 0.0;
        for (int i = 0; i < wt_list.size(); i++) {
            totAL_WT += wt_list.get(i);
        }
        avgWT = totAL_WT/wt_list.size();
        System.out.println("Average value of waiting time =" + avgWT);
        System.out.print("\n");


    }

}

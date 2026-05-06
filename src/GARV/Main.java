package GARV;
import java.util.*;
public class Main {
	static List<Task> tasks = new ArrayList<>();
	static List<VM> vms = new ArrayList<>();
	static List<TaskVmPair> finalAllocationList = new ArrayList<>();
	public static void main(String[] args) {
        try {
            tasks = Utils.readTasks("G:\\My Drive\\PhD\\Contributions\\4. Contribution 3 (GARV)\\Revision 2\\Dataset\\TaskDataset\\TaskDataset100.csv");
            vms = Utils.readVMs("G:\\My Drive\\PhD\\Contributions\\4. Contribution 3 (GARV)\\Revision 2\\Dataset\\VmDataset\\100VmDataset.csv");
            
            
            GeneticAlgorithm ga = new GeneticAlgorithm(tasks, vms);
            
            long startTime = System.currentTimeMillis();
            
            Chromosome bestSolution = ga.run();
            
            long endTime = System.currentTimeMillis();
            
            long executionTimeMs = endTime - startTime;
            
            double executionTimeSec = executionTimeMs / 1000.0;
            
            Results.executionTimeSec=executionTimeSec;
            
         // This handles all three scenarios automatically
            finalAllocationList = ga.buildFinalAllocation(bestSolution);

            
            System.out.println("******************************************");
            System.out.println("The Allocation List:");
            for (TaskVmPair pair : finalAllocationList) {
                System.out.println("Task " + pair.task.id + " → VM " + pair.vm.id);
            }
            
            Execution.performExecution(finalAllocationList);
            Results.printResults();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

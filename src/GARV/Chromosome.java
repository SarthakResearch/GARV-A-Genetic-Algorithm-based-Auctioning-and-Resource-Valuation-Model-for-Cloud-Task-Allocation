package GARV;
import java.util.*;

public class Chromosome {
	// gene[i] = position in vmOrder list assigned to task i
    //           (when tasks <= vms)
    // gene[k] = position in taskPool list assigned to VM k  
    //           (when tasks > vms)
    // VALUES ALWAYS range from 0 to gene.length-1
    // This is critical for fillRemaining() to work correctly
    public int[] gene;
    public double fitness;
 
    public Chromosome(int size) {
        gene = new int[size];
    }
 
    public Chromosome clone() {
        Chromosome c = new Chromosome(gene.length);
        System.arraycopy(this.gene, 0, c.gene, 0, gene.length);
        c.fitness = this.fitness;
        return c;
    }
//	public int[] taskToVm; // Index: task, Value: vm assigned
//	public int[] selectedTasks;
//	// MODIFICATION: new array for tasks > vms scenario
//    // selectedTasks[k] = index of task assigned to VM k
//    // This tells the GA WHICH tasks are selected for allocation
//    public double fitness;
//
//    public Chromosome(int taskCount) {
//        taskToVm = new int[taskCount];
//        selectedTasks=null; // not needed when tasks <= vms
//    }
//    
//    // MODIFICATION: new constructor for tasks > vms scenario
//    // vmCount = number of VMs = number of tasks that can be allocated
//    public Chromosome(int vmCount, boolean tasksExceedVms) {
//        // When tasks > vms, chromosome length = vmCount
//        // Each position k represents VM k
//        // Value selectedTasks[k] tells which task goes to VM k
//        taskToVm = new int[vmCount];
//        selectedTasks = new int[vmCount];
//    }
//
//    public Chromosome clone() {
//    	if(selectedTasks == null) {
//    		// Original clone for tasks <= vms
//        	Chromosome c = new Chromosome(taskToVm.length);
//        	System.arraycopy(this.taskToVm, 0, c.taskToVm, 0, taskToVm.length);
//        	c.fitness = this.fitness;
//        	return c;
//    	}
//    	else {
//    		// MODIFICATION: clone for tasks > vms
//    		Chromosome c = new Chromosome(taskToVm.length, true);
//    		System.arraycopy(this.taskToVm, 0, c.taskToVm, 0, taskToVm.length);
//    		System.arraycopy(this.selectedTasks, 0, c.selectedTasks, 0, selectedTasks.length);
//    		c.fitness = this.fitness;
//    		return c;
//    	}
//    }
}

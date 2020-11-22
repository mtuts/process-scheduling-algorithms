public class Main {

  public static void main(String[] args) {
    int[] bt =  {10, 2, 3, 2}; // {5, 3, 8, 6}
    int[] at =  {0, 1, 2, 5}; // {0, 1, 2, 3}
    int[] pp = {1, 2, 1, 3};  // process priority
    Process[] processes = new Process[bt.length];
    for (int i = 0; i < processes.length; i++) {
      processes[i] = new Process(i + 1, bt[i], at[i]);
      processes[i].setPriority(pp[i]);
    }

    FCFS fcfs = new FCFS(processes);
    fcfs.printResult();

    SJF sjf = new SJF(processes);
    sjf.printResult();

    SJFPreemptive sjf_preemptive = new SJFPreemptive(processes);
    sjf_preemptive.printResult();

    RoundRobin roundRobin = new RoundRobin(processes, 2);
    roundRobin.printResult();


    Priority priority = new Priority(processes);
    priority.printResult();
  }
}

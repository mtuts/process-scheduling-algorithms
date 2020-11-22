import java.util.SortedSet;

public abstract class Algorithm {
  protected Process[] processes;
  protected SortedSet<Process> sorted_processes;
  protected double total_waiting_time;
  protected double average_waiting_time;
  protected int time;

  public Algorithm(Process[] processes) {
    this.processes = processes;
    for (Process process : processes) {
      process.reset();
    }
    time = 0;
  }

  protected abstract void sort();

  /**
   * compute waiting time algorithm over
   */
  protected abstract void apply();
  public abstract void printResult();

  protected String getName() {
    return getClass().getName();
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class RoundRobin extends FCFS {

  private int quantum;

  public RoundRobin(Process[] processes, int quantum) {
    super(processes);
    this.quantum = quantum;
  }

  @Override
  protected void apply() {
    GrantChart grantChart = new GrantChart();
    ArrayList<Process> list;
    time = 0;
    total_waiting_time = 0;
    average_waiting_time = 0;
    sort();
    list = new ArrayList<>(sorted_processes);

    int index = 0;
    while (list.size() > 0) {
      Process process = list.get(index);
      grantChart.schedule(process);
      int processed = Math.min(process.remaining_burst_time, quantum);
      grantChart.passTime(processed);
      process.remaining_burst_time -= processed;
      if (process.remaining_burst_time == 0) {
        list.remove(index);
        if (list.size() > 0) {
          index = index % list.size();
        }
      } else {
        index = (index + 1) % list.size();
      }
    }
    grantChart.calculateWaitingTime();
    grantChart.print();
    average_waiting_time = grantChart.getTotalWaitingTime() / processes.length;
  }
}

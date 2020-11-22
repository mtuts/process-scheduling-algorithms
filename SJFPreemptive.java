import java.util.ArrayList;
import java.util.Arrays;

public class SJFPreemptive extends SJF {

  public SJFPreemptive(Process[] processes) {
    super(processes);
  }

  @Override
  protected void apply() {
    time = 0;
    total_waiting_time = 0;
    average_waiting_time = 0;
    ArrayList<Process> list = new ArrayList<>(Arrays.asList(processes));
    GrantChart grantChart = new GrantChart();

    while (list.size() > 0) {
      Process process = nextProcess(list, time);
      grantChart.schedule(process);
      process.remaining_burst_time--;
      if (process.remaining_burst_time == 0) {
        list.remove(process);
      }
      time++;
    }
    grantChart.calculateWaitingTime();
    grantChart.print();
    average_waiting_time = grantChart.getTotalWaitingTime() / processes.length;
  }

  private Process nextProcess(ArrayList<Process> list, int time) {
    Process process = list.get(0);
    for (int i = 1; i < list.size(); ++i) {
      if ((list.get(i).getArrivingTime() <= time
          && list.get(i).remaining_burst_time < process.remaining_burst_time)
          || (list.get(i).getArrivingTime() <= time
          && process.getArrivingTime() > time)) {
        process = list.get(i);
      }
    }
    return process;
  }

  @Override
  protected String getName() {
    return "SJF Preemptive";
  }
}

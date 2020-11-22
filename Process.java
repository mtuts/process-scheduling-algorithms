public class Process {
  private int id;
  private int burst_time;
  private int arriving_time;
  private int starting_time;
  private int waiting_time;
  private int priority;
  int remaining_burst_time;

  public Process(int id, int burst_time, int arriving_time) {
    this.id = id;
    this.burst_time = burst_time;
    this.arriving_time = arriving_time;
    remaining_burst_time = burst_time;
    waiting_time = -1;
    priority = 0;
  }

  public int getId() {
    return id;
  }

  public int getBurstTime() {
    return burst_time;
  }

  public int getArrivingTime() {
    return arriving_time;
  }

  public int getStartingTime() {
    return starting_time;
  }

  public void setStartingTime(int starting_time) {
    this.starting_time = starting_time;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public int getWaitingTime() {
    if (waiting_time < 0) {
      return starting_time - arriving_time;
    }
    return waiting_time;
  }

  public void setWaitingTime(int waiting_time) {
    this.waiting_time = waiting_time;
  }

  public static String getHeader() {
    return getHeader(false);
  }
  public static String getHeader(boolean with_priority) {
    return "Process\tBurst\tArriving\tStarting\tWaiting"
        + (with_priority ? "\tPriority" : "");
  }

  @Override
  public String toString() {
    return String.format("P%-6d\t%-5d\t%-8d\t%-8d\t%-6d",
        id, burst_time, arriving_time, starting_time, getWaitingTime());
  }

  public String toStringWithPriority() {
    return String.format("%s\t%-5d",
          this, priority);
  }

  public void reset() {
    remaining_burst_time = burst_time;
    starting_time = -1;
    waiting_time = -1;
  }
}

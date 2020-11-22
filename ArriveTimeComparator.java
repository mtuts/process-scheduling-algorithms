import java.util.Comparator;

public class ArriveTimeComparator implements Comparator<Process> {
  @Override
  public int compare(Process o1, Process o2) {
    int diff = o1.getArrivingTime() - o2.getArrivingTime();
    if (diff == 0) diff = o1.getId() - o2.getId();
    return diff;
  }
}

import java.util.Comparator;

public class PriorityComparator implements Comparator<Process> {
  @Override
  public int compare(Process o1, Process o2) {
    int diff = o2.getPriority() - o1.getPriority();
    if (diff == 0) diff = o1.getArrivingTime() - o2.getArrivingTime(); // low has low priority
    if (diff == 0) diff = o1.getId() - o2.getId();
    return diff;
  }
}

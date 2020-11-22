import java.util.Comparator;

public class ShortestJobComparator implements Comparator<Process> {
  @Override
  public int compare(Process o1, Process o2) {
    int diff = o1.getBurstTime() - o2.getBurstTime();
    if (diff == 0) diff = 1;
    return diff;
  }
}

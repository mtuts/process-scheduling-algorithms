import java.util.Comparator;

public class IdComparator implements Comparator<Process> {
  @Override
  public int compare(Process o1, Process o2) {
    int diff = o1.getId() - o2.getId();
    return diff;
  }
}

public class Part {
  private Process process;
  private int start;
  private int end;

  public Part(Process process, int start) {
    this.process = process;
    this.start = start;
    this.end = start + 1;
  }

  public Process getProcess() {
    return process;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public void complete(int time) {
    this.end = time;
  }
}

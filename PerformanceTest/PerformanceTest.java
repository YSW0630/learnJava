public class PerformanceTest {
  public static void main(String[] args) {
    SwitchCaseTest();
    System.out.println();
    IfElseTest();
    System.out.println();
  }

  public static void IfElseTest() {
    long StartTime, EndTime;
    StartTime = System.currentTimeMillis(); // 單位：毫秒
    for (int i = 0; i < 100000000; ++i) {
      if (i % 3 == 1) {
      } // nothing
      else if (i % 3 == 2) {
      } // nothing
      else {
      } // nothing
    }
    EndTime = System.currentTimeMillis(); // 單位：毫秒
    System.out.print("Times of IfElseMethod: ");
    System.out.println(EndTime - StartTime);
    System.out.print("(unit: ms)");
    return;
  }

  public static void SwitchCaseTest() {
    long StartTime, EndTime;
    StartTime = System.currentTimeMillis(); // 單位：毫秒
    for (int i = 0; i < 100000000; ++i) {
      switch (i) {
        case 1: // nothing
        case 2: // nothing
        default: // nothing
      }
    }
    EndTime = System.currentTimeMillis(); // 單位：毫秒
    System.out.print("Times of SwitchCaseMethod: ");
    System.out.println(EndTime - StartTime);
    System.out.print("(unit: ms)");
    return;
  }
}

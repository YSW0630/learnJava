import java.util.Scanner;

public class MustWin {
  public static void PrintLogo() {
    // 提供ascii art : figlet (http://www.figlet.org/)
    System.out.println("__        __   _                            _____");
    System.out.println("\\ \\      / /__| | ___ ___  _ __ ___   ___  |_   _|__");
    System.out.println(" \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   | |/ _ \\");
    System.out.println("  \\ V  V /  __/ | (_| (_) | | | | | |  __/   | | (_) |");
    System.out.println("   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|   |_|\\___/");
    System.out.println(" ____  ____  ____     ____");
    System.out.println("|  _ \\|  _ \\/ ___|   / ___| __ _ _ __ ___   ___");
    System.out.println("| |_) | |_) \\___ \\  | |  _ / _` | '_ ` _ \\ / _ \\");
    System.out.println("|  _ <|  __/ ___) | | |_| | (_| | | | | | |  __/");
    System.out.println("|_| \\_\\_|   |____/   \\____|\\__,_|_| |_| |_|\\___|");
    System.out.println();
    // 讓程式停頓
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    PrintLogo();
    String[] special_weapons = {"大砲", "棒球棍", "核彈"};
    String myFist;
    Scanner scanner = new Scanner(System.in);
    System.out.println("你想出什麼拳 (無論出什麼我絕對會贏..吧？) [1] rock [2] paper [3] scissors [4] special");
    while (scanner.hasNext()) {
      myFist = scanner.next();
      if (myFist.equals("rock") || myFist.equals("1")) {
        System.out.println("paper !");
      } else if (myFist.equals("paper") || myFist.equals("2")) {
        System.out.println("scissors !");
      } else if (myFist.equals("scissors") || myFist.equals("3")) {
        System.out.println("rock !");
      } else if (myFist.equals("special") || myFist.equals("4")) {
        int r = (int)(Math.random()*10) % 3;
        if (special_weapons[r].equals("大砲")) {
          System.out.println("使用大砲將對手轟飛!");
        } else if (special_weapons[r].equals("棒球棍")) {
          System.out.println("RPG Game被棒球棍雜碎!");
        } else {
          System.out.println("BOOOOOOM");
        }
        System.exit(0);
      } else {
        System.out.println("我不認得這個拳???\n請輸入數字 1 ~ 3或rock paper scissors");
      }
    }
    scanner.close();
  }
}

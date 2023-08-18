import java.util.ArrayList;
import java.util.Scanner;

public class square_table {
    // java 中實現停頓效果 (link:
    // https://matthung0807.blogspot.com/2017/09/java-threadsleep.html)
    public static void Sleep(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void PrintLogo() {
        // 提供 ascii art : figlet (http://www.figlet.org/)
        System.out.println(" ___        _       _____ _");
        System.out.println("/ _ \\ _   _(_)____ |_   _(_)_ __ ___   ___");
        System.out.println("| | | | | | | |_  /   | | | | '_ ` _ \\ / _ \\");
        System.out.println("| |_| | |_| | |/ /    | | | | | | | | |  __/");
        System.out.println(" \\__\\_\\\\__,_|_/___|   |_| |_|_| |_| |_|\\___|\n");
        System.out.println("ps. 欲離開測驗請按 Ctrl + C \n");
        Sleep(1000);
    }

    private static void Ready() {
        System.out.print("測驗即將開始，倒數：");
        for (int _i = 3; _i >= 1; --_i) {
            System.out.print(_i);
            System.out.print(' ');
            Sleep(1000);
        }
        System.out.println();
    }

    private static void Total_grade(int Correct, int Incorrect, ArrayList<String> Emoji) {
        String Good = " 🤑 精熟, Power King！🤑 ", Meh = "😑 還行ㄟ～ 😑", Bad = "😵 請再加油吧 😵";
        System.out.print("測驗結束！你的成績是");
        for (int _i = 0; _i < 10; ++_i) {
            System.out.print('.');
            Sleep(300);
        }
        System.out.println();
        for (int i = 0; i < Emoji.size(); ++i) {
            System.out.printf("第%d題：%s\n", i + 1, Emoji.get(i));
            Sleep(1000);
        }
        System.out.print("評比");
        for (int _i = 0; _i < 10; ++_i) {
            System.out.print('.');
            Sleep(300);
        }
        System.out.println();
        if (Correct > Incorrect)
            System.out.println(Good);
        else if (Correct < Incorrect)
            System.out.println(Bad);
        else
            System.out.println(Meh);
    }

    public static void main(String[] args) {
        final String Check = "✅", Wrong = "❌", TLE = "💣 超過時限";
        boolean again = true;
        PrintLogo();
        while (again) {
            int correct_cnt = 0, incorrect_cnt = 0;
            // 沒用過的資料結構，類似 C++ 的 Vector, 可長可短 (link:
            // https://www.runoob.com/java/java-arraylist.html)
            ArrayList<Integer> ans = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<String> emoji = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            // slow: 10s fast: 5s
            System.out.print("請選擇測驗速度：(1) slow (2) fast\n>> ");
            String speed = sc.next();
            while (!speed.equals("1") && !speed.equals("2") && !speed.equalsIgnoreCase("fast")
                    && !speed.equalsIgnoreCase("slow")) {
                System.out.print("速度請輸入 1 or 2 or slow or fast\n>> ");
                speed = sc.next();
            }
            System.out.print("請輸入今日的題數 (須為正整數, 建議不要太大否則會有重複)：\n>> ");
            // user input test
            int probs;
            while (true) {
                if (sc.hasNextInt()) {
                    probs = sc.nextInt();
                    if (probs >= 1)
                        break;
                    else
                        System.out.print("請照要求輸入非零正整數\n>> ");
                } else {
                    System.out.print("請照要求輸入喔\n>> ");
                    sc.next(); // 清除無效數字
                }
            }
            // 生成測驗表
            for (int makeList_cnt = 0; makeList_cnt < probs; ++makeList_cnt) {
                list.add((int) (Math.random() * 50) + 1);
                ans.add(list.get(makeList_cnt) * list.get(makeList_cnt));
            }
            Ready();
            // main
            if (speed.equals("1") || speed.equalsIgnoreCase("slow")) {
                for (int travel_cnt = 0; travel_cnt < list.size(); ++travel_cnt) {
                    System.out.printf("%d x %d = ", list.get(travel_cnt), list.get(travel_cnt));
                    // 實現倒計時 (link: https://tw.gitbook.net/java/lang/system_currenttimemillis.html)
                    // 另外，有一個叫 Thread 的物件可以實現多線程來立即判斷有沒有超時，但目前還沒學到 qq
                    long startTime = System.currentTimeMillis();
                    int usrInput = sc.nextInt();
                    if (usrInput == ans.get(travel_cnt) && System.currentTimeMillis() - startTime < 10000) {
                        correct_cnt++;
                        emoji.add(Check);
                    } else {
                        incorrect_cnt++;
                        if (usrInput == ans.get(travel_cnt) && System.currentTimeMillis() - startTime > 10000) {
                            emoji.add(TLE);
                            System.out.println("算太久了！");
                        } else
                            emoji.add(Wrong);
                    }
                    System.out.println();
                }
            } else if (speed.equals("2") || speed.equalsIgnoreCase("fast")) {
                for (int travel_cnt = 0; travel_cnt < list.size(); ++travel_cnt) {
                    System.out.printf("%d x %d = ", list.get(travel_cnt), list.get(travel_cnt));
                    long startTime = System.currentTimeMillis();
                    int usrInput = sc.nextInt();
                    if (usrInput == ans.get(travel_cnt) && System.currentTimeMillis() - startTime < 3000) {
                        correct_cnt++;
                        emoji.add(Check);
                    } else {
                        incorrect_cnt++;
                        if (usrInput == ans.get(travel_cnt) && System.currentTimeMillis() - startTime > 3000) {
                            emoji.add(TLE);
                            System.out.println("算太久了！");
                        } else
                            emoji.add(Wrong);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Speed Error");
                break;
            }
            Total_grade(correct_cnt, incorrect_cnt, emoji);
            Sleep(3000);
            System.out.print("Play Again ? (yes or no)\n>> ");
            String checkAgain = sc.next();
            again = checkAgain.equalsIgnoreCase("yes") ? true : false;
        }
    }
}
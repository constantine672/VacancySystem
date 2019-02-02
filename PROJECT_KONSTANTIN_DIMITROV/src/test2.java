import java.util.Scanner;
import java.io.*;

import static java.lang.System.out;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int select;
        do {
            out.println("1. Заяви отпуска.");
            out.println("2. Виж всички отпуски");
            out.println("3. Виж отпуска за служител.");
            out.println("4. Промени статус на отпуска.");
            out.println("5. Изход.");
            select = in.nextInt();
            if (select == 1) {
                declareVacancy();
            }
            if (select == 2) {
                print();
            }
            if (select == 3) {
                printWorkerVacancy();
            }
            if (select == 4) {
                changeStatus();
            }
        } while (select != 5);
    }


    public static void declareVacancy() {

        Scanner in = new Scanner(System.in);
        out.println("Въведи Име");
        String name = in.nextLine();

        out.println("Въведи e-mail");
        String email = in.nextLine();

        out.println("Въведи егн");
        int egn = in.nextInt();
        

        out.println("Въведи начална дата");
        int startDate = in.nextInt();

        out.println("Въведи крайна дата");
        int endDate = in.nextInt();

        try {
            String msg = " " + name + ", " + email + ", " + egn + ", " + startDate + ", " + endDate + ", Decline,\n";
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("Vacancy.txt", true));
            out.write(msg);
            out.close();
        } catch (IOException e) {
            out.println("Грешка при запаметяването");
        }
    }

    public static void print() {
        try {
            FileReader fr = new FileReader("Vacancy.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                out.println(str + "\n");
            }
            br.close();
        } catch (IOException e) {
            out.println("Файлът не беше открит");
        }
    }

    public static void printWorkerVacancy() {
        Scanner in = new Scanner(System.in);
        out.println("Въведи име :");
        String name = in.nextLine();
        try {
            FileReader fr = new FileReader("Vacancy.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {

                String array[] = str.split(", ");
                if (name.equals(array[0]))
                    out.println(str);
            }
            br.close();
        } catch (IOException e) {
            out.println("Файлът не беше открит");
        }
    }

    public static void changeStatus() {
        Scanner in = new Scanner(System.in);
        out.println("Въведи име :");
        String name = in.nextLine();
        try {
            FileReader fr = new FileReader("Vacancy.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                String array[] = str.split(", ");
                if (name.equals(array[0])) {
                    out.println(str);
                    out.println("Ще смениш ли статуса на отпуската си?: ");
                    String change = in.nextLine();
                    if (change.equals("yes")) {
                        System.out.println(array[5]);
                        array[5] = "Approved";
                    }

                }

            }
            br.close();
        } catch (IOException e) {
            out.println("Файлът не беше открит");
        }
    }
}


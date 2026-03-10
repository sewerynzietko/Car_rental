import java.util.Scanner;

public class UI {
    public UI () {}

    boolean functions(){
        Scanner sc = new Scanner(System.in);

        System.out.print("=== CAR RENTAL ===");
        System.out.print(" ");
        System.out.print("1 - ");
        int i = sc.nextInt();
        switch (i){
            case 1:

            case 2:

            case 3:

            case 4:
                System.out.println("Program ended.");
                return true;
        }
        return false;
    }
}

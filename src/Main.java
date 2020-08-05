import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static String[] words = {"oriented", "daily", "goal", "today", "antelope", "screwdriver", "improve", "water", "yesterdays", "goals"};

    public static void main(String[] args) throws InterruptedException{

        System.out.println("3");
        //This allows a one second waiting period before it prints next line
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        Random rand = new Random();
        //Prints a random element from the "words" array. Also "print" instead of "println" to allow it to print on the same line
        for(int i = 0; i <10; i++){
            System.out.print(words[rand.nextInt(9)] + " ");
        }
        System.out.println();
        //Using IRL nanoseconds of the day to allow us to see how long it takes the user to finish the typing test
        double startTime = LocalTime.now().toNanoOfDay();

        Scanner kb = new Scanner(System.in);
        String typedWords = kb.nextLine();

        double endTime = LocalTime.now().toNanoOfDay();
        double elapsedTime = endTime - startTime;
        double seconds = elapsedTime / 1000000000.0;
        System.out.println(seconds);
        int numChars = typedWords.length();
        // The Forumla for the WPM is (x characters / 5) / 1min = y WPM
        int wpm = (int) ((((double)numChars / 5) / seconds) * 60);

        System.out.println("Your WPM is " + wpm +"!");


    }
}

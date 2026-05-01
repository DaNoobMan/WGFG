import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        double numbersHigher;
        double numbersLower;
        double lowerWeight;
        double higherWeight;
        ArrayList<Integer> startingArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
        int rolledNumber = -1;
        String luckyGuess;
        int randomInt;

        while (startingArray.size() > 1) {
            while (!startingArray.contains(rolledNumber)) {
                System.out.print("Rolled #: ");
                rolledNumber = scanner.nextInt();
            }
            System.out.println(rolledNumber);
            startingArray.remove(startingArray.indexOf(rolledNumber));
        
            numbersHigher = 0;
            numbersLower = 0;
            for (int i:startingArray) {
                if (i > rolledNumber) {
                    numbersHigher++;
                } else {
                    numbersLower++;
                }
            }
            
            higherWeight = numbersHigher/startingArray.size();
            lowerWeight = numbersLower/startingArray.size();

            System.out.println(higherWeight);
            System.out.println(lowerWeight);

            if (higherWeight > lowerWeight) {
                System.out.println("It is most likely to be higher!");
            } else if (lowerWeight > higherWeight) {
                System.out.println("It is most likely to be lower!");
            } else {
                randomInt = rand.nextInt(2);
                if (randomInt == 0) {
                    luckyGuess = "lower?";
                } else {
                    luckyGuess = "higher?";
                }
                System.out.println("It's a fifty... I guess " + luckyGuess);
            }
        }
        
        System.out.println("Alright, it's a 50/50 chance! Good luck!");
    }
}
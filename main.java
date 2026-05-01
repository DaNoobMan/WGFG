import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

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

            double randomDouble = rand.nextDouble();
            if (Math.abs(randomDouble - lowerWeight) < Math.abs(randomDouble - higherWeight)) {
                System.out.println("Guess lower!");
            } else if (Math.abs(randomDouble - higherWeight) < Math.abs(randomDouble - lowerWeight)) {
                System.out.println("Guess higher!");
            } else {
                randomInt = rand.nextInt(2);
                if (randomInt == 0) {
                    System.out.println("Guess lower!");
                } else {
                    System.out.println("Guess higher!");
                }
            }
        }
        
        System.out.println("Alright, it's a 50/50 chance! Good luck!");
    }
}
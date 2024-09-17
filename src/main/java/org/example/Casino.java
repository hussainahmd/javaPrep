package org.example;

import java.security.SecureRandom;

public class Casino {
    // create secure random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();

    // enum type with constants that represent the game status
    private enum Status {CONTINUE, WON, LOST}

    ;

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    private static int gamblerFRW = 0;
    private static int casinoFRW = 0;
    private static int moneyG = 0; //money won by gambler
    private static int moneyC = 0; //money won by casino
    private static int winsG = 0; //number of wins of gambler
    private static int winsC = 0; //number of wins of casino

    // plays one game of craps
    public static void main(String[] args) {
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST

        for (int i = 1; i <= 9_000; i++) {
            int sumOfDice = rollDice(); // first roll of the dice
            int money = bet();

            // determine game status and point based on first roll
            switch (sumOfDice) {
                case SEVEN: // win with 7 on first roll
                case YO_LEVEN: // win with 11 on first roll
                    gameStatus = Status.WON;
                    gamblerFRW++;
                    moneyG += money;
                    moneyC -= money;
                    break;
                case SNAKE_EYES: // lose with 2 on first roll
                case TREY: // lose with 3 on first roll
                case BOX_CARS: // lose with 12 on first roll
                    gameStatus = Status.LOST;
                    casinoFRW++;
                    moneyG -= money;
                    moneyC += money;
                    break;
                default: // did not win or lose, so remember point
                    gameStatus = Status.CONTINUE; // game is not over
                    myPoint = sumOfDice; // remember the point
                    break;
            }

            // while game is not complete
            while (gameStatus == Status.CONTINUE) { // not WON or LOST
                sumOfDice = rollDice(); // roll dice again

                // determine game status
                if (sumOfDice == myPoint) { // win by making point
                    gameStatus = Status.WON;
                    moneyG += money;
                    moneyC -= money;
                } else {
                    if (sumOfDice == SEVEN) { // lose by rolling 7 before point
                        gameStatus = Status.LOST;
                        moneyG -= money;
                        moneyC += money;
                    }
                }
            }

            // display won or lost message
            if (gameStatus == Status.WON) {
                //System.out.println("Player wins");
                winsG++;

            } else {
                //System.out.println("Player loses");
                winsC++;
            }
        }
        System.out.printf("%n1)Gambler wins %d times, org.example.Casino wins %d times%n", winsG, winsC);
        System.out.printf("2)First roll wins for gambler : %,d%n", gamblerFRW);
        System.out.printf("3)First roll wins for casino : %,d%n", casinoFRW);
        System.out.printf("4)Gambler has Rs %,d%n", moneyG);
        System.out.printf("5)org.example.Casino has Rs %,d%n%n", moneyC);
    }

    // roll dice, calculate sum and display results
    public static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll

        int sum = die1 + die2; // sum of die values

        return sum;
    }

    public static int bet() {
        //pick random bet money
        int money = 50 + randomNumbers.nextInt(51);

        return money;
    }
}

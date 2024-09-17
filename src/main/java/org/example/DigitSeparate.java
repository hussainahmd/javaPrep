package org.example;

//separate an integer with x number of digits

import java.util.Scanner;

public class DigitSeparate {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter an integer: ");
        int num = input.nextInt();
        int dupNum = num; //duplicate num
        int count = 0;

        //counting the number of digits in the integer
        do {
            dupNum /= 10;
            count++;

        } while (dupNum > 0);

        //creating an array of size equal to count
        int[] arr = new int[count];

		/* separting the right most digit and storing it in the
		array(descending order of index) respectively "used this
		method to print the number in the correct order later on" */
        int i = count;
        while (num > 0) {
            arr[i - 1] = num % 10;
            num /= 10;
            i--;
        }

        //printing the array
        for (int x = 0; x < count; x++) {
            System.out.print(arr[x] + "   ");
        }
    }
}
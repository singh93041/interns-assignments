package org.fi;

import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target element: ");
        int target = scanner.nextInt();
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Element " + target + " is found at index " + index + ".");
        } else {
            System.out.println("Element " + target + " is not in the array.");
        }
        scanner.close();
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2, midValue = array[mid];
            if (midValue == target) return mid;
            else if (midValue < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}


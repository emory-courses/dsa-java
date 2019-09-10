package edu.emory.cs.utils;

import java.util.Random;

public class Utils {
    static public int getMiddleIndex(int beginIndex, int endIndex) {
        return beginIndex + (endIndex - beginIndex) / 2;
    }

    static public int[] getRandomIntArray(Random rand, int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt();

        return array;
    }

    static public double log2(int i) {
        return Math.log(i) / Math.log(2);
    }

    static public void main(String[] args) {
        System.out.println(getMiddleIndex(0, 10));
    }
}

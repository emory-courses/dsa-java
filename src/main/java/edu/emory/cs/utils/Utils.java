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

    static public Integer[] getRandomIntegerArray(Random rand, int size) {
        return getRandomIntegerArray(rand, size, Integer.MAX_VALUE);
    }

    static public Integer[] getRandomIntegerArray(Random rand, int size, int range) {
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt(range);

        return array;
    }

    static public void main(String[] args) {
        System.out.println(getMiddleIndex(0, 10));
    }
}

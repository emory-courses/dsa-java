package edu.emory.cs.utils;

public class Utils {
    static public int getMiddleIndex(int beginIndex, int endIndex) {
        return beginIndex + (endIndex - beginIndex) / 2;
    }

    static public void main(String[] args) {
        System.out.println(getMiddleIndex(0, 10));
    }
}

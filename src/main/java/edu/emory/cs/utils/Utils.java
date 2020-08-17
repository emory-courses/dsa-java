/*
 * Copyright 2020 Emory University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

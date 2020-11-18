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
package edu.emory.cs.dynamic.fibonacci;

import java.util.Arrays;

/** @author Jinho D. Choi */
public class FibonacciDynamic implements Fibonacci {
    @Override
    public int get(int k) {
        return getAux(k, createTable(k));
    }

    /**
     * @param k size of dynamic table
     * @return dynamic table
     */
    private int[] createTable(int k) {
        int[] table = new int[k + 1];
        table[0] = 0;
        table[1] = 1;
        Arrays.fill(table, 2, k + 1, -1);
        return table;
    }

    private int getAux(int k, int[] table) {
        if (table[k] >= 0) return table[k];
        return table[k] = getAux(k - 1, table) + getAux(k - 2, table);
    }
}

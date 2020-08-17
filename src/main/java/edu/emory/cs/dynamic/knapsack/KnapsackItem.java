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
package edu.emory.cs.dynamic.knapsack;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class KnapsackItem implements Comparable<KnapsackItem> {
    private int i_weight;
    private int i_value;

    public KnapsackItem(int weight, int value) {
        set(weight, value);
    }

    public void set(int weight, int value) {
        i_weight = weight;
        i_value = value;
    }

    public int getWeight() {
        return i_weight;
    }

    public int getValue() {
        return i_value;
    }

    @Override
    public int compareTo(KnapsackItem o) {
        return i_weight - o.i_weight;
    }
}

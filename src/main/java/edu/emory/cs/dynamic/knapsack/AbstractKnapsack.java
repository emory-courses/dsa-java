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

import java.util.Collection;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractKnapsack {
    /**
     * @param items     items to be entered into the knapsack.
     * @param maxWeight the maximum weight that the knapsack can hold.
     * @return a list of items maximizing the total value given {@code items} and {@code maxWeight}.
     */
    public abstract List<KnapsackItem> solve(KnapsackItem[] items, int maxWeight);

    /**
     * @return the total value of the specific items.
     */
    protected int getTotalValue(Collection<KnapsackItem> items) {
        int total = 0;

        for (KnapsackItem item : items)
            total += item.getValue();

        return total;
    }
}

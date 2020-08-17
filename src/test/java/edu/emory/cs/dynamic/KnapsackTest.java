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
package edu.emory.cs.dynamic;

import edu.emory.cs.dynamic.coin.*;
import edu.emory.cs.dynamic.knapsack.AbstractKnapsack;
import edu.emory.cs.dynamic.knapsack.DKnapsack;
import edu.emory.cs.dynamic.knapsack.KnapsackItem;
import edu.emory.cs.dynamic.knapsack.RKnapsack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class KnapsackTest {
    @Test
    public void test() {
        KnapsackItem[] items = createKnapsackItems();
        AbstractKnapsack recursive = new RKnapsack();
        AbstractKnapsack dynamic = new DKnapsack();

        for (int weight = 10; weight <= 100; weight += 10)
            assertEquals(recursive.solve(items, weight), dynamic.solve(items, weight));
    }

    private KnapsackItem[] createKnapsackItems() {
        KnapsackItem[] items = new KnapsackItem[20];

        items[0] = new Dollar();
        items[1] = new Dollar();
        items[2] = new Half();
        items[3] = new Half();
        items[4] = new Quarter();
        items[5] = new Quarter();
        items[6] = new Quarter();
        items[7] = new Quarter();
        items[8] = new Quarter();
        items[9] = new Quarter();
        items[10] = new Dime();
        items[11] = new Dime();
        items[12] = new Dime();
        items[13] = new Dime();
        items[14] = new Nickel();
        items[15] = new Nickel();
        items[16] = new Nickel();
        items[17] = new Cent();
        items[18] = new Cent();
        items[19] = new Cent();

        return items;
    }
}

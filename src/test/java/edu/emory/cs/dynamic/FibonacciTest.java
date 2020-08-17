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

import edu.emory.cs.dynamic.fibonacci.AbstractFibonacci;
import edu.emory.cs.dynamic.fibonacci.DFibonacci;
import edu.emory.cs.dynamic.fibonacci.LFibonacci;
import edu.emory.cs.dynamic.fibonacci.RFibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class FibonacciTest {
    @Test
    public void compare() {
        AbstractFibonacci recursive = new RFibonacci();
        AbstractFibonacci loop = new LFibonacci();
        AbstractFibonacci dynamic = new DFibonacci();

        for (int k = 0; k < 20; k++)
            assertEquals(recursive.get(k), loop.get(k), dynamic.get(k));
    }
}

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

import edu.emory.cs.dynamic.fibonacci.Fibonacci;
import edu.emory.cs.dynamic.fibonacci.FibonacciDynamic;
import edu.emory.cs.dynamic.fibonacci.FibonacciIterative;
import edu.emory.cs.dynamic.fibonacci.FibonacciRecursive;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class FibonacciTest {
    @Test
    public void compare() {
        Fibonacci recursive = new FibonacciRecursive();
        Fibonacci iterative = new FibonacciIterative();
        Fibonacci dynamic = new FibonacciDynamic();

        for (int k = 0; k < 20; k++)
            assertEquals(recursive.get(k), iterative.get(k), dynamic.get(k));
    }
}

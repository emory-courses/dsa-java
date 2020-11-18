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

/** @author Jinho D. Choi */
public class FibonacciIterative implements Fibonacci {
    @Override
    public int get(int k) {
        if (k < 2) return k;
        int f0 = 0, f1 = 1, f2;

        for (int i = 2; i < k; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        return f0 + f1;
    }
}

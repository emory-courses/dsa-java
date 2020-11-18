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
public class FibonacciRecursive implements Fibonacci {
    @Override
    public int get(int k) {
        return switch (k) {
            case 0 -> 0;
            case 1 -> 1;
            default -> get(k - 1) + get(k - 2);
        };
    }
}

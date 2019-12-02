/*
 * Copyright 2014, Emory University
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

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractFibonacci {
    /**
     * @return the k'th Fibonacci number.
     * @throws IllegalArgumentException if {@code k < 0}.
     */
    public int get(int k) {
        if (k < 0) throw new IllegalArgumentException("Invalid: " + k);

        switch (k) {
            //Base cases of Fibonacci sequence
            case 0:
                return 0;
            case 1:
                return 1;

            default:
                return get2p(k);
        }
    }

    /**
     * @param k must be greater than 1.
     * @return the k'th Fibonacci number.
     */
    protected abstract int get2p(int k);
}

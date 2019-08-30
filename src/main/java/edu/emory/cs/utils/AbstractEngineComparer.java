/**
 * Copyright 2014, Emory University
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.cs.utils;

import java.util.Random;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractEngineComparer<EngineType> {
    @SuppressWarnings("unchecked")
    public long[][] printTotal(final int ITERATIONS, final int INIT_SIZE, final int MAX_SIZE, final int INCREMENT, final int OPS, final Random RAND, EngineType... engines) {
        long[][] times = new long[engines.length][OPS];
        StringBuilder build = new StringBuilder();
        int i, j, size;

        for (size = INIT_SIZE; size <= MAX_SIZE; size += INCREMENT) {
            for (i = 0; i < ITERATIONS; i++)
                add(RAND, size, times, engines);

            build.append(size);

            for (j = 0; j < OPS; j++) {
                for (i = 0; i < engines.length; i++) {
                    build.append("\t");
                    build.append(times[i][j]);
                }
            }

            build.append("\n");
        }

        System.out.println(build.toString());
        return times;
    }

    @SuppressWarnings("unchecked")
    public abstract void add(final Random RAND, final int SIZE, long[][] times, EngineType... engines);
}
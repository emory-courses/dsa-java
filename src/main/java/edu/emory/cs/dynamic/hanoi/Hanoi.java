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
package edu.emory.cs.dynamic.hanoi;

import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class Hanoi {
    /**
     * @param n            the total number of rings.
     * @param source       the source tower.
     * @param intermediate the intermediate tower.
     * @param destination  the destination tower.
     * @return a list of steps to move all rings in the source tower to the destination tower.
     */
    public abstract List<String> solve(int n, char source, char intermediate, char destination);

    protected String getKey(int n, char source, char destination) {
        return n + ":" + source + "->" + destination;
    }
}

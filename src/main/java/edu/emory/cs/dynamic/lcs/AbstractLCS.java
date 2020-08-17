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
package edu.emory.cs.dynamic.lcs;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractLCS {
    /**
     * @param a the first string.
     * @param b the second string.
     * @return a longest common sequence of the specific strings {@code a} and {@code b}.
     */
    public String solve(String a, String b) {
        return solve(a.toCharArray(), b.toCharArray(), a.length() - 1, b.length() - 1);
    }

    /**
     * @param c the first array of characters.
     * @param d the second array of characters.
     * @param i the index of {@code c} to be compared.
     * @param j the index of {@code d} to be compared
     * @return a longest common sequence of the specific strings {@code c} and {@code d}.
     */
    protected abstract String solve(char[] c, char[] d, int i, int j);
}


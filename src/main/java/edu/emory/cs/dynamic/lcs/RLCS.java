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
package edu.emory.cs.dynamic.lcs;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class RLCS extends AbstractLCS {
    @Override
    protected String solve(char[] c, char[] d, int i, int j) {
        if (i < 0 || j < 0)
            return "";

        if (c[i] == d[j])
            return solve(c, d, i - 1, j - 1) + c[i];

        //Get the lcs through searching from the right of string c
        String c1 = solve(c, d, i - 1, j);
        //Get the lcs through searching from the right of string d
        String d1 = solve(c, d, i, j - 1);

        return (c1.length() > d1.length()) ? c1 : d1;
    }
}

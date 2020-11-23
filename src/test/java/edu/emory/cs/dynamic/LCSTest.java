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

import edu.emory.cs.dynamic.lcs.LCS;
import edu.emory.cs.dynamic.lcs.LCSDynamic;
import edu.emory.cs.dynamic.lcs.LCSRecursive;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class LCSTest {
    @Test
    public void compare() {
        LCS r = new LCSRecursive();
        LCS d = new LCSDynamic();

        String a = "ACGTCGTGT";
        String b = "CTAGTGGAG";

        assertEquals(r.solve(a, b), d.solve(a, b));

        a = "GAATGTCCTTTCTCTAAGTCCTAAG";
        b = "GGAGACTTACAGGAAAGAGATTCAGGATTCAGGAGGCCTACCATGAAGATCAAG";
    }
}

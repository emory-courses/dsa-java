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

import java.util.ArrayList;
import java.util.List;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HanoiRecursive extends Hanoi {
    @Override
    public List<String> solve(int n, char source, char intermediate, char destination) {
        List<String> list = new ArrayList<>();
        solve(list, n, source, intermediate, destination);
        return list;
    }

    private void solve(List<String> list, int n, char source, char intermediate, char destination) {
        if (n == 0) return;

        //Move all plates from 'source' to 'intermediate' via 'destination' as medium
        solve(list, n - 1, source, destination, intermediate);

        //Record the step
        list.add(getKey(n, source, destination));

        //Move all plates from 'intermediate' to 'destination' via 'source' as medium
        solve(list, n - 1, intermediate, source, destination);
    }
}

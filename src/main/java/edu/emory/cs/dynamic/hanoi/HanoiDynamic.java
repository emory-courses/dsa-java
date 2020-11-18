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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HanoiDynamic extends Hanoi {
    @Override
    public List<String> solve(int n, char source, char intermediate, char destination) {
        List<String> list = new ArrayList<>();
        solve(list, n, source, intermediate, destination, new HashMap<>());
        return list;
    }

    private void solve(List<String> list, int n, char source, char intermediate, char destination, Map<String, int[]> map) {
        if (n == 0) return;
        int fromIndex = list.size();

        //Get previous steps to move current plate to designate destination
        int[] sub = map.get(getKey(n - 1, source, intermediate));

        //If previous steps exist, add the steps to the step list
        if (sub != null) addAll(list, sub[0], sub[1]);
            //Move all plates from 'source' to 'intermediate' via 'destination' as medium
        else solve(list, n - 1, source, destination, intermediate, map);

        //Record the step
        String key = getKey(n, source, destination);
        list.add(key);

        //Get previous steps to move current plate to designate destination
        sub = map.get(getKey(n - 1, intermediate, destination));

        //If previous steps exist, add the steps to the step list
        if (sub != null) addAll(list, sub[0], sub[1]);
            //Move all plates from 'intermediate' to 'destination' via 'source' as medium
        else solve(list, n - 1, intermediate, source, destination, map);

        //If steps do not exist, add them to the dynamic list
        if (!map.containsKey(key))
            map.put(key, new int[]{fromIndex, list.size()});
    }

    private void addAll(List<String> list, int fromIndex, int toIndex) {
        for (int i = fromIndex; i < toIndex; i++)
            list.add(list.get(i));
    }
}

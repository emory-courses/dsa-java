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
package edu.emory.cs.sort.distribution;

import java.util.Comparator;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class LSDRadixSort extends RadixSort {
    public LSDRadixSort() {
        this(Comparator.naturalOrder());
    }

    public LSDRadixSort(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    public void sort(Integer[] array, int beginIndex, int endIndex) {
        int maxBit = getMaxBit(array, beginIndex, endIndex);

        for (int bit = 0; bit < maxBit; bit++)
            sort(array, beginIndex, endIndex, bit);
    }

    private void sort(Integer[] array, int beginIndex, int endIndex, int bit) {
        int div = (int) Math.pow(10, bit), idx;

        for (int i = beginIndex; i < endIndex; i++)
            buckets.get(getBucketIndex(array[i], div)).add(array[i]);

        for (List<Integer> bucket : buckets) {
            idx = beginIndex = beginIndex + bucket.size();
            while (bucket.size() > 0) array[--idx] = bucket.remove(bucket.size() - 1);
        }
    }
}

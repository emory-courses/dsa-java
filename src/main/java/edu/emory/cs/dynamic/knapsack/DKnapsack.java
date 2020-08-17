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
package edu.emory.cs.dynamic.knapsack;

import java.util.*;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class DKnapsack extends AbstractKnapsack
{
	@Override
	public List<KnapsackItem> solve(KnapsackItem[] items, int maxWeight)
	{
		Arrays.sort(items);
		return solve(items, maxWeight, items.length-1, new HashMap<>());
	}
	
	/** @param items sorted by their weights in ascending order. */
	private List<KnapsackItem> solve(KnapsackItem[] items, int maxWeight, int index, Map<String,List<KnapsackItem>> map)
	{
		if (index < 0 || maxWeight == 0) return new ArrayList<>();
		KnapsackItem item = items[index];
		
		if (item.getWeight() > maxWeight)
			return solveAux(items, maxWeight, index-1, map);
		else
		{
			List<KnapsackItem> with    = solveAux(items, maxWeight - item.getWeight(), index-1, map);
			List<KnapsackItem> without = solveAux(items, maxWeight, index-1, map);
			with.add(item);
			return (getTotalValue(with) > getTotalValue(without)) ? with : without;
		}
	}
	
	private List<KnapsackItem> solveAux(KnapsackItem[] items, int maxWeight, int index, Map<String,List<KnapsackItem>> map)
	{
		String key = maxWeight+" "+index;
		List<KnapsackItem> list = map.get(key);
		
		if (list == null)
		{
			list = solve(items, maxWeight, index, map);
			map.put(key, list);
		}
		
		return new ArrayList<>(list);
	}
}

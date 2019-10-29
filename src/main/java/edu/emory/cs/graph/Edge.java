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
package edu.emory.cs.graph;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Edge implements Comparable<Edge> {
    private int source;
    private int target;
    private double weight;

    public Edge(int source, int target, double weight) {
        init(source, target, weight);
    }

    public Edge(Edge edge) {
        init(edge.getSource(), edge.getTarget(), edge.getWeight());
    }

    private void init(int source, int target, double weight) {
        setSource(source);
        setTarget(target);
        setWeight(weight);
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    public void setSource(int vertex) {
        source = vertex;
    }

    public void setTarget(int vertex) {
        target = vertex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addWeight(double weight) {
        weight += weight;
    }

    @Override
    public int compareTo(Edge edge) {
        double diff = weight - edge.weight;
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 0;
    }

    public String toString() {
        return String.format("%d <- %d : %f", getTarget(), getSource(), getWeight());
    }
}

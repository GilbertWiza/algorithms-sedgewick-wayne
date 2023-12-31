package chapter4.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Rene Argento on 01/10/17.
 */
// Thanks to SSoelvsten (https://github.com/SSoelvsten) for suggesting a fix to the runtime complexity
// of countParallelEdges().
// https://github.com/reneargento/algorithms-sedgewick-wayne/issues/278
public class Exercise32_ParallelEdgeDetection {

    private int countParallelEdges(Graph graph) {
        int parallelEdges = 0;
        int currentIteration = 1;
        int[] neighbors = new int[graph.vertices()];

        for (int vertex = 0; vertex < graph.vertices(); vertex++) {
            for (int neighbor : graph.adjacent(vertex)) {
                if (neighbors[neighbor] != currentIteration) {
                    neighbors[neighbor] = currentIteration;
                } else {
                    parallelEdges++;
                }
            }
            currentIteration++;
        }
        return parallelEdges / 2;
    }

    public static void main(String[] args) {
        Exercise32_ParallelEdgeDetection exercise32 = new Exercise32_ParallelEdgeDetection();

        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 0);
        StdOut.println("Parallel edges: " + exercise32.countParallelEdges(graph1) + " Expected: 0");

        Graph graph2 = new Graph(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 0);
        graph2.addEdge(3, 2);
        StdOut.println("Parallel edges: " + exercise32.countParallelEdges(graph2) + " Expected: 1");

        Graph graph3 = new Graph(4);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 0);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 2);
        graph3.addEdge(3, 2);
        graph3.addEdge(3, 0);
        StdOut.println("Parallel edges: " + exercise32.countParallelEdges(graph3) + " Expected: 3");
    }
}

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testingGraph {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        System.out.println(graph.vertices().size());
        Vertex vertex1 = graph.insertVertex(1);
        System.out.println(graph.vertices().size());
        Vertex vertex2 = graph.insertVertex(1);
        Vertex vertex3 = graph.insertVertex(1);
        Vertex vertex4 = graph.insertVertex(1);
        System.out.println(graph.vertices().size());
        System.out.println("##################");
        System.out.println(vertex1.getPosition() + " " + vertex2.getPosition() + " " + vertex3.getPosition() + " " + vertex4.getPosition());
        for (Vertex v : graph.vertices()) {
            System.out.println(graph.vertices().indexOf(v));
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class Edge {
    private Vertex v;
    private Vertex w;
    private int position;
    boolean directed = false;

    Edge(Vertex v, Vertex w, int position) {
        this.v = v;
        this.w = w;
        this.position = position;
    }

    ArrayList<Vertex> getEndVertices() {return new ArrayList<Vertex>(Arrays.asList(this.v, this.w));}

    Vertex getOppositeVertex(Vertex v){
        if (v.equals(this.v)) return this.w;
        return this.v;
    }

    boolean getDirection(){return this.directed;}

    int getPosition(){return this.position;}

    void setUndirected(){this.directed = false;}

    void setDirected(){this.directed = true;}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    Map<Vertex, ArrayList<Edge>> adjacencyList = new HashMap<Vertex, ArrayList<Edge>>();
    
    int numVertices(){return adjacencyList.size();}

    int numEdges(){
        float count = 0;
        for (Vertex v: adjacencyList.keySet()){
            for (Edge e: adjacencyList.get(v)){
                if (e.getDirection() == false) count += 0.5f;
                else count++;
            }
        }
        return Math.round(count);
    }

    Set<Vertex> vertices(){
        Set<Vertex> vertices = new HashSet<Vertex>();
        for (Vertex v: adjacencyList.keySet()){
            vertices.add(v);
        }
        return vertices;
    }

    Set<Edge> edges(){
        Set<Edge> edges = new HashSet<Edge>();
        for (Vertex v: adjacencyList.keySet()){
            for (Edge e: adjacencyList.get(v)){
                edges.add(e);
            }
        }
        return edges;
    }

    Vertex aVertex(){
        if (!adjacencyList.keySet().isEmpty()){return null;}
        return adjacencyList.keySet().iterator().next();
    }

    int degree(Vertex v){return v.getDegree();}

    ArrayList<Vertex> adjacentVertices(Vertex v){
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        ArrayList<Vertex> tempList = new ArrayList<Vertex>();
        Vertex tempVertex;
        for (Edge e: adjacencyList.get(v)){
            tempList = e.getEndVertices();
            tempVertex = tempList.get(0);
            if (tempVertex != v)vertices.add(tempVertex);
            else vertices.add(tempList.get(1));
        }
        return vertices;
    }

    ArrayList<Edge> incidentEdges(Vertex v){return adjacencyList.get(v);}

    ArrayList<Vertex> endVertices(Edge e){return e.getEndVertices();}

    Vertex opposite(Vertex v, Edge e){return e.getOppositeVertex(v);}

    boolean areAdjacent(Vertex v1, Vertex v2){
        for (Edge e: adjacencyList.get(v1)){
            if (e.getEndVertices().contains(v1) && e.getEndVertices().contains(v2)){
                return true;
            }
        }
        return false;
    }

    Set<Edge> unDirectedEdges(){
        Set<Edge> edges = new HashSet<Edge>();
        for (Vertex v: adjacencyList.keySet()){
            for (Edge e: adjacencyList.get(v)){
                if (e.getDirection() == false) edges.add(e);
            }
        }
        return edges;
    }

    Vertex destination(Edge e){
        if (e.getDirection() == false) return null;
        return e.getEndVertices().get(1);
    }

    Vertex origin(Edge e){
        if (e.getDirection() == false) return null;
        return e.getEndVertices().get(0);
    }

    boolean isDirected(Edge e){return e.getDirection();}

    int inDegree(Vertex v){return v.getInDegree();}

    int outDegree(Vertex v){return v.getOutDegree();}

    ArrayList<Edge> inIncidentEdges(Vertex v){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (Edge e: adjacencyList.get(v)){
            if (e.getDirection() == true && e.getEndVertices().get(1).equals(v)){
                edges.add(e);
            }
        }
        return edges;
    }

    ArrayList<Edge> outIncidentEdges(Vertex v){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (Edge e: adjacencyList.get(v)){
            if (e.getDirection() == true && e.getEndVertices().get(0).equals(v)){
                edges.add(e);
            }
        }
        return edges;
    }

    ArrayList<Vertex> inAdjacentVertices(Vertex v){
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for (Edge e: adjacencyList.get(v)){
            if (e.getDirection() == true){
                vertices.add(e.getEndVertices().get(0));
            }
        }
        return vertices;
    }

    ArrayList<Vertex> outAdjacentVertices(Vertex v){
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        for (Edge e: adjacencyList.get(v)){
            if (e.getDirection() == true){
                vertices.add(e.getEndVertices().get(1));
            }
        }
        return vertices;
    }

    Edge insertEdge(Vertex v, Vertex w, int position){
        Edge e = new Edge(v, w, position);
        if(!adjacencyList.containsKey(v)) insertVertex(v.getPosition());
        if (!adjacencyList.containsKey(w)) insertVertex(w.getPosition());
        adjacencyList.get(v).add(position, e);
        adjacencyList.get(w).add(position, e);
        return e;
    }

    Edge insertDirectedEdge(Vertex v, Vertex w, int position){
        Edge e = insertEdge(v, w, position);
        e.setDirected();
        return e;
    }

    Vertex insertVertex(int position){
        Vertex v = new Vertex(position);
        adjacencyList.put(v, new ArrayList<Edge>());
        return v;
    }

    void removeEdge(Edge e){
        adjacencyList.get(e.getEndVertices().get(0)).remove(e);
        adjacencyList.get(e.getEndVertices().get(1)).remove(e);
        e = null;
    }

    void makeUndirected(Edge e){e.setUndirected();}

    void reverseDirection(Edge e){
        if (e.getDirection() == false) e.setDirected();
        e = new Edge(e.getEndVertices().get(1), e.getEndVertices().get(0), e.getPosition());
    }

    void setDirectionFrom(Edge e, Vertex v){
        if (e.getDirection() == false) return;
        e = new Edge(v,e.getEndVertices().get(1),e.getPosition());
    }

    void setDirectionTo(Edge e, Vertex v){
        if (e.getDirection() == false) return;
        e = new Edge(e.getEndVertices().get(0),v,e.getPosition());
    }
}
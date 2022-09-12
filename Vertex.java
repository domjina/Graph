public class Vertex {
    private int incomingDirectedEdges;
    private int incidentUndirectedEdges;
    private int outgoingDirectedEdges;
    private int position;

    Vertex(int position){this.position = position;}

    public int getDegree(){return this.incomingDirectedEdges + this.incidentUndirectedEdges + this.outgoingDirectedEdges;}

    public int getInDegree(){return incomingDirectedEdges;}

    public int getOutDegree(){return outgoingDirectedEdges;}

    public int getPosition(){return this.position;}
}

/******************************************************************************
 *  Compilation:  javac Graph.java
 *  Execution:    java Graph < input.txt
 *  Dependencies: ST.java SET.java In.java StdOut.java
 *  Data files:   https://introcs.cs.princeton.edu/java/45graph/tinyGraph.txt
 *
 *  Undirected graph data type implemented using a symbol table
 *  whose keys are vertices (String) and whose values are sets
 *  of neighbors (SET of Strings).
 *
 *  Remarks
 *  -------
 *   - Parallel edges are not allowed
 *   - Self-loop are allowed
 *   - Adjacency lists store many different copies of the same
 *     String. You can use less memory by interning the strings.
 *
 *  % java Graph < tinyGraph.txt
 *  A: B C G H
 *  B: A C H
 *  C: A B G
 *  G: A C
 *  H: A B
 *
 *  A: B C G H
 *  B: A C H
 *  C: A B G
 *  G: A C
 *  H: A B
 *
 ******************************************************************************/

/**
 *  The {@code Graph} class represents an undirected graph of vertices
 *  with string names.
 *  It supports the following operations: add an edge, add a vertex,
 *  get all the vertices, iterate over all the neighbors adjacent
 *  to a vertex, is there a vertex, is there an edge between two vertices.
 *  Self-loops are permitted; parallel edges are discarded.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://introcs.cs.princeton.edu/45graph">Section 4.5</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 */
public class SubGraph {

    // symbol table: key = string vertex, value = set of neighboring vertices
    private ST<String, SET<String>> st;

    // number of edges
    private int E;

   /**
     * Initializes an empty graph with no vertices or edges.
     */
    public SubGraph() {
        st = new ST<String, SET<String>>();
    }

   /**
     * Initializes a graph from the specified file, using the specified delimiter.
     *
     * @param filename the name of the file
     * @param delimiter the delimiter
     */
    public SubGraph(String filename, String delimiter) {
        st = new ST<String, SET<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

   /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return st.size();
    }

   /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an exception if v is not a vertex
    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

   /**
     * Returns the degree of vertex v in this graph.
     *
     * @param  v the vertex
     * @return the degree of {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public int degree(String v) {
        validateVertex(v);
        return st.get(v).size();
    }

   /**
     * Adds the edge v-w to this graph (if it is not already an edge).
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

   /**
     * Adds vertex v to this graph (if it is not already a vertex).
     *
     * @param  v the vertex
     */
    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new SET<String>());
    }


   /**
     * Returns the vertices in this graph.
     *
     * @return the set of vertices in this graph
     */
    public Iterable<String> vertices() {
        return st.keys();
    }

   /**
     * Returns the set of vertices adjacent to v in this graph.
     *
     * @param  v the vertex
     * @return the set of vertices adjacent to vertex {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
    }

   /**
     * Returns true if v is a vertex in this graph.
     *
     * @param  v the vertex
     * @return {@code true} if {@code v} is a vertex in this graph,
     *         {@code false} otherwise
     */
    public boolean hasVertex(String v) {
        return st.contains(v);
    }

   /**
     * Returns true if v-w is an edge in this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @return {@code true} if {@code v-w} is a vertex in this graph,
     *         {@code false} otherwise
     * @throws IllegalArgumentException if either {@code v} or {@code w}
     *         is not a vertex in this graph
     */
    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        return st.get(v).contains(w);
    }

   /**
     * Returns a string representation of this graph.
     *
     * @return string representation of this graph
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st) {
            s.append(v + ": ");
            for (String w : st.get(v)) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }

   /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
		//The graph is created.
        SubGraph graph = new SubGraph();
		
		//The in statement will process all values located in the txt file into the graphed array.
		In in = new In(args[0]);
		String[] graphed = in.readAllStrings();
		
		//Creates a second array based on input after the txt file, which will be used for the subgraph.
		String[] sub = new String[args.length-1];
		System.arraycopy(args, 1, sub, 0, args.length-1);
		
		//j acts as a reader for even numbered strings in the graphed array.
		int j = 1;
		//The for loop will process all values associated with the text file into the graph.
		for (int i = 0; i < graphed.length; i=i+2) {
			String v = (graphed[i]);
			String w = (graphed[j]);
			j=j+2;
			graph.addEdge(v, w);
		}


        // print out graph
		StdOut.println("The graph is");
        StdOut.println(graph);

        // print out graph again by iterating over vertices and edges
		StdOut.println("The subgraph is");
        //The first for loop will go through every value for v to find a match for it in args.
		for (String v : graph.vertices()) {
			//With the current value assigned to v, a for loop will process to see if there is a match
			for (int i = 0; i < sub.length; i++) {
				//If a match is found, the statement below will print out.
				if (v.equals(sub[i])) {
					StdOut.print(v + ": ");
					//Once found, a new for loop will generate to find matching values in w based on the args array.
					for (String w : graph.adjacentTo(v)) {
						//All values for w assigned to the current v will process.
						for (int k = 0; k < sub.length; k++) {
							//if the value for w finds a mtch, it will print it out, and break the loop and get a new value for w.
							if (w.equals(sub[k])) {
								StdOut.print(w + " ");
								break;
							}
						}
					}
					//The print line will end once all values for v are located, and will move back into the first for loop.
					StdOut.println();
				}
			}
		}
	}
}
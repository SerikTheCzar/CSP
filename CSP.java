public class CSP {
 
    //number of points
    static int V = 7;
 
    //toString method
    static void printSolution(int[] color)
    {
        System.out.println("test here");
        System.out.println("Found a solution...");
        for (int i = 0; i < V; i++){
            System.out.print("  " + color[i]);
        
        }
        System.out.println("");
    }
    public void breakOut(boolean [][]graph){
        //graph = [][];
        //reset graph 
        //not going to work, because it's recursive, you couldn't persist the state throughout the multiple calls
    }
 //given a color and the graph, check if surrounding space satisfies constraints
    static boolean isSafe(boolean[][] graph, int[] color)
    {
        //check all edges
        for (int i = 0; i < V; i++){
            for (int j = i + 1; j < V; j++) {
                if ((graph[i][j]) && color[j] == color[i]) {
                    //breakOut();
                    //dont' need this, just cut it with a return statement
                    return false;
                }
            }
        }
        return true;
    }
    static void graphColoringHelper(boolean[][]graph, int i) {
        int a = i;
        if(a>0) {
            //break? //base case --> not needed here it turns out
        } else {
            graphColoring(graph, a, i, null); //doesn't work
        } 
        System.out.println("bbroken here");
        graphColoringHelper(graph, i); //this isnt' going to work, no real break case
    } //scratch this

    public int totalMoveCalculator(int n, boolean[][]graph, int m, int[]color ) {
        int counter = 0;
        int b = n;
        for(int a=0;a<b;a++ ) {
            if(!didnotbreak()){
                graphColoring(graph, m, a, color);
                    System.out.println("test graph + " + graph);
                counter++;
            }
        }
//        return counter;

        return counter;
    }
    public boolean didnotbreak(){
        return true;
    }
   //recursive M color Solver
    static boolean graphColoring(boolean[][] graph, int m,
                                 int i, int[] color)
    {
        
        if (i == V) { //base case
 
            // if coloring is safe
            if (isSafe(graph, color)) {
 
                // Print the solution
                printSolution(color);
                return true;
            }
            return false;
        }
 
        // Assign each color from 1 to m
        for (int j = 1; j <= m; j++) {
            color[i] = j;
           //boolean feo = didnotbreak();
            // Recur of the rest vertices
            if (graphColoring(graph, m, i + 1, color)){
                //if it's possible to color here, return true
                return true;
            }
            //set color back to 0
            color[i] = 0;
        }
        return false;
    }
 
    // Driver code
    public static void main(String[] args)
    {
 
        /* Create following graph and
            test whether it is 3 colorable
            (3)---(2)
            | / |
            | / |
            | / |
            (0)---(1)
            */
        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false },
        };
        int m = 3; // Number of colors
 
        // Initialize all color values as 0.
        // This initialization is needed
        // correct functioning of isSafe()
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        // Function call
        if (!graphColoring(graph, m, 0, color))
            System.out.println("Solution does not exist");
    }
}
 
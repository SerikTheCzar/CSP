import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

//vertex edges class, initliazation of project in main
class Vertex {
    public static void main(String args[]){ 
        //define edges
        Vertex edges[]= {new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D")};
    
        //creatornator --> creates and connects edges together with vertices
        edges[0].connector(edges[1]);
        edges[1].connector(edges[2]);
        edges[2].connector(edges[3]);
        edges[0].connector(edges[3]);
        edges[0].connector(edges[3]);
        edges[2].connector(edges[1]);
        //this is the list of colors we'll use
        String colors[] = {"Red","Blue"};
    
        //assign color to an object so we can assign more information to it
        colObj color1 = new colObj(colors, edges.length);
    
        //init at the first edge
        boolean hasSolution = color1.setColors(edges[0]);
         
        long startTime = System.nanoTime();
        //we're going to keep checking if there's a solution
        if (!hasSolution)
            System.out.println("no Solution, failure...");
        else {
          

            for (Vertex vertex: edges){
                System.out.println("solution found!!");
                System.out.println(vertex.name + " has a color value of "+ vertex.color +"\n");
            }
            long endTime = System.nanoTime();
        
            long duration = (endTime - startTime); 
            double elapsedTimeInSecond = (double) duration / 1_000_000_000;

            System.out.println("The program took " + elapsedTimeInSecond + " seconds to run");
        }
      }
  String name;
  List<Vertex> adjacentedges;
  boolean colored;
  String color;

  public Vertex(String name) {
    this.adjacentedges = new ArrayList<>();
    this.name = name;
    this.color = "";
    this.colored =false;
  }

  //connect two edges
  public void connector(Vertex vertex){
    this.adjacentedges.add(vertex);
    if(isValid(vertex)){
    vertex.adjacentedges.add(this);
    } else {
      System.out.println("Please set appropriate vertices");
    }
  }

  boolean isValid(Vertex v1) {
    if(v1.name=="" || v1.color==null || this.adjacentedges == null){
    return false;
    } else {
      return true;
    }

  }
}

class colObj {
  String colors[];
  int numberOfedges;
  int colorCount;

  public colObj(String[] colors, int alpha) {
    this.colors = colors;
    this.numberOfedges = alpha;
  }
  
  //Function to check whether it is valid to color with color[colorIndex]
  
  boolean setColHelper(int colorIndex, Vertex vertex) {
    for(Vertex nbrvertex: vertex.adjacentedges){
      if(nbrvertex.colored && nbrvertex.color.equals(colors[colorIndex]))
        return  true;
    }
    return false;
  }
  public boolean setColors(Vertex vertex){
    //loop through all colors sets
    for(int colorIndex=0; colorIndex<colors.length; colorIndex++){ 
      //check if possible
      System.out.println("color index " + colorIndex);
    //  System.out.println(vertex.name);
      if(setColHelper(colorIndex, vertex)) 
        continue; 
      
      //set vertex = the index that you need
      vertex.color=colors[colorIndex]; 
      //set it equal to colored
      System.out.println("test help + " + vertex.color);
      vertex.colored=true; 
      //iterate one
      colorCount++; 
      System.out.println("this is count " + colorCount);
      //break case
      if(colorCount== numberOfedges) //itl quit here
        return true; 

      //recursive call
      for(Vertex nbrvertex: vertex.adjacentedges){ 
        if (!nbrvertex.colored){ 
          if(setColors(nbrvertex)) //recursive
            return true;
          } 
      }

    }
      
    //now we backtrack
    //so set the color back to empty
    //and make it uncolored
    //this is why objects are so useful
    vertex.color = "";
    vertex.colored = false;
   
    return false;
  } 

}
                    

import java.util.ArrayList;
import java.util.List;

class Vertex {
    public static void main(String args[]){ 
        //define edges
        Vertex edges[]= {new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D")};
    
        //join verices
        edges[0].connector(edges[1]);
        edges[1].connector(edges[2]);
        edges[2].connector(edges[3]);
        edges[0].connector(edges[3]);
    
        //define colors
        String colors[] = {"Red","Blue"};
    
        //create color1 object
        colObj color1 = new colObj(colors, edges.length);
    
        //start color1 with vertex-A
        boolean hasSolution = color1.setColors(edges[0]);
    
        //check if color1 was successful
        if (!hasSolution)
            System.out.println("No Solution");
        else {
            for (Vertex vertex: edges){
                System.out.println(vertex.name + " "+ vertex.color +"\n");
            }
        }
      }
  String name;
  List<Vertex> adjacentedges;
  boolean colored;
  String color;

  public Vertex(String name) {
    this.name = name;
    this.adjacentedges = new ArrayList<>();
    this.colored =false;
    this.color = "";
  }

  //connect two edgess bi-directional
  public void connector(Vertex vertex){
    this.adjacentedges.add(vertex);
    vertex.adjacentedges.add(this);
  }
}

class colObj {
  String colors[];
  int colorCount;
  int numberOfedges;

  public colObj(String[] colors, int N) {
    this.colors = colors;
    this.numberOfedges = N;
  }

  public boolean setColors(Vertex vertex){
    //Step: 1
    for(int colorIndex=0; colorIndex<colors.length; colorIndex++){ 
      //Step-1.1: checking validity
      if(!canColorWith(colorIndex, vertex)) 
        continue; 

      //Step-1.2: continue color1 
      vertex.color=colors[colorIndex]; 
      vertex.colored=true; 
      colorCount++; 

      //Step-1.3: check whether all edges colored? 
      if(colorCount== numberOfedges) //base case 
        return true; 

      //Step-1.4: next uncolored vertex 
      for(Vertex nbrvertex: vertex.adjacentedges){ 
        if (!nbrvertex.colored){ 
          if(setColors(nbrvertex))
            return true;
          } 
      }

    }
      
    //Step-4: backtrack 
    vertex.colored = false;
    vertex.color = "";
    return false;
  } 

  //Function to check whether it is valid to color with color[colorIndex]
  boolean canColorWith(int colorIndex, Vertex vertex) {
    for(Vertex nbrvertex: vertex.adjacentedges){
      if(nbrvertex.colored && nbrvertex.color.equals(colors[colorIndex]))
        return  false;
    }
    return true;
  }
}
                    

public class Main{
    public static void main(String args[]){ 
      //define vertices
      Vertex vertices[]= {new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D")};
  
      //join verices
      vertices[0].addNeighbor(vertices[1]);
      vertices[1].addNeighbor(vertices[2]);
      vertices[2].addNeighbor(vertices[3]);
      vertices[0].addNeighbor(vertices[3]);
  
      //define colors
      String colors[] = {"Green","Blue"};
  
      //create coloring object
      Coloring coloring = new Coloring(colors, vertices.length);
  
      //start coloring with vertex-A
      boolean hasSolution = coloring.setColors(vertices[0]);
  
      //check if coloring was successful
      if (!hasSolution)
          System.out.println("No Solution");
      else {
          for (Vertex vertex: vertices){
              System.out.println(vertex.name + " "+ vertex.color +"\n");
          }
      }
    }
  }
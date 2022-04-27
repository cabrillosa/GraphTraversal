//------------------------------------------------------------------------
// 2022 IT-ELAI Introduction to AI
//------------------------------------------------------------------------
//
// File Name    :   GraphTraversal.java
// Class Name:  :   GraphTraversal 
// Stereotype   :   
//
//------------------------------------------------------------------------
// GraphTraversal class:
//  Methods:
//      add_place                       - Add a place in string format.
//      connect                         - Connect one vertex to another vertex.
//      display_adjacency_list          - Display adjacency list.
//      BFS                             - Traverse the map using Breadth-first search
//      DFS                             - Traverse the map using Depth-first search
//  Attributes:
//      num_of_vertices(int)            - Number of places/vertices in the map.
//      vertices(LinkedList<Integer>[]) - Array of linkedlist to represent the adjacency list.
//      places(String[])                - Buffer to store the name of the places in string format.
//      place_ctr(int)                  - place counter.
//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2022-04-27 cabrillosa  First Release.

import java.util.*;

class GraphTraversal {
//---------------------------------------------------------------------
// Attribute Definition.
//---------------------------------------------------------------------
    int                     num_of_vertices;
    LinkedList<Integer>[]   vertices;
    String[]                places;
    int                     place_ctr = 0;

//---------------------------------------------------------------------
// Method Definition.
//---------------------------------------------------------------------

    //------------------------------------------------------------------------
    //  Method Name : GraphTraversal
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : void.
    //  Return      : void.
    //------------------------------------------------------------------------
    GraphTraversal(int num)
    {
        num_of_vertices = num;
        places          = new String[num_of_vertices];
        vertices        = new LinkedList[num_of_vertices];
        
        for(int x = 0; x < num_of_vertices; x ++) {
            vertices[x] = new LinkedList<Integer>();
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : add_place
    //  Description : Adds a place in string format.
    //  Arguments   : String place
    //  Return      : 0 (OK)
    //               -1 (NG - exceeds the total defined list size)
    //------------------------------------------------------------------------
    public int add_place(String place)
    {   
        if(place_ctr >= num_of_vertices) {
            System.out.println("[Error] The number of places exceeds the defined size!");
            return -1;
        } else {}

        places[place_ctr] = place;
        place_ctr++;
        return 0;
    }

    //------------------------------------------------------------------------
    //  Method Name : connect
    //  Description : Connect one vertex to another vertex
    //  Arguments   : int v1
    //                int v2
    //  Return      : 0 (OK)
    //               -1 (NG - exceeds the total defined list size)
    //------------------------------------------------------------------------
    public int connect(int v1, int v2)
    {
        if(v1 >= num_of_vertices || v2 >=num_of_vertices) {
            System.out.println("[Error] The vertex number exceeds the total size defined!");
            return -1;
        } else {}

        vertices[v1].add(v2);
        return 0;
    }

    //------------------------------------------------------------------------
    //  Method Name : display_adjacency_list
    //  Description : Display adjacency list.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void display_adjacency_list() 
    {
        for(int x = 0; x < num_of_vertices; x ++) {
            System.out.print("["+places[x]+"] ==> [");
           for(int y = 0; y < vertices[x].size(); y++) {
               System.out.print(places[vertices[x].get(y)] + "]->");
            }
            System.out.println("[null]");
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : BFS
    //  Description : Traverse the map using Breadth-First Search.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void BFS(int start_vertex)
    {
        //todo
    }

    //------------------------------------------------------------------------
    //  Method Name : DFS
    //  Description : Traverse the map using Depth-First Search.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void DFS(int start_vertex)
    {
        //todo
    }
}

public class GraphDriver{
    public static void main(String[] args)
    {
         /* EXAMPLE ONLY!!! Given map (Talisay City)
                        Lagtang(0) 
                            \     
                             \     
                              \
                               \
         Lawaan(1) --------- Tabunok(2) --------- Bulacao(3)
                                |
                                |
                                |
                                |
                              Kimba(4)
        */
        
        // Create GraphTraversal object with 5 Brgys
        GraphTraversal gt = new GraphTraversal(5);

        // Input the names of each Brgys
        gt.add_place("Lagtang"); //0
        gt.add_place("Lawaan");  //1
        gt.add_place("Tabunok"); //2
        gt.add_place("Bulacao"); //3
        gt.add_place("Kimba");   //4

        //Connect each Brgys
        //back and forth
        gt.connect(0, 2); //Lagtang-Tabunok
        gt.connect(2, 0); //Tabunok-Lagtang

        //back and forth
        gt.connect(1, 2); //Lawaan-Tabunok
        gt.connect(2, 1); //Tabunok-Lawaan

        //back and forth
        gt.connect(2, 3); //Tabunok-Bulacao
        gt.connect(3, 2); //Bulacao-Tabunok

        //back and forth
        gt.connect(2, 4); //Tabunok-Kimba
        gt.connect(4, 2); //Kimba-Tabunok
        

        //Display the adjacency list
        gt.display_adjacency_list();
    }
}
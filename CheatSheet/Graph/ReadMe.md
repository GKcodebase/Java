### Graph Algorithms

#### 1.Dijkstra's Shortest Path Algorithm
Algorithm to find the shortest distance between nodes in a graph.
```
Algorithm :

1.Create a set visited (shortest path tree set) that keeps track of vertices included in the shortest path tree, i.e., whose minimum distance from the source is calculated and finalized. Initially, this set is empty.
2.Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE . Assign the distance value as 0 for the source vertex so that it is picked first.
3.While visited doesn’t include all vertices
    Pick a vertex u that is not there in visited and has a minimum distance value.
    Include u to visited .
    Then update the distance value of all adjacent vertices of u .
        To update the distance values, iterate through all adjacent vertices.
        For every adjacent vertex v, if the sum of the distance value of u (from source) and weight of edge u-v , is less than the distance value of v , then update the distance value of v .

```

#### 2.Kruskal's Minimum Spanning Tree.
A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree.

```dtd
Algorithm : 

    1.Sort all the edges in non-decreasing order of their weight. 
    2.Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If the cycle is not formed, include this edge. Else, discard it. 
    3.Repeat step#2 until there are (V-1) edges in the spanning tre

```

#### 3.Prim's Minimum Spanning Tree
The algorithm starts with an empty spanning tree. The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST, and the other set contains the vertices not yet included. At every step, it considers all the edges that connect the two sets and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST.

````dtd
Algorithm :
        Step 1: Determine an arbitrary vertex as the starting vertex of the MST.
        Step 2: Follow steps 3 to 5 till there are vertices that are not included in the MST (known as fringe vertex).
        Step 3: Find edges connecting any tree vertex with the fringe vertices.
        Step 4: Find the minimum among these edges.
        Step 5: Add the chosen edge to the MST if it does not form any cycle.
        Step 6: Return the MST and exit
````

#### 4.Floyd Warshall All Pair The Shortest Path
The Floyd Warshall Algorithm is an all pair shortest path algorithm unlike Dijkstra and Bellman Ford which are single source shortest path algorithms. This algorithm works for both the directed and undirected weighted graphs

```dtd
Initialize the solution matrix same as the input graph matrix as a first step. 
Then update the solution matrix by considering all vertices as an intermediate vertex. 
The idea is to pick all vertices one by one and updates all shortest paths which include the picked vertex as an intermediate vertex in the shortest path. 
When we pick vertex number k as an intermediate vertex, we already have considered vertices {0, 1, 2, .. k-1} as intermediate vertices. 
For every pair (i, j) of the source and destination vertices respectively, there are two possible cases. 
    k is not an intermediate vertex in shortest path from i to j. We keep the value of dist[i][j] as it is. 
    k is an intermediate vertex in shortest path from i to j. We update the value of dist[i][j] as dist[i][k] + dist[k][j], if dist[i][j] > dist[i][k] + dist[k][j]
```
#### 5.Tarjan's Strongly connected Components
A directed graph is strongly connected if there is a path between all pairs of vertices. A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.


#### 6.Topological sorting
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v, vertex u comes before v in the ordering.




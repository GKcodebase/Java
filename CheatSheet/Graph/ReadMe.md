### Graph Algorithms

#### 1.Dijkstra's Shortest Path Algorithm
Algorithm to find the shortest distance between nodes in a grpah.
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
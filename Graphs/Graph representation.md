Here we will talk about how to implement a data structure like graph in the computer's memory. As we know a graph contains a set of vertices and a set of edges. To create and store a graph in the memory, the simplest thing that we can do is, to create two lists - one to store all vertices and another to store all the edges. For a list we can use an array of appropriate size or we can use an implementation of a dynamic list. In fact, we can use a dynamic list available to us in language libraries, something like vector in C++ ot ArrayList in Java. Now, a vertex is identified by it's name, so the first list - the list of vertices would simply be a list of names or strings. But what should we fill in the edge list?

![](https://i.ibb.co/V9xzMj9/gr1.png)

An edge is identified by it's twho endpoints, so what we can do is we can create an edge as an object with two fields. We can define edge as a structure or class with two fields. One to store the start vertex and another to store the end vertex.

```cpp
struct Edge
{
   char *startVertex;
   char* *endVertex;
}
    //OR
class Edge
{
    string startVertex;
    string endVertex;
}
```
Edge list would basically be an array or list of this type - struct Edge. In these two definitions of edges - int he first one we have used character pointers, because in C we typically use character pointers to store or refer to strings. We could use character array also. In C++ or Java, where we can create classes, we have string available to us as a data-type, so we can use that also. So we can use any of these for the fields depending on how we want to design our implementation.

The graph that we have is an undirected graph, so any vertex can be called start vertex and any vertex can be called end vertex. Order of the vertices is not important here. 

![](https://i.ibb.co/cy2pxg6/gr2.png)

If this was a directed graph, for example < F,H > and < H,F >, would have meant two different connections - which is the start vertex and which is the end vertex would have mattered, but it our case the graph is undirected so that doesn't matter. Maybe in case of undirected graphs we should name the fields as first vertex and second vertex and in case of directed graphs we should name the fields as start vertex and end vertex. 

Now, our graph here could also be a weighted graph. We can have some cost or weight associated with the edges. As we know in an unweighted graph cost of all the connextions is equal but in a weighted graph, different connections would have differenc weight or different cost. Now in the following example graph we associated some weight:

![](https://i.ibb.co/Wnz1vzf/gr3.png)

When the graph is weighted we can have one more field in the edge object to store the weight:

```cpp
struct Edge
{
   char *startVertex;
   char* *endVertex;
   int weight;
}
    //OR
class Edge
{
    string startVertex;
    string endVertex;
    int weight;
}
```

Now an entry in our edge-list has 3 fields. One to store the start vertex, one to store the end vertex and one more to store the weight. So this is one possible way of storing a graph. We can simply create two lists - one to store the vertices and another to store the edges.

```cpp
string vertexList[MAX_SIZE];
Edge edgeList[MAX_SIZE];
```

But this is not very efficient. For any possible way of storing and organazing data we must also see it's cost and when we say cost we mean two things - time cost of various operations and memory usage.<br>
(*Typiccally we measure the rate of growth of time taken with the size of input or data - what we also call time complexity. And we measure the rate of growth of memory consumed with size of input data - what we also call space complexity*)

Time and space complexity are most commonly expressed in terms of what we call Big-O notation. We always want to minimize the time cost of most frequently performed operations and we always want to make sure that we do not consume unreasonably high memory.<br> Let's now analyze the particular structure that we're trying to use to store our graph. Let's first discuss the memory usage. For the first list, the vertex list, least number of rows needed or consumed would be equal to number of vertices. Now, each row in the vertex list is a name or string and string can be of any length. Right now all strings have just one character because we simply named the nodec A, B, C and so on but we could have names with multiple characters. And because strings can be of different lengths - all rows may not be consuming the same amount of memory - like the following example:

![](https://i.ibb.co/1qxRbYs/gr4.png)

#### Cost:
- Time cost of operations (*time complexity*)
- Memory usage (*space complexity*)



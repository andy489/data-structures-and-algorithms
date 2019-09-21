Here we will talk about how to implement a data structure like graph in the computer's memory. As we know a graph contains a set of vertices and a set of edges. To create and store a graph in the memory, the simplest thing that we can do is, to create two lists - one to store all vertices and another to store all the edges. For a list we can use an array of appropriate size or we can use an implementation of a dynamic list. In fact, we can use a dynamic list available to us in language libraries, something like vector in C++ ot ArrayList in Java. Now, a vertex is identified by it's name, so the first list - the list of vertices would simply be a list of names or strings. But what should we fill in the edge list?

![](https://i.ibb.co/V9xzMj9/gr1.png)

An edge is identified by it's twho endpoints, so what we can do is we can create an edge as an object with two fields. We can define edge as a structure or class with two fields. One to store the start vertex and another to store the end vertex.

```cpp
struct Edge
{
   char *startVertex;
   char* *endVertex;
}
    OR
class Edge
{
    string startVertex;
    string endVertex;
}
```

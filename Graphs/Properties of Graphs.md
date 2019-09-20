## Properties of graph

We can have some special kind of edges in a graph. These edges complicate algorithms and make working with graphs difficult. An edge is called a self-loop or self-edge if it involves only 1 vertex. If both endpoints of an edge are same then it's caled a self loop. 

![](https://i.ibb.co/XWnn4f4/POG1.png)

We can have a self loop in both directed and undirected graphs, but the question is why would we ever have a self loop in a graph? Well, sometimes if edges are depicting some relationship or connection that's possible with the same node as origin as well as destination, then we can have a self loop. For example, interlinked web pages on the internet or the world wide web can be represented as a directed graph. A page with a unique URL can be a node in the graph and we can have a directed edge if a page contains link to another page. Now, we can have a self loop in similar graph, because it's very much possible for a webpage to have a link to itself. Have a look at the current webpage. have a look here: [https://github.com/andy489/Data_Structures_and_Algorithms_CPP/Properties_of_graph.md](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Graphs/Properties%20of%20Graphs.md). Now we basically have link in the header for the same page, and if we click it, all it will happen with the click is a refresh, because we are already in this page. My origin and destination are same. So if we are representing world wide web as a directed graph the way we just discussed, then we have a self loop here.

![](https://i.ibb.co/jH0DBZv/POG2.png)

The next special type of edge that we are going to talk about is multi-edge.

![](https://i.ibb.co/9GWdg5q/POG3.png)

An edge is called a multi-edge if it occurs more than once in a graph. Once again we can have a multi-edge in both directed and undirected graphs. The first multiedge in the above example is undirected and the second one is directed. Once again the question why should be ever have a multi-edge. Well, lets say we are representing flight network between cities as a graph. A city would be a node and we can have an edge if there is a direct flight connection between any 2 cities, but then there can be multiple flights between a pair of cities. These flights would have different names and may have different costs. If we want to keep the information about all the flights in our graph, we can draw multi-edges. We can draw 1 directed edge for each flight and then we can label an edge with its cost or any other propery. 

![](https://i.ibb.co/GdKCJMj/POG5.png)

We have just labeled edges here with some unique random flight numbers. Now as we were saying earlier, self loops and multi-edges often complicate working with graphs. Their presence means that we need to take extra care while solving problems. If a graph contains no self loop or multi-edge then it's called a simple graph. Here, we will mostly be dealing with simple graphs. 

Given number of vertices in a simple graph that is a graph with no self loops or multi-edge. What would be maximum possible number of edges? 

![](https://i.ibb.co/kS4tgVv/POG6.png)

Obviously minimum possible number of edges in a graph is zero. Now, if this is a directed graph, what do you think can be maximum number of edges here? Well, each node can have directed edges to all other nodes.

![](https://i.ibb.co/fQDVMGp/POG7.png)

In this figure here, each node can have directed edges to 3 other nodes. We have 4 nodes in total, so maximum possible number of edges here is 4 * 3 that is 12.

![](https://i.ibb.co/DMCMmrH/POG8.png)

This is the maximum that we can draw if there is no self loop or multi-edges. In general if there are n vertices, then maximum number of edges in a directed graph would be <img src="https://latex.codecogs.com/svg.latex?\Large&space;n(n-1)">. So in a simple directed graph, number of edges would be in the range <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{|E|}\le{n(n-1)}">. Now what will be the maximum for an undirected graph? In an undirected graph we can have only 1 bi-directional edge between a pair of nodes. We can't have 2 edges in different directions, so here the maximum would be half of maximum for directed, i.e. <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{|E|}\le\frac{{n(n-1)}}{2}">.

Assuming no self-loop or multiedge <img src="https://latex.codecogs.com/svg.latex?\Large&space;(|V|=n)">:
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{|E|}\le{n(n-1)}">, *if directed*
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{|E|}\le\frac{{n(n-1)}}{2}">, *if undirected*

Number of edges in the graph can be really large compared to a number of vertices. For example if number of vertices in a directed graph is equal to 10, maximum number of edges would be 90. If number of vertices is 100, maximum number of edges would be 9900. Maximum nubmer of edges would be close to square of number of vertices.

A graph is called dense if number of edges in the graph is close to maximum possible number of edges, that is if the number of edges is of the order of square of number of vertices, and a graph is called sparse if the number of edges is really less - tipically close to a number of vertices and not more than that. There is no defined boundary for what can be called dense and what can be called sparse. It all depends on context. This is an important classification. While working with graphs, a lot of decisions are made based on whether the graph is dense or sparse. For example we typically choose a different kind of storage structure in computer's memory for a dense graph. We typically store a dense graphs in something called adjacency matrix, and for a sparse graph we typically use something called adjacency list. 

The next concept that we are going to talk about is concept of path in a graph. A path in a graph is *a sequence of vertices where each adjacent pair in the sequence is connected by an edge*. 

![](https://i.ibb.co/RTX2pDQ/POG9.png)

The sequence of vertices < A,B,F,H > is a path in this graph. Now, we have undirected graph here, edges are bi-directional. In a directed graph, all edges must also be aligned in 1 direction - the direction og the path. A path is called *simple path if no vertices are repeated and if vertices are not repeated then edges will also not be repeated*. So in a simple path both vertices and edges are not repeated. This path < A,B,F,H > that we have highlighted here is a simple path but we could also have a path like the show below:

![](https://i.ibb.co/rGWP55b/POG10p.png)

Here, start vertex is A and end vertex is D. In this path, 1 edge and 2 vertices are repeated - < A,B,F,H,E,B,A,D >. In graph theory there is some inconsistency in use of this term path. Most of the time, when we say path, we mean a simple path. And if repetition is possible we used this term *walk*. So a path is basically a walk in which no vertices (and thus no edges) are repeated. A walk is called a *trail* if vertices can be repeated but edges cannot be repeated.

![](https://i.ibb.co/HDDp54d/POG11p.png)

Walk and path are used as synonyms, but most often when we say path we mean simple path, a path in which vertices and edges are not repeated. Between 2 different vertices if there is a walk in which vertices or edges are repeated like the highlighted in the above example, then there must also be a path or simple path that is a walk in which vertices or edges would not be repeated. In the walk from the above example, we're starting at A and we are ending our walk at C. There is a simple path from A to C with just 1 edge. All we need to do is, we need to avoid going to B E H D and then coming back again to A. 

![](https://i.ibb.co/XzYXgqp/POG12.png)

So this is why we mostly talk about simple path between 2 vertices, because if any other walk is possible - simle path is also possible and it makes most sense to look for a simple path. When we say path we mean a simple path and if it's not a simple path we will say it explicitly. 

A graph is called *strongly connected if in the graph there is a path from any vertex to any other vertex.* If it's an undirected graph, we simply call it connected and if it's a directed graph, we call it strongly connected. 

![](https://i.ibb.co/mS2jx74/POG13.png)

IN leftmost and rightmost graphs shown in the above example, we have a path from any vertex to any other vertex. But for the graph in the middle, we do not have a path from any vertex to any other vertex. We cannot go from vertex C to A. We can go from A to C but we cannot go in the oposite direction. So this is not a strongly connected graph. Remember, if it's an undirected graph we simply say connected and if it's a directed graph we say strongly connected. If a directed graph is not strongly connected, but can be turned into connected graph by treating all edges as undirected, then such a directed graph is called weakly connected. In the middle graph in the example, if we just ignore the directions of edges - it will become a connected graph. 

If we remove one of the edges from the leftmost graph we will have a not connected graph.

![](https://i.ibb.co/nzwHVZf/POG14.png)

Now we have 2 disjoint connected components here. But the graph overall is not connected. Connectedness of a graph is a really important property. If we remember, intra-city road network with a city that would have a lot of 1 ways can be presented as a directed graph. Now, an intra-city road network should always be strongly connected. We should be able to reach any street from any street, any intersection to any intersection. 

Lets now talk about *cycle* in a graph. A walk is called a closed walk if it starts and ends at same vertex and there is one more condition - the length of the walk must be greater than 0.

![](https://i.ibb.co/syFz4Yd/POG15.png)

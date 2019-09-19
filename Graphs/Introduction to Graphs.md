## Graph Data Structure

Graph is a non-linear data structure that has got its application in a wide number of scenarios in computer science. It is used to model and represent a variety of systems. We will first study graph as a mathematical and logical model. A graph just like tree is a collection of objects or entities that we call nodes or vertices, connected to each other through a set of edges. But in a tree connections are bound to be in a certain way. In a tree there are rules dictating the connection among the nodes. In a tree with N nodes, we must have exactly N-1 edges. One edge for each parent-child relationship. As we know, an edge is for a parent-child relationship and all nodes in a tree except the root node would have exactly one parent. In a tree all nodes must be reachable from the root and there must be exactly one possible path from root to a node. Now in a graph there are no rules dictating the connection among the nodes. A graph contains a set of nodes and a set of edges and edges can be connecting nodes in any possible way. *Tree is only a special king of graph.* Graph as a concept has been studied extensively in mathematics (discrete mathematics). In computer science we basically study and implement the same concept of graph from mathematics. The study of graph is often referred to as graph theory. IN pure mathematical terms we can define graph in the following way.

#### Graph:
- A graph **G** is an ordered pair of a set **V** of vertices and a set **E** of edges. **G=(V,E)**.

An ordered pair is just a pair of mathematical objects in which the order of objects in the pair matters. This is how we write and represent an ordered pair - objects separated by comma put within paranthesis. Now, because the order here matters, we can say that V is the first object in the pair and E is the second object. 

- ordered pair:
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;(a,b)\neq{(b,a)}">, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;a\neq{b}">
- unordered pair:
  - <img src="https://latex.codecogs.com/svg.latex?\Large&space;\{a,b\}=\{b,a\}">
  
In our definition of a graph, first object in the pair must always be a set of vertices and the second object must be a set of edges that's why we are calling the pair an ordered pair. We also have concept of unordered pair. An unordered pair is simply a set of two elements. Order is not important here. We write an unordered pair using curly brackets or braces. Because the order is not important here, unordered pair {a,b} is equal to {b,a}. It doesn't matter which object is first and which object is second. Lets draw an example graph.

![](https://i.ibb.co/RTbKqSD/graph1.png)

The above graph has 8 vertices and 10 edges. We want to give some names to these vertices because each node in a graph must have some identification. It can be a name or it can be an index. We are giving names, so that the naming is not indicative of any order. There is no 1st, 2nd and 3rd node here. We could give any name to any node. 

![](https://i.ibb.co/QHjMfBL/graph2.png)

So our set of vertices here is <img src="https://latex.codecogs.com/svg.latex?\Large&space;V=\{V1,V2,V3,V4,V5,V6,V7,V8\}"> and what is the set of edges? An edge is uniquely identified by it's two endpoints, so we can just write the names of the two endpoints of an edge as a pair and it can be a representation for the edge. But edges can be of two types:
- Edges: 
  - directed - one way connection
  - undirected - two way connection

![](https://i.ibb.co/Y7TXwqy/graph3.png)

In a tree we have directed edges. With the directed edge in the above example , we are saying that there is a link or path from vertex *u* to *v*, but we cannot assume a path form *v* to *u*. This connection is one way. For a directed edge, one of the end points would be the origin and other end point would be the destination and we draw the edge with an arrow head pointing towards the destination. FOr our edge above, origin is *u* and destination is *v*. A directed edge can be represented as ordered pair. First element of the pair cn be the origin and second element can be the destination - *(u,v)* - we have a path from *u* to *v*. If we want a path from *v* to *u*, then we need to draw another directed edge with *v* as origin and *u* as destination and then the result will be represented as ordered pair *(v,u)*. Now, if the edge is undirected, the connection is two way and undirected edge can be represented as an unordered pair, because the edge is bi-directional origin and destination are not fixed. We only need to know what two end points are being connected. So now that we know how to represent edges, we can write the set of edges for the above graph example. 

The set of edges is: <img src="https://latex.codecogs.com/svg.latex?\Large&space;E=\bigg{\{V1,V2\},\{V1,V3\},\{V1,V4\},\{V2,V5\},\{V2,V6\},\{V3,V7\},\{V4,V8\},\{V7,V8\},\{V5,V8\},\{V6,V8\}\bigg}">


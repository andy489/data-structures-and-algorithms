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

The set of edges is: <img src="https://latex.codecogs.com/svg.latex?\Large&space;E=\{\{V1,V2\},\{V1,V3\},\{V1,V4\},\{V2,V5\},\{V2,V6\},\{V3,V7\},\{V4,V8\},\{V7,V8\},\{V5,V8\},\{V6,V8\}\}">

To denote number of elements in a set, that we also call cardinality of a set, we use the same notation that we used for modulus or absolute value. So, this is how we can denote number of vertices and number of edges in a graph:
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;|V|"> → number of vertices
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;|E|"> → number of edges

In our example we have <img src="https://latex.codecogs.com/svg.latex?\Large&space;|V|=8,|E|=10">.

Tipically in a graph, all edges would either be directed or undirected. It's possible for  graph to have both directed and undirected edges. We are only going to work with such graphs in which all edges would either be directed or undirected. 

![](https://i.ibb.co/nmgdDKD/graph4.png)

A graph with all directed edges is called a directed graph or digraph and a graph with all undirected edges is called undirected graph. There is no special name for an undirected graph. Usually, if the graph is directed, we explicitly say that it's directed graph or digraph. So these are two types of graphs. So these are two types of graphs. Directed graph or digraph in which edges are uni-directional or ordered pairs and undirected graph in which edges are bi-directional or unordered pairs. Now many real-world systems and problems can be modeled using a graph. Graphs can be used to represent any collection of objects having some kind of pairwise relationship. Let's have a look at some of the interesting examples.

![](https://i.ibb.co/MPFR11S/graph5.png)

A social network like Facebook can be represented as an undirected graph. A user would be a node in the graph and if two users are friends, there would be an edge connecting them. A real social network would have millions and billions of nodes. In our diagram above we can show only few, because we are short of space. Social network is an undirected graph because friendship is a mutual relationship. If I'm your friend, you are my friend too. So connections have to be 2 way. Now once a system is modeled as a graph a lot of problems can easily be solved by applying standard algorithms in graph theory. Like here in this social network, let's say we want to do something like *suggest friends to a user*. Let's say we want to suggest some connections to a user. Let's say we want to suggest some connection to *Elly*. One possible approach to do so can be suggesting friends of friends who are not connected already. *Elly* has three friends: *Annie, Tom* and *Polly* and friends of these three that are not connected to *Elly* already can be suggested. There is no friend of *Annie*, which is not connected to *Elly*  already. *Tom* however, has three friends - *Calahan, Robert* and *Frank* that are not friends with *Elly* so they can be suggested. And *Polly* has two friends - *Frank* and *Harry* that are not connected to *Elly*. We have counted *Frank* already, so in all we can suggest these four users to *Elly*.

![](https://i.ibb.co/vxPHQ9g/graph6.png)

Now, even though we described this problem in context of a social network, this is a standard graph problem. The problem here in pure graph terms is *finding all nodes having length of shortest path from a given node equal to 2*. Standard algorithms can be applied to solve this problem. 

Lets have a look at another example. Interlinked web pages on the internet or the World Wide Web can be represented as a directed graph. 

![](https://i.ibb.co/DMrn447/graph7.png)

A web page that would have a unique address or URL would be a node in the graph and we can have a directed edge if a page contains link to another page. Now once again, there are billions of pages on the web but we can show only few here. The edges in this graph are directed because the relationship is not mutual this time. If page A has a link to page B then it's not necessary that page B will also a link to page A. Lets say that one of the pages on https://www.github.com/andy489 has a tutorial on graph and on this page I have put a link to Wikipedia article on graph. Lets assume that in the above example graph Page P is my Github page and page Q is the Wikipedia article on graph. Now on my page P, I have put a link to the page Q. If you are on page P, you can click on this link and go to page Q. But Wikipedia has not reciprocated to my favor by putting a link back to my page. So if you are on page Q you cannot click on a link and come to page P. Connection here is one way and that's why we have drawn a directed edge here.

Now, once again if we are able to represent web as a directed graph, we can apply standard graph theory algorithms to solve problems and to perform tasks. One of the tasks like search engines like Google perform very regularly is web crawling. Search engines use a program called web crawler that systematically browsers the World Wide Web to collect and store data about web pages. Search engines can then use this data to provide quick and accurate results against search queries. Now, even though in this context, we are using a nice and heavy term like web crawling, web crawling is basically graph traversal or in simpler words, act of visiting all nodes in a graph and no prizes for guessing that there are standard algorithms for graph traversal.

Next thing that we should mention is the concept of weighted graph. Sometimes in a graph, all connections cannot be treated as equal. Some connections can be preferable to others. Like for example we can represent intercity road network that is the network of hoghways and freeways between cities as an undirected graph. 

![](https://i.ibb.co/ZMpJbWX/graph9.png)

We're assuming that all highways would be bi-directional. Intra-city road network that is road network within a city would definitely have one-way roads and so intra-city road network must be represented as a directed graph, but intercity road network can be represented as an undirected graph. Now clearly we cannot treat all connections as equal here. Roads would be of different lengths and to perform a lot of tasks, to solve a lot of problems, we need to take length of roads into account. In such cases, we associate some weight or cost with every edge. We label the edge with their weights. In the above case weight can be length of the roads, so what to do here is we'll just label this edges with some values for the lengths. Lets say these values are in kilometers. And now edges in this graph are weighted and this graph can be called a weighted graph. 

Let's say in this graph, we want to pick the best route from city A to city D. We have 4 possible routs shown in four possible colours. Now, if we would treat all edges as equal then we would say that the green route through B and C and a red route through E and F are equally good. Both these paths have three edges and the yellow rout through E is the best, because we have only two edges in this path. 

But with different weights assigned to the connections, we need to add up weights of edges in a path to calculate total cost. When we are taking weight into account, shortest route is through B and C. Connections have different weights and this is really important here in this graph. 

Actually, we can look at all the graphs as weighted graphs. An unweighted graph can basically be seen as a weighted graph in which weight of all the edges is same and typically we assume the weight as 1. 

So we have represented inter-city road network as a weighted undirected graph. Social network was an unweighted undirected graph ans World Wide Web was an unweighted directed graph. Intra-city road network that is road network within a city can be modeled as a weighted directed graph because in a city there would be some one-ways. Intersections in intra-city's road network would be Nodes and road segments would be our edges. 

![](https://i.ibb.co/L1KpH3M/graph10.png)

And by the way we can also draw an undirected graph as directed - it's just that for each undirected edge we will have 2 directed edges. We may not be able to redraw a directed graph as undirected but we can always redraw an undirected graph as directed.


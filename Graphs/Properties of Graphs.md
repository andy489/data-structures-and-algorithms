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

![](https://i.ibb.co/fQDVMGp/POG7.png)

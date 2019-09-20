## Properties of graph

We can have some special kind of edges in a graph. These edges complicate algorithms and make working with graphs difficult. An edge is called a self-loop or self-edge if it involves only 1 vertex. If both endpoints of an edge are same then it's caled a self loop. 

![](https://i.ibb.co/FmQXPYz/POG1.png)

We can have a self loop in both directed and undirected graphs, but the question is why would we ever have a self loop in a graph? Well, sometimes if edges are depicting some relationship or connection that's possible with the same node as origin as well as destination, then we can have a self loop. For example, interlinked web pages on the internet or the world wide web can be represented as a directed graph. A page with a unique URL can be a node in the graph and we can have a directed edge if a page contains link to another page. Now, we can have a self loop in similar graph, because it's very much possible for a webpage to have a link to itself. Have a look at the current webpage. have a look here: [https://github.com/andy489/Data_Structures_and_Algorithms_CPP/Properties_of_graph.md](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Graphs/Properties%20of%20Graphs.md). Now we basically have link in the header for the same page, and if we click it, all it will happen with the click is a refresh, because we are already in this page. My origin and destination are same. So if we are representing world wide web as a directed graph the way we just discussed, then we have a self loop here.

![](https://i.ibb.co/jH0DBZv/POG2.png)







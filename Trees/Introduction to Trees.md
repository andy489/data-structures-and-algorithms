Tree is one data structure that's quite often used to represent hierarchical data. For example. let's say we want to show employees in an organization and their positions in organizational hierarchy, then we can show it something like this. Let's say the following example is organization hierarchy of some company.

![](https://i.ibb.co/8XBf95W/Line-Organizational-Structure-1.png)

We have to look at the structure upside down and then it will resemble a real tree. The root is at top and we are branching out in downward direction. Logical representation of tree data structure is always like this. Root at top and branching out in downward direction. Tree is an efficient way of storing and organazing data that is naturally hierarchical, but this is not the only application of tree in computer science. Before we proceed to other applications and implementation, let's first define tree as a logical model.

Tree data structure can be defined as a collection of entities called nodes linked together to simulate a hierarchy. *Tree is a non-linear data structure, it's a hierarchical structure*. The topmost node in the tree is called root of the tree. Each node will contain some data and this can be data of any type. In the above tree that we have displayed - data is the name of position (designation) in the organization. We can have also an object with two (or more) - one to store name of person and another to store designation. So, each node will contain some data and may contain link or reference to some other nodes that can be called its children.

The HTML source code and the tree accompanying the source illustrate another hierarchy. Notice that each level of the tree corresponds to a level of nesting inside the HTML tags. The first tag in the source is <img src="https://latex.codecogs.com/svg.latex?\Large&space;<html>"> and the last is <img src="https://latex.codecogs.com/svg.latex?\Large&space;</html>"> All the rest of the tags in the page are inside the pair. If you check, you will see that this nesting property is true at all levels of the tree.

Here is the tree that corresponds to each of the HTML tags used to create the page.

![](https://bradfieldcs.com/algos/trees/introduction/figures/htmltree.png)

#### Definitions

Now that we have looked at examples of trees, we will formally define a tree and its components.

#### Node

A node is a fundamental part of a tree. It can have a unique name, which we sometimes call the “key.” A node may also have additional information, which we refer to in this book as the “payload.” While the payload information is not central to many tree algorithms, it is often critical in applications that make use of trees.

#### Edge

An edge is another fundamental part of a tree. An edge connects two nodes to show that there is a relationship between them. Every node other than the root is connected by exactly one incoming edge from another node. Each node may have several outgoing edges.

#### Root

The root of the tree is the only node in the tree that has no incoming edges. In a file system, / is the root of the tree. In an HTML document, the <html> tag is the root of the tree.

#### Path

A path is an ordered list of nodes that are connected by edges. For example, <img src="https://latex.codecogs.com/svg.latex?\Large&space;html→body→h2→a\"> is a path.

#### Children

The set of nodes *C* that have incoming edges from the same node are said to be the children of that node. In our example, nodes ul, h1, and h2 are the children of node body.

#### Parent

A node is the parent of all the nodes to which it connects with outgoing edges. In our example the node head is the parent of nodes meta and title.

#### Sibling

Nodes in the tree that are children of the same parent are said to be siblings. The nodes meta and title are siblings in the HTML tags system tree.

#### Subtree

A subtree is a set of nodes and edges comprised of a parent and all the descendants of that parent.

#### Leaf Node

A leaf node is a node that has no children. For example, 'a' is a leaf node.

#### Level 

The level of a node *n* is the number of edges on the path from the root node to *n*. For example, the level of the ul node in our example is two. By definition, the level of the root node is zero.

#### Height

The height of a tree is equal to the maximum level of any node in the tree. The height of the tree in our example is three.

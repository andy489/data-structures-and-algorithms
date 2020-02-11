## Rust & Murdered

[Judge System](https://www.hackerrank.com/challenges/rust-murderer/problem)

Detective Rust is investigating a homicide and he wants to chase down the murderer. The murderer knows he would definitely get caught if he takes the main roads for fleeing, so he uses the village roads (or side lanes) for running away from the crime scene.

Rust knows that the murderer will take village roads and he wants to chase him down. He is observing the city map, but it doesn't show the village roads (or side lanes) on it and shows only the main roads.

The map of the city is a graph consisting
nodes (labeled to ) where a specific given node represents the current position of Rust and the rest of the nodes denote other places in the city, and an edge between two nodes is a main road between two places in the city. It can be suitably assumed that an edge that doesn't exist/isn't shown on the map is a village road (side lane). That means, there is a village road between two nodes and

iff(if and only if) there is no city road between them.

In this problem, distance is calculated as number of village roads (side lanes) between any two places in the city.

Rust wants to calculate the shortest distance from his position (Node

) to all the other places in the city if he travels only using the village roads (side lanes).

Note: The graph/map of the city is ensured to be a sparse graph.

Input Format

The first line contains
, denoting the number of test cases. testcases follow.
First line of each test case has two integers , denoting the number of cities in the map and , denoting the number of roads in the map.
The next lines each consist of two space-separated integers and denoting a main road between city and city . The last line has an integer

, denoting the current position of Rust.

Constraints

Note

    No nodes will have a road to itself.
    There will not be multiple edges between any pair of nodes i.e. there is at most one undirected edge between them.
    Graph is guaranteed to be sparse.
    It is guranteed that there will be a path between any pair of nodes using the side lanes.

Output Format

For each of T test cases, print a single line consisting of N-1 space separated integers, denoting the shortest distances of the remaining N-1 places from Rust's position (that is all distances, except the source node to itself) using the village roads/side lanes in ascending order based on vertex number.

Sample Input 0

2
4 3
1 2
2 3
1 4
1
4 2
1 2
2 3
2

Sample Output 0

3 1 2
2 2 1

Explanation 0

The graph in the first testcase can be shown as:

image Here the source node is 1 (marked S).
The distance from 1 to 2 is 3. Path: 1 -> 3 -> 4 -> 2
The distance from 1 to 3 is 1. Path: 1 -> 3
The distance from 1 to 4 is 2. Path: 1 -> 3 -> 4 

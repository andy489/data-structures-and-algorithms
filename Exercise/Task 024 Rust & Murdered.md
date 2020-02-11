## Rust & Murdered

[Judge System](https://www.hackerrank.com/challenges/rust-murderer/problem)

Detective Rust is investigating a homicide and he wants to chase down the murderer. The murderer knows he would definitely get caught if he takes the main roads for fleeing, so he uses the village roads (or side lanes) for running away from the crime scene.

Rust knows that the murderer will take village roads and he wants to chase him down. He is observing the city map, but it doesn't show the village roads (or side lanes) on it and shows only the main roads.

The map of the city is a graph consisting <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> nodes (labeled <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> ) where a specific given node <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> represents the current position of Rust and the rest of the nodes denote other places in the city, and an edge between two nodes is a main road between two places in the city. It can be suitably assumed that an edge that doesn't exist/isn't shown on the map is a village road (side lane). That means, there is a village road between two nodes <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> iff(if and only if) there is no city road between them.

In this problem, distance is calculated as number of village roads (side lanes) between any two places in the city.

Rust wants to calculate the shortest distance from his position (Node <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">) to all the other places in the city if he travels only using the village roads (side lanes).

**Note:** The graph/map of the city is ensured to be a sparse graph.

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, denoting the number of test cases. <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> testcases follow.<br>
First line of each test case has two integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, denoting the number of cities in the map and <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">, denoting the number of roads in the map.<br>
The next <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> lines each consist of two space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;y"> denoting a main road between city and city . The last line has an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, denoting the current position of Rust.

####Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{N}\le{2\times{10^5}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{M}\le{120000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x,y,S}\le{N}">

#### Note

- No nodes will have a road to itself.
- There will not be multiple edges between any pair of nodes i.e. there is at most one undirected edge between them.
- Graph is guaranteed to be sparse.
- It is guranteed that there will be a path between any pair of nodes using the side lanes.

####Output Format

For each of T test cases, print a single line consisting of N-1 space separated integers, denoting the shortest distances of the remaining N-1 places from Rust's position (that is all distances, except the source node to itself) using the village roads/side lanes in ascending order based on vertex number.

#### Sample Input 0
```
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
```
#### Sample Output 0
```
3 1 2
2 2 1
```
#### Explanation 0

The graph in the first testcase can be shown as:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Rust%20%26%20Murdered%2001.png) 

Here the source node is 1 (marked S).
The distance from 1 to 2 is 3. Path: 1 -> 3 -> 4 -> 2
The distance from 1 to 3 is 1. Path: 1 -> 3
The distance from 1 to 4 is 2. Path: 1 -> 3 -> 4 

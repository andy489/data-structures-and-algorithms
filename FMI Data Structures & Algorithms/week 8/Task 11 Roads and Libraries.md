## Roads and Libraries

[Judge System](https://www.hackerrank.com/challenges/torque-and-development/problem)

The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, HackerLand was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest programmer of HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.

HackerLand has <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> cities numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">. The cities are connected by <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> bidirectional roads. A citizen has access to a library if:

- Their city contains a library.
- They can travel by road from their city to a city containing a library.

The following figure is a sample map of HackerLand where the dotted lines denote obstructed roads:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Roads%20and%20Libraries%2001.png)

The cost of repairing any road is <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}"> dollars, and the cost to build a library in any city is <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}"> dollars. If in the above example <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}=2"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}=3">, we would build <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> roads at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\times{2}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> libraries for a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">. We don't need to rebuild one of the roads in the cycle <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{2}\rightarrow{3}\rightarrow{1}">.

You are given <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> queries, where each query consists of a map of HackerLand and value of <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}">. For each query, find the minimum cost of making libraries accessible to all the citizens and print it on a new line.

#### Function Description

Complete the function roadsAndLibraries in the editor below. It must return the minimal cost of providing libraries to all, as an integer.

roadsAndLibraries has the following parameters:

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">: integer, the number of cities
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}">: integer, the cost to build a library
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}">: integer, the cost to repair a road
- cities: 2D array of integers where each <img src="https://latex.codecogs.com/svg.latex?\Large&space;cities[i]"> contains two integers that represent cities connected by an obstructed road.

#### Input Format

The first line contains a single integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;q">, that denotes the number of queries.

The subsequent lines describe each query in the following format:
- The first line contains four space-separated integers that describe the respective values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> , <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}">, the number of cities, number of roads, cost of a library and cost of a road.
- Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> lines contains two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;u[i]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v[i]">, that describe a bidirectional road that connects cities <img src="https://latex.codecogs.com/svg.latex?\Large&space;u[i]"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;v[i]">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q}\le{10}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{m}\le{min{\bigg(10^5,\frac{n\cdot{(n-1)}}{2}\bigg)}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{c_{road},c_{lib}}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{u[i],v[i]}\le{n}">
- Each road connects two distinct cities.

#### Output Format

For each query, print an integer that denotes the minimum cost to make libraries accessible to all the citizens on a new line.

Sample Input|Simple Output
-|-
2<br>3 3 2 1<br>1 2<br>3 1<br>2 3<br>6 6 2 5<br>1 3<br>3 4<br>2 4<br>1 2<br>2 3<br>5 6|4<br>12

#### Explanation

Perform the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;q=2"> queries:

1. HackerLand contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3"> cities connected by <img src="https://latex.codecogs.com/svg.latex?\Large&space;m=3"> bidirectional roads. The price of building a library is <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}=2"> and the price for repairing a road is <img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}=1">.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Roads%20and%20Libraries%2002.png)

The cheapest way to make libraries accessible to all is to:

- Build a library in city <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=2">.
- Repair the road between cities <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;y=1">.
- Repair the road between cities <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> at a cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;y=1">.

This gives a total cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2+1+1=4">. Note that the road between cities <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> does not need to be repaired each is connected to city <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.

2. In this scenario it is optimal to build a library in each city because the cost of building a library (<img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{lib}=2">) is less than the cost of repairing a road (<img src="https://latex.codecogs.com/svg.latex?\Large&space;c_{road}=5">).

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Roads%20and%20Libraries%2003.png)

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> cities, so the total cost is <img src="https://latex.codecogs.com/svg.latex?\Large&space;6\times{2}=12">.

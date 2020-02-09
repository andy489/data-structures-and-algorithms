## Jesse and Cookies

[Judge System](https://www.hackerrank.com/challenges/jesse-and-cookies/problem)

Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;=1\times"> Least sweet cookie <img src="https://latex.codecogs.com/svg.latex?\Large&space;+2\times"> 2nd least sweet cookie <img src="https://latex.codecogs.com/svg.latex?\Large&space;)">.

He repeats this procedure until all the cookies in his collection have a sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;\ge{K}">.

You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;\ge{K}">. Print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> if this isn't possible.

#### Input Format

The first line consists of integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, the number of cookies and <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">, the minimum required sweetness, separated by a space.<br>
The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> integers describing the array <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;A_i"> is the sweetness of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> cookie in Jesse's collection.

#### Constraints
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^6}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{K}\le{10^9}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{A_i}\le{10^6}">

#### Output Format

Output the number of operations that are needed to increase the cookie's sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;\ge{K}">.

Output <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> if this isn't possible.

#### Sample Input
```
6 7
1 2 3 9 10 12
```
#### Sample Output
```
2
```
#### Explanation

Combine the first two cookies to create a cookie with *sweetness* <img src="https://latex.codecogs.com/svg.latex?\Large&space;=1\times{1}+2\times{2}=5"><br>
After this operation, the cookies are <img src="https://latex.codecogs.com/svg.latex?\Large&space;3,5,9,10,12">.<br>
Then, combine the cookies with *sweetness* <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> and sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, to create a cookie with resulting *sweetness* = <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\times{3}+2\times{5}=13"><br>
Now, the cookies are <img src="https://latex.codecogs.com/svg.latex?\Large&space;9,10,12,13">.<br>
All the cookies have a sweetness <img src="https://latex.codecogs.com/svg.latex?\Large&space;\ge{7}">.

Thus,<img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> operations are required to increase the sweetness.

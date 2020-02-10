## Jim and the Skyscrapers

[Judge System](https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem)

Jim has invented a new flying object called HZ42. HZ42 is like a broom and can only fly horizontally, independent of the environment. One day, Jim started his flight from Dubai's highest skyscraper, traveled some distance and landed on another skyscraper of same height! So much fun! But unfortunately, new skyscrapers have been built recently.

Let us describe the problem in one dimensional space. We have in total <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> skyscrapers aligned from left to right. The <img src="https://latex.codecogs.com/svg.latex?\Large&space;i^{th}"> skyscraper has a height of <img src="https://latex.codecogs.com/svg.latex?\Large&space;h_i">. A flying route can be described as <img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)"> with <img src="https://latex.codecogs.com/svg.latex?\Large&space;i\neq{j}">, which means, Jim starts his HZ42 at the top of the skyscraper and lands on the skyscraper <img src="https://latex.codecogs.com/svg.latex?\Large&space;j">. Since HZ42 can only fly horizontally, Jim will remain at the height <img src="https://latex.codecogs.com/svg.latex?\Large&space;h_i"> only. Thus the path <img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)"> can be valid, only if each of the skyscrapers <img src="https://latex.codecogs.com/svg.latex?\Large&space;i,i+1,...,j-1,j"> is not strictly greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;h_i"> and if the height of the skyscraper he starts from and arrives on have the same height. Formally,<img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)"> is valid if <img src="https://latex.codecogs.com/svg.latex?\Large&space;\nexists{k}\in{[i,j]:h_k>h_i}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;h_i=h_j">.

Help Jim in counting the number of valid paths represented by ordered pairs <img src="https://latex.codecogs.com/svg.latex?\Large&space;(i,j)">.

#### Input Format

The first line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, the number of skyscrapers. The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> space separated integers representing the heights of the skyscrapers.

#### Output Format

Print an integer that denotes the number of valid routes.

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{3.10^5}"> and no skyscraper will have height greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;10^6"> and less than <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">.

#### Sample Input #00
```
6
3 2 1 2 3 3
```
#### Sample Output #00
```
8
```
#### Sample Input #01
```
3
1 1000 1
```
#### Sample Output #01
```
0
```
#### Explanation

First testcase: (1, 5), (1, 6) (5, 6) and (2, 4) and the routes in the opposite directions are the only valid routes.

Second testcase: (1, 3) and (3, 1) could have been valid, if there wasn't a big skyscraper with height 1000 between them.

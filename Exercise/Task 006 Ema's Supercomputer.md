## Ema's Supercomputer

[Judge System](https://www.hackerrank.com/challenges/two-pluses/problem)

Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size <img src="https://latex.codecogs.com/svg.latex?\Large&space;n\times{m}">, each cell in the grid is either <img src="https://latex.codecogs.com/svg.latex?\Large&space;good"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;bad">.

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

In the diagram below, the blue pluses are valid and the orange ones are not valid. 

![]()

Find the two largest valid pluses that can be drawn on <img src="https://latex.codecogs.com/svg.latex?\Large&space;good"> cells in the grid, and return an integer denoting the maximum product of their areas. In the above diagrams, our largest pluses have areas of <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;9">. The product of their areas is <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\times{9}=45">.

**Note:** The two pluses cannot overlap, and the product of their areas should be maximal.

#### Input Format

The first line contains two space-separated integers, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines contains a string of <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> characters where each character is either <img src="https://latex.codecogs.com/svg.latex?\Large&space;G(good)"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;B(bad)">. These strings represent the rows of the grid. If the <img src="https://latex.codecogs.com/svg.latex?\Large&space;y^{th}"> character in the <img src="https://latex.codecogs.com/svg.latex?\Large&space;x^{th}"> line is <img src="https://latex.codecogs.com/svg.latex?\Large&space;G">, then <img src="https://latex.codecogs.com/svg.latex?\Large&space;(x,y)"> is a <img src="https://latex.codecogs.com/svg.latex?\Large&space;good"> cell. Otherwise it's a <img src="https://latex.codecogs.com/svg.latex?\Large&space;bad"> cell.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{15}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{m}\le{15}">

#### Output Format

Find <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> pluses that can be drawn on <img src="https://latex.codecogs.com/svg.latex?\Large&space;good"> cells of the grid, and return an integer denoting the maximum product of their areas.

Sample Input 0|Sample Output 0
-|-
5 6<br>GGGGGG<br>GBBBGB<br>GGGGGG<br>GGBBGB<br>GGGGGG|5

Sample Input 1|Sample Output 1
-|-
6 6S<br>BGBBGB<br>GGGGGG<br>BGBBGB<br>GGGGGG<br>BGBBGB<br>BGBBGB|25

**Explanation**

Here are two possible solutions for **Sample 0** (left) and **Sample 1** (right): 

![]()

Explanation Key:

- Green: <img src="https://latex.codecogs.com/svg.latex?\Large&space;good"> cell;
- Red: <img src="https://latex.codecogs.com/svg.latex?\Large&space;bad"> cell;
- Blue: possible <img src="https://latex.codecogs.com/svg.latex?\Large&space;pluses">.

 - Green: <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> as <img src="https://latex.codecogs.com/svg.latex?\Large&space;P_i">.

**Sample 0**<br>
There is enough good space to color one <img src="https://latex.codecogs.com/svg.latex?\Large&space;P_3"> plus and one <img src="https://latex.codecogs.com/svg.latex?\Large&space;P_1"> plus. <img src="https://latex.codecogs.com/svg.latex?\Large&space;Area(P_3)=5"> units, and <img src="https://latex.codecogs.com/svg.latex?\Large&space;Area(P_1)=1"> unit. The product of their areas is <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\times{1}=5">.

**Sample 1**<br>
There is enough good space to color two <img src="https://latex.codecogs.com/svg.latex?\Large&space;P_3"> pluses. <img src="https://latex.codecogs.com/svg.latex?\Large&space;Area(P_3)=5"> units. The product of the areas of our two <img src="https://latex.codecogs.com/svg.latex?\Large&space;P_3"> pluses is <img src="https://latex.codecogs.com/svg.latex?\Large&space;5\times{5}=25">.

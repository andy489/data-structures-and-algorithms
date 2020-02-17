[Link](https://www.hackerrank.com/challenges/30-operators/problem)

## Day 2: Operators

#### Objective
In this challenge, you'll work with arithmetic operators. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-operators/tutorial) tab for learning materials and an instructional video!

#### Task
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.

**Note:** Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result!

#### Input Format

There are <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines of numeric input:<br>
The first line has a double,<img src="https://latex.codecogs.com/svg.latex?\Large&space;mealCost"> (the cost of the meal before tax and tip).<br>
The second line has an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;tipPercent"> (the percentage of <img src="https://latex.codecogs.com/svg.latex?\Large&space;mealCost"> being added as tip).<br>
The third line has an integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;taxPercent"> (the percentage of <img src="https://latex.codecogs.com/svg.latex?\Large&space;mealCost"> being added as tax).

#### Output Format

Print the total meal cost, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;totalCost"> is the rounded integer result of the entire bill (<img src="https://latex.codecogs.com/svg.latex?\Large&space;mealCost"> with added tax and tip).

#### Sample Input
```
12.00
20
8
```
#### Sample Output
```
15
```
#### Explanation

Given:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;mealCost=12,tioOercent=20,taxPercent=8">

Calculations:
<img src="https://latex.codecogs.com/svg.latex?\Large&space;tip=12\times{\frac{20}{100}}=2.4"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;tax=12\times{\frac{8}{100}}=0.96"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;totalCost=mealCost+tip+tax=12+2.4+0.96=15.36"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;round(totalCost)=15"><br>

We round <img src="https://latex.codecogs.com/svg.latex?\Large&space;totalCost"> to the nearest dollar (integer) and then print our result, <img src="https://latex.codecogs.com/svg.latex?\Large&space;15">.

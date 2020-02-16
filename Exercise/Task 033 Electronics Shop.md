## Electronics Shop

[Judge System](https://www.hackerrank.com/challenges/electronics-shop/problem)

Monica wants to buy a keyboard and a USB drive from her favorite electronics store. The store has several models of each. Monica wants to spend as much as possible for the <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> items, given her budget.

Given the price lists for the store's keyboards and USB drives, and Monica's budget, find and print the amount of money Monica will spend. If she doesn't have enough money to both a keyboard and a USB drive, print -1 instead. She will buy only the two required items.

For example, suppose she has <img src="https://latex.codecogs.com/svg.latex?\Large&space;b=60"> to spend. Three types of keyboards cost <img src="https://latex.codecogs.com/svg.latex?\Large&space;keyboards=[40,50,60]">. Two USB drives cost <img src="https://latex.codecogs.com/svg.latex?\Large&space;drives=[5,8,12]">. She could purchase a <img src="https://latex.codecogs.com/svg.latex?\Large&space;40{\;}keyboard+12{\;}USB{\;}drive=52">, or a <img src="https://latex.codecogs.com/svg.latex?\Large&space;50{\;}keyboard+8{\;}USB{\;}drive=58">. She chooses the latter. She can't buy more than <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> items so she can't spend exactly <img src="https://latex.codecogs.com/svg.latex?\Large&space;60">.

#### Function Description

Complete the getMoneySpent function in the editor below. It should return the maximum total price for the two items within Monica's budget, or <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1"> if she cannot afford both items.

getMoneySpent has the following parameter(s):

- keyboards: an array of integers representing keyboard prices
- drives: an array of integers representing drive prices
- b: the units of currency in Monica's budget

#### Input Format

The first line contains three space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;b,n,m">, her budget, the number of keyboard models and the number of USB drive models.<br>
- The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;keyboard[i]">, the prices of each keyboard model.<br>
The third line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;drives">, the prices of the USB drives.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n,m}\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{b}\le{10^6}">
- The price of each item is in the inclusive range <img src="https://latex.codecogs.com/svg.latex?\Large&space;[1,10^6]">.

#### Output Format

Print a single integer denoting the amount of money Monica will spend. If she doesn't have enough money to buy one keyboard and one USB drive, print -1 instead.

Sample Input 0
```
10 2 3
3 1
5 2 8
```
#### Sample Output 0
```
9
```
#### Explanation 0

She can buy the <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{nd}"> keyboard and the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^{rd}"> USB drive for a total cost of <img src="https://latex.codecogs.com/svg.latex?\Large&space;8+1=9">.

#### Sample Input 1
```
5 1 1
4
5
```
#### Sample Output 1
```
-1
```
#### Explanation 1

There is no way to buy one keyboard and one USB drive because <img src="https://latex.codecogs.com/svg.latex?\Large&space;4+5>5">, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

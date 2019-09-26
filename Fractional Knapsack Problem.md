## Fractional Knapsack Problem
A modification of the famous knapsack problem is the so-called [continuous (or fractional) knapsack problem](https://en.wikipedia.org/wiki/Continuous_knapsack_problem). 
We have N items, each with a certain weight and price. The knapsack has a maximum capacity, so we need to choose what to take in order to maximize the value (price) of the items in it. 
Unlike the classical version of the problem where an object should either be taken in its entirety or not at all, in this version we can take a fraction of each item. For example, such items may be liquids or powders; unlike solid objects which (presumably) we cannot split, we’ll assume that all items under consideration can be divided in any proportion. Therefore, the weight can be thought as the maximum quantity Q of an item we are allowed to take – we can take any amount in the range [0 … Q]. Note that in this version of the problem the knapsack will always be filled completely (if the total quantity of items is greater than its capacity).
Items will be given on separate lines in format price -> weight. Round all numbers to two digits after the decimal separator.
Examples
Input	Output
Capacity: 16
Items: 3
25 -> 10
12 -> 8
16 -> 8	Take 100% of item with price 25.00 and weight 10.00
Take 75.00% of item with price 16.00 and weight 8.00
Total price: 37.00
Capacity: 13
Items: 2
13 -> 7
15 -> 7	Take 100% of item with price 15.00 and weight 7.00
Take 85.71% of item with price 13.00 and weight 7.00
Total price: 26.14
Capacity: 22
Items: 4
50 -> 25
34 -> 25
41 -> 25
3 -> 25	Take 88.00% of item with price 50.00 and weight 25.00
Total price: 44.00
Capacity: 134
Items: 9
12 -> 14
45 -> 54
98 -> 78
21 -> 51
64 -> 11
90 -> 117
33 -> 17
64 -> 23
7 -> 3	Take 100% of item with price 64.00 and weight 11.00
Take 100% of item with price 64.00 and weight 23.00
Take 100% of item with price 7.00 and weight 3.00
Take 100% of item with price 33.00 and weight 17.00
Take 100% of item with price 98.00 and weight 78.00
Take 14.29% of item with price 12.00 and weight 14.00
Total price: 267.71
Capacity: 10
Items: 1
25 -> 5	Take 100% of item with price 25 and weight 5
Total price: 25.00
Hints
Use a greedy algorithm: take the best item (max price / weight) as much as possible, then the next best item, etc.

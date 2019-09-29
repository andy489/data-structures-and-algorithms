## Egyptian Fractions
In mathematics, a fraction is the rational number <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{p}{q}"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;p"> and q are integers. An Egyptian fraction is a sum of fractions, each with numerator 1 where all denominators are different, e.g. 1/2 + 1/3 + 1/16 is an Egyptian fraction, but 1/3 + 1/3 + 1/5 is not (repeated denominator 3). 
Every positive fraction (q != 0, p < q) can be represented by an Egyptian fraction, for instance, 43/48 = 1/2 + 1/3 + 1/16. Given p and q, write a program to represent the fraction p/q as an Egyptian fraction.
Examples
Input	Output
43/48	43/48 = 1/2 + 1/3 + 1/16
3/7	3/7 = 1/3 + 1/11 + 1/231
23/46	23/46 = 1/2
22/7	Error (fraction is equal to or greater than 1)
134/3151	134/3151 = 1/24 + 1/1164 + 1/2445176
Note: There may be more than one correct solution, e.g. 3/7 = 1/4 + 1/8 + 1/19 + 1/1064. If you follow the greedy algorithm logic, you should get the solutions given in the input/output examples.
Hints
You can complete the expression by starting with the biggest fraction with numerator 1 which added to the expression keeps it smaller than or equal to the target fraction. The biggest fraction is the one with smallest denominator – 1/2. Increase the denominator until you’ve found a solution.

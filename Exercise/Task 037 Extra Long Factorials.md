## Extra Long Factorials

[Judge System](https://www.hackerrank.com/challenges/extra-long-factorials/problem)

The factorial of the integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, written <img src="https://latex.codecogs.com/svg.latex?\Large&space;n!">, is defined as:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;n!=n\times{n-1}\timrs{n-2}\times{...}\times{3}\times{2}\times{1}">

Calculate and print the factorial of a given integer.

For example, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=30">, we calculate <img src="https://latex.codecogs.com/svg.latex?\Large&space;30\times{29}\times{28}\times{...}\times{2}\times{1}"> and get <img src="https://latex.codecogs.com/svg.latex?\Large&space;265252859812191058636308480000000">.

#### Function Description

Complete the extraLongFactorials function in the editor below. It should print the result and return.

extraLongFactorials has the following parameter(s):

- n: an integer

**Note:** Factorials of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n>20"> can't be stored even in a <img src="https://latex.codecogs.com/svg.latex?\Large&space;64-bit"> long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.

We recommend solving this challenge using BigIntegers.

#### Input Format

Input consists of a single integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">

#### Constraints

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100}">

#### Output Format

Print the factorial of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

#### Sample Input

<img src="https://latex.codecogs.com/svg.latex?\Large&space;25">

#### Sample Output

<img src="https://latex.codecogs.com/svg.latex?\Large&space;15511210043330985984000000">

#### Explanation

<img src="https://latex.codecogs.com/svg.latex?\Large&space;25!=25\times{24}\times{23}\times{...}\times{3}\times{2}\times{1}">

## Task 7.

Find the number of ways that a given integer, , can be expressed as the sum of the

powers of unique, natural numbers.

For example, if
and , we have to find all combinations of unique squares adding up to . The only solution is

.

Function Description

Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.

powerSum has the following parameter(s):

    X: the integer to sum to
    N: the integer power to raise numbers to

Input Format

The first line contains an integer
.
The second line contains an integer

.

Constraints

Output Format

Output a single integer, the number of possible combinations caclulated.

Sample Input 0

10
2

Sample Output 0

1

Explanation 0

If
and , we need to find the number of ways that

can be represented as the sum of squares of unique numbers.

This is the only way in which

can be expressed as the sum of unique squares.

Sample Input 1

100
2

Sample Output 1

3

Explanation 1

Sample Input 2

100
3

Sample Output 2

1

Explanation 2

can be expressed as the sum of the cubes of .
. There is no other way to express as the sum of cubes. 

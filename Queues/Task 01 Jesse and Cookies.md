## Jesse and Cookies

[Judge System](https://www.hackerrank.com/challenges/jesse-and-cookies/problem)

Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value

. To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness
Least sweet cookie

2nd least sweet cookie).

He repeats this procedure until all the cookies in his collection have a sweetness
.
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print

if this isn't possible.

#### Input Format

The first line consists of integers
, the number of cookies and , the minimum required sweetness, separated by a space.
The next line contains integers describing the array where is the sweetness of the

cookie in Jesse's collection.

#### Constraints



#### Output Format

Output the number of operations that are needed to increase the cookie's sweetness
.
Output

if this isn't possible.

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

Combine the first two cookies to create a cookie with sweetness
=
After this operation, the cookies are .
Then, combine the cookies with sweetness and sweetness , to create a cookie with resulting sweetness =
Now, the cookies are .
All the cookies have a sweetness .

Thus, operations are required to increase the sweetness.

## Jim and the Skyscrapers

[Judge System](https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem)

Jim has invented a new flying object called HZ42. HZ42 is like a broom and can only fly horizontally, independent of the environment. One day, Jim started his flight from Dubai's highest skyscraper, traveled some distance and landed on another skyscraper of same height! So much fun! But unfortunately, new skyscrapers have been built recently.

Let us describe the problem in one dimensional space. We have in total
skyscrapers aligned from left to right. The th skyscraper has a height of . A flying route can be described as with , which means, Jim starts his HZ42 at the top of the skyscraper and lands on the skyscraper . Since HZ42 can only fly horizontally, Jim will remain at the height only. Thus the path can be valid, only if each of the skyscrapers is not strictly greater than and if the height of the skyscraper he starts from and arrives on have the same height. Formally, is valid iff and

.

Help Jim in counting the number of valid paths represented by ordered pairs

.

#### Input Format

The first line contains
, the number of skyscrapers. The next line contains

space separated integers representing the heights of the skyscrapers.

#### Output Format

Print an integer that denotes the number of valid routes.

#### Constraints

and no skyscraper will have height greater than and less than

.

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

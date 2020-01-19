## Bigger is Greater

[Judge System](https://www.hackerrank.com/challenges/bigger-is-greater/problem)

[Lexicographical](https://en.wikipedia.org/wiki/Lexicographical_order) order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

- It must be greater than the original word
- It must be the smallest word that meets the first condition

For example, given the word <img src="https://latex.codecogs.com/svg.latex?\Large&space;w=abcd">, the next largest word is <img src="https://latex.codecogs.com/svg.latex?\Large&space;abdc">.

#### Input Format

The first line of input contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">, the number of test cases.<br>
Each of the next <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> lines contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;w">.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|w|}\le{100}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;w"> will contain only letters in the range ascii[a..z].

#### Output Format

For each test case, output the string meeting the criteria. If no answer exists, print *no answer*.

Sample Input 0|Sample Output 0
-|-
5<br>ab<br>bb<br>hefg<br>dhck<br>dkhc|ba<br>no answer<br>hegf<br>dhkc<br>hcdk

**Explanation 0**

- Test case <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">:<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;ba"> is the only string which can be made by rearranging <img src="https://latex.codecogs.com/svg.latex?\Large&space;ab">. It is greater.

- Test case <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">:<br>It is not possible to rearrange <img src="https://latex.codecogs.com/svg.latex?\Large&space;bb"> and get a greater string.

- Test case <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">:<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;hegf"> is the next string greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;hefg">.

- Test case <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">:<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;dhkc"> is the next string greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;dhck">.

- Test case <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">:<br><img src="https://latex.codecogs.com/svg.latex?\Large&space;hcdk"> is the next string greater than <img src="https://latex.codecogs.com/svg.latex?\Large&space;dkhc">.

Sample Input 1|Sample Output 1
-|-
6<br>lmno<br>dcba<br>dcbb<br>abdc<br>abcd<br>fedcbabcd|lmon<br>no answer<br>no answer<br>acbd<br>abdc<br>fedcbabdc

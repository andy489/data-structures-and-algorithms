## Simple Text Editor

[Judge System](https://www.hackerrank.com/challenges/simple-text-editor/problem)

In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">. You must perform <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> operations of the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> types:

1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;append(W)"> - Append string <img src="https://latex.codecogs.com/svg.latex?\Large&space;W"> to the end of <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">.

2. <img src="https://latex.codecogs.com/svg.latex?\Large&space;delete(k)"> - Delete the last <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> characters of <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">.

3. <img src="https://latex.codecogs.com/svg.latex?\Large&space;print(k)"> - Print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;k^{th}"> character of <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">.

4. <img src="https://latex.codecogs.com/svg.latex?\Large&space;undo()"> - Undo the last (not previously undone) operation of type <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, reverting <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> to the state it was in prior to that operation.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q">, denoting the number of operations.<br>
Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> subsequent lines (where <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{i}<Q">) defines an operation to be performed. Each operation starts with a single integer,<img src="https://latex.codecogs.com/svg.latex?\Large&space;t"> (where <img src="https://latex.codecogs.com/svg.latex?\Large&space;t\in\{1,2,3,4\}">), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,<img src="https://latex.codecogs.com/svg.latex?\Large&space;t"> is followed by its space-separated argument. For example, if <img src="https://latex.codecogs.com/svg.latex?\Large&space;t=1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;W=abcd">, line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> will be *1 abcd*.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{10^6}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{k}\le{|S|}">
- The sum of the lengths of all <img src="https://latex.codecogs.com/svg.latex?\Large&space;W"> in the input <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{10^6}">.
- The sum of <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> over all delete operations <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{2.10^6}">.
- All input characters are lowercase English letters.
- It is guaranteed that the sequence of operations given as input is possible to perform.

#### Output Format

Each operation of type <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> must print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;k^{th}"> character on a new line.

#### Sample Input
```
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
```
#### Sample Output
```
c
y
a
```
#### Explanation

Initially, <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> is empty. The following sequence of <img src="https://latex.codecogs.com/svg.latex?\Large&space;8"> operations are described below:

1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\varnothing">. We append <img src="https://latex.codecogs.com/svg.latex?\Large&space;abc"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, so <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=abc">.

2. Print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^{rd}"> character on a new line. Currently, the <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^{rd}"> character is <img src="https://latex.codecogs.com/svg.latex?\Large&space;c">.

3. Delete the last <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> characters in <img src="https://latex.codecogs.com/svg.latex?\Large&space;S(abc)">, so <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\varnothing">.

4. Append <img src="https://latex.codecogs.com/svg.latex?\Large&space;xy"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, so <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=xy">.

5. Print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{nd}"> character on a new line. Currently, the <img src="https://latex.codecogs.com/svg.latex?\Large&space;2^{nd}"> character is <img src="https://latex.codecogs.com/svg.latex?\Large&space;y">.

6. Undo the last update to <img src="https://latex.codecogs.com/svg.latex?\Large&space;S">, making <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> empty again (i.e.,<img src="https://latex.codecogs.com/svg.latex?\Large&space;S=\varnothing">).

7. Undo the next to last update to <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> (the deletion of the last <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> characters), making <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=abc">.

8. Print the <img src="https://latex.codecogs.com/svg.latex?\Large&space;1^{st}"> character on a new line. Currently, the <img src="https://latex.codecogs.com/svg.latex?\Large&space;1^{st}"> character is <img src="https://latex.codecogs.com/svg.latex?\Large&space;a">.

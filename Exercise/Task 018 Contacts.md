## Contacts

[Judge System](https://www.hackerrank.com/challenges/contacts/problem)

We're going to make our own Contacts application! The application must perform two types of operations:

1. *add name*, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> is a string denoting a contact name. This must store <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> as a new contact in the application.
2. find partial, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;partial"> is a string denoting a partial name to search the application for. It must count the number of contacts starting with <img src="https://latex.codecogs.com/svg.latex?\Large&space;partial"> and print the count on a new line.

Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> sequential add and find operations, perform each operation in order.

#### Input Format

The first line contains a single integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, denoting the number of operations to perform.<br>
Each line <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> subsequent lines contains an operation in one of the two forms defined above.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|name|}\le{21}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{|partial|}\le{21}">
- It is guaranteed that <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;partial"> contain lowercase English letters only.
- The input doesn't have any duplicate <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> for the <img src="https://latex.codecogs.com/svg.latex?\Large&space;add"> operation.

#### Output Format

For each *find partial* operation, print the number of contact names starting with <img src="https://latex.codecogs.com/svg.latex?\Large&space;partial"> on a new line.

#### Sample Input
```
4
add hack
add hackerrank
find hac
find hak
```
#### Sample Output
```
2
0
```
#### Explanation

We perform the following sequence of operations:

1.  Add a contact named *hack*.<br>
2. Add a contact named *hackerrank*.<br>
3. Find and print the number of contact names beginning with *hac*. There are currently two contact names in the application and both of them start with *hac*, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> on a new line.<br>
4. Find and print the number of contact names beginning with *hak*. There are currently two contact names in the application but neither of them start with *hak*, so we print <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> on a new line.

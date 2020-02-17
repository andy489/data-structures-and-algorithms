[Link](https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem)

## Day 8: Dictionaries and Maps

#### Objective
Today, we're learning about Key-Value pair mappings using a Map or Dictionary data structure. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-dictionaries-and-maps/tutorial) tab for learning materials and an instructional video!

#### Task
Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an unknown number of names to query your phone book for. For each <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> queried, print the associated entry from your phone book on a new line in the form *name=phoneNumber;* if an entry for <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> is not found, print *Not found* instead.

**Note:** Your phone book should be a Dictionary/Map/HashMap data structure.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, denoting the number of entries in the phone book.<br>
Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> subsequent lines describes an entry in the form of <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated values on a single line. The first value is a friend's name, and the second value is an <img src="https://latex.codecogs.com/svg.latex?\Large&space;8">-digit phone number.

After the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> lines of phone book entries, there are an unknown number of lines of queries. Each line (query) contains a <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> to look up, and you must continue reading lines until there is no more input.

**Note:** Names consist of lowercase English alphabetic letters and are first names only.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{queries}\le{10^5}">
#### Output Format

On a new line for each query, print *Not found* if the name has no corresponding entry in the phone book; otherwise, print the full <img src="https://latex.codecogs.com/svg.latex?\Large&space;name"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;phoneNumber"> in the format *name=phoneNumber*.

#### Sample Input
```
3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry
```
#### Sample Output
```
sam=99912222
Not found
harry=12299933
```
#### Explanation

We add the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3"> (Key,Value) pairs to our map so it looks like this:<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;phoneBook=\{(sam,999122222),(tom,11122222),(harry,12299933)\}"><br>
We then process each query and print key=value if the queried <img src="https://latex.codecogs.com/svg.latex?\Large&space;key"> is found in the map; otherwise, we print *Not found*.

Query 0: sam<br>
Sam is one of the keys in our dictionary, so we print sam=99912222.

Query 1: edward<br>
Edward is not one of the keys in our dictionary, so we print Not found.

Query 2: harry<br>
Harry is one of the keys in our dictionary, so we print harry=12299933.

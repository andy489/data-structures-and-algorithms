## Journey to the Moon

[Judge System](https://www.hackerrank.com/challenges/journey-to-the-moon/problem)

The member states of the UN are planning to send

people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

For example, we have the following data on 2 pairs of astronauts, and 4 astronauts total, numbered
through

.

1   2
2   3

Astronauts by country are
and . There are pairs to choose from: and

.

Function Description

Complete the journeyToMoon function in the editor below. It should return an integer that represents the number of valid pairs that can be formed.

journeyToMoon has the following parameter(s):

    n: an integer that denotes the number of astronauts
    astronaut: a 2D array where each element 

is a

    element integer array that represents the ID's of two astronauts from the same country

Input Format

The first line contains two integers
and , the number of astronauts and the number of pairs.
Each of the next lines contains

space-separated integers denoting astronaut ID's of two who share the same nationality.

Constraints

Output Format

An integer that denotes the number of ways to choose a pair of astronauts from different coutries.

Sample Input 0

5 3
0 1
2 3
0 4

Sample Output 0

6

Explanation 0

Persons numbered
belong to one country, and those numbered belong to another. The UN has

ways of choosing a pair:

Sample Input 1

4 1
0 2

Sample Output 1

5

Explanation 1

Persons numbered
belong to the same country, but persons and don't share countries with anyone else. The UN has

ways of choosing a pair:


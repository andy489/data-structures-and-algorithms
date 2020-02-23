
[Link](https://www.hackerrank.com/challenges/30-regex-patterns/problem)

## Day 28: RegEx, Patterns, and Intro to Databases

#### Objective
Today, we're working with regular expressions. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-regex-patterns/tutorial) tab for learning materials and an instructional video!

#### Task
Consider a database table, Emails, which has the attributes First Name and Email ID. Given <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in <img src="https://latex.codecogs.com/svg.latex?\Large&space;@gmail.com">.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, total number of rows in the table.<br>
Each of the <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> subsequent lines contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> space-separated strings denoting a person's first name and email ID, respectively.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{N}\le{30}">
- Each of the first names consists of lower case letters <img src="https://latex.codecogs.com/svg.latex?\Large&space;[a-z],@"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;."> only.
- Each of the email IDs consists of lower case letters <img src="https://latex.codecogs.com/svg.latex?\Large&space;[a-z],@"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;."> only.
- The length of the first name is no longer than 20.
- The length of the email ID is no longer than 50.

#### Output Format

Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.

#### Sample Input
```
6
riya riya@gmail.com
julia julia@julia.me
julia sjulia@gmail.com
julia julia@gmail.com
samantha samantha@gmail.com
tanya tanya@gmail.com
```
#### Sample Output
```
julia
julia
riya
samantha
tanya
```

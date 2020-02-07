## Kindergarten Adventures

[Judge System](https://www.hackerrank.com/challenges/kindergarten-adventures/problem)

Meera teaches a class of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> students, and every day in her classroom is an adventure. Today is drawing day!

The students are sitting around a round table, and they are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> in the clockwise direction. This means that the students are numbered <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,2,3,...,n-1,n">, and students <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> are sitting next to each other.

After letting the students draw for a certain period of time, Meera starts collecting their work to ensure she has time to review all the drawings before the end of the day. However, some of her students aren't finished drawing! Each student <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> needs <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_i"> extra minutes to complete their drawing.

Meera collects the drawings sequentially in the clockwise direction, starting with student ID <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">, and it takes her exactly <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> minute to review each drawing. This means that student <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> gets <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> extra minutes to complete their drawing, student <img src="https://latex.codecogs.com/svg.latex?\Large&space;x+1"> gets <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> extra minute, student <img src="https://latex.codecogs.com/svg.latex?\Large&space;x+2"> gets <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> extra minutes, and so on. *Note* that Meera will still spend <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> minute for each student even if the drawing isn't ready.

Given the values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1,t_2,...,t_n">, help Meera choose the best possible <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> to start collecting drawings from, such that the number of students able to complete their drawings is maximal. Then print <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> on a new line. If there are multiple such IDs, select the smallest one.

#### Input Format

The first line contains a single positive integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, denoting the number of students in the class. The second line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers describing the respective amounts of time that each student needs to finish their drawings (i.e. <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1,t_2,...,t_n">).

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{t_i}\le{n}">

Subtasks
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{10^4}"> for <img src="https://latex.codecogs.com/svg.latex?\Large&space;30%"> of the maximum score.

#### Output Format

Print an integer denoting the ID number, <img src="https://latex.codecogs.com/svg.latex?\Large&space;x">, where Meera should start collecting the drawings such that a maximal number of students can complete their drawings. If there are multiple such IDs, select the smallest one.

#### Sample Input 1
```
3
1 0 0
```
#### Sample Output 1
```
2
```
#### Explanation 1

Meera's class has <img src="https://latex.codecogs.com/svg.latex?\Large&space;n=3"> students:

1. If <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=1">, then only two students will finish.<br>
The first student needs <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1=1"> extra minute to complete their drawing. If Meera starts collecting here, this student will never finish their drawing. Students <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">'s drawings are already finished, so their drawings are ready when she collects them in the second and third minutes.

2. If <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=2">, then all three students will finish.<br>
The second student needs <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_2=0"> extra minutes, so the drawing is ready for Meera to collect. The next (third) student's drawing is also ready one minute later, as <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_3=0">. Meera then proceeds to the next (first) student, who needed <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1=1"> extra minute. Because she already spent two minutes collecting the work of the other two students, the first student's drawing has already been completed for <img src="https://latex.codecogs.com/svg.latex?\Large&space;2-1=1"> minute.

3. If <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=3">, then all three students will finish.<br>
The third student needs <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_3=0"> extra minutes, so the drawing is ready for Meera to collect. The next (first) student's drawing is also ready one minute later, as <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_1=1"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> minute passed while Meera collected the third student's drawing. She then proceeds to the next (second) student, whose drawing was already completed (as <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_2=0">)

Starting with student IDs <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=2"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;x=3"> will result in a maximum number of completed drawings (i.e., <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">). Because there are two equally valid answers, we choose the smaller ID, <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">, and print it as our answer.

#### Sample Input 2
```
3
0 1 2
```
#### Sample Output 2
```
1
```

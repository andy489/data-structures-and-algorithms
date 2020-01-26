## Цикличен граф

[Judge System](https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12)

Даден е насочен граф с тегла по ребрата. Да се напише функция, която проверява дали има цикъл в графа.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой тестове следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой тестове всеки от който има: V E - брой върхове и брой ребра xi yi wi - ребро между връх xi и връх yi с тегло wi

Constraints

1 < N < 20

1< V < 1000

Output Format

за всеки граф ако има цикъл се принтира true иначе falsе, резултатите се разделят с интервал.

Sample Input 0

2
3 5
3 1 4
2 3 4
3 2 2
1 3 2
2 1 1
3 5
1 3 1
1 2 4
2 3 3
3 1 3
3 2 4

Sample Output 0

true true 


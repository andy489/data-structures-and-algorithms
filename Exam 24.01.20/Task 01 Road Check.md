## Пътна проверка

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353)

Даден ви е претеглен неориентиран граф <img src="https://latex.codecogs.com/svg.latex?\Large&space;G"> с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой върха, <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой ребра. От вас се иска да намерите дали дадена поредица от върхове <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1,x_2,...,X_n"> образува път в графа и ако да, да изведете дължината на пътя.

#### Входен формат

От първия ред на стандартния вход се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;М">. На следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;М"> реда се въвеждат по <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> числа - <img src="https://latex.codecogs.com/svg.latex?\Large&space;x,y,w">. Всеки такъв ред определя ребро с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;w">, свързващо възлите <img src="https://latex.codecogs.com/svg.latex?\Large&space;x"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;y">. На следващия ред се въвежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. На последния ред се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> на брой числа - <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1,X_2"> и т.н. до <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_K">

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<N\le{1000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<M\le{10000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<K\le{1000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{a,b,X_i}<N">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<w\le{100}">

#### Изходен формат

Ако дадената последователност от върхове образува път, то се извежда дължината му, а в противен случай <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

#### Sample Input 0
```
4 5
0 1 1
0 2 2 
2 3 5 
2 1 3
0 3 1
3
0 1 2
```
#### Sample Output 0
```
4
```

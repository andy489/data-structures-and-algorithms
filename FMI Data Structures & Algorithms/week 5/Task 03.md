## Задача 3.

Намерете дължината на най-кратъкия път през лабиринт. Лабиринта е описан с карта-матрица състояща се от нули и единици. Нулата представлява клетка в лабиринта в която може да се влезне, а единицата е препятствие (стена). Започвайки от клетката в горния ляв ъгъл, която има координати <img src="https://latex.codecogs.com/svg.latex?\Large&space;(0,0)"> трябва да се придвижите възможно най-бързо (с най-малко ходове) до клетката с координати <img src="https://latex.codecogs.com/svg.latex?\Large&space;(x_i,y_i)">, като позволените ходове са: нагоре с една позиция, надолу с една позиция, наляво с една позиция и надясно с една позииция. Ако дадена клетка има стойност <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, то нямате право да влизате или преминавате през нея.

#### Входен формат
На първия ред са дадени три числа: <img src="https://latex.codecogs.com/svg.latex?\Large&space;N{\;}M{\;}K"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой редове на матрицата<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> - брой колони на матрицата<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> - брой заявки

На всеки от следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> реда се задава всеки от редовете на матрицата, като <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> съответства на празна клетка през която може да се придвижвате, а <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> съотвества на заета клетка (препятствие).

На всеки от следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> реда ще получите двойка <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i,y_i">, която съотвества на клетката до която трябва да се придвижите с възможно най-малко стъпки.

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{5000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{5000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{x_i}<N"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{y_i}<M"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{K}\le{M*N}"><br>

**Output Format**

За всяка заявка на нов ред изведете минималния брой стъпки, за които може да се придвижите от (0, 0) до съответната клетка. Ако няма път от началната клетка до търсения изход то върнете -1.

**Sample Input 0**

```
5 5 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 1 1 0
0 0 0 0 0
4 0
4 4
```

**Sample Output 0**

```
12
8
```


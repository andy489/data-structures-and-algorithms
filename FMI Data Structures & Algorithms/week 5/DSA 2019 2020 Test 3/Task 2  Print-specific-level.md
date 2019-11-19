## Print-specific-level

[Print-specific-level](https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/print-specific-level)

Дадена ви е имплементация на двоично наредено дърво. Напишете метод, който принтира всички възли на разстояние k от корена на дървото. Изкарайте ги от дясно на ляво.

Пример:
```
   	4
       / \
      2   7     
     / \   \
    1   3   9 
```
printKDistant(1) -> 7 2

printKDistant(2) -> 9 3 1

#### Входен формат

Функцията приема като аргумент числото k - разстоянието от корена до търсените върхове.

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le">Броят на върховете в дървото<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{1000000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le">Стойността на елементите на дървото<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{1000000}">

Възможно е да няма нито един връх на разстояние <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> от корена.

#### Изходен формат

Изкарайте възлите от дясно на ляво с интервали между тях.

Примерен вход|Очакван изход
-|-
6<br>4 2 7 1 3 9<br>1|7 2 


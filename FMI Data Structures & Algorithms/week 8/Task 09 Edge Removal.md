## Премахване на ребра

[Judge System](https://www.hackerrank.com/contests/test6-sda/challenges/challenge-1761/problem)

Даден е ненасочен граф без цикли с четен брой възли. Да се намери максималният брой ребра, които може да се премахнат така че всички свързани компоненти да са с четен брой възли.

Примери за премахване на ребра с изпълняване на условието:

*Пример 1:* 

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Edge%20Removal%2001.png)

*Пример 2:* 

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Edge%20Removal%2002.png)

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;V,E"> - брой на възли и ребра. Следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;E"> реда съдържат по две числа <img src="https://latex.codecogs.com/svg.latex?\Large&space;v1"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;v2">, които показват че има ребро между двата възела.

#### Ограничения

Входа ще е коректен т.е. ще има свързан граф с четен брой възли. <img src="https://latex.codecogs.com/svg.latex?\Large&space;V<100">

#### Изходен формат

Максималният брой ребра които може да премахнем със запазване на исканото свойство.

Примерен вход|Oчакван изход
-|-
10 9<br>2 1<br>3 1<br>4 3<br>5 2<br>6 1<br>7 2<br>8 6<br>9 8<br>10 8|2

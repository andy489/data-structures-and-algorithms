## Цикличен граф

[Judge System](https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12)

Даден е насочен граф с тегла по ребрата. Да се напише функция, която проверява дали има цикъл в графа.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой тестове следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой тестове всеки от който има: <img src="https://latex.codecogs.com/svg.latex?\Large&space;V,E"> - брой върхове и брой ребра <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i,y_i,w_i"> - ребро между връх <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i"> и връх <img src="https://latex.codecogs.com/svg.latex?\Large&space;y_i"> с тегло <img src="https://latex.codecogs.com/svg.latex?\Large&space;w_i">.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<N<20">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<V<1000">

#### Изходен формат

За всеки граф ако има цикъл се принтира *true*, иначе *falsе*, резултатите се разделят с интервал.

Примерен вход|Очакван изход
-|-
2<br>3 5<br>3 1 4<br>2 3 4<br>3 2 2<br>1 3 2<br>2 1 1<br>3 5<br>1 3 1<br>1 2 4<br>2 3 3<br>3 1 3<br>3 2 4|true true

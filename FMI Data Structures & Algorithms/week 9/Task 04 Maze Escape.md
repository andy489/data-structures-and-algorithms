## Maze Escape

[Judge System](https://www.hackerrank.com/contests/practice-8-sda/challenges/maze-9)

Вие се намирате в лабиринт, от който трябва да се измъкнете възможно най-бързо. Лабиринтът е разделен на клетки (може да си го представим като матрица с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> реда и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> колони), всяка от които е или празна (‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;.">’) или е стена (‘#’). Все още не можете да минавате през стени и се налага да се придвижвате само през празните клетки, като преминаването от една клетка в друга отнема, точно 1 секунда.

Тъй като, това да излезете най-бързо от въпросният лабиринт, не би било твърде голямо предизвикателство, вие разполагате с отварачка на портали. Въпросната отварачка ви позволява да отворите портал, от клетката в която се намирате, до някоя от стените на лабиринта, до която имате пряка видимост. Тъй като това е все още ранен прототип, отварачката може да отваря портали само по права линия от текущото ви местоположение и самите портали стоят отворени само 1 секунда (т.е ако не минете през портала, а отидете в друга празна клетка, порталът се затваря).

Намерете най-краткото време за което можете да излезете от лабиринта при дадени начална клетка и изход.

#### Входен формат

На първият ред на входа се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> - броят редове и броят колони на матрицата. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> реда с по <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> символа от азбуката {‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;.">’, ‘#’, ‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;S">’, ‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;F">’}, където ‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;S">’ е началната клетка, а ‘<img src="https://latex.codecogs.com/svg.latex?\Large&space;F">’ - изхода от лабиринта.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<N,M\le{1000}">

В <img src="https://latex.codecogs.com/svg.latex?\Large&space;50%"> от тестовете <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N,M}\le{100}">.

#### Изходен формат

Изведете едно число - минималното време за достигане на изхода от лабиринта. Ако изходът е недостижим, изведете -1.

Примерен вход 0|Очакван изход 0
-|-
7 16<br>################<br>##S.....#....###<br>#####...#......#<br>#.#.....#..#####<br>#..............#<br>##.####....#.F.#<br>################|6

**Пояснение:**

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Maze%20Escape%2001.png)

Примерен вход 1|Очакван издох 1
-|-
<br>####<br>#S#.#<br>#.#.#<br>#.#F#<br>#####|-1

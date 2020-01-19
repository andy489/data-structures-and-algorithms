## Minimal Forest

[Judge System](https://www.hackerrank.com/contests/practice-9-sda/challenges/forest-1)

На входа ще получите несвързан претеглен мултиграф. Трябва да намерите тежестта на минималната покриваща гора. За всяка компонента на графа с <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> връх тази тежест е <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">. За всяка компонента с повече от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> връх тази тежест е тежестта на някое минимално покриващо дърво на компонентата.

#### Входен формат

На първият ред ще получите <img src="https://latex.codecogs.com/svg.latex?\Large&space;N,M"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N">е броят на върховете в графа. Върховете са номерирани с числа от <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N-1">.<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> е броят на ребрата.

На следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> реда ще получите <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> ребра , <img src="https://latex.codecogs.com/svg.latex?\Large&space;A,B,W">, където <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> са краищата на ребро, а <img src="https://latex.codecogs.com/svg.latex?\Large&space;W"> е тежестта му.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{20000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;M\le{20000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;W\le{1000}">

#### Изходен формат

На изхода изведете едно число - тежестта на минималната покриваща гора.

Примерен вход 0|Очакван изход 0
-|-
3 4<br>0 1 1<br>1 0 4<br>0 2 7<br>1 2 2|3

**Пояснение 0**

Всички върхове са свързани помежду си, т.е имаме <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> компонента на свързаност. За да свържем <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> върха са ни необходими <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> ребра. Най-леките ребра, които ни вършат работа са с тежест <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">. <img src="https://latex.codecogs.com/svg.latex?\Large&space;1+2=3">.

Примерен вход 1|Очакван изход 1
-|-
5 4<br>0 1 5<br>2 3 1<br>2 4 1<br>4 3 10|7

**Пояснение 1**

Графът има <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> компоненти на свързаност: <img src="https://latex.codecogs.com/svg.latex?\Large&space;0-1,2-3-4">. Минималната тежест на покриващо дърво за <img src="https://latex.codecogs.com/svg.latex?\Large&space;0-1"> е <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">, а за <img src="https://latex.codecogs.com/svg.latex?\Large&space;2-3-4"> е <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;5+2=7">.

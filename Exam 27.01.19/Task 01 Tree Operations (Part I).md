## Дървесни операции

[Judge System](https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/challenge-1795)

Напишете следните функции за двоично наредено дърво:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;void{\;}add(int{\;}X)"> - добавя елемент в двоично наредено дърво (ако елемента вече съществува в дървото то дървото не се променя). Не принтира нищо на стандартният изход.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;void{\;}print()"> - извежда на стандартният изход дървото в последователност *корен-ляво-дясно* разделена с интервали

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой операции които ще бъдат подадени

Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> операции всяка от която на нов ред (операцията се дава с името си и ако има входен параметър например: ***add число, print***)

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<N<2.10^5">

#### Изходен формат

На стандартният изход се очаква да се принтира поредица от числа спрямо изхода от изпълнените операции. (Всичко се принтира на един ред, като всички числа са разделени с интервали)

Примерен вход|Очакван изход
-|-
5<br>add 2<br>add 5<br>add 5<br>add 1<br>print|2 1 5

## Дървесни операции втора част

[Judge System](https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/challenge-1796)

Използвайте вече написаните функции <img src="https://latex.codecogs.com/svg.latex?\Large&space;add"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;print"> и добавете следните нови функции:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;void{\;}remove(int{\;}X)"> - ако в дървото имаме елемент <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> го изтрива (запазвайки структурата наредено двоично дърво. Упътване: ако възела няма наследник просто се премахва, ако има само един наследник то той отива на негово място, а ако има два наследника тогава се търси най-малкият по-голям от него). Не принтира нищо на стандартният изход.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;void{\;}print_odd_layers()"> - принтира елементите на дървото от нечетните му нива започвайки от корена и продължавайки с ниво <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, ниво <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> и т.н. (елементите от четните нива се прескачат)

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой на операциите. Следват имената на операциите като аргументите са разделени с интервал

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<N<2.10^5">

#### Иходен формат

Изход спрямо изпълнените операции

Примерен вход 0|Очакван изход 0
-|-
5<br>add 2<br>add 2<br>add 1<br>remove 2<br>print|1 

Примерен вход 0|Очакван изход 0
-|-
8<br>add 1<br>add 2<br>add 4<br>add 6<br>add 7<br>add 5<br>print_odd_layers<br>print|1 4 5 7 1 2 4 6 5 7

## Графици

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2274)

Помогнете за валидиране на графици за командосите от Командоленд.

Счетоводният отдел иска да може да вкара множество от интервали (начало на мисия, край на мисия за командос) и след това да провери за конкретна милисекунда колко командоси са били в това време на мисия.

Всички записи имат уникално начало(няма два интервала които започват едновременно). При проверка ако числото съвпада с началото или края на интервала се счита, че е в интервала.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;n,q"> - брой интервали и брой заявки

<img src="https://latex.codecogs.com/svg.latex?\Large&space;start_i,end_i"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> на брой интервала разделени с празномясто

<img src="https://latex.codecogs.com/svg.latex?\Large&space;q_j"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> на брой милисекунди за които да се провери колко интервала имат тази милисекунда

#### ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<n<100,000"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<q<100,000"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{start_i}\le{start_i}\le{100,000,000}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<q_j<100,000,000">

#### Изходен формат

За всяка заявка се извежда число показващо броя на командосите в мисия в конкретният момент.

Примерен вход|Очакван изход
-|-
5 5<br>12 13 15 34 3 14 13 27 16 31<br>20 36 25 35 2|3 0 3 0 0

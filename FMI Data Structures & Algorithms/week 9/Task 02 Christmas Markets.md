## Коледни базари

[Judge System](https://www.hackerrank.com/contests/practice-8-sda/challenges/challenge-2303)

Тази година сте решили, че искате да обикаляте коледните базари по света. Разполагате със самолетни билети за градове с коледни базари, като формата на всеки билет е <img src="https://latex.codecogs.com/svg.latex?\Large&space;CITY1{\;}CITY2">. Въпреки че Коледния дух ви е обзел напълно, вие все пак сте здраво стъпили на земята и знаете, че е хубаво после да можете да се върнете от мястото, от което сте започнали. Ако знаете, че започвате пътешествието си от град <img src="https://latex.codecogs.com/svg.latex?\Large&space;X">, покажете примерен план за пътуване, който да ви върне обратно в стартовия град.

#### Входен формат

На първия ред на стандартния вход ще получите <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> числа: <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броя различни градове, до или от които имате билети и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">, броя на билетите, които имате.

На следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> реда ще получите по <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> низа - името на градовете от и до които е полета.

На последия ред на стандартния вход ще получите низ <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> - стартовия град, за който трябва да отговорите дали можете да се върнете.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{5.10^5}">

Името на всеки град е дадено с низ с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{4}"> символа.

#### Изходен формат

На единствения ред на стандартния изход изведете пътя, който трябва да следвате, за да се върнете в началния град. Ако има повече от един такъв път, изведете някой от тях. Ако няма такъв път, изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

Примерен вход|Очакван изход
-|-
7 10<br>SOF LON<br>SOF PAR<br>PAR LSA<br>LON NYC<br>NYC SYD<br>SYD TOK<br>TOK PAR<br>PAR TOK<br>NYC SOF<br>SOF TOK<br>LON|LON NYC SOF LON

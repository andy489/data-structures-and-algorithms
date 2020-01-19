## BDZ

[Judge System](https://www.hackerrank.com/contests/practice-8-sda/challenges/bdz)

Дойде време за празници и всички започнаха да си тръгват от София чрез любимото БДЖ. За да са по-ефективни, БДЖ решили да направят всички влакове да са еднопосочни и да няма циклични линии - така ще могат влаковете да са съсредоточени върху изкарването на хората от София. Градовете, които имат спирки, са <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой и са номерирани с числата от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, а БДЖ има <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой линии между тях. В един такъв момент човек си задава логичния въпрос - "По колко начина мога да стигна от град <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> до град <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">?" Напишете програма, която по дадени начален и краен град, намира броят на възможните пътища, започвайки от началния и завършвайки в крайния град.

#### Входен формат

На първия ред на входа се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> - броят градове и броят линии. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> реда с по две числа - еднопосочна линия на БДЖ между два града. На последния ред има две числа - началния и крайния град.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{2.10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{start,end}\le{N}">
- Гарантирано е, че няма цикъл.

#### Изходен формат

Изведете едно число - броят различни пътища от началния до крайния град. Тъй като това число може да е прекалено голямо, изведете остатъка му по модул <img src="https://latex.codecogs.com/svg.latex?\Large&space;1000000007">.

Примерен вход 0|Очакван изход 0
-|-
4 6<br>2 1<br>4 3<br>1 3<br>4 1<br>2 3<br>2 4<br>2 3|4

**Пояснение 0**

Различните пътища от <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> са:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{3}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{4}\rightarrow{3}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{4}\rightarrow{1}\rightarrow{3}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{1}\rightarrow{3}">

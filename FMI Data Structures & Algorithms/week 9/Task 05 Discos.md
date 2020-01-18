## Дискотеки

[Judge System](https://www.hackerrank.com/contests/practice-8-sda/challenges/discos)

Иванчо е кореняк софиянец. Като такъв, на него често му се налага да отговаря на приятелите си от провинцията на следния въпрос - “На какво разстояние е най-близката дискотека до общежитието ми в студентски град?”. Тъй като на него му писна да отговаря на този въпрос, той реши да напише програма, която изчислява това.

Общежитията на приятелите на Иванчо, както и дискотеките, са общо <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой и са номерирани с числата от <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N-1">. Можем да представим върховете като две множества - на общежитията и на дискотеките, като броят на дискотеките е <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. Иванчо има <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой сведения за **двупосочни** пътища между двойка обекти и техните дължини.

Напишете програма, която отговаря на <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> заявки. За всяка заявка получавате връх от множеството на общежитията. Вие трябва да отговорите колко е разстоянието до най-близката дискотека(връх от множеството на дискотеките).

#### Входен формат

На първият ред на входа се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> - броят обекти и броят на известните на Иванчо пътища между тях. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> реда с по <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> числа на ред - двойка обекти и разстоянието между тях.

От следващия ред се въвежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;K">. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> на брой числа - номерата на дискотеките.

От следващия ред се въвежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q">. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда с po <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> число на ред - текущото местоположение на обадилия се човек (номера на общежитието му).

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{3.10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{K}<{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{10^5}">
- В <img src="https://latex.codecogs.com/svg.latex?\Large&space;20%"> от тестовете <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q=1">
- В други <img src="https://latex.codecogs.com/svg.latex?\Large&space;20%"> от тестовете <img src="https://latex.codecogs.com/svg.latex?\Large&space;K=1">

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда с по <img src="https://latex.codecogs.com/svg.latex?\Large&space;q"> число на ред - разстоянието до най-близката дискотека от обадилия се човек.

Примерен вход|Очакван изход
-|-
6 8<br>0 1 1<br>1 2 2<br>1 3 6<br>0 4 5<br>1 4 7<br>1 5 8<br>3 5 2<br>4 5 2<br>2<br>4 5<br>4<br>0<br>1<br>2<br>3|5<br>6<br>8<br>2

**Пояснение**

Отговаряме на <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> заявки - за върховете <img src="https://latex.codecogs.com/svg.latex?\Large&space;0,1,2,3">.

Най-късият път от върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> до дискотека е <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\rightarrow{4}"> с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;5">.

Най-късият път от върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до дискотека е <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\rightarrow{0}\rightarrow{4}"> с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">.

Най-късият път от върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> до дискотека е <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\rightarrow{1}\rightarrow{0}\rightarrow{4}"> с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;8">.

Най-късият път от върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> до дискотека е <img src="https://latex.codecogs.com/svg.latex?\Large&space;3\rightarrow{5}"> с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.

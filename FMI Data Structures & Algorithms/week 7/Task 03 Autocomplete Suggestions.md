## Autocomplete Suggestions

[Judge System](https://www.hackerrank.com/contests/practice-7-sda/challenges/autocomplete-19-1)

Трябва да имплементирате една от най-важните функции на търсачките - <img src="https://latex.codecogs.com/svg.latex?\Large&space;\boxed{Autocomplete}">. Например когато пишете думи в <img src="https://latex.codecogs.com/svg.latex?\Large&space;Goodle">, техният <img src="https://latex.codecogs.com/svg.latex?\Large&space;\boxed{Autocomplete}"> ви предлага някакви възможности, базирани на написаното до момента.

За целта ви е даден речник с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой популярни думи - знаете, че тези думи са често търсени от потребителите и съответно трябва да ги предлагате, когато е възможно. Напишете програма, която да може бързо да намира по дадено начало на дума колко от думите от речника я autocomplete-ват (т.е на колко думи от речника е префикс).

Ще трябва да отговаряте на <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> на брой заявки. Всяка заявка се състои от един низ - начало на дума. Програмата ви трябва да намери колко от думите в речника започват с дадения префикс.

#### Входен формат

Първия ред на входа съдържа числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> - съответно броят на думите в речника и броят на заявките.

На следващия ред има <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> низа - всички думи от речника.

Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда с по един низ - префиксът за който се търсят броят думи, които го autocomplete-ват.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{200000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{200000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le"> дължина на дума от речника <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{20}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le"> дължина на префикс <img src="https://latex.codecogs.com/svg.latex?\Large&space;\le{20}">

Думите и префиксите се състоят само от малки латински букви.

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда с по едно число за всеки префикс - съответно броят думи от речника, които го autocomplete-ват.

Примерен вход|Очакван изход
-|-
4 5<br>baba banica boza ba<br>b<br>ba<br>ban<br>bi<br>a|4<br>3<br>1<br>0<br>0

## Tunnel Maps

[Judge System](https://www.hackerrank.com/contests/practice-8-sda/challenges/tunnel-maps)

Всеобща заблуда е че дядо Коледа се придвижва чрез летяща шейна. За да не бъде забелязан, той, всъщност се придвижва чрез мрежа от еднопосочни подземни тунели, като използва известното приложение tunnel maps, за да се ориентира. Въпросната мрежа се състои от <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> кръстовища, свързани помежду си с <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> тунела.

Сега дядо Kоледа планира как ще стигне до къщата на Иван, за да му занесе дългоочаквания подарък. Проблемът е, че той не може да обикаля из тунелите твърде дълго, защото ще му падне батерията на телефона и ще се изгуби. Другият проблем на дядо Коледа е, че както всички знаят, той, не е много елегантен и ще му е невъзможно да мине през някои от по-тесните тунели. Той ще тръгне от кръстовище с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, а къщата на Иван се намира на кръстовище с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">.

Помогнете на Дядо Коледа като му кажете колко най-малко трябва да отслабне, за да може да стигне до къщата на Иван преди да му падне батерията не телефона, ако знаете колко време отнема да се премине всеки от тунелите и с колко килограма трябва да отслабне дядо Коледа, за може да мине през него.

#### Входен формат

От първият ред се въвеждат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> - броят кръстовища, броят тунели и времето което издържа батерията на телефона.

От следващите М реда се въвеждат по <img src="https://latex.codecogs.com/svg.latex?\Large&space;4"> числа: <img src="https://latex.codecogs.com/svg.latex?\Large&space;u">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;v">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;c"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;t"> - съответно кръстовищата, които са свързани от тунела, килограмите които дядо Коледа трябва да свали, за да може да мине и времето, което отнема да бъде преминат.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{M}\le{3.10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{u}\neq{v}\le{N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{c},t,K\le{10^6}">

#### Изходен формат

Изведете едно число - колко най-малко килограма трябва да остслабне дядо Коледа, за да може да стигне до къщата на Иван. Ако колкото и килограми да свали, дядо Коледа, не може да стигне за необходимото време, изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">.

Примерен вход 0|Очакван изход 0
-|-
7 11 42<br>1 3 7 11<br>3 1 7 13<br>1 2 3 3<br>1 4 13 1<br>6 1 14 8<br>4 6 1 7<br>2 4 1 13<br>2 6 4 20<br>3 5 2 5<br>5 6 6 4<br>6 7 5 20|7

**Пояснение 0**

Оптималният път е <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-3-5-6-7">: дядо Коледа трябва да свали <img src="https://latex.codecogs.com/svg.latex?\Large&space;7">кг и ще го измине за <img src="https://latex.codecogs.com/svg.latex?\Large&space;40"> минути.

Примерен вход 1|Очакван изход 1
-|-
2 2 3<br>1 2 3 5<br>1 2 1 9|-1

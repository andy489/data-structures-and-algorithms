## Намиране на елемент

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/find-element-sda)

Даден ви е сортиран масив с <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> целочислени елемента. Ще трябва да отговаряте на много на брой заявки от вида - съдържа ли се елементът <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> в масива. Ако елемента се съдържа, трябва да изведете първата и последната позиция на елемента, а ако не се съдържа - на коя позиция ще застане, ако се добави в сортираната последователност. Позициите са индексирани от <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">.

#### Входен формат

Първия ред съдържа числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броят на елементите в масива.<br>
На вторият ред се намират елементите на масива <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_i,i=\overline{1,N}">.<br>
На следващия се съдържа числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> - броят на заявките, на които ще трябва да отговаряте.<br> 
Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда с по едно число на ред - числото, отговарящо на текущата заявка.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{100000}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{200000}">
<img src="https://latex.codecogs.com/svg.latex?\Large&space;-10^9\le{X_i}\le{10^9}">
-10^9 ≤ елементите на масива, числата от заявките ≤ 10^9

Елементите на масива и числата от заявките могат да се повтарят.

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда със съответно едно или две числа на ред - отговорите на всички заявки.

Примерен вход|Очакван изход
-|-
6<br>1 1 3 5 5 7<br>6<br>1<br>0<br>3<br>5<br>6<br>10|0 1<br>0<br>2 2<br>3 4<br>5<br>6

*Пояснение*

Отговаряме на <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> заявки - за числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;1,0,3,5,6,10">.

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> се среща в масива като първото му срещане е на позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">, а последното - на позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">.
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> не се среща в масива, ако се добави ще застане точно в началото на масива - на позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;0">.

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> се среща <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> път в масива, съответно първото и последното му срещане са на позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;5"> се среща в масива, първото и последното срещане са му съответно на позиции <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;4">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;6"> не се среща и ако се добави ще застане точно след втората петица - на позиция 5<img src="https://latex.codecogs.com/svg.latex?\Large&space;5">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;10"> не се среща и при добавяне ще застане накрая на масива - позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;6">.

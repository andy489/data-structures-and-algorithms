## Задача 3.

Дадено е двоично дърво с корен връх <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">. Операцията <img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(i,k)"> връща <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">-тия предшественик на върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">, като <img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(i,0)=i,{\;}pred(i,1)=parent(i),{\;}pred(i,2)=parent(parent(i))"> и т.н. По зададеното двоично дърво и множество от заявки <img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(i,k)">, за всяка заявка на нов ред изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">-тия предшественик на върха <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">.

#### Входен формат

На първия ред е зададено числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броя на върховете в дървото. На всеки от следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;N-1"> реда е зададена двойка <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_j,y_j"> съотвестваща на ребро в дървото, като върховете са номерирани с числата от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. На следващия ред е зададено числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> - броя на заявките. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда, като на всеки ред е зададена двойката <img src="https://latex.codecogs.com/svg.latex?\Large&space;i{\;}k">, за която трябва да изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(i,k)">.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{500000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{Q}\le{500000}"><br>

<img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(i,k)"> винаги ще съществува (тоест <img src="https://latex.codecogs.com/svg.latex?\Large&space;k\le{depth(i)}">

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда, като <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия ред трябва да съдържа отговора на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тата заявка.

Примерен вход|Очакван изход|Обяснения
-|-|-
7<br>1 2<br>1 7<br>2 5<br>2 6<br>4 6<br>3 6<br>3<br>6 2<br>4 2<br>7 1|1<br>2<br>1|<img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(6,2)=parent(parent(6))=parent(2)=1"><br><img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(4,2)=parent(parent(4))=parent(6)=2"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;pred(7,1)=parent(7)=1">

![image](assets/1542735573-c76d881c19-tree.png)







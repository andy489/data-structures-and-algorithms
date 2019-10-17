## Задача 6.

Иван играе на любимата си компютърна игра. За съжаление има затруднения с преминаването на едно от последните нива и се нуждае от вашата помощ. Нивото се състои от множество чудовища намиращи се на голяма платформа. Иван трябва да премахне всички чудовища, като използва своя бластер, който му позволява да унищожи всички чудовища на дадена позиция. Бластера е толкова мощен, че избутва всички останали чудовища с <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> единици разстояние от мястото на взрива. Тъй като началото на платформата е голяма пропаст, то Иван може да се отърве от чудовищата и като ги избута в пропастта с помощта на бластера. Вашата задача е да помогнете на Иван да премине нивото с възможно най-малък брой използвания на бластера. 

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Monster%20World%2001.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Monster%20World%2002.png)

На горния п<img src="https://latex.codecogs.com/svg.latex?\Large&space;X">ример бластера е използван на позиция **5**, а стойността на <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> e **2**.

## Входен формат
<img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> - брой чудовища;<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> - разстоянието, на което бластера избутва чудовищата от центъра на взрива;<br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;s_i"> - позицията, на която се намира <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тото чудовище<br>

На първия ред ще получите числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;X">. На втория ред ще получите числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;s_i">. Всички числа ще са разделени с един интервал.

## Ограничения
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{2\cdot{10^5}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{X}\le{2\cdot{10^5}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{s_i}\le{{10^6}}">
## Изходен формат

Изведете числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;y">- минималният брой използвания на бластера, нужни за преминаването на нивото.

Примерен вход|Oчакван изход
-|-
3 2<br>1 3 5|2
4 1<br>5 2 3 5|2
4 2<br>5 3 1 6|2

## Green School

[Judge System](https://www.hackerrank.com/contests/sda-2019-2020-test-5/challenges/challenge-2299)

Учениците от 777 СОУ имат възможност да спечелят почивка на зелено училище през коледната ваканция ако успеят да отговорят на въпроса: „Кои са градовете на разстояние точно <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> от тях?“ Помогнете им да си починат с написването на програма, която пресмята това вместо тях.

Разстоянието се изчислява по брой градове през които се минава, като първият град не се брои, а последният се брои. Не е позволено да се минава през един град повече от веднъж. Ако има път от град <img src="https://latex.codecogs.com/svg.latex?\Large&space;A"> до град <img src="https://latex.codecogs.com/svg.latex?\Large&space;B">, то има път и от град <img src="https://latex.codecogs.com/svg.latex?\Large&space;B"> до град <img src="https://latex.codecogs.com/svg.latex?\Large&space;A">. Ако има пътища с различни дължини от град до град то разстоянието между двата града е равно на най-късият път между тях.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой градове

<img src="https://latex.codecogs.com/svg.latex?\Large&space;М"> - брой на пътища между два града които ще бъдат подадени

<img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> - търсено разстояние

<img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i,x_j"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> на брой двойки, указващи че има път между двата града

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{N}\le{M}\le{100,000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{К}\le{N-1}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x_i}\le{N}">

#### Изходен формат

Сортиран в нарастващ ред списък от градовете на разстояние <img src="https://latex.codecogs.com/svg.latex?\Large&space;k">. Ако няма градове на търсеното разстояние се извежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">. Града от който тръгват учениците е града с най-голям номер.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Green%20School%2001.png)

Примерен вход|Очакван изход
-|-
5 6 2<br>1 2<br>2 5<br>1 3<br>3 5<br>3 4<br>4 5|1 


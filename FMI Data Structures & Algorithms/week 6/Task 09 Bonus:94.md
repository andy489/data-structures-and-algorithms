#### Bonus: 94
Difficulty: Medium to Hard. Author: Petko Mitkov
[Bonus: 94 Judge System](https://www.hackerrank.com/contests/practice-6-sda/challenges/94)

Студентите от СИ нямат търпение да посетят ежеседмичната лекция по СДА. Те все още са в Студентски Град и ще използват автобус 94 за да се придвижат до ФМИ. Бивайки лоши хора, асистентите са забранили да има повече от един студент в даден автобус за да се избегне подсказване за домашното. В студентски град има <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> спирки, като за всяка от тях знаете позицията ѝ <img src="https://latex.codecogs.com/svg.latex?\Large&space;y_i">, както и времето <img src="https://latex.codecogs.com/svg.latex?\Large&space;t_i">, когато автобус 94 ще спре на нея(само един автобус 94 ще спре на дадена спирка и на всяка спирка спира различен автобус). Студентите от СИ са <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> на брой и за всеки от тях знаете неговата първоначална позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i">. Студентите могат да се придвижват с една единица разстояние напред и назад по маршрута за единица време. Даден студент може да хване автобус на дадена спирка, ако стигне дотам преди автобуса да е спрял(и потеглил). Ако на спирката има повече от един студент, само един от тях може да се качи.

От вас се иска да намерите колко най-много студенти ще успеят да посетят лекцията.

#### 

- На първия ред са зададени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> - брой студенти
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> - брой спирки

- Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> реда, като всеки ред съответства на позиция <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i"> на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия студент.
- Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> реда, като всеки ред съдържа две числа съответсващи на позицията на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тата спирка и времето, в което автобуса тръгва от спирката

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{2*10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{2*10^5}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{x_i}\le{10^9}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{y_i}\le{10^9}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{t_i}\le{10^9}">

#### Изходен формат

На един ред изведете максималния брой студенти, които могат да се качат на автобусите.

Примерен вход|Очакван изход
-|-
4 3<br>1<br>3<br>5<br>6<br>2 1<br>4 3<br>7 2|3

Обяснение

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Bonus%2094%2001.png)

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Bonus%2094%2002.png)

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Bonus%2094%2003.png)

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Bonus%2094%2004.png)

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Bonus%2094%2005.png)

Примерен вход|Очакван изход
-|-
2 2<br>1<br>10<br>2 10<br>3 2|2


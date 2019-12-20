## Text Contents

[Judge System](https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents)

Иван много обича да прави статистически проучвания. Напоследък интересът му е концентриран върху изследването на различни текстове и съдържанието им. За да си изгради представа за даден текст, той се интересува от най-често срещаните думи в него. Помогнете му като напишете програма, която определя коя е най-често срещаната дума в дадент текст която има дължина точно K символа. За дума в текста ще приемаме всяка последователност от <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> символа, срещанията на дадена думата се броят за различни дори да се застъпват.

#### Входен формат

На първия ред се въвеждат числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> - дължината на текста и дължината на думата. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой символа - въпросния текст.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N}\le{1,000,000}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{K}\le{N}">

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> на брой символа - най-често срещаната дума в текста с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;К">, ако има няклко такива извдете тази която се среща последна в текста.

Примерен вход|Очакван изход
-|-
10 3<br>bababaabab|bab
10 1<br>b  c.b b.a|b

*Пояснение за първия пример:*
```
Думата bab се среща 3 пъти: bababaabab
                            |||    |||
                              |||
```
*Пояснение за втория пример:*
```

Думата b се среща 3 пъти: b  c.b b.a
                          |    | |
```

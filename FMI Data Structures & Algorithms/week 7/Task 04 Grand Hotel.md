## Grand Hotel

[Judge System](https://www.hackerrank.com/contests/practice-7-sda/challenges/grand-hotel)

Алекс планира обира на най-големият хотел в Алгоритмия - Grand Hotel. Хотела се състои от <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> на брой стаи, като Алекс предварително е избрала реда в който ще премине през стаите. Тя е избрала реда по такъв начин, че между стая <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;i+1"> винаги има врата през която тя да премине. За нейно съжаление тези врати са заключение, но Алекс знае че вратата между стаи <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;i+1"> се отваря с ключ номериран <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> (един ключ може да се използва само веднъж). Тя също така знае, че в стая <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> има скрит ключ номериран <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_i">, който тя ще вземе по време на обира. Алекс осъзнава, че може да се окаже заключена в дадена стая и обира да се провали. Затова тя е наела ключар, който може да й изработи ключове с произволни номера. Тъй като ключовете са много скъпи вие трябва да помогнете на Алекс като и кажете колко най-малко ключа трябва да бъдат изработени от ключаря за да бъде успешен обира.

#### Входен формат

На първия ред е зададено числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> - броя на стаите. Алекс започва обира от първата стая. Следват два реда. На първия ред са зададени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;b_i"> - ключа намиращ се в стая <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">. На втория ред са зададени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> - ключа необходим за отваряне на врата между стая <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;i+1">.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{5*10^6}">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i}\le{10^9}">

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{b_i}\le{10^9}">

#### Изходен формат

На единствен ред изведете минималният брой ключове, които ключаря трябва да изработи за да бъде успешен обира.

Примерен вход|Очакван изход
-|-
5<br>1 2 3 10<br>2 1 3 3|2

*Пояснение на примера:*

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Grand%20Hotel%2001.png)

Алекс казва на ключаря да й направи два ключа с номера 2 и 3.

- Тя започва обира от първата стая където намира ключ с номер 1. Ключовете, което има са с номера 1, 2 и 3.

- Откючва първата врата с ключ номер 2 и отива в другата стая където намира ключ с номер 2. Сега ключовете, които има са с номера 1, 2 и 3.

- Отключва втората врата с ключ номер 1 и отива в другата стая където намира ключ с номер 3. Сега ключовете, които има са с номера 2, 3 и 3.

- Отключва третата врата с ключ номер 3 и отива в другата стая където намира ключ с номер 10. Сега ключовете, които има са с номера 2, 3 и 10.
    
- Отключва четвъртата и последна врата с ключ номер 3 и отива в последната стая, с което обира се смята за успешен.

Може да се убедите, отговор по-малък от 2 е невъзможен.

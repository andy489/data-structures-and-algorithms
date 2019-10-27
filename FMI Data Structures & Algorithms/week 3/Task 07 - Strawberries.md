## Задача 7.

[Challenges](https://www.hackerrank.com/contests/practice-3-sda/challenges)

Цвети е на СДА. Асистентите са донесли n купички с ягоди, като в купичка с номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> има <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> ягоди. Всички ягоди са номерирани с последователни числа: в първата купичка ягодите били номерирани от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_1">, във втората - от <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_1+1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_1+a_2"> и така нататък.

Асистентите са измислили състезание: те казват номер на някоя вкусна ягода, а който първи познае в коя купичка се намира ягодата, я получава.

Цвети обожава ягоди и иска да изяде всички. Помогнете й!

## Входен формат

Първият ред от стандартния изход съдържа числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> - броя на купичките.

На следващия ред следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> числа - <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_1,a_2,...,a_n"> където <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_i"> e броят ягоди в <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тата купичка.

Третият ред съдържа числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> - броя на вкусните ягоди, посочени от асистентите.

На четвъртия ред имаме m числа - <img src="https://latex.codecogs.com/svg.latex?\Large&space;q_1,q_2,...,q_n"> - номерата на вкусните ягоди.

# Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{100000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{100000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i}\le{10^9}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{q_i}\le{a_1+a_2+...+a_n}"><br>

## Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> реда на стандартния изход. Ред номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;i"> съдържа номера на купичката в която се намира ягода номер <img src="https://latex.codecogs.com/svg.latex?\Large&space;q_i">.

Примерен вход|Oчакван изход|Пояснение
-|-|-
5<br>2 7 3 4 9<br>3<br>1 25 11|1<br>5<br>3|Първата купичка съдържа ягодите с номера 1 и 2, втората - ягодите с номера 3,4,5,6,7,8,9 и така нататък. Така получаваме, че първата ягода е в първата купичка, 25-тата в петата, а 11-тата - в третата. 

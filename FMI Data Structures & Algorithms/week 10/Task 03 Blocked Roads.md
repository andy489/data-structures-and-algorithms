## Blocked Roads

[Judge System](https://www.hackerrank.com/contests/practice-9-sda/challenges/roads-5)

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N">-те населени места на един район, номерирани от <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> до <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">, са свързани с пътища. След като паднал сняг, останали проходими само <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> пътни отсечки, всяка от които свързва две от населените места. Изнервени граждани, които пътуват от едно населено място до друго – по работа, или просто така, атакуват многократно операторите на телефон 112 с въпроси от вида „Може ли да се стигне от селището <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> до селището <img src="https://latex.codecogs.com/svg.latex?\Large&space;Y"> в момента?“ От своя страна, почистващите служби успяват от време на време да почистят по някой от затрупаните пътища и също звънят на оператора на 112 с информация от рода: „Пътната отсечка от селището <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> до селището <img src="https://latex.codecogs.com/svg.latex?\Large&space;Y"> е проходима.“

Напишете програма, която да помага на операторите да отговарят бързо на въпросите на гражданите за актуалното състояние на пътищата.

#### Входен формат

На първия ред на стандартния вход ще бъдат зададени числата <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">. На всеки от следващите <img src="https://latex.codecogs.com/svg.latex?\Large&space;M"> реда – по два номера на град, свързани с проходима пътна отсечка.

Следва ред с броя <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> на обажданията – както от граждани, така и от пътните служби и <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q"> реда със съдържанието на обажданията – вид на обаждането и двата номера на населените места, за които се отнася съответното обаждане. Ако обаждането е въпрос на гражданин – кодът е <img src="https://latex.codecogs.com/svg.latex?\Large&space;1">, а ако е от пътните служби – кодът е <img src="https://latex.codecogs.com/svg.latex?\Large&space;2">.

#### Ограничения

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{1000}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;M\le{2N}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;Q\le{10^6}">

#### Изходен формат

На стандартния изход програмата трябва да изведе битов низ с толкова знака, колкото са въпросите на граждани за проходимост на пътната мрежа, като знакът <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> означава че отговорът на поредния въпрос е „Невъзможно е да се стигне!“, а знакът <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> – „Възможно е!“.

Примерен вход|Очакван изход
-|-
9 8<br>1 2<br>3 4<br>5 6<br>7 8<br>9 5<br>7 2<br>8 2<br>6 9<br>6<br>1 1 8<br>1 6 2<br>2 7 1<br>1 4 7<br>2 2 3<br>1 4 7|1001

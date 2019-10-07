## Задача 2.

Получавате като вход число <img src="https://latex.codecogs.com/svg.latex?\Large&space;N">. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> числа, които трябва да ги прочетете и съхраните в собственоръчно написан *свързан списък*. Следва число <img src="https://latex.codecogs.com/svg.latex?\Large&space;P">. Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;P"> числа на нов ред. (*тях може да съхраните по начин който е най-удобен за вас*).

От вас се изисква да върнете броя на различните двойки елементи ( *(1,2) и (2,1) е една и съща двойка* ), които се срещат в масива <img src="https://latex.codecogs.com/svg.latex?\Large&space;P"> и са съседи във вашият свръзан списък.

#### Входен формат
Число <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> ( размер на вашият свързан списък )<br>
Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> числа.<br>
Число <img src="https://latex.codecogs.com/svg.latex?\Large&space;P">.<br>
Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;P"> числа. 
(*Важно! Тези P числа може да се съхраняват в каквато структура прецените за добре, без да я имплементирате. Т.е. може да я ползвате на готово от стандартни/вградени библиотеки.*)

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;N\le{1000000}"><br>
Всеки един елемент е между <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N_i}\le{1000000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;P\le{3000}"><br> 
Всяко едно число <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{P_i}\le{1000000}"> 

#### Изходен формат
Число <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> броят на двойките които удовлетворяват условието.

Примерен вход|Очакван изход|Пояснениe
-|-|-
4<br>1 2 3 4<br>5<br>6 1 2 3 4|3|1->2->3->4 (1->2, 2->3, 3->4 като числата 1,2,3,4 се срещат в *P*)


  


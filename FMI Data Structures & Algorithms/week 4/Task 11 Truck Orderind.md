## Truck Ordering

Победителите от FMI codes: Code for Automation са решили да демонстрират най-новите открития в автономните системи - самоуправляващи се камиони. За целта искат <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> камиона да минат в определен ред пред ФМИ (Първият камион е отбелязан с номер 1, вторият с номер 2 и тн.).

Камионите са пристигнали, но в разбъркан ред и организаторите се чудят дали могат да ги подредят. До събитието почти няма време и за да ги подредят могат да използват само последната останала пресечна улица по пътят им до ФМИ. Въпросната улица позволява само на последния влязъл в нея камион да излезе, понеже е задънена и твърде тясна за разминаване, за сметка на това е достатъчно дълга да побере всички камиони ако се налага.

Ако камионите са пристигнали в реда: 5 1 2 4 3, то тогава ще могат да бъдат подредени използвайки трясната уличка по следният начин:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2001.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2002.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2003.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2004.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2005.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2006.png)

Погмогнете на организаторите като им кажете дали ще могат да подредят камионите в необходимия за събитето ред.

#### Входен формат

На първият ред се въвежда <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> - брой заявки.

На първият ред от всяка заявка се въвежда числото <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - броя камиони.

Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой числа - реда в който идват камионите.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;A_0,A_1,...,A_{N-1}-A_i"> e номера на <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-тия пристигнал камион.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{10}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{N}\le{10^5}">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{A_i}\le{N}">

#### Изходен формат

Изведете <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> на брой реда.

На всеки от редовете извдете отговора на поредната заявка - "yes" ако е възможно да се подредят камионите или "no" в противен случай.

Примерен вход| Очакван изход
-|-
2<br>5<br>5 1 2 4 3<br>5<br>3 2 4 5 1|yes<br>no


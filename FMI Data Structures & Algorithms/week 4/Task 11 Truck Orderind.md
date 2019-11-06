Победителите от FMI codes: Code for Automation са решили да демонстрират най-новите открития в автономните системи - самоуправляващи се камиони. За целта искат N камиона да минат в определен ред пред ФМИ (Първият камион е отбелязан с номер 1, вторият с номер 2 и тн.).

Камионите са пристигнали, но в разбъркан ред и организаторите се чудят дали могат да ги подредят. До събитието почти няма време и за да ги подредят могат да използват само последната останала пресечна улица по пътят им до ФМИ. Въпросната улица позволява само на последния влязъл в нея камион да излезе, понеже е задънена и твърде тясна за разминаване, за сметка на това е достатъчно дълга да побере всички камиони ако се налага.

Ако камионите са пристигнали в реда: 5 1 2 4 3, то тогава ще могат да бъдат подредени използвайки трясната уличка по следният начин:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2001.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2002.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2003.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2004.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2005.png)
![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Truck%20Ordering%2006.png)

Погмогнете на организаторите като им кажете дали ще могат да подредят камионите в необходимия за събитето ред.

Input Format

На първият ред се въвежда T - брой заявки.

На първият ред от всяка заявка се въвежда числото N - броя камиони.

Следват N на брой числа - реда в който идват камионите.

А0, А1, ..., АN-1 - Ai e номера на i-тия пристигнал камион.

Constraints

1 <= T <= 10

0 <= N <= 10^5

1 <= Ai <= N

Output Format

Изведете Т на брой реда.

На всеки от редовете извдете отговора на поредната заявка - "yes" ако е възможно да се подредят камионите или "no" в противен случай.

Sample Input 0

2
5
5 1 2 4 3
5
3 2 4 5 1

Sample Output 0

yes
no


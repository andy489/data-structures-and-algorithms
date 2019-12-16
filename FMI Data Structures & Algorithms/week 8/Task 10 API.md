## Агенция пътна инфраструктура

[Judge System](https://www.hackerrank.com/contests/test7-sda-soft-eng/challenges/challenge-1771/problem)

Във връзка с въвеждането на тол таксите за пътищата във България, агенция пътна инфраструктура (АПИ) иска максимално честно да изчисли каква да е таксата за минаване по различните пътища. От вас се иска да и помогнете да намери каква е май-често срещаната дължина на път който преминава през <img src="https://latex.codecogs.com/svg.latex?\Large&space;К+1"> града (път с <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> ребра).

Като вход получавате насочен граф с тегла по ребрата, където градовете са върхове на графа, ребро е път между два града (еднопосочен път), а тегло е дължината на даден път. Може да има повече от един път между два града. От АПИ искат при подаване на число К да може да отговорите коя е най-често срещаната дължина на път с <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> ребра. Ако няколко дължини са еднакво често срещани, то тогава връщаме най-голямата от тях. Ако няма път с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> ребра се връща <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">. АПИ не се интересува от пътища които минават повече от веднъж през даден град.

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/API%2001.png) 

Ако <img src="https://latex.codecogs.com/svg.latex?\Large&space;К=2">, то отговора е <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">. Имаме две най-често срещани дължини <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">, като и за двете дължини имаме по два пътя. Пътища с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> са с върхове <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-3-4"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;1-2-5">, а пътищата с дължина <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> са <img src="https://latex.codecogs.com/svg.latex?\Large&space;3-4-2"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;4-2-5">. Тъй като <img src="https://latex.codecogs.com/svg.latex?\Large&space;3>2">, то отговора е <img src="https://latex.codecogs.com/svg.latex?\Large&space;3">.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;V,E"> - брой върхове, брой ребра в граф

<img src="https://latex.codecogs.com/svg.latex?\Large&space;v_i,u_i,w_i"> - <img src="https://latex.codecogs.com/svg.latex?\Large&space;E"> на брой тройки за ребра - начален връх, краен връх, дължина на път.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> - броя на ребра на търсения път.

#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;V<100">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<w_i<1000">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;1<K<15">

#### Изходен формат

Най-често срещаната дължина на път между <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> града (ако няма път между <img src="https://latex.codecogs.com/svg.latex?\Large&space;К"> града то <img src="https://latex.codecogs.com/svg.latex?\Large&space;-1">, ако имаме повече няколко дължини, които се срещат еднакво много то връщаме най-дългата от тях).

Примерен вход|Очакван изход
-|-
5 5<br>1 3 1<br>3 4 1<br>1 2 1<br>4 2 2<br>2 5 1<br>2|3

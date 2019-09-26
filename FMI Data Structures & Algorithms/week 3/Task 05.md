#### Задача 5

Джизъса има <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> скъпоценни камъка. Всеки от неговите камъни има стойност <img src="https://latex.codecogs.com/svg.latex?\Large&space;V_i"> и тегло <img src="https://latex.codecogs.com/svg.latex?\Large&space;W_i">. Обаче, жената на Джизъса - Зелената Златка решила да го разори и Джизъса почти фалирал. Той решил да продаде част от своите скъпоценни камъни, но Зелената Златка разкрила  „спасителния му план“ и решила да запази <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> от най-добрите диаманта за себе си.

Златка иска да вземе за себе си <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> диаманта такива че <img src="https://latex.codecogs.com/svg.latex?\Large&space;\frac{S_K(V)}{S_K(W)}"> (*съотношението между цена и тегло*) да е максимално. Където <img src="https://latex.codecogs.com/svg.latex?\Large&space;S_K(V)"> е сумата <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sum_{i=1}^{K}V_i"> на заделените от нея <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> диаманти, а <img src="https://latex.codecogs.com/svg.latex?\Large&space;S_K(W)"> е сумата <img src="https://latex.codecogs.com/svg.latex?\Large&space;\sum_{i=1}^{K}W_i"> от теглата им.

#### Входен формат
Като вход получавате 2 числа <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> (брой на камъните и размера на търсеното множество)<br>
Следват <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> реда с 2 числа на всеки ред <img src="https://latex.codecogs.com/svg.latex?\Large&space;V_i,W_i,i=\overline{i,N}">.

#### Ограничения
<img src="https://latex.codecogs.com/svg.latex?\Large&space;K\le{N}\le{1000000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;V_i\le{10000000}"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;W_i\le{10000000}">

#### Изходен формат
За намереното множество от <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> диаманта такива че <img src="https://latex.codecogs.com/svg.latex?\Large&space;P=\frac{\sum_{i=1}^{K}V_i}{\sum_{i=1}^{K}W_i}"> е максимално (възможно е да има няколко такива максимални K множества ), затова от вас се иска да изведете само максималното S_K(V) сред всички възможни P множества.

Пример:

Вход:

2 1

1 1

1 4

Изход:

1

Пояснения:

Всички възможни P = S_K(V) / S_K(W) ( при K = 1) са:

1 / 1 = 1

1 / 4 = 0.25

=> P = {(1,1)} е оптималното и единствено затова изваждаме сумата от цените на елементите в случая: 1



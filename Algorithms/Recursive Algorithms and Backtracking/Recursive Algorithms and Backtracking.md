# Recursion

<p align="center">
  <img width="480" style="border: 3px solid gray"
  src="https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Recursive%20Algorithms%20and%20Backtracking%2001.png" alt="Example for recursion in nature" />
</p>

Рекурсията описва повтаряемост. По-конкретно:

- В математиката и лингвистиката – свързана с или включваща многократното приложение на правило, дефиниция или процедура с цел последващ резултат.
- В програмирането – отнасяща се за или включваща програма, за чието частично приложение се изисква прилагането на цялото, така че неговата изрична интерпретация изисква множество последващи изпълнения: рекурсивна подпрограма.
- Модерните операционни системи (ОС) дефинират файловата си структура по рекурсивен начин. Състои се от главна директория, а вътре в нея има файлове и други директории.

Един обект наричаме рекурсивен, ако съдържа опростен свой вариант или е дефиниран от по-опростена своя версия. 

#### Характеристики на рекурсията:
  - разделя проблема на подпроблеми от същия тип
    - включва функция, която извиква себе си
    - функцията трябва да има базов случай (*дъно*)
    - на всяка стъпка от рекурсията трябва да се движим напред към базовия случай

#### Примери от живота:
  - две огледала насочени едно към друго
  - [фракталите](https://en.wikipedia.org/wiki/Fractal)

#### Видове рекурсия:
- пряка – когато една функция извиква сама себе си
- непряка – когато една функция извиква друга, а тя отсвоя страна извиква първата (или аналогично верига от n извикващи се функции)

#### Части на рекурсията:
- Разгъване – когато се извикват вложените функции
  - 3!=3.2!
  - 2!=2.1!
- Дъно – когато е достигнато условието за край
  - 1!=1
- Свиване – когато вложените функции една по една връщат резултатите си
  – 2!=2.1!=2.1=2
  – 3!=2.2!=3.2=6
– Дълбочина – броят на рекурсивните извиквания на функцията

#### Решаванена задачи чрез рекурсия
- Задачата се привежда до по-проста задача от същия вид
- Трябва задължително да има условие за край (осигуряващо *дъното* на рекурсията), и трябва разгъването на рекурсията постепенно да ниприближава до дъното
- Ако условието за дъно не е избрано коректно, рекурсията продължава докато се запълни стека, и програмата (или системата) блокира (препълва се стека – *stackoverflow*)
- Кодът който трябва да се изпълни по време на разгъването се поставя преди рекурсивното извикване, а кодът, който ще се изпълнява при свиването на рекурсията – след него

#### Рекурсия или итерация
- решение чрез рекурсия:

```cpp
long long fact(unsigned n){
	if (n < 2) {
		return 1;
	}

	return n * fact(n - 1);
}
```
- решение чрез итерация:

```cpp
long long fact(unsigned n){
	unsigned result = 1;

	for (int i = 1; i <= n; i++) {
		result *= i;
	}

	return result;
}
```
Някой задачи се решават по-удачно чрез итерации, други чрез рекурсия.

#### Предимства и недостатъци
- Предимства
  - *По-прост код* – обяснението на много задачи чрез рекурсия е по-просто от еквивалентен итеративен алгоритъм
  - *Незаменимо за някои задачи* – някой задачи се решават най-елегантно чрез рекурсия
- Недостатъци 
  - *По-трудна за разбиране и осмисляне* – рекурсията не е толкова очевидно разбираема колкото итерацията например
  - *Коства повече памет* – всяко рекурсивно извикване заделя допълнителна памет от стека
  - *В повеето случаи ще се сблъскваме с експоненциално време за изпълнение*
 ## Примери
 
 **Задача 1.** Да се напише рекурсивен метод, който печата на конзолата следната фигура:
 
	**	***	****
	*	**	***
	#	*	**
	##	#	*
		##	#
		###	##
			###
			####
съответно за подадено число n = 2, 3, 4, ... и т.н.
 
*Решение:*
 
 ```cpp
#include <iostream>

using namespace std;

void help_func_print(int n, char symbol) {
    for (int i = 0; i < n; ++i) {
        cout << symbol;
    }
    
    cout << endl;
}

void recursion_print(int n) {
    if (n == 0) {
        return;
    }

    help_func_print(n, '*');
    recursion_print(n - 1);
    help_func_print(n, '#');
}

int main() {
    int n;
    cin >> n;

    recursion_print(n);
    return 0;
}
 ```
 
 #### Комбинаторни алгоритми чрез рекурсия
**Задача 2.** Да се генерират рекурсивно всички вектори с дължина 4 съставени само от 0 и 1.

*Решение:*

```cpp
#include <iostream>
#include <vector>

using namespace std;

void print_vector(vector<int> &arr) {
    for (int e:arr) {
        cout << e << ' ';
    }

    cout << endl;
}

void generate01(int index, vector<int>& arr) {
    if (index >= arr.size()) {
        print_vector(arr);
    } else {
        for (int i = 0; i <= 1; ++i) {
            arr[index] = i;
            generate01(index + 1, arr);
        }
    }
}

int main() {
    vector<int> arr(4);
    generate01(0, arr);
    return 0;
}
```

Аналогично, ако искаме да започнем на обратно като принтираме най-големия (според *лексикографската наредба*) вектор може да подходим по следния начин:

```cpp
#include <iostream>
#include <vector>

using namespace std;

void print_vector(vector<int> &arr) {
    for (int e:arr) {
        cout << e << ' ';
    }

    cout << endl;
}

void generate02(int index, vector<int> &arr) {
    if (index >= arr.size()) {
        print_vector(arr);
    } else {
        for (int i = 1; i >= 0; i--) {
            arr[index] = i;
            generate02(index - 1, arr);
        }
    }
}

int main() {
    vector<int> arr(4);
    generate02(arr.size() - 1, arr);

    return 0;
}
```
**Задача 3.** Напишете рекурсивна функция, която принтира всички 4-цифрени числа.

*Решение:*
Аналогично на предходната задача, това са всикчи 4-метни вектора с компоненти цифрите от 0, 1, ..., 9, без тези които започват с 0.

```cpp
#include <iostream>
#include <vector>

using namespace std;

const int DIGITS = 9;

void print_vector(vector<int> arr) {
    int n = arr.size();
    if (arr[0] != 0) {
        for (int i = 0; i < n; ++i) {
            cout << arr[i];
        }

        cout << endl;
    }
}

void generate_4_digit_nums(int index, vector<int> &arr) {
    if (index == arr.size()) {
        print_vector(arr);
    } else {
        for (int i = 0; i <= DIGITS; i++) {
            arr[index] = i;
            generate_4_digit_nums(index + 1, arr);
        }
    }
}

int main() {
    vector<int> arr(4);
    generate_4_digit_nums(0, arr);
    return 0;
}
```
**Задача 4.** Напишете рекурсивна функция, която извежда на конзолата всички двойни комбинации от 4 на брой елемента.

*Решение:*

Аналогично на горната задача, ще вземем първи вектор от две позиции където ще съхраняваме комбинациите и втори вектор с допустимите елементи, от които ще се грнерират комбинациите. Отново ще генерираме всички двойни вектори с повторения, а от тях ще изберем само тези които например образуват монотонна редица. Като отговор ще получим желаните комбинации.

```cpp
#include <iostream>
#include <vector>

using namespace std;

bool monotone_vector(vector<int> &arr) {
    int N = arr.size();

    for (int i = 0; i < N - 1; ++i) {
        if (arr[i] >= arr[i + 1]) {
            return false;
        }
    }

    return true;
}

void print_vector(vector<int> &arr) {
    if (monotone_vector(arr)) {
        for (int e: arr) {
            cout << e << ' ';
        }

        cout << endl;
    }
}

void generate_comb(vector<int> &set, vector<int> &arr, int index) {
    if (index >= arr.size()) {
        print_vector(arr);
    } else {
        for (int i = 0; i < set.size(); ++i) {
            arr[index] = set[i];
            generate_comb(set, arr, index + 1);
        }
    }
}

int main() {
    vector<int> set = {4, 8, 9, 22};
    vector<int> vector = {0, 0};

    generate_comb(set, vector, 0);
    return 0;
}
```

# Backtracking

Бектракинг (на английски: *backtracking*, в превод „търсене с възврат“) е общо название на клас от алгоритми, които намират всички или някои решения на изчислителни задачи, по-специално задачи за удовлетворяване на ограниченията. При този вид алгоритми решението се образува стъпка по стъпка, като за всяка стъпка се проверява дали удовлетворява поставените ограничения. При нарушаване на някое ограничение се отменя последната стъпка и се търси друга възможност. При изчерпване на възможностите се отменя предпоследната стъпка и т.н. до получаване на решение или до изчерпване на всички възможности.

Концептуално, частичните кандидат-решения се представят като възли от дървовидна структура от данни, т.е. пространството на решенията се представя като дърво. Всеки възел (без кореновия) има само един родителски възел. Всяко частично кандидат-решение е родителски възел за кандидат-решенията, които се различават от него само с по една стъпка на разширяване, а листата на дървото са частични кандидат-решения, които няма накъде повече да бъдат разширявани.

Бектракинг алгоритъмът обхожда рекурсивно дървото на търсене от корена надолу към листата в дълбочина (*depth-first*). На всеки възел v, алгоритъмът проверява дали v може да бъде завършено до валидно решение. Ако не може, то цялото поддърво с корен в v се отстранява. В противен случай, алгоритъмът *(1)* проверява дали самия кандидат v е валидно решение, и ако да, съобщава за това на потребителя и *(2)* рекурсивно номерира всички поддървета на v. Тези две проверки се дефинират по зададени от потребителя процедури. 

*Псевдо код за* **backtracking** *алгоритъмa:*

```cpp
procedure Backtracking(Node node){
	if node is solution then {
		PrintSolution(node);
	} else {
		for each child v of node
			if v is perspective candidate then {
				MarkPositionVisited(v);
				BackTracking(v);
				UnmarkPositionVisited(v);
			}
	}
}
```

**Задача 5.** Даденa е редица от положителни числа a и сума X, да се намерят всички уникални комбинации в a, чиято сума е равна на X. Едно и също число от a може да бъде избирано неограничен брой пъти. Елементите в комбинациия C=(a_1, a_2, ..., a_k) трябва да бъдат принтирани в ненамаляващ ред, т.е. a_1 < a_2 < ... < a_k. Комбинациите сами по себе си трябва да бъдат сортирани в нарастващ ред, т.е., комбинацията с най-малък първи елемент трябва да бъде принтирана на първо място. Ако не съществува възможна комбинация удовлетворяваща условието да се принтира подходящо съобщение.

*Пример:*

	Вход: a = {2, 4, 6, 8}, X=8

	Изход:   2, 2, 2, 2
	         2, 2, 4	 
      	     2, 6	
        	 4, 4	 
        	 8
*Решение:*

**Алгоритъм:**

- 1. Сортираме масива (не намаляващ);
- 2. Премахваме всички дубликати от масива;
- 3. Използваме рекурсия и backtracking за решаване проблемa;
  - (A) Ако в даден текущата сума стане равна на 0, тогава добавяме този вектор към резултата (вектор от вектори);
  - (Б) В противен случай, ако сумата стане отрицателна – това не е потенциално решение и го игнорираме;
  - (C) Докато индекса е по-малък от дължината на вектора с елементи и сумата е не по-малка от 0 – извикваме рекурсията за всички останали елементи (вкл. и потенциално добавения), като преди нея сме добавили потенциалния елемент във вектора с потенциалния резултат, а след нея сме увеличили индекса и сме премахнали елемента от списъка, който не води до потенциално решение.

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void print_vec_of_vectors(vector<vector<int>> &a) {
    int N = a.size();

    if (N == 0) {
        cout << "No such combination" << endl;
    } else {
        for (const auto &v :a) {
            int M = v.size();
            if (M > 0) {
                cout << "(";
                for (int j = 0; j < M; ++j) {
                    if (j == M - 1) {
                        cout << v[j];
                    } else {
                        cout << v[j] << ", ";
                    }
                }
                cout << ")" << endl;
            }
        }
    }
}

void find_sum_comb(vector<int> &a, int sum, vector<vector<int>> &res, vector<int> &r, int i) {
    if (sum < 0) { // if current sum becomes negative
        return;
    }

    if (sum == 0) { // if we get the wanted sum
        res.push_back(r);
        return;
    }

    while (i < a.size() && sum - a[i] >= 0) {
        r.push_back(a[i]);

        find_sum_comb(a, sum - a[i], res, r, i); // without repetitions: i + 1, instead of i
        i++;

        r.pop_back(); // backtrack
    }
}

vector<vector<int>> combination_sum(vector<int> &a, int sum) {

    sort(a.begin(), a.end());

    // remove duplicates
    a.erase(unique(a.begin(), a.end()), a.end());

    vector<int> r;
    vector<vector<int> > res;
    find_sum_comb(a, sum, res, r, 0);

    return res;
}

int main() {
    vector<int> a = {4, 2, 6, 2, 8, 4};
    int X = 8;
    sort(a.begin(), a.end());

    a.erase(unique(a.begin(), a.end()), a.end());

    vector<vector<int>> res = combination_sum(a, X);
    print_vec_of_vectors(res);

    return 0;
}
```
**Задача 5.** (*Класически пример*) Да се намерят всички възможни начини, по които може да се поставят 8 царици на шахматна дъска, така че да не се атакуват една-друга.

*Решение:* [РЕШЕНИЕ](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/tree/master/Algorithms/8%20Queens%20Problem)

**Задача 6.** Даден е лабиринт, представен чрез матрица от клетки. Целта е да намерим всички пътища от стартовата позиция (клетка с координати (0, 0) до финалната позиция (клетката със символ 'e').
- празните (проходими) клетки са маркирани с '-';
- стените (непроходимите клетки) са маркирани с '*';
На първия и втория ред ще получим размерите на лабиринта. На следващите редове ще получаваме клетките на лабиринта.
Редът на пътищата е без значение.

Примерен вход | Очакван изход
:-|:-
3<br>3<br>---<br>-*-<br>--е|RRDD<br>DDRR
3<br>5<br>-**-e<br>-----<br>*****|DRRRRU<br>DRRRUR

*Решение:* [РЕШЕНИЕ](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Algorithms/Find%20All%20Paths%20in%20Labyrinth/Find%20all%20Paths%20in%20labyrinth.cpp)

**Задача 6.** Да се намерят всички решения на дадено частично запълнено судоку 9х9.

*Решение:* [РЕШЕНИЕ](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Algorithms/Sudoku/Sudoku%20solver.cpp)

**Задача 7.** Напишете рекурсивен bubble_sort алгоритъм. Оптимизирайте го в рекурсивен cocktail_sort алгоритъм.
 
*Коментар:* тъй като bubble_sort-а при първата итерация (в този случай е обхождане на масива) изпраща най-големия елемент в края на списъка, то може рекурсивно да го извикаме отново за всички елементи на списъка без последния и така докато не достигнем дължина от един елемент.

```cpp
#include <iostream>

using namespace std;

int list[] = {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
int n = sizeof(list) / sizeof(list[0]);

int cnt_swaps;
int cnt_checks;
int recur_calls;

bool swapped = false;

void display() {
    for (int e: list) {
        cout << e << " ";
    }
    
    cout << endl;
}

void bubble_sort_rec(int n) {
    if (n == 1) {
        return;
    }

    for (int i = 0; i < n; ++i) {
        cnt_checks++;
        if (list[i] > list[i + 1]) {
            swapped = true;
            cnt_swaps++;
            swap(list[i], list[i + 1]);
        }
    }
    if (!swapped) {
        return;
    }

    swapped = false;
    recur_calls++;
    bubble_sort_rec(n - 1);
}

int main() {
    bubble_sort_rec(n);
    display();

    cout << "Total swaps: " << cnt_swaps << endl;
    cout << "Total checks: " << cnt_checks << endl;
    cout << "Recur depth: " << recur_calls << endl;

    return 0;
}
```

*Аналогично на bubble_sort, за cocktail_sort може да напишем подобна рекурсивна функция, която обхожда списъка отзад напред и да направим така, че рекурсивно да се извикват една-друга двете функции на bubble_sort_forward за обхождане напред и bubble_sort_backward съответно за обхождане назад. Къде ще бъде дъното на рекурсиите в такъв случай?*

```cpp
#include <iostream>

using namespace std;

int list[] = {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
int n = sizeof(list) / sizeof(list[0]);

int cnt_swaps;
int cnt_checks;
int recur_calls;

bool swapped = false;

void display() {
    for (int e: list) {
        cout << e << " ";
    }

    cout << endl;
}

void bubble_sort_rec_backward(int start_index, int end_index);

void bubble_sort_rec_forward(int start_index, int end_index) {
    if (end_index == n / 2 - 1) {
        return;
    }
    for (int i = start_index; i < end_index; ++i) {
        cnt_checks++;
        if (list[i] > list[i + 1]) {
            swapped = true;
            cnt_swaps++;
            swap(list[i], list[i + 1]);
        }
    }

    if (!swapped) {
        return;
    }

    swapped = false;
    recur_calls++;
    bubble_sort_rec_backward(start_index, end_index - 1);
}

void bubble_sort_rec_backward(int start_index, int end_index) {
    if (start_index == n / 2 + 1) {
        return;
    }

    for (int i = end_index; i > start_index; i--) {
        cnt_checks++;

        if (list[i] < list[i - 1]) {
            swapped = true;
            cnt_swaps++;
            swap(list[i], list[i - 1]);
        }
    }

    if (!swapped) {
        return;
    }

    swapped = false;
    recur_calls++;
    bubble_sort_rec_forward(start_index + 1, end_index);
}

int main() {
    bubble_sort_rec_forward(0, n - 1);
    display();

    cout << "Total swaps: " << cnt_swaps << endl;
    cout << "Total checks: " << cnt_checks << endl;
    cout << "Recur depth: " << recur_calls << endl;

    return 0;
}
```
**Задача 8.** (*Площадки в матрица*) Нека дефинираме *площадка* в матрица от клетки като множество от клетки, между всеки две от които има път (*можеството има една компонента на свързаност*). Път между две клетки има когато двете клетки имат точко една обща стена (*тук „път“ може да се дефинира и когато клетките имат едно общо ръбче, но в нашия случай ще разглеждаме пътя като съществуващ, ако клетките имат точно една обща стена. В случая думата „точно“ показва, че клетките трябва да са различни*). Напишете програма, която намира всички площадки в дадена матрица. На конзолата принтирайте общия брой на площадките, а на отделни редове принтирайте следната информация за всяка площадка: нейната позиция (*най-горен ляв ъгъл*) и размер (*брой клетки*).

Подредете площадките по размер (в намаляващ ред), така че най-голямата площадка да е принтирана първа. Ако няколко площадки имат един и същи размер, сортирайте ги по позиция, първо по редове, после по колони от най-горния ляв ъгъл. Така, ако има две площадки с един и същ размер, тази която е над и/или от ляво на другата ще се принтира първа.

Примери:
<p align="center">
  <img width="940" style="border: 2px solid gray"
  src="https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Recursive%20Algorithms%20and%20Backtracking%2002.png" alt="еxamples for task 8" />
</p>

 *Решение:*
 
 ```cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//const int ROWS = 5;
//const int COLS = 10;

// площадка отбелязваме с тире '-', празна клетка отбелязваме със звездичка '*'

char **read_matrix(int &rows, int &cols) {
    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    // заделяме динамично памет за матрицата
    char **matrix = new char *[rows];

    for (int i = 0; i < rows; ++i) {
        matrix[i] = new char[cols];
    }

    for (int r = 0; r < rows; ++r) {
        for (unsigned c = 0; c < cols; c++) {
            cin >> matrix[r][c];
        }
    }

    return matrix;
}

template<typename T>
void release_matrix(T **matrix, int rows) {
    for (int i = 0; i < rows; ++i) {
        delete[] matrix[i];
    }

    delete[] matrix;
}

bool **create_duplicate_bool(int rows, int cols) {
    bool **visited = new bool *[rows];

    for (int i = 0; i < rows; ++i) {
        visited[i] = new bool[cols];
    }

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            visited[i][j] = false;
        }
    }

    return visited;
}

struct Area {   // създаваме си клас описващ площадка
    unsigned start_index;
    unsigned end_index;
    unsigned sz;
};

void release_vec_of_pointers(vector<Area *> &areas) {
    for (auto &area : areas) {
        delete area;
    }

    areas.clear();
}

/* Хардкоднати матрици за тестване в течение на имплементация на решението */
//char P[ROWS][COLS] = { { '-', '-', '-', '-', '*', '*', '*', '-', '-','-' },
//					   { '-', '-', '-', '*', '*', '-', '*', '*', '-', '*' },
//					   { '-', '-', '*', '*', '-', '-', '-', '*', '*', '*' },
//					   { '-', '-', '*', '*', '*', '-', '*', '*', '*', '*' },
//					   { '-', '*', '*', '*', '*', '*', '*', '*', '*', '-' } };
//
//char Q[ROWS][COLS] = { { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '*', '*', '*', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' } };
//
//char R[ROWS][COLS] = { { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '-', '*', '-', '*', '-', '-', '*' },
//					   { '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

template<typename T>
void print_matrix(T **M, int rows, int cols) { // помощна функция за принтиране на оригиналната матрица, за тестване
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            cout << M[r][c] << ' ';
        }
        cout << endl;
    }
    cout << endl;
}

void print_vec_with_areas(vector<Area *> &areas) { // помощна функция за принтиране на вектора от площадки
    for (int i = 0; i < areas.size(); ++i) {
        cout << "Area #"
             << i + 1
             << " at (" << areas[i]->start_index
             << ", "
             << areas[i]->end_index
             << "), sz: "
             << areas[i]->sz
             << endl;
    }
}

bool is_safe(int row, int col, int rows, int cols, char **M, bool **(&visited)) {
    // реда и колоната не са извън размера на матрицата и клетката не е посетена все още
    return (row >= 0) && (row < rows) && (col >= 0) && (col < cols) && (M[row][col] == '-' && !visited[row][col]);
}

int cnt_size_dfs(int row, int col, int rows, int cols, char **M, bool **(&visited), int K, int *rowBr4, int *colBr4,
                 int &sz) {
    visited[row][col] = true; // маркираме клетката като посетена
    for (int k = 0; k < K; ++k) {
        if (is_safe(row + rowBr4[k], col + colBr4[k], rows, cols, M, visited)) {
            sz++;
            cnt_size_dfs(row + rowBr4[k], col + colBr4[k], rows, cols, M, visited, K, rowBr4, colBr4,
                         sz);
        }
    }

    return sz;
}

int cnt_islands_and_areas(char **M, int rows, int cols, vector<Area *> &areas, bool **(&visited), int K, int *rowBr4,
                          int *colBr4, int &size) {
    int cnt = 0; // Инициализираме брояча на 0, като започваме да обхождаме всички клетки на матрицата

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; j++) {
            // Ако клетката не е посетена и е част от площадка
            if (M[i][j] == '-' && !visited[i][j]) {
                // инкрементираме броя на площадките
                cnt++;
                // не е посещавана до сега - обхождаме и посещаваме всички клетки в тази площадка
                int areaSize = cnt_size_dfs(i, j, rows, cols, M, visited, K, rowBr4, colBr4, size);

                // cout << "Area #" << count << " at (" << i << ", " << j << "), sz: " << areaSize << endl;

                Area *a = new Area(); /* оператор new => оператор delete */
                a->start_index = i;
                a->end_index = j;
                a->sz = areaSize;
                areas.push_back(a);
            }
            size = 1;
        }
    }

    return cnt;
}

int main() {
    /* Помощни масиви за достигане на индексите на реда и колоната
        на всички 8 съседа на дадена клетка (дефиниция с ръбче) */
    int rowBr8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int colBr8[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    /* Помощни масиви за достигане на индексите на реда и колоната
    на всички 4 съседа на дадена клетка (дефиниция с точно една обща стена) */
    int rowBr4[] = {-1, 0, 0, 1};
    int colBr4[] = {0, -1, 1, 0};

    unsigned K = sizeof(rowBr4) / sizeof(rowBr4[0]);

    int rows, cols;
    char **M = read_matrix(rows, cols);

    cout << endl << "Original matrix is:" << endl << endl;
    print_matrix(M, rows, cols);

    // булева матрица дубликат, на която ще отбелязваме дали сме посетили дадена клетка от оригиналната матрица
    bool **visited = create_duplicate_bool(rows, cols);

    // cout << endl << "Duplicate bool matrix is:" << endl << endl;
    // print_matrix(visited, rows, cols);

    vector<Area *> areas; /* създаваме си вектор от пойнтъри към площадки,
						  като не забравяме после да изтрием поинтърите */

    int size = 1; /* инициализираме с конструктор с параметър променливата sz да приема
					  стартова стойност 1, защото вече сме намерили площадка с поне единица размер */

    int totalCount = cnt_islands_and_areas(M, rows, cols, areas, visited, K, rowBr4, colBr4, size);

    cout << "Total areas found: " << totalCount << endl;

    auto lambda = [](Area const *a, Area const *b) { return a->sz > b->sz; };

    sort(areas.begin(), areas.end(), lambda);

    print_vec_with_areas(areas);

    release_matrix(M, rows);
    release_matrix(visited, rows);
    release_vec_of_pointers(areas);

    return 0;
}
```

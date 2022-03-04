**Задача 1.** *(Пермутации без повтарения)* Имплементирайте рекурсивен метод за генериране на всички пермутации на даден списък от уникални елементи.

*Решение:*

```cpp
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int n, perm_cnt;

vector<int> arr;
vector<bool> used;
vector<int> perm;

void display_perm() {
    cout << '(';

    for (int i = 0; i < n; ++i) {
        cout << perm[i];

        if (i != n - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_perm(int index) { // index is the current cell we want to fill
    if (index > n - 1) {
        perm_cnt++;
        display_perm();
    } else {
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                used[i] = true;
                perm[index] = arr[i];
                gen_perm(index + 1);
                used[i] = false;
            }
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    used.resize(n, false);
    perm.resize(n, 0);

    gen_perm(0);
    cout << "Total: " << n << "! = " << perm_cnt << " permutations." << endl;

    return 0;
}

```
*Коментар:* В имплементацията по-горе използваме два допълнителни (помощни) вектора used и perm. Първият е от булев тип и в него маркираме кой елемент е използван при разгъването на рекурсията, а при свиването ѝ го отмаркираме (backtracking – обхождане с възврат). Другият е от същия тип, от който са съответните елементи, от които генерираме пермутациите и го използваме за запълване с тези елементи и в момента, в който го напълним го принтираме на конзолата. Метода за генериране на пермутации с *backtracking* е стандартен и лесен за имплементация, но използва два допълнителни масива за да работи. Може ли да избегнем заделянето на тази странична памет?

За да оптимизираме решението, ще трябва да „задълбаем“ (да достигнем максимално напред в клетката, в която искаме да поставим елемент) в рекурсията до край, след което да разменяме елементите без да повтаряме видовете размени. Т.е. вървим до края напред, след което се връщаме назад и се опитваме да разменим нещо, като в момента, в който размениме нещо викаме рекурсията напред и се връщаме.

```cpp
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int n, perm_cnt;

vector<int> arr;
vector<int> perm;

void display_perm() {
    cout << '(';

    for (int i = 0; i < n; ++i) {
        cout << arr[i];

        if (i != n - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_perm(int index) { // index is the current cell we want to fill
    if (index > n - 1) {
        perm_cnt++;
        display_perm();
    } else {
        gen_perm(index + 1);
        for (int i = index+1; i < n; ++i) {
            swap(arr[index], arr[i]);
            gen_perm(index + 1);
            swap(arr[index], arr[i]);
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    perm.resize(n, 0);

    gen_perm(0);
    cout << "Total: " << n << "! = " << perm_cnt << " permutations." << endl;

    return 0;
}

```

**Задача 2.** *(Пермутации с повтарения)* Имплементирайте рекурсивен метод за генериране на всички пермутации на даден списък с повтарящи се елементи.

*Пример:* за списъка {A,B,B} съществуват следните пермутации: (A,B,B), (B,A,B) и (B,B,A). Точно 3!/(2!.1!) на борй.

*Решение:*
```cpp
#include <iostream>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

int n, perm_cnt;

vector<int> arr;
vector<int> perm;

void display_perm() {
    cout << '(';

    for (int i = 0; i < n; ++i) {
        cout << arr[i];

        if (i != n - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_perm_rep(int index) {
    if (index > n - 1) {
        perm_cnt++;
        display_perm();
    }
    else {
        set<int> swapped;

        for (int i = index; i < n; ++i) {
            if (!swapped.count(arr[i])) {
                swap(arr[index], arr[i]);
                gen_perm_rep(index + 1);
                swap(arr[index], arr[i]);

                swapped.insert(arr[i]);
            }
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    perm.resize(n, 0);

    gen_perm_rep(0);
    cout << "Total: " << perm_cnt << " permutations." << endl;

    return 0;
}

```

*Коментар:* В горната имплементация използваме предишния алгоритъм, като в дадено множество броим всички елементи които сме използвали (разменяли), защото те ще генерират същите пермутации като тези породени от еднаквите с тях елементи. Така лесно ще направим проверката дали даденият елемент го има в множеството и ако това не е изпълнено – ще разменяме. Но отново използваме странична памет като използваме място за множеството, което се заделя многократно. Възможно ли е да оптимизираме?

Това би могло да се реализира, като на всеки текущ елемент, който ще разбъркваме, му разменяме позицията с позицията на всички следващи елементи.

```cpp
#include <iostream>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

int n, perm_cnt;

vector<int> arr;
vector<int> perm;

void display_perm() {
    cout << '(';

    for (int i = 0; i < n; ++i) {
        cout << arr[i];

        if (i != n - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_perm_rep(int start_index, int end_index) {
    display_perm();
    perm_cnt++;

    for (int l = end_index - 1; l >= start_index; --l) {
        for (int r = l + 1; r <= end_index; ++r) {
            if (arr[l] != arr[r]) {
                swap(arr[l], arr[r]);
                gen_perm_rep(l + 1, end_index);
            }
        }
        int fir_el = arr[l];
        for (int i = l; i < end_index - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        arr[end_index] = fir_el;
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    perm.resize(n, 0);

    gen_perm_rep(0, n-1);
    cout << "Total: " << perm_cnt << " permutations." << endl;

    return 0;
}

```
*Обяснение:* започваме да вървим отзад напред с един цикъл и с друг цикъл от другата страна и в момента, в който два елемента се различават ги разменяме. Има и един много важем момент, в който след като сме изциклили навсякъде с даден елемент, го връщаме обратно на стартовата позиция и рекурсията го разменя ако е необходимо. За по-ясно разбиране може да приложим алгоритъма за списък от вида {1,3,3,3,3,3,3} и да дебъгнем програмата, като преди това анализираме резултата от нея.
 
**Важно!** Алгоритъма ще работи много по-оптимално ако преди да извикаме рекурсивния метод gen_perm_rep(...) сортираме списъка от елементи.

```cpp
#include <iostream>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

int n, perm_cnt;

vector<int> arr;
vector<int> perm;

void display_perm() {
    cout << '(';

    for (int i = 0; i < n; ++i) {
        cout << arr[i];

        if (i != n - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_perm_rep(int index) {
    if (index > n - 1) {
        perm_cnt++;
        display_perm();
    } else {
        set<int> swapped;
        for (int i = index; i < n; ++i) {
            if (!swapped.count(arr[i])) {
                swap(arr[index], arr[i]);
                gen_perm_rep(index + 1);
                swap(arr[index], arr[i]);
                swapped.insert(arr[i]);
            }
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    sort(arr.begin(), arr.end());

    n = arr.size();

    perm.resize(n, 0);

    gen_perm_rep(0);
    cout << "Total: " << perm_cnt << " permutations." << endl;

    return 0;
}

```
**Задача 3.** *(Вариации без повтарения)* Имплементирайте рекурсивен метод за генериране на всички вариации от два елемента на даден списък с уникални елементи.

*Пример:* за списъка {A,B,C} съществуват следните вариации без повторения от два елемента: (A,B), (A,C), (B,A), (B,C), (C,A) и (C,B). Точно 3!/(3-2)! на борй.

*Решение:*

```cpp
#include <iostream>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

int n, vars_cnt;

vector<int> arr;
vector<bool> used;
vector<int> vars;

const int k = 2;

void display_var() {
    cout << '(';

    for (int i = 0; i < k; ++i) {
        cout << vars[i];
        if (i != k - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_vars_2(int index) {
    if (index > k - 1) {
        vars_cnt++;
        display_var();
    } else {
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                used[i] = true;
                vars[index] = arr[i];
                gen_vars_2(index + 1);
                used[i] = false;
            }
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    used.resize(n, false);
    vars.resize(k);

    gen_vars_2(0);
    cout << "Total: " << vars_cnt << " variations of two elements." << endl;

    return 0;
}
```
**Задача 4.** *(Вариации с повтарения)* Имплементирайте рекурсивен метод за генериране на всички вариации с повторения от два елемента на даден списък с уникални елементи.

*Пример:* за списъка {A,B,C} съществуват следните вариации с повторения от два елемента: (A,A), (A,B), (A,C), (B,B), (B,A), (B,C), (C,A), (C,B) и (C,C). Точно 3^2=9 на борй.

*Решение:*

```cpp
#include <iostream>
#include <vector>
#include <set>
#include <sstream>

using namespace std;

int n, vars_cnt;

vector<int> arr;
vector<int> vars;

const int k = 2;

void display_var() {
    cout << '(';

    for (int i = 0; i < k; ++i) {
        cout << vars[i];
        if (i != k - 1) {
            cout << ',';
        }
    }
    cout << ')' << endl;
}

void gen_vars_2_rep(int index) {
    if (index > k - 1) {
        vars_cnt++;
        display_var();
    } else {
        for (int i = 0; i < n; ++i) {
            vars[index]=arr[i];
            gen_vars_2_rep(index+1);
        }
    }
}

int main() {
    string line;
    cout << "Enter comma separated unique integers: ";
    getline(cin, line);
    istringstream iss(line);

    int num;
    while (iss >> num) {
        arr.push_back(num);
        iss.ignore();
    }

    n = arr.size();

    vars.resize(k);

    gen_vars_2_rep(0);
    cout << "Total: " << vars_cnt << " variations of two elements." << endl;

    return 0;
}
```
**Задача 5.** *(Вариации с повтарения)* Имплементирайте итеративен метод за генериране на всички триместни вариации с повторения на числата {0,1,2,3,4}.

*Решение:*

```cpp
#include <iostream>
#include <vector>

using namespace std;

const int n = 5;
const int k = 3;

vector<int> vars;
int var_rep_cnt;

void display_var() {
    cout << '(';

    for (int i = 0; i < k; ++i) {
        cout << vars[i];
        if (i != k - 1) {
            cout << ',';
        }
    }
    
    cout << ')' << endl;
}

void gen_var_3_rep_iter() {
    while (true) {
        var_rep_cnt++;
        display_var();
        int index = k - 1;

        while (index >= 0 && vars[index] == n - 1) {
            index--;
        }

        if (index < 0) {
            break;
        }

        vars[index]++;

        for (int i = index + 1; i < k; ++i) {
            vars[i] = 0;
        }
    }
}

int main() {
    vars.resize(k);

    gen_var_3_rep_iter();
    cout << "Total: " << n << '^' << k << " = " << var_rep_cnt << " variations." << endl;

    return 0;
}
```

*Този метод се базира на броенето, аналогично на двоичното, третичното и т.н.* 

**Задача 6.** *(Комбинации)* Имплементирайте рекурсивен метод за генериране на всички тримерни комбинации на даден списък от уникални елементи, например {2,4,6,8,10}.

*Решение:*

```cpp
#include <iostream>
#include <vector>

using namespace std;

const int n = 5;
const int k = 3;

vector<int> arr;
vector<int> comb;
int comb_cnt;

void display_comb() {
    cout << '(';

    for (int i = 0; i < k; ++i) {
        cout << comb[i];
        if (i != k - 1) {
            cout << ',';
        }
    }

    cout << ')' << endl;
}

void gen_comb(int index, int start) {
    if (index >= k) {
        display_comb();
        comb_cnt++;
    } else {
        for (int i = start; i <= n - 1; ++i) {
            comb[index] = arr[i];
            gen_comb(index + 1, i + 1);
        }
    }
}

int main() {
    arr.resize(n);
    for (int i = 0; i < n; ++i) {
        arr[i] = 2 * (i + 1); // {2,4,6,8,10}
    }

    comb.resize(k);

    gen_comb(0, 0);
    cout << "Total: " << comb_cnt << " combination." << endl;

    return 0;
}
```
*Коментар:* броя на комбинациите е C_{k}^{n}=\binom{n}{k}=\frac{n!}{k!(n-k)!}=\frac{5!}{3!(5-3)!}=10.

**Задача 6.** *(Комбинации с повторения)* Имплементирайте рекурсивен метод за генериране на всички тримерни комбинации на даден списък от уникални елементи, например {2,4,6,8,10}.

*Решение:*

В имплементацията на предишната задача пви извикването на рекурсивния метод е необходимо да осигурим достъп и до текущия елемент, който взимаме. Т.е. е необходимо да извикваме метода по следния начин:  „*gen_comb(index + 1, i);*“ . Броят им е точно \binom{n+k-1}{k}=\binom{7}{3}=\frac{7!}{3!(7-3)!}=\frac{7!}{3!4!}=35.

**Задача 7.** Напишете функция, която пресмята по-колко начина може да се изберат *k* елемента от *n* елемента като използвате [триъгълника на Паскал](https://medium.com/i-math/top-10-secrets-of-pascals-triangle-6012ba9c5e23).

*Решение:*

```cpp
#include <iostream>

using namespace std;

const int k = 3;
const int n = 6;

long long bin(int n, int k) {
    if (k > n) {
        return 0;
    }

    if (k == 0 || k == n) {
        return 1;
    }

    return bin(n - 1, k - 1) + bin(n - 1, k);
}

int main() {
    long long choose_k_n = bin(n, k);
    cout << choose_k_n << endl;
    return 0;
}
```

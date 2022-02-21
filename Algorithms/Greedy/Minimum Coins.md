**Задача.** [Монети] Даден е множество от допустими монети {1, 2, 5, 10, 20, 50} и желана сума. Целта е да достигнем желаната сума с възможно най-малко монети.


Вход |	Изход |	Коментар
----|----|----
Монети: 1, 2, 5, 10, 20, 50<br>Сума: 923 | Брой монети за желаната сума: 21<br>18 монети с номинал 50<br>1 монета с номинал 20<br>1 монета с номинал 2<br>1 монета с номинал 1 |	18 x 50 + 1 x 20 + 1 x 2 + 1 x 1 = 900 + 20 + 2 + 1 = 923
Монети: 1<br>Сума: 42 |	Брой монети за желаната сума: 42<br>42 монети с номинал 1	
Монети: 3, 7<br>Сума: 11 |	Грешка! |	Желаната сума е недостижима с тоя набор от монети
Монети: 1, 2, 5<br>Сума: 2031154123| 	Брой монети за желаната сума: 406230826<br>406230824 монети с номинал 5<br>1 монета с номинал 2<br>1 монета с номинал 1| Решението трябва да е достатъчно бързо за да се справи с комбинация от много малки монети и голяма желана сума
Монети: 1, 9, 10<br>Сума: 27 |	Брой монети за желаната сума: 9<br>2 монети с номинал 10<br>7 монетаи с номинал 1 |	Подходът с *greedy* алгоритъм връща неоптимално решение (9 монети вместо 3 с номинал 9)

*Решение:*

```cpp
#include <iostream>
#include <algorithm>

using namespace std;

int coins[] = {1, 2, 5, 10, 20, 50};
const int LEN = sizeof(coins) / sizeof(coins[0]);
const int TARGET_SUM = 923;

int *cnt_coins;
int num_coins;

void print_coins();

int main() {
    cnt_coins = new int[LEN];
    sort(coins, coins + LEN, greater<>());

    int curr_sum = 0;
    int coin_index = 0;

    while (coin_index < LEN || curr_sum > TARGET_SUM) {
        int curr_coin_val = coins[coin_index];

        if (curr_sum + curr_coin_val > TARGET_SUM) {
            coin_index++;
            continue;
        }

        int remaining_sum = TARGET_SUM - curr_sum;
        int coinsToTake = remaining_sum / curr_coin_val;

        if (coinsToTake > 0) {
            cnt_coins[coin_index] = coinsToTake;
            curr_sum += coinsToTake * curr_coin_val;
        }
    }
    for (unsigned i = 0; i < LEN; i++) {
        num_coins += cnt_coins[i];
    }

    if (curr_sum != TARGET_SUM) {
        cerr << "Error" << endl;
        return 0;
    }

    print_coins();
    return 0;
}

void print_coins() {
    cout << "Number of coins to take: " << num_coins << endl;
    for (int i = 0; i < LEN; ++i) {
        if (cnt_coins[i] != 0) {
            cout << cnt_coins[i] << " coin(s) with value " << coins[i] << endl;
        }
    }
}
```
Забележете, че в последния пример, *greedy* подходът не дава оптимално решение, но все пак дава някакво решение. За да бъде оптимално решението на *greedy* е необходимо монетите да изпълняват следното условие: сбора на която и да е (текуща) монета с най-малката от всички монети да не е по-малък от удвоената следваща по-малка монета от текущата монета. Например монетите 10, 5, 4, 1 няма да дават оптимални решения, тъй като 5 + 1 < 2 x 4.

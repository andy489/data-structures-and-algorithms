// github.com/andy489

#include <iostream>

using namespace std;

struct Snowman {
    int value = 0, total = 0;
    Snowman *prev = nullptr;
};

int main() {
    int N, dupTarget(0), add(0), i(1), sum(0);
    cin >> N;
    Snowman *arr = new Snowman[N + 1]; //the first one is the zero snowman

    for (; i < N + 1; ++i) {
        cin >> dupTarget >> add;
        if (add == 0) {
            if (arr[dupTarget].prev)
                arr[i] = *arr[dupTarget].prev;
        } else {
            arr[i].value = add;
            arr[i].total = arr[dupTarget].total + add;
            arr[i].prev = &arr[dupTarget];
        }
    }
    for (i = 0; i < N + 1; ++i)
        sum += arr[i].total;

    return cout << sum, 0;
}

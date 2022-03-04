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
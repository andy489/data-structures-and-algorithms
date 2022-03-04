
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
    
    ++recur_calls;
    
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
    
    ++recur_calls;
    
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
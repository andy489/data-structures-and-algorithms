// github.com/andy489

#include <iostream>

using namespace std;

int getMinDaysRecursive(int sections) {
    if (sections < 1)
        return 0;
    return
            getMinDaysRecursive(sections / 2) + 1;
}

int getMinDays(size_t sections) {
    int result(0);
    while (sections > 0) {
        ++result;
        sections /= 2;
    }
    return result;
}

void printResult(int *result) {
    int i(0);
    for (; result[i]; ++i)
        cout << result[i] << '\n';
}

int main() {
    int T, N, i(0);
    cin >> T;
    int *result = new int[T];
    while (T--) {
        cin >> N;
        result[i++] = getMinDaysRecursive(N); //result[i] = getMinDays(N);
    }
    result[i] = '\0';
    printResult(result);
    delete result;
    return 0;
}

// github.com/andy489

#include <iostream>
#include <algorithm>

using namespace std;

struct Building {
    int height = 0;
    int price = 0;
};

bool compareHeight(Building &lhs, Building &rhs) {
    return (lhs.height < rhs.height); // || (lhs.height == rhs.height && lhs.price < rhs.price));
}

int price(Building *buildings, int arrSize, int height) {
    int price(0);
    for (int i = 0; i < arrSize; ++i)
        price += abs(buildings[i].height - height) * buildings[i].price;
    return price;
}

int min(int a, int b) {
    return a < b ? a : b;
}

int minPriceTernaryNaive(Building *buildings, int size, int left, int right) {
    if (right - left < 3) {
        int currentMin = price(buildings, size, left);
        for (int i = left + 1; i < right + 1; ++i)
            currentMin = min(currentMin, price(buildings, size, i));
        return currentMin;
    } else if (left < right) {
        int leftThird = left + (right - left) / 3;
        int rightThird = right - (right - left) / 3;

        int leftPrice = price(buildings, size, leftThird);
        int rightPrice = price(buildings, size, rightThird);

        if (leftPrice < rightPrice)
            return minPriceTernaryNaive(buildings, size, left, rightThird);
        else if (leftPrice > rightPrice)
            return minPriceTernaryNaive(buildings, size, leftThird, right);
        else
            return min(min(minPriceTernaryNaive(buildings, size, left, leftThird),
                           minPriceTernaryNaive(buildings, size, leftThird, rightThird)),
                       minPriceTernaryNaive(buildings, size, rightThird, right));
    }
    return -1;
}

int minPriceTernary(Building *buildings, int size, Building *unique, int uniqueSize, int left, int right) {
    if (right - left < 3) {
        int currentMin = price(buildings, size, buildings[left].height);
        for (int i = left + 1; i < right + 1; ++i)
            currentMin = min(currentMin, price(buildings, size, buildings[i].height));
        return currentMin;
    } else if (left < right) {
        int leftThird = left + (right - left) / 3;
        int rightThird = right - (right - left) / 3;

        int leftPrice = price(buildings, size, buildings[leftThird].height);
        int rightPrice = price(buildings, size, buildings[rightThird].height);

        if (leftPrice < rightPrice)
            return minPriceTernary(buildings, size, unique, uniqueSize, left, rightThird);
        else if (leftPrice > rightPrice)
            return minPriceTernary(buildings, size, unique, uniqueSize, leftThird, right);
        else
            return min(min(minPriceTernary(buildings, size, unique, uniqueSize, left, leftThird),
                           minPriceTernary(buildings, size, unique, uniqueSize, leftThird, rightThird)),
                       minPriceTernary(buildings, size, unique, uniqueSize, rightThird, right));
    }
    return -1;
}

int main() {
    int N, i(0);
    cin >> N;
    Building *buildings = new Building[N];
    for (; i < N; ++i)
        cin >> buildings[i].height;
    for (i = 0; i < N; ++i)
        cin >> buildings[i].price;
    sort(buildings, buildings + N, compareHeight);
    if (N > 1)
        cout << minPriceTernaryNaive(buildings, N, buildings[0].height, buildings[N - 1].height);
}

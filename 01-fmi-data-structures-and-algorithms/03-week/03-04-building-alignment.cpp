// https://www.hackerrank.com/contests/practice-3-1/challenges
// Stroitel

#include <iostream>
#include <algorithm>

using namespace std;

struct Building {
    int height = 0;
    int price = 0;
};

bool compare_height(Building &lhs, Building &rhs) {
    return (lhs.height < rhs.height); // || (lhs.height == rhs.height && lhs.price < rhs.price));
}

int price(Building *buildings, int n, int height) {
    int price = 0;
    for (int i = 0; i < n; ++i) {
        price += abs(buildings[i].height - height) * buildings[i].price;
    }

    return price;
}

int min(int a, int b) {
    return a < b ? a : b;
}

int min_price_ternary(Building *buildings, int size, int left, int right) {
    if (right - left < 3) {
        int currentMin = price(buildings, size, left);

        for (int i = left + 1; i < right + 1; ++i) {
            currentMin = min(currentMin, price(buildings, size, i));
        }

        return currentMin;
    } else if (left < right) {
        int leftThird = left + (right - left) / 3;
        int rightThird = right - (right - left) / 3;

        int leftPrice = price(buildings, size, leftThird);
        int rightPrice = price(buildings, size, rightThird);

        if (leftPrice < rightPrice) {
            return min_price_ternary(buildings, size, left, rightThird);
        } else if (leftPrice > rightPrice) {
            return min_price_ternary(buildings, size, leftThird, right);
        } else {
            return min(min(min_price_ternary(buildings, size, left, leftThird),
                           min_price_ternary(buildings, size, leftThird, rightThird)),
                       min_price_ternary(buildings, size, rightThird, right));
        }
    }

    return -1;
}

int main() {
    int n;
    cin >> n;

    auto *buildings = new Building[n];

    for (int i = 0; i < n; ++i) {
        cin >> buildings[i].height;
    }

    for (int i = 0; i < n; ++i) {
        cin >> buildings[i].price;
    }

    sort(buildings, buildings + n, compare_height);
    
    if (n > 1) {
        cout << min_price_ternary(buildings, n, buildings[0].height, buildings[n - 1].height);
    }
}

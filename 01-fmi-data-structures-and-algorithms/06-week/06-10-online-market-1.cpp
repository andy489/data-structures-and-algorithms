// https://www.hackerrank.com/contests/sda-test-5/challenges/1-140

#include <cstdio>
#include <unordered_map>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);

    unordered_map<int, int> orders;

    int id;
    while (n-- && scanf("%d", &id)) {
        ++orders[id];
    }

    int clients_waiting = 0;
    int undelivered_products = 0;
    for (const auto &x : orders) {
        if (x.second % 10) {
            ++clients_waiting;
        }

        undelivered_products += x.second % 10;
    }

    printf("%d %d", clients_waiting, undelivered_products);

    return 0;
}

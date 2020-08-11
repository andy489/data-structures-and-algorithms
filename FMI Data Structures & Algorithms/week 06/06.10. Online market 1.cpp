// github.com/andy489

// https://www.hackerrank.com/contests/sda-test-5/challenges/1-140

#include <stdio.h>
#include <unordered_map>

using namespace std;

int main() {
    int n, id, clients_waiting(0), undelivered_products(0);
    scanf("%d", &n);

    unordered_map<int, int> orders;

    while (n-- && scanf("%d", &id))
        ++orders[id];

    for (const auto &x : orders) {
        if (x.second % 10)
            ++clients_waiting;
        undelivered_products += x.second % 10;
    }
    return printf("%d %d", clients_waiting, undelivered_products), 0;
}

// https://www.hackerrank.com/contests/si-practice-5/challenges/challenge-1668/problem

#include <iostream>
#include <cmath>

using namespace std;

int main() {
    long n;
    cin >> n;

    return cout << 1l + 2l * (n - (long) pow(2, (int) log2(n))), 0;
}
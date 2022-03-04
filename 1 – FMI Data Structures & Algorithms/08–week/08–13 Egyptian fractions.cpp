#include <iostream>
#include <stack>
#include <vector>

using namespace std;

void getRational(long &numerator, long &denominator) {
    string s;
    cin >> s;

    const int LEN = s.length();

    stack<long> stack;
    stack.push(0);

    for (int i = 0; i <= LEN; ++i) {
        if (s[i] >= '0' && s[i] <= '9') {
            long num = stack.top() * 10 + s[i] - '0';

            stack.pop();
            stack.push(num);
        } else {
            if (i != LEN) {
                numerator = stack.top();
                stack.pop();
                stack.push(0);
            } else {
                denominator = stack.top();
                stack.pop();
            }
        }
    }
}

int main() {
    long numerator, denominator;
    getRational(numerator, denominator);
    cout << numerator << '/' << denominator << " = ";

    if (denominator < numerator) {
        cout << "Error (fraction is equal to or greater tha 1)" << endl;
        return 0;
    }

    vector<long> result;

    int index_denominator = 2;

    while (numerator != 0) {
        long diff = numerator * index_denominator - denominator;

        if (diff < 0) {
            ++index_denominator;
            continue;
        }

        result.push_back(index_denominator);

        numerator = diff;
        denominator = denominator * index_denominator;
        index_denominator++;
    }

    int resLen = result.size();

    for (int i = 0; i < resLen - 1; ++i) {
        cout << "1/" << result[i] << " + ";
    }

    cout << "1/" << result[resLen - 1];

    return 0;
}
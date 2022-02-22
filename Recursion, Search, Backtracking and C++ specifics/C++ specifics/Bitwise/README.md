When **k** is **ODD**, **k - 1** is **EVEN**, **k - 1** can always be reached by **(k - 1) & k**.
```
In binary form:
    k   = 11
    k-1 = 10
    k-1 == (k-1) & k
```
That is, **((k - 1) | k)** is always **k**. And **((k - 1) | k) <= n** is always TRUE.

When **k** is **EVEN**, **k - 1** is **ODD**, **k-1** can only be reached if and only if **((k - 1) | k) <= n** is **TRUE**

Why?
```
In binary form:
    k   = 10110
    k-1 = 10101
    pos = 10111
    k-1 == (k-1) & pos
```
You can get **k - 1** if **pos <= n** is TRUE. And you can get **pos** by **((k - 1) | (k - 1 + 1))**, that is **((k - 1) | k)**. Otherwise, you just need to follow the process above when **k** is **ODD** (because **k - 1** is **ODD**), then you get the answer **k - 2**.
In brief, you can just do the test **((k - 1) | k) <= n** to determine the answer.

```cpp
// https://www.hackerrank.com/challenges/30-bitwise-and/problem

#include <iostream>

using namespace std;

int main() {
    int q;
    cin >> q;

    while (q--) {
        int n, k;
        cin >> n >> k;

        if (((k - 1) | k) <= n) {
            cout << k - 1;
        } else {
            cout << k - 2;
        }
        cout << endl;
    }
    return 0;
}

```
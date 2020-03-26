// github.com/andy489
// O(n)
#include <iostream>
using namespace std;

int main() {
    int n, m, a, b, s;
    cin >> n >> m;
    long* arr = new long[n + 2];
    while (m--)    {        
        cin >> a >> b >> s;
        arr[a] += s;
        arr[b + 1] -= s;
    }
    for (a = 2;a <= n;++a) {
        arr[a] += arr[a - 1];
        if (arr[a] > arr[0]) {
            arr[0] = arr[a];
        }//max=arr[0]
    }
    cout << arr[0];
}

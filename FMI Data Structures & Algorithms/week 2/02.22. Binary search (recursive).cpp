// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

bool binarySearch(const vi &vec, int begin, int end, int x) {
    if (begin <= end) {
        int mid = begin + (end - begin) / 2;
        if (vec[mid] == x)
            return mid;
        if (vec[mid] > x)
            return binarySearch(vec, begin, mid - 1, x);
        return binarySearch(vec, mid + 1, end, x);
    }

    return false;
}

int main() {
    int searched;
    cin >> searched;
    vi vec = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 8, 8, 9};
    int N = sz(vec);
    return cout << (binarySearch(vec, 0, N - 1, searched) ? "exist" : "not exist"), 0;

}

// github.com/andy489

#include<algorithm>
#include<iostream>
#include<list>

int main() {
    using namespace std;

    list<int> nums { 61, 41, 231, 764, 45 };
    nums.sort();

    for (int num : nums) {
        cout << num << " ";
    }
    cout << endl;

    nums.sort(std::greater<int>());
    for (int num : nums) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}

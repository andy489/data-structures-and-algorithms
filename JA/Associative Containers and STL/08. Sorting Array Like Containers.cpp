#include<algorithm>
#include<iostream>
#include<vector>

int main() {
    using namespace std;

    vector<int> numsVector { 61, 41, 231, 764, 45 };
    sort(numsVector.begin(), numsVector.end(), std::greater<int>());
    for (int num : numsVector) {
        cout << num << " ";
    }
    cout << endl;

    cout << endl;

    string wordsArray[6] { "whales", "cats", "dogs", "fish", "cheetahs", "dodos" };
    sort(wordsArray, wordsArray + 6);
    for (string word : wordsArray) {
        cout << word << " ";
    }
    cout << endl;

    return 0;
}

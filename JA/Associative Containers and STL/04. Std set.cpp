// github.com/andy489

#include<iostream>
#include<set>
#include<string>
#include<sstream>

int main() {
    using namespace std;

    set<int> digits { 4, 1, 4, 0, 2, 6, 9, 1, 8, 6, 2, 3, 5, 6, 7 };

    for (int d : digits) {
        cout << d << " ";
    }
    cout << endl;

    cout << endl;

    set<char> letters;
    string sentence = "the quick brown fox jumps over the lazy dog";
    istringstream sentenceIn(sentence);
    char letter;
    while (sentenceIn >> letter) {
        letters.insert(letter);
    }

    for (set<char>::iterator i = letters.begin(); i != letters.end(); i++) {
        cout << *i;
    }
    cout << endl;

    return 0;
}

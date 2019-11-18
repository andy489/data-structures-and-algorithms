#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

string changeLetters(string s, unordered_map<char, char> letterChangeMap) {
    string changed(s.size(), ' ');
    for (size_t i = 0; i < s.size(); i++) {
        char originalChar = s[i];
        if (isalpha(originalChar)) {
            /// NOTE: we know that every char will have a matching char
            changed[i] = letterChangeMap[originalChar];
        } else {
            changed[i] = originalChar;
        }
    }

    return changed;
}

string encrypt(string text, string encryption) {
    unordered_map<char, char> encryptionMap;

    for (int i = 0; i < encryption.size(); i++) {
        char encryptedChar = encryption[i];
        char actualChar = 'a' + i;
        encryptionMap[actualChar] = encryptedChar;
    }

    return changeLetters(text, encryptionMap);
}

string decrypt(string text, string encryption) {
    unordered_map<char, char> encryptionMap;

    for (int i = 0; i < encryption.size(); i++) {
        char encryptedChar = encryption[i];
        char actualChar = 'a' + i;
        encryptionMap[encryptedChar] = actualChar;
    }

    return changeLetters(text, encryptionMap);
}

int main() {
    string start;
    getline(cin, start);

    unordered_map<string, vector<string> > groupsByStart;
    string message;
    getline(cin, message);
    while (message != "[encryptions]") {
        string messageStart = message.substr(0, start.size());
        groupsByStart[messageStart].push_back(message);

        getline(cin, message);
    }

    vector<string> maxGroup;
    string maxGroupTable;

    string encryptionTable;
    getline(cin, encryptionTable);
    while (encryptionTable != "[end]") {
        string encryptedStart = encrypt(start, encryptionTable);

        if (maxGroup.size() < groupsByStart[encryptedStart].size()) {
            maxGroup = groupsByStart[encryptedStart];
            maxGroupTable = encryptionTable;
        }

        getline(cin, encryptionTable);
    }

    for (string message : maxGroup) {
        cout << decrypt(message, maxGroupTable) << endl;
    }

    return 0;
}

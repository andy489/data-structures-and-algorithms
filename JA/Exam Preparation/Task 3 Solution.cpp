#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;


vector<string> getStrings(string originalString) {
    vector<string> strings;

    istringstream in(originalString);

    string s;
    while (in >> s) {
        strings.push_back(s);
    }

    return strings;
}

vector<string> readLineOfString() {
    string line;
    getline(cin, line);

    return getStrings(line);
}

int main() {
    vector<string> keys = readLineOfString();

    typedef map<string, string> Entity;
    vector<Entity> entities;

    string line;
    getline(cin, line);
    while (line != "end") {
        vector<string> values = getStrings(line);

        Entity e;
        for (int i = 0; i < keys.size(); i++) {
            e[keys[i]] = values[i];
        }

        entities.push_back(e);

        getline(cin, line);
    }

    string searchKey;
    getline(cin, searchKey);

    map<string, int> occurencesByValue;
    for (Entity e : entities) {
        occurencesByValue[e[searchKey]]++;
    }

    string maxValue;
    int maxOccurrences = 0;
    for (pair<string, int> occurenceByValue : occurencesByValue) {
        if (occurenceByValue.second > maxOccurrences) {
            maxOccurrences = occurenceByValue.second;
            maxValue = occurenceByValue.first;
        }
    }

    cout << maxValue << " " << maxOccurrences << endl;

    return 0;
}

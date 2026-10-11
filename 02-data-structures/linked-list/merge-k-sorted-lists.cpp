/*
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * Example
 * Input:
 * 1->4->5
 * 1->3->4
 * 2->6
 * 
 * Output
 * 1->1->2->3->4->4->5->6
*/

#include <iostream>
#include <cstring>
#include <sstream>
#include <vector>
#include <list>

using namespace std;

void parse(string &text) {
    string delimiters(",->");

    char *next_token = nullptr;
    char *token = strtok_r(const_cast<char *>(text.c_str()), delimiters.c_str(), &next_token);

    string parsed;

    while (token != nullptr) {
        parsed.append(token);
        parsed.append(" ");

        token = strtok_r(nullptr, delimiters.c_str(), &next_token);
    }
    
    text = parsed;
}

int main() {
    vector<list<int>> lists;

    string text;
    getline(cin, text);

    while (text != "]") {
        if (text == "[") {
            getline(std::cin, text);
            
            continue;
        }

        list<int> A;

        parse(text);
        istringstream istream(text);
        int element;
        istream >> element;
        
        while (istream) {
            A.push_back(element);
            istream >> element;
        }
        
        lists.push_back(A);
        
        getline(cin, text);
    }

    list<int> result;

    int min;
    int min_index;

    int SIZE = lists.size();

    while (!lists.empty()) {
        min = lists[0].front();
        min_index = 0;
        
        for (int i = 0; i < SIZE; ++i) {
            if (lists[i].front() < min) {
                min = lists[i].front();
                min_index = i;
            }
        }
        
        result.push_back(min);
        lists[min_index].pop_front();
        
        if (lists[min_index].empty()) {
            lists.erase(lists.begin() + min_index);
            SIZE = lists.size();
        }
    }

    for (auto &node : result) {
        cout << node;

        if (&node != &result.back()) {
            cout << "->";
        }
    }

    return 0;
}
// function that removes all min elements in a queue

#include <iostream>
#include <queue>
#include <ctime>

using namespace std;

const int MAX = 1e9;
const int MIN = -1e9;

void display_queue(queue<int> q) { // makes a copy
    while (!q.empty()) {
        cout << q.front() << ' ';
        q.pop();
    }
    
    cout << endl;
}

void remove_min_elements_from_queue(queue<int> &q) { // works with original
    int min(MAX);
    int cnt = 0;
    int curr_el;

    int SIZE = q.size();
    if (SIZE == 0) {
        return;
    }
    
    while (SIZE) {
        curr_el = q.front();
        q.pop();
        
        if (min > curr_el) {
            if (min != MIN) {
                while (cnt) {
                    q.push(min);
                    --cnt;
                }
            }
            
            min = curr_el;
            ++cnt;
        } else if (min == curr_el) {
            ++cnt;
        }
        else {
            q.push(curr_el);
        }
        
        --SIZE;
    }
}

int main() {
    queue<int> q;

    srand(time(nullptr));

    int n = 10 + rand() % 15;

    for (int i = 0; i < n; ++i) {
        q.push(1 + rand() % 10);
    }

    display_queue(q);

    remove_min_elements_from_queue(q);
    display_queue(q);

    remove_min_elements_from_queue(q);
    display_queue(q);

    remove_min_elements_from_queue(q);
    display_queue(q);
    //etc.
    return 0;
}

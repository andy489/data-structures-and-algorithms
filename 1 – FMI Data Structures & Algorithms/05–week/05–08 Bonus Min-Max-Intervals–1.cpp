// https://www.hackerrank.com/contests/practice-5-sda/challenges/min-max-intervals

#include <iostream>
#include <queue>
#include <list>

using namespace std;

const int MIN = -1e9;
const int MAX = 1e9;

struct MyQueue {
    list<int> _q, _min, _max;
    int size = 0;

    void push(int num) {
        ++size;
        _q.push_back(num);
        
        while (!_min.empty() && _min.back() > num) {
            _min.pop_back();
        }
        
        _min.push_back(num);
        
        while (!_max.empty() && _max.back() < num) {
            _max.pop_back();
        }
        
        _max.push_back(num);
    }

    void pop() {
        --size;
        
        if (_min.front() == _q.front()) {
            _min.pop_front();
        }

        if (_max.front() == _q.front()) {
            _max.pop_front();
        }
        
        _q.pop_front();
    }

    int min() {
        if (size == 0) {
            return MAX;
        }
        
        return _min.front();
    }

    int max() {
        if (size == 0) {
            return MIN;
        }
        
        return _max.front();
    }
};

int main() {
    /*
    MyQueue queue;
    cout << "8 1 4 7 2 3" << endl;
     
    queue.push(8);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.push(1);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.push(4);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.push(7);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.push(2);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.push(3);
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    cout << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;
     
    queue.pop();
    cout << "min " << queue.min() << endl;
    cout << "MAX " << queue.max() << endl;

    We designed our queue in such way that 
    TOTAL time complexity of the above 
    operations is O(n) on average
    */

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, k, e;
    cin >> n >> k;

    queue<int> q;
    MyQueue special_queue;

    for (int i =0; i < n; ++i) {
        cin >> e; // element
        q.push(e);
    }

    long long total_cnt = n;

    while (!q.empty()) {
        special_queue.push(q.front());
        q.pop();

        while (special_queue.max() - special_queue.min() > k) {
            special_queue.pop();
        }
        
        if (special_queue.max() - special_queue.min() <= k && special_queue.size > 1) {
            total_cnt += special_queue.size - 1;
        }
    }

    cout << total_cnt;
    
    return 0;
}
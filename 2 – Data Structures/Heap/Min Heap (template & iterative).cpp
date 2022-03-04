#include <iostream>
#include <vector>
#include <queue>

using namespace std;

template<class T>
struct Heap {
private:
    vector<T> arr;
    T t{};

    int getParent(int child) {
        return child % 2 == 0 ? child / 2 - 1 : child / 2;
    }

    int getLeftChild(int parent) {
        return parent * 2 + 1;
    }

    int getRightChild(int parent) {
        return parent * 2 + 2;
    }

    void sift_up(int ind) {
        int child = ind;
        int parent = getParent(child);
        while (arr[child] < arr[parent] && parent != -1) {
            swap(arr[child], arr[parent]);
            child = parent;
            parent = getParent(child);
        }
    }

    void sift_down(int ind) {
        int parent = ind;
        
        while (true) {
            int l = getLeftChild(parent), r = getRightChild(parent);
            int len = arr.size(), smallest = parent;

            if (l < len && arr[l] < arr[smallest]) {
                smallest = l;
            }
            
            if (r < len && arr[r] < arr[smallest]) {
                smallest = r;
            }
            
            if (smallest == parent) {
                break;
            }
            
            swap(arr[smallest], arr[parent]);
            parent = smallest;
        }
    }

public:
    Heap() = default;

    void build(const vector<T> &v) {
        arr.clear();
        arr.assign(v.begin(), v.end());
        
        int sz = (v.size() - 1) / 2;
        
        for (int i = sz; i >= 0; --i) {
            sift_down(i);
        }
    }

    void insert(T val) {
        arr.push_back(val);
        sift_up(size() - 1);
        t = arr[0];
    }

    T pop() {
        int child = (int)arr.size() - 1;
        
        if (child == 0) {
            T top = arr[0];
            arr.pop_back();
            return top;
        }
        
        swap(arr[child], arr[0]);
        T top = arr.back();
        arr.pop_back();
        
        sift_down(0);
        
        t = top;
        return top;
    }

    T peek() {
        return t;
    }

    bool empty() {
        return arr.size();
    }

    int size() {
        return arr.size();
    }

    void print() {
        while (!empty()) {
            cout << pop() << ' ';
        }
        
        cout << endl;
    }
};


int main() {
    vector<int> v1 = {4, 3, 1, 14, -10, 22, 19, 4, 0, -3};
    priority_queue<int, vector<int>, greater<int>> pq1;
    Heap<int> h1;
    
    for (int & i : v1) {
        h1.insert(i);
        pq1.push(i);
        assert(h1.peek() == pq1.top());
    }
    
    while (!pq1.empty()) {
        assert(pq1.top() == h1.pop());
        pq1.pop();
        assert(h1.size() == pq1.size());
    }

    Heap<string> h2;
    priority_queue<string, vector<string>, greater<string>> pq2;
    vector<string> v2 = {"zzz", "casa", "abc", "aaa", "hey", "check"};
    h2.build(v2);
    
    for (auto & i : v2) {
        pq2.push(i);
    }
    
    while (!pq2.empty()) {
        assert(pq2.top() == h2.pop());
        pq2.pop();
        assert(h2.size() == pq2.size());
    }
    
    return 0;
}

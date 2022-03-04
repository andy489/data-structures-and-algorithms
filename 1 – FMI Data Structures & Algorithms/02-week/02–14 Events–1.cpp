// https://www.hackerrank.com/contests/practice-2-sda/challenges
// Schedule SDA

#include <iostream>
#include <vector>

using namespace std;

struct Event {
    int start, end;

    Event() : start(0), end(0) {};

    Event(int start, int end) : start(start), end(end) {};
};

int partition(vector<Event> &events, int start, int end) {
    int mid_index = start + (end - start) / 2;
    swap(events[mid_index], events[end]);

    int pivot = events[end].end;
    int piv_index = start;

    for (int i = start; i < end; i++) {
        if (events[i].end <= pivot) {
            swap(events[i], events[piv_index]);
            piv_index++;
        }
    }
    swap(events[piv_index], events[end]);

    return piv_index;
}

void quick_sort(vector<Event> &events, int start, int end) {
    if (start >= end) {
        return;
    }

    int pivot = partition(events, start, end);

    quick_sort(events, start, pivot - 1);
    quick_sort(events, pivot + 1, end);
}

size_t max_events(vector<Event> &events) {
    int cnt = 1;
    int r1 = events[0].end;
    int SIZE = events.size();

    for (int i = 1; i < SIZE; ++i) {
        int l1 = events[i].start, r2 = events[i].end;

        if (l1 >= r1) {
            ++cnt, r1 = r2;
        }
    }

    return cnt;
}

int main() {
    int n;
    cin >> n;

    if (n == 0) {
        return cout << 0, 0;
    }

    vector<Event> events;
    events.reserve(n);

    int s, e;
    for (int i =0; i < n; ++i) {
        cin >> s >> e;
        events.emplace_back(s, s + e);
    }

    quick_sort(events, 0, n - 1);

    return cout << max_events(events), 0;
}

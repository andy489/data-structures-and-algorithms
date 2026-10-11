/* logic that will work even with input data in the form "asd23s  kjd30n x1 &$3ds" instead of "23 30 1 3" .
The following logic literally extracts all numbers from a given text, covering their lengths and delimiters.
For example if we have a text like "Example1, number 12 asd489asd. 1st and 2nd. 00asd" The stack will be filled with:
1, 12, 489, 1, 2 and 0. Stack operations are performed for a constant time. */

#include <iostream>
#include <stack>
#include <iomanip>

using namespace std;

int get_duration_of_journey_in_minutes(const string &line) {
    // utility stack to store extracted numbers from line from back to front
    stack<int> num_util; // utility stack with numbers
    // the idea is to extract numbers from string using the idea from Reverse Polish Notation
    int length = line.length();

    int cnt = 0;
    for (int i = 0; i < length; ++i) {
        if (line[i] >= '0' && line[i] <= '9') {
            if (cnt > 0) {
                int number = num_util.top() * 10 + (line[i] - '0');

                num_util.pop();
                num_util.push(number);
            } else {
                num_util.push(line[i] - '0');
                ++cnt;
            }
        } else {
            cnt = 0;
        }
    }

    stack<int> num;

    while (!num_util.empty()) {
        num.push(num_util.top());
        num_util.pop();
    } // now in min stack we have extracted all numbers from the input line

    size_t hoursStart, minStart, hoursFin, minFin;
    hoursStart = num.top();
    num.pop();

    minStart = num.top();
    num.pop();

    hoursFin = num.top();
    num.pop();

    minFin = num.top();
    num.pop();

    int minutes1 = hoursStart * 60 + minStart;
    int minutes2 = hoursFin * 60 + minFin;
    int check;

    if (minutes1 <= minutes2) {
        check = 0;
    } else {
        check = 24 * 60;
    }

    int diff = check + minutes2 - minutes1;
    
    return diff;
}

int main() {
    int durations[3];
    int index = 0;
    
    for (int i =0; i < 3; ++i) {
        string line;
        getline(cin, line);
        durations[index++] = get_duration_of_journey_in_minutes(line);
    }
    
    int min_trip = 24 * 60;
    int max_trip = 0;

    for (int duration : durations) {
        if (duration > max_trip) max_trip = duration;
        if (duration < min_trip) min_trip = duration;
    }
    
    cout << min_trip / 60 << ':' << setfill('0') << setw(2) << min_trip % 60 << endl;
    cout << max_trip / 60 << ':' << setfill('0') << setw(2) << max_trip % 60 << endl;
    
    return 0;
}

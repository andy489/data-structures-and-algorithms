// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector <vector<int>> &stations) {
        if (startFuel >= target) {
            return 0;
        }

        priority_queue<int> pq;

        int minRefuels = 0;

        for (const auto &station : stations) {
            while (startFuel < station[0]) {
                if (pq.empty()) {
                    return -1;
                }

                startFuel += pq.top();
                pq.pop();
                
                minRefuels++;
            }

            pq.push(station[1]);
        }

        while (startFuel < target) {
            if (pq.empty()) {
                return -1;
            }

            startFuel += pq.top();
            pq.pop();
            minRefuels++;
        }

        return minRefuels;
    }
};

//https://leetcode.com/problems/keys-and-rooms/

class Solution {
public:
    bool canVisitAllRooms(vector <vector<int>> &rooms) {
        vector<bool> visited(rooms.size());

        stack<int> s;
        s.push(0);

        visited[0] = true;

        while (!s.empty()) {
            int cur = s.top();
            s.pop();

            for (int child:rooms[cur]) {
                if (!visited[child]) {
                    s.push(child);
                    visited[child] = true;
                }
            }
        }

        for (const auto &x:visited) {
            if (!x) {
                return false;
            }
        }

        return true;
    }
};

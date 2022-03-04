// https://leetcode.com/problems/course-schedule-ii

class Solution {
public:
    vector<int> findOrder(int num_courses, vector<vector<int>> &prerequisites) {
        vector<list<int>> in(num_courses);
        vector<list<int>> out(num_courses);

        for (const auto &constraint : prerequisites) {
            in[constraint[0]].push_back(constraint[1]);
            out[constraint[1]].push_back(constraint[0]);
        }

        queue<int> sources;
        vector<int> top_sort;

        for (int i = 0; i < num_courses; ++i) {
            if (in[i].empty()) {
                sources.push(i);
            }
        }

        while (!sources.empty()) {
            int curr = sources.front();
            sources.pop();

            top_sort.push_back(curr);

            for (int v : out[curr]) {
                in[v].pop_back();
                if (in[v].empty()) {
                    sources.push(v);
                }
            }
        }

        for (const auto &e : in) {
            if (!e.empty()) { // at least one cycle
                return {};
            }
        }

        return top_sort;
    }
};
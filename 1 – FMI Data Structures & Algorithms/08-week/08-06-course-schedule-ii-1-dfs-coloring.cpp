// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    vector <list<int>> copy;
    vector<int> top_sort;
    vector<bool> temp_mark;
    vector<bool> perm_mark;

    bool is_acyclic(int u) {
        if (perm_mark[u]) {
            return true;
        }

        if (temp_mark[u]) {
            return false;
        }

        temp_mark[u] = true;

        for (int child : copy[u]) {
            if (is_acyclic(child)) {
                continue;
            }

            return false;
        }

        top_sort.push_back(u);
        perm_mark[u] = true;
        temp_mark[u] = false;
        return true;
    }

public:
    vector<int> findOrder(int num_courses, vector <vector<int>> &prerequisites) {
        copy.resize(num_courses, list<int>());

        const int CONSTRAINS = prerequisites.size();

        for (const auto& constraint : prerequisites) {
            copy[constraint[0]].push_back(constraint[1]);
        }

        top_sort.reserve(num_courses);
        temp_mark.resize(num_courses, false);
        perm_mark.resize(num_courses, false);

        for (int i = 0; i < num_courses; ++i) {
            if (!perm_mark[i]) {
                if (!perm_mark[i] && !is_acyclic(i)) {
                    return {};
                }
            }
        }

        return top_sort;
    }
};
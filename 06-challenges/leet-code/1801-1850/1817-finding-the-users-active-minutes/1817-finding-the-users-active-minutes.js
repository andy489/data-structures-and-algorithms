// https://leetcode.com/problems/finding-the-users-active-minutes/

var findingUsersActiveMinutes = function(logs, k) {
    const uam = new Map();
    for (const [id, t] of logs) {
        if (!uam.has(id)) uam.set(id, new Set());
        uam.get(id).add(t);
    }
    const ans = new Array(k).fill(0);
    for (const minutes of uam.values()) {
        const cnt = minutes.size;
        if (cnt <= k) ans[cnt - 1]++;
    }
    return ans;
};

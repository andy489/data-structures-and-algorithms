// https://leetcode.com/problems/find-latest-group-of-size-m/

var findLatestStep = function(arr, m) {
    const n = arr.length;
    const size = new Array(n + 2).fill(0);
    const parent = Array.from({length: n + 2}, (_, i) => i);
    const active = new Array(n + 2).fill(false);
    const groupCount = new Array(n + 1).fill(0);
    let result = -1;

    const find = (x) => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    const union = (a, b) => {
        const ra = find(a), rb = find(b);
        if (ra === rb) {
            return;
        }
        groupCount[size[ra]]--;
        groupCount[size[rb]]--;
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
            groupCount[size[rb]]++;
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
            groupCount[size[ra]]++;
        }
    };

    for (let step = 0; step < n; step++) {
        const pos = arr[step];
        active[pos] = true;
        size[pos] = 1;
        groupCount[1]++;
        if (active[pos - 1]) {
            union(pos - 1, pos);
        }
        if (active[pos + 1]) {
            union(pos, pos + 1);
        }
        if (groupCount[m] > 0) {
            result = step + 1;
        }
    }
    return result;
};

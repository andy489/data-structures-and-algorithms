// https://leetcode.com/problems/find-all-people-with-secret/

// Solution: Union-Find by time groups — O(m log m) time, O(n) space
var findAllPeople = function(n, meetings, firstPerson) {
    const parent = Array.from({length: n}, (_, i) => i);
    const find = (x) => { while (parent[x] !== x) { parent[x] = parent[parent[x]]; x = parent[x]; } return x; };
    const union = (a, b) => { a = find(a); b = find(b); if (a !== b) parent[b] = a; };
    union(0, firstPerson);
    meetings.sort((a, b) => a[2] - b[2]);
    let i = 0;
    while (i < meetings.length) {
        let j = i, t = meetings[i][2];
        while (j < meetings.length && meetings[j][2] === t) j++;
        const people = new Set();
        for (let k = i; k < j; k++) { union(meetings[k][0], meetings[k][1]); people.add(meetings[k][0]); people.add(meetings[k][1]); }
        for (const p of people) { if (find(p) !== find(0)) parent[p] = p; }
        i = j;
    }
    const root0 = find(0);
    return [...Array(n).keys()].filter(p => find(p) === root0);
};

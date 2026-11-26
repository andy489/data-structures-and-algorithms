// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

var groupThePeople = function(groupSizes) {
    const pending = new Map(), res = [];
    for (let i = 0; i < groupSizes.length; i++) {
        const sz = groupSizes[i];
        if (!pending.has(sz)) pending.set(sz, []);
        pending.get(sz).push(i);
        if (pending.get(sz).length === sz) { res.push([...pending.get(sz)]); pending.get(sz).length = 0; }
    }
    return res;
};

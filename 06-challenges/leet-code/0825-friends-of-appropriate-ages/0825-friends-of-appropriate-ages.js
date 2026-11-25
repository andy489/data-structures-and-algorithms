// https://leetcode.com/problems/friends-of-appropriate-ages/

var numFriendRequests = function(ages) {
    const count = new Array(121).fill(0);
    for (const a of ages) { count[a]++; }
    let requests = 0;
    for (let a = 1; a <= 120; a++) {
        for (let b = 1; b <= 120; b++) {
            if (b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)) { continue; }
            requests += count[a] * count[b];
            if (a === b) { requests -= count[a]; }
        }
    }
    return requests;
};

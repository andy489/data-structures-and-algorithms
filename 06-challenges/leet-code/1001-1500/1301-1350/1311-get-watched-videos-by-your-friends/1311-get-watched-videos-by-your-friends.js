// https://leetcode.com/problems/get-watched-videos-by-your-friends/

var watchedVideosByFriends = function(watchedVideos, friends, id, level) {
    const visited = new Set([id]);
    let q = [id];
    for (let lv = 0; lv < level; lv++) {
        const next = [];
        for (const cur of q) {
            for (const f of friends[cur]) {
                if (!visited.has(f)) { visited.add(f); next.push(f); }
            }
        }
        q = next;
    }
    const freq = new Map();
    for (const person of q) {
        for (const v of watchedVideos[person]) freq.set(v, (freq.get(v)||0)+1);
    }
    return [...freq.keys()].sort((a,b) => freq.get(a) !== freq.get(b) ? freq.get(a)-freq.get(b) : a.localeCompare(b));
};

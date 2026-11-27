// https://leetcode.com/problems/video-stitching/

var videoStitching = function(clips, time) {
    const maxEnd = new Array(time + 1).fill(0);
    for (const [s, e] of clips) {
        if (s <= time) maxEnd[s] = Math.max(maxEnd[s], e);
    }
    let count = 0, curEnd = 0, nextEnd = 0;
    for (let i = 0; i < time; i++) {
        nextEnd = Math.max(nextEnd, maxEnd[i]);
        if (i === curEnd) {
            if (nextEnd <= curEnd) return -1;
            count++;
            curEnd = nextEnd;
        }
    }
    return count;
};

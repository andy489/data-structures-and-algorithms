// https://leetcode.com/problems/count-mentions-per-user/
/**
 * @param {number} numberOfUsers
 * @param {string[][]} events
 * @return {number[]}
 */
var countMentions = function(numberOfUsers, events) {
    events.sort((a, b) => {
        const ta = parseInt(a[1]);
        const tb = parseInt(b[1]);
        if (ta !== tb) {
            return ta - tb;
        }
        return a[0] === 'OFFLINE' ? -1 : 1;
    });

    const mentions = new Array(numberOfUsers).fill(0);
    const offlineUntil = new Array(numberOfUsers).fill(0);

    for (const [type, timeStr, data] of events) {
        const time = parseInt(timeStr);
        if (type === 'OFFLINE') {
            const userId = parseInt(data);
            offlineUntil[userId] = time + 60;
        } else {
            if (data === 'ALL') {
                for (let i = 0; i < numberOfUsers; i++) {
                    mentions[i]++;
                }
            } else if (data === 'HERE') {
                for (let i = 0; i < numberOfUsers; i++) {
                    if (offlineUntil[i] <= time) {
                        mentions[i]++;
                    }
                }
            } else {
                for (const token of data.split(' ')) {
                    const userId = parseInt(token.substring(2));
                    mentions[userId]++;
                }
            }
        }
    }

    return mentions;
};

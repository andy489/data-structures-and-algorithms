// https://leetcode.com/problems/magnetic-force-between-two-balls/

var maxDistance = function(position, m) {
    position.sort((a, b) => a - b);

    const canPlace = (minDist) => {
        let count = 1, last = position[0];
        for (let i = 1; i < position.length; i++) {
            if (position[i] - last >= minDist) {
                count++;
                last = position[i];
                if (count === m) {
                    return true;
                }
            }
        }
        return count >= m;
    };

    let lo = 1, hi = position[position.length - 1] - position[0];
    while (lo < hi) {
        const mid = Math.floor((lo + hi + 1) / 2);
        if (canPlace(mid)) {
            lo = mid;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
};

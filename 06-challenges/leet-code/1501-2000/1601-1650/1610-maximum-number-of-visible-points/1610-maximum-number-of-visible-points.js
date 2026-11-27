// https://leetcode.com/problems/maximum-number-of-visible-points/

var visiblePoints = function(points, angle, location) {
    const [lx, ly] = location;
    const angles = [];
    let atOrigin = 0;

    for (const [x, y] of points) {
        const dx = x - lx, dy = y - ly;
        if (dx === 0 && dy === 0) {
            atOrigin++;
        } else {
            angles.push(Math.atan2(dy, dx) * 180 / Math.PI);
        }
    }

    angles.sort((a, b) => a - b);
    const doubled = [...angles, ...angles.map(a => a + 360)];

    let maxVisible = 0;
    let left = 0;
    for (let right = 0; right < doubled.length; right++) {
        while (doubled[right] - doubled[left] > angle) {
            left++;
        }
        maxVisible = Math.max(maxVisible, right - left + 1);
    }

    return maxVisible + atOrigin;
};

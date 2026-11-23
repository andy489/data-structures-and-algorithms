/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayNesting = function (nums) {
    const visited = new Array(nums.length).fill(false);
    let max = 0;
    for (let i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }
        let count = 0;
        let j = i;
        while (!visited[j]) {
            visited[j] = true;
            j = nums[j];
            count++;
        }
        max = Math.max(max, count);
    }
    return max;
};

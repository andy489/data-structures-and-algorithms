class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int count = 0;
            int j = i;
            while (nums[j] != -1) {
                int next = nums[j];
                nums[j] = -1;
                j = next;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

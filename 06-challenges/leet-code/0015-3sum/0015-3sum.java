// https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            
            int l = i + 1;
            int r = n - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum < 0) {
                    ++l;
                } else if (sum > 0) {
                    --r;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                   
                    while (l + 1 < r && nums[l] == nums[l + 1]){
                        ++l;
                    }
                    
                    while (l < r - 1 && nums[r - 1] == nums[r]){
                        --r;
                    }
                   
                    ++l;
                    --r;
                }
            }
        }
        
        return res;
    }
}

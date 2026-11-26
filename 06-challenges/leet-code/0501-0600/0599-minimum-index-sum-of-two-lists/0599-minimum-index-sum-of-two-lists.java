// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexInList1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexInList1.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (indexInList1.containsKey(list2[j])) {
                int indexSum = indexInList1.get(list2[j]) + j;
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear();
                    result.add(list2[j]);
                } else if (indexSum == minIndexSum) {
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}

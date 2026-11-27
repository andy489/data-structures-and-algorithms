// https://leetcode.com/problems/adding-two-negabinary-numbers/

// Solution: Bit-by-Bit Addition with Carry — O(max(m,n)) time, O(max(m,n)) space
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? arr1[i--] : 0;
            int b = j >= 0 ? arr2[j--] : 0;
            int sum = a + b + carry;
            res.add(sum & 1);
            carry = -(sum >> 1);
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

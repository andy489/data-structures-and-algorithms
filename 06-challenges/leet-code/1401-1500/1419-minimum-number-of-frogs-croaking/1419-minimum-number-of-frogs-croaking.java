// https://leetcode.com/problems/minimum-number-of-frogs-croaking/

// Solution: Counter Simulation — O(n) time, O(1) space
class Solution {
    public int minNumberOfFrogs(String s) {
        int c=0,r=0,o=0,a=0,k=0,maxFrogs=0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'c': c++; break;
                case 'r': if(c==0) return -1; c--; r++; break;
                case 'o': if(r==0) return -1; r--; o++; break;
                case 'a': if(o==0) return -1; o--; a++; break;
                case 'k': if(a==0) return -1; a--; k++; break;
            }
            maxFrogs = Math.max(maxFrogs, c+r+o+a);
        }
        return (c==0&&r==0&&o==0&&a==0) ? maxFrogs : -1;
    }
}

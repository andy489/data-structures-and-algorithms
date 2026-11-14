# https://leetcode.com/problems/tenth-line/

# Solution: sed — select by line number — O(n) time, O(1) space
sed -n '10p' file.txt

# Solution 2: awk — line counter — O(n) time, O(1) space
awk 'NR==10{print; exit}' file.txt

# Solution 3: head + tail — pipeline — O(1) time, O(1) space
head -10 file.txt | tail -1

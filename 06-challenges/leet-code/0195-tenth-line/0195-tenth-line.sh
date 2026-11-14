# https://leetcode.com/problems/tenth-line/

# Solution: sed — select by line number — O(n) time, O(1) space
sed -n '10p' file.txt

# Solution 2: awk — NR counter with early exit — O(n) time, O(1) space
awk 'NR==10{print; exit}' file.txt

# Solution 3: awk — store line 10, print only if file has >= 10 lines — O(n) time, O(1) space
awk 'NR==10{line=$0} END{if(NR>=10) print line}' file.txt

# Solution 4: perl — line counter — O(n) time, O(1) space
perl -ne 'print if $.==10' file.txt

# Solution 5: bash — while read loop with counter — O(n) time, O(1) space
cnt=0; while IFS= read -r line; do cnt=$((cnt+1)); [ $cnt -eq 10 ] && echo "$line" && break; done < file.txt

# Solution 6: mapfile (bash 4+) — load into array, index directly — O(n) time, O(n) space
mapfile -t lines < file.txt; [ ${#lines[@]} -ge 10 ] && echo "${lines[9]}"

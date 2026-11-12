# https://leetcode.com/problems/valid-phone-numbers/

# Solution: grep -E (anchored ERE pattern) — O(n) time, O(1) space
grep -E '^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$' file.txt

# Solution 2: grep -P (Perl-compatible regex) — O(n) time, O(1) space
grep -P '^(\(\d{3}\) |\d{3}-)\d{3}-\d{4}$' file.txt

# Solution 3: awk — implicit match — O(n) time, O(1) space
awk '/^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$/' file.txt

# Solution 4: sed — print only matching lines — O(n) time, O(1) space
sed -n -E '/^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$/p' file.txt

# Solution 5: perl — O(n) time, O(1) space
perl -ne 'print if /^(\(\d{3}\) |\d{3}-)\d{3}-\d{4}$/' file.txt

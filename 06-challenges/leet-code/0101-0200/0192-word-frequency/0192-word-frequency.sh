# https://leetcode.com/problems/word-frequency/

# Solution 1: tr + sort + uniq pipeline — O(n log n) time, O(n) space
tr -s ' ' '\n' < words.txt | grep -v '^$' | sort | uniq -c | sort -rn | awk '{ print $2, $1 }'

# Solution 2: awk word-count map — O(n) time, O(k log k) sort
awk '{
    for (i = 1; i <= NF; i++) {
        freq[$i]++
    }
}
END {
    for (word in freq) {
        print freq[word], word
    }
}' words.txt | sort -rn | awk '{ print $2, $1 }'

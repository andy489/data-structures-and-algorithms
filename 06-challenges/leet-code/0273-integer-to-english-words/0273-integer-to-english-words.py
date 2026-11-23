# https://leetcode.com/problems/integer-to-english-words/

class Solution:
    ONES = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    TENS = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    SCALES = ["", " Thousand", " Million", " Billion"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        def helper(n):
            if n == 0:
                return ""
            if n < 20:
                return self.ONES[n]
            if n < 100:
                return self.TENS[n // 10] + (" " + self.ONES[n % 10] if n % 10 else "")
            return self.ONES[n // 100] + " Hundred" + (" " + helper(n % 100) if n % 100 else "")

        parts = []
        for i in range(3, -1, -1):
            divisor = 1000 ** i
            if num // divisor > 0:
                parts.append(helper(num // divisor) + self.SCALES[i])
                num %= divisor
        return " ".join(parts)

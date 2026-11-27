# https://leetcode.com/problems/maximum-value-of-concatenated-binary-segments/
class Solution:
    def maximumValue(self, nums1: list[int], nums0: list[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums1)

        def seg_value(ones: int, zeros: int) -> int:
            # Value = (2^ones - 1) * 2^zeros
            return ((pow(2, ones, MOD) - 1) * pow(2, zeros, MOD)) % MOD

        # Sort: segment A before B if concatenating A+B gives larger value
        def compare_key(i: int):
            ones = nums1[i]
            zeros = nums0[i]
            len_seg = ones + zeros
            # For comparison purposes, we can approximate with float
            val = ((1 << ones) - 1) * (1 << zeros) if ones + zeros <= 60 else float('inf')
            return (ones, zeros, len_seg)

        # Custom sort: A before B if A*2^len(B) + val(B) > B*2^len(A) + val(A)
        from functools import cmp_to_key

        def cmp(a: int, b: int) -> int:
            onesA, zerosA = nums1[a], nums0[a]
            onesB, zerosB = nums1[b], nums0[b]
            lenA = onesA + zerosA
            lenB = onesB + zerosB
            # valA = (2^onesA - 1) * 2^zerosA, valB similarly
            # Compare valA * 2^lenB + valB vs valB * 2^lenA + valA
            # For small sizes use exact integer arithmetic
            if lenA + lenB <= 60:
                valA = ((1 << onesA) - 1) * (1 << zerosA)
                valB = ((1 << onesB) - 1) * (1 << zerosB)
                lhs = valA * (1 << lenB) + valB
                rhs = valB * (1 << lenA) + valA
                if lhs > rhs:
                    return -1
                elif lhs < rhs:
                    return 1
                return 0
            else:
                # Float approximation
                valA = (2.0 ** onesA - 1) * 2.0 ** zerosA
                valB = (2.0 ** onesB - 1) * 2.0 ** zerosB
                lhs = valA * 2.0 ** lenB + valB
                rhs = valB * 2.0 ** lenA + valA
                if lhs > rhs:
                    return -1
                elif lhs < rhs:
                    return 1
                return 0

        indices = sorted(range(n), key=cmp_to_key(cmp))

        result = 0
        for idx in indices:
            ones = nums1[idx]
            zeros = nums0[idx]
            length = ones + zeros
            seg_val = seg_value(ones, zeros)
            result = (result * pow(2, length, MOD) + seg_val) % MOD

        return result

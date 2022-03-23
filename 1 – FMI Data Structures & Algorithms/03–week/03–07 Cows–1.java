import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private boolean validate(int mid, int[] huts, int k) {
        int n = huts.length;
        int position = huts[0];

        int cows = 1;

        for (int i = 1; i < n; i++) {
            if (huts[i] - position >= mid) {
                position = huts[i];
                cows++;

                if (cows == k) {
                    return true;
                }
            }
        }

        return false;
    }

    private int binSearchOnAns(final int[] huts, int k) {
        int n = huts.length;

        int l = huts[0];
        int r = huts[n - 1];
        int mid;

        int ans = -1;
        while (l <= r) {
            mid = l + (r - l) / 2;

            if (validate(mid, huts, k)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] huts = new int[n];

        for (int i = 0; i < n; i++) {
            huts[i] = sc.nextInt();
        }

        Arrays.sort(huts);

        Solution o = new Solution();
        System.out.println(o.binSearchOnAns(huts, k));
    }
}

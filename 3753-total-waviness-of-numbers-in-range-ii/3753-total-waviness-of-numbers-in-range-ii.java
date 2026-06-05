import java.util.*;

class Solution {

    static class Pair {
        long cnt;
        long sum;

        Pair(long c, long s) {
            cnt = c;
            sum = s;
        }
    }

    String digits;
    Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }

    private long calc(long x) {
        if (x <= 0) return 0;

        digits = Long.toString(x);

        memo = new Pair[17][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).sum;
    }

    private Pair dfs(int pos,
                     int tight,
                     int started,
                     int prev2,
                     int prev1) {

        if (pos == digits.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0 &&
            memo[pos][tight][started][prev2][prev1] != null) {
            return memo[pos][tight][started][prev2][prev1];
        }

        int limit = tight == 1 ? digits.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair child = dfs(
                        pos + 1,
                        ntight,
                        0,
                        10,
                        10
                );

                totalCnt += child.cnt;
                totalSum += child.sum;

            } else {

                int nstarted = 1;

                long add = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                int np2 = prev1 == 10 ? d : prev1;
                int np1 = d;

                Pair child = dfs(
                        pos + 1,
                        ntight,
                        nstarted,
                        np2,
                        np1
                );

                totalCnt += child.cnt;
                totalSum += child.sum + add * child.cnt;
            }
        }

        Pair ans = new Pair(totalCnt, totalSum);

        if (tight == 0) {
            memo[pos][tight][started][prev2][prev1] = ans;
        }

        return ans;
    }
}
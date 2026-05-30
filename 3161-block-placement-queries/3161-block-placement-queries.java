class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int res = 0;

            while (idx > 0) {
                res = Math.max(res, bit[idx]);
                idx -= idx & -idx;
            }

            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50005;

        TreeSet<Integer> obstacles = new TreeSet<>();

        obstacles.add(0);
        obstacles.add(MAX);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        Fenwick bit = new Fenwick(MAX + 5);

        Integer prev = null;

        for (int pos : obstacles) {

            if (prev != null) {

                bit.update(pos, pos - prev);
            }

            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                Integer left = obstacles.floor(x);

                int gapEndingAtX = x - left;

                int bestGap = Math.max(
                        bit.query(x),
                        gapEndingAtX
                );

                ans.add(bestGap >= sz);
            }

            else {

                int x = q[1];

                Integer l = obstacles.lower(x);
                Integer r = obstacles.higher(x);

                obstacles.remove(x);

                bit.update(r, r - l);
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}
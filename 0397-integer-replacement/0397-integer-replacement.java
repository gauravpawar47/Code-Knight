class Solution {
    public int integerReplacement(int n) {
        return helper(n, new HashMap<>());
    }

    private int helper(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int ans;
        if (n % 2 == 0) {
            ans = 1 + helper(n / 2, memo);
        } else {
            ans = 1 + Math.min(helper(n + 1, memo), helper(n - 1, memo));
        }

        memo.put(n, ans);
        return ans;
    }
}

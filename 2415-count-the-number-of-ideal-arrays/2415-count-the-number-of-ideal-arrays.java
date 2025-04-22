public class Solution 
{
    static final int MOD = 1_000_000_007;
    int[] fact, invFact;

    public int idealArrays(int n, int maxValue) 
    {
        int max = n + 100; // enough buffer for exponents

        // Precompute factorials and inverse factorials
        fact = new int[max];
        invFact = new int[max];
        fact[0] = 1;
        for (int i = 1; i < max; i++) 
        {
            fact[i] = (int)((long)fact[i - 1] * i % MOD);
        }

        invFact[max - 1] = modInverse(fact[max - 1]);
        for (int i = max - 2; i >= 0; i--) {
            invFact[i] = (int)((long)invFact[i + 1] * (i + 1) % MOD);
        }

        // Sieve for prime factorization
        int[] spf = sieve(maxValue);

        long result = 0;
        for (int num = 1; num <= maxValue; num++) {
            Map<Integer, Integer> primeCounts = primeFactorize(num, spf);
            long ways = 1;
            for (int exp : primeCounts.values()) {
                ways = ways * comb(n + exp - 1, exp) % MOD;
            }
            result = (result + ways) % MOD;
        }

        return (int) result;
    }

    // Calculate C(a, b) = a! / (b! * (a-b)!)
    private long comb(int a, int b) {
        if (b > a) return 0;
        return (long)fact[a] * invFact[b] % MOD * invFact[a - b] % MOD;
    }

    // Modular inverse using Fermat's little theorem
    private int modInverse(int x) {
        return pow(x, MOD - 2);
    }

    private int pow(int a, int b) {
        long res = 1, base = a;
        while (b > 0) {
            if ((b & 1) == 1) res = res * base % MOD;
            base = base * base % MOD;
            b >>= 1;
        }
        return (int) res;
    }

    // Sieve to compute smallest prime factor (SPF)
    private int[] sieve(int limit) {
        int[] spf = new int[limit + 1];
        for (int i = 2; i <= limit; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= limit; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
        return spf;
    }

    // Fast prime factorization using SPF
    private Map<Integer, Integer> primeFactorize(int num, int[] spf) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num > 1) {
            int p = spf[num];
            map.put(p, map.getOrDefault(p, 0) + 1);
            num /= p;
        }
        return map;
    }
}

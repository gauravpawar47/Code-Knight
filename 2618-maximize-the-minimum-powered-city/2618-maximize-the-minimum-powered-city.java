class Solution 
{
    public long maxPower(int[] stations, int r, int k) 
    {
        // Step 1: Compute prefix sums
        int n = stations.length;
        long sumAll = 0;
        for (int v : stations)
        {
            sumAll += v;  // total sum of all stations
        } 

        // prefix[i] = sum of stations[0..i-1]
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++)
        {
            pref[i + 1] = pref[i] + stations[i];
        } 

        // Step 2: Compute initial power (base) for each city
        long[] base = new long[n];
        for (int i = 0; i < n; i++) 
        {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            base[i] = pref[R + 1] - pref[L];  // total power affecting city i
        }

        // Step 3: Set binary search bounds
        long low = 0;
        long high = sumAll + k;  // upper bound for possible minimum power
        long ans = 0;

        // Step 4: Binary search on the answer
        while (low <= high) 
        {
            long mid = (low + high) >>> 1; // try mid as possible minimum
            if (canMake(mid, base, r, k)) // Step 5: check feasibility
            {
                ans = mid;
                low = mid + 1; // try larger minimum power
            } 
            else 
            {
                high = mid - 1; // try smaller minimum power
            }
        }

        // Step 7: Return result
        return ans;
    }

    // Step 5: Feasibility check (can we make every city have ≥ target power?)
    public boolean canMake(long target, long[] base, int r, long k) 
    {
        int n = base.length;
        long[] diff = new long[n + 1]; // difference array for range updates
        long curAdd = 0;  // cumulative extra power affecting current city
        long used = 0;    // total new stations used so far

        for (int i = 0; i < n; i++) 
        {
            curAdd += diff[i]; // apply scheduled removals/additions at i
            long curPower = base[i] + curAdd;

            // if current city has less than target power
            if (curPower < target) 
            {
                long need = target - curPower; // how many new stations needed here
                used += need;
                if (used > k)
                {
                    return false; // exceed limit, not feasible
                } 

                // place new stations greedily at the farthest point (i + r)
                curAdd += need;
                int pos = Math.min(n - 1, i + r);
                int end = Math.min(n, pos + r + 1); // where their effect ends

                // schedule removal of their effect after `end`
                diff[end] -= need;
            }
        }

        // If we managed to reach the end without exceeding k → feasible
        return true;
    }
}
public class Solution 
{
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) 
    {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        
        while (left < right) 
        {
            int mid = (left + right + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) 
            {
                left = mid;
            } 
            else 
            {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) 
    {
        int[] taskSubset = Arrays.copyOfRange(tasks, 0, k);
        int[] workerSubset = Arrays.copyOfRange(workers, workers.length - k, workers.length);
    
        int pillsLeft = pills;
        int taskIdx = k - 1;
        int workerIdx = k - 1;

        while (taskIdx >= 0) 
        {
            if (workerSubset[workerIdx] >= taskSubset[taskIdx]) 
            {
                workerIdx--;
                taskIdx--;
            } 
            else 
            {
                if (pillsLeft == 0) 
                {
                    return false;
                }
                
                int idx = findLeftmostWorker(workerSubset, 0, workerIdx, taskSubset[taskIdx] - strength);
                if (idx > workerIdx) 
                {
                    return false;
                }
                
                // Remove the worker at idx by shifting elements
                for (int i = idx; i < workerIdx; i++) 
                {
                    workerSubset[i] = workerSubset[i + 1];
                }
                
                workerIdx--;
                taskIdx--;
                pillsLeft--;
            }
        }

        return true;
    }

    private int findLeftmostWorker(int[] workers, int left, int right, int target) 
    {
        int l = left;
        int r = right;

        while (l <= r) 
        {
            int mid = (l + r) / 2;
            if (workers[mid] < target) 
            {
                l = mid + 1;
            } 
            else 
            {
                r = mid - 1;
            }
        }

        return l;
    }
}
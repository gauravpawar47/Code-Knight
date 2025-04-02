class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        int maxArea = 0;
        int n = heights.length;

        // Step 1 : Find Next Smaller to Left
        Stack<Integer> left = new Stack<>();
        int[] nsl = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!left.isEmpty() && heights[left.peek()] >= heights[i])
            {
                left.pop();
            }

            if(left.isEmpty())
            {
                nsl[i] = -1;
            }
            else
            {
                nsl[i] = left.peek();
            }

            left.push(i);
        }

        // Step 2 : Find Next Smaller to Right
        Stack<Integer> right = new Stack<>();
        int[] nsr = new int[n]; 

        for(int i = n - 1; i >= 0; i--)
        {
            while(!right.isEmpty() && heights[right.peek()] >= heights[i])
            {
                right.pop();
            }

            if(right.isEmpty())
            {
                nsr[i] = n;
            }
            else
            {
                nsr[i] = right.peek();
            }

            right.push(i);
        }        

        // Step 3 : Find the Area
        for(int i = 0; i < n; i++)
        {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;

            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
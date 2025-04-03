class Solution 
{
    public int calculate(String s) 
    {
        Stack<Integer> number = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        
        int num = 0;
        int result = 0;
        int sign = 1; // sign=1 for '+', sign=-1 for '-'
        
        for (char c : s.toCharArray()) 
        {
            if (Character.isDigit(c)) 
            {
                num = num * 10 + (c - '0'); // Handle multi-digit numbers
            } 
            else if (c == '+' || c == '-') 
            {
                result += sign * num; // Apply previous number with sign
                num = 0; 
                sign = (c == '+') ? 1 : -1; // Update sign for next number
            } 
            else if (c == '(') 
            {
                number.push(result);  // Store previous result
                signStack.push(sign);  // Store sign before '('

                result = 0;
                sign = 1; // Reset sign inside parentheses
            } 
            else if (c == ')') 
            {
                result += sign * num; // Apply last number before ')'
                num = 0;
                
                result *= signStack.pop(); // Multiply by sign before '('
                result += number.pop(); // Add previous result before '('
            }
        }
        
        return result + (sign * num); // Add remaining number
    }
}
class OrderedStream 
{
    String[] arr;
    int ptr = 0;
    List<String> st = new ArrayList<>();
    
    public OrderedStream(int n) 
    {
        arr = new String[n];    
    }
    
    public List<String> insert(int idKey, String value) 
    {
        arr[idKey - 1] =  value;
        st.clear();

        while(ptr < arr.length && arr[ptr] != null)
        {
            st.add(arr[ptr]);
            ptr++;
        }
        
        return st;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
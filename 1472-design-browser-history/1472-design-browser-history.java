class BrowserHistory 
{
    public LinkedList<String> history;
    public int currIdx;

    public BrowserHistory(String homepage) 
    {
        history = new LinkedList<>();
        history.add(homepage);
        currIdx = 0;
    }
    
    public void visit(String url) 
    {
        while(history.size() > currIdx + 1)
        {
            history.removeLast();
        }

        history.add(url);
        currIdx++;
    }
    
    public String back(int steps) 
    {
        currIdx = Math.max(currIdx - steps, 0);
        return history.get(currIdx);
    }
    
    public String forward(int steps) 
    {
        currIdx = Math.min(currIdx + steps, history.size() - 1);
        return history.get(currIdx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
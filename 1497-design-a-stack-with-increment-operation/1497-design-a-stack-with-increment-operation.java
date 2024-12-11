class CustomStack {
    int[] stackArray;
    int top;
    int len;
    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        len = maxSize;
        top = -1;
    }
    
    public void push(int x) {
        if(top == len-1){
            return;
        }
        stackArray[++top] = x;
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        int popped = stackArray[top--];

        return popped;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, top+1);
        for(int i = 0; i < limit; i++){
            stackArray[i] += val; 
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
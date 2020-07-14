class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    
    int front;
    int rear;
    boolean first;
    int arr[];
    boolean cross;
    int sum;
    public MyCircularQueue(int k) {
    front=0;
        rear=0;
        first=false;
        arr=new int[k];
        cross=false;
        sum=0;
        
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
         if(first==true && front==rear)
        {
            return false;
        }
        else
        {
        arr[rear]=value;
           first=true;
            rear++;
            sum++;
           
            if(rear==arr.length)
            {
                rear=0;
            }
            
        }
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(sum==0)
        {
            return false;
        }
        else
        {
            front++;
            sum--;
            if(front==arr.length)
            {
                front=0;
            }
            if(front==rear)
            {
                first=false;
            }
                
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
       if(sum==0)
       {
           return -1;
       }
        else
        {
            return arr[front];
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
         if(sum==0)
       {
           return -1;
       }
        else
        {
         int temp=rear-1;
            if(temp<0)
            {
                return arr[arr.length-1];
            }
            return arr[temp];
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return sum==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
      //  System.out.println("sum is"+sum);
        return sum==arr.length;
    }
}
public static class GenericStack<E>
{
    //not including globals makes things like checking size, resizing the array or making an initial constructor without magic numbers  needlessly complicated
    private E[] stack;  
    public static final int INITIAL_CAPACITY = 8;
    public int size;
    public GenericStack()
    {
        stack= (E[]) new Object[INITIAL_CAPACITY];
    }
    public GenericStack(int capacity)
    {
        stack (E[]) new Object[capacity];
    }
    public E peek()
    {
        return stack[size-1];
    }
    public void resize(int capacity)
    {
        E[] stack2 = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            stack2[i] = stack[i];
        }
        stack = stack2;
    }
    public void push(E o){
        if(size = stack.length)
        {
            resize(2*stack.length);
        }
        stack[size]= o;
        size++;
    }
    public E pop(E o)
    {
     E o = stack[size-1];
     stack[size-1] = null;
     size--;
     return o;
    }
    public 
    }
    public boolean isEmpty()
    {
        return size==0;
    }
}

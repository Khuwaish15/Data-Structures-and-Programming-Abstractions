package CSE260;
public class GenericStackWithArray<E> {
    public static final int INIT_SIZE = 8;
    public E[] stack;
    public int size;
    
    @SuppressWarnings("unchecked")
	public GenericStackWithArray() {
        stack =( E[]) new Object[INIT_SIZE];
        
    }
    public void push(E element) {
        if(size>= stack.length) {
            if(size > INIT_SIZE) {
                @SuppressWarnings("unchecked")
				E[] tmp = (E[])new Object[size*2];
            }else {
                @SuppressWarnings("unchecked")
				E[] tmp = (E[])new Object[INIT_SIZE * 2];
            }
                for(int i = 0; i < stack.length; i++) {
                stack[i] = stack[i];
                
            }
            stack = stack; 
        }
        
        stack[size++] = element; 
    }
    public E pop() {
        return stack[--size];
    }
    public E peek() {
        return stack[size-1];
    }}
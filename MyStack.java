import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY=10;


    /**
     * Provide two constructors
     * 1. takes in an int as the size of the stack
     * 2. default constructor - uses default as the size of the stack
     */

    public MyStack(int initialCapacity ){
        T[] temp_stack= (T[])new Object[initialCapacity];
        stack=temp_stack;
        topIndex=-1;

    }

    public MyStack(){
        this(DEFAULT_CAPACITY);
    }


    /**
     * Determines if Stack is empty
     * @return true if Stack is empty, false if not
     */
    @Override
    public boolean isEmpty()  {
       if(topIndex<0) {
    	   return true;
       }
       return false;
    }


    /**
     * Determines if Stack is full
     * @return true if Stack is full, false if not
     */

    @Override
    public boolean isFull() {
     return topIndex== stack.length-1;

    }

    /**
     * Deletes and returns the element at the top of the Stack
     * @return the element at the top of the Stack
     * @throws StackUnderflowException if stack is empty
     */

    @Override
    public T pop() throws StackUnderflowException {
       if(isEmpty()){
           throw new StackUnderflowException();
       }
       T top= stack[topIndex];
       stack[topIndex]= null;
       topIndex--;
       return top;
    }
    /**
     * Returns the element at the top of the Stack, does not pop it off the Stack
     * @return the element at the top of the Stack
     * @throws StackUnderflowException if stack is empty
     */
    @Override
    public T top() throws StackUnderflowException {
        if(isEmpty()){
            throw new StackUnderflowException();
        }
        return stack[topIndex];
    }

    /**
     * Number of elements in the Stack
     * @return the number of elements in the Stack
     */
    @Override
    public int size() {
        int count=0;
        for(int i=0;i<stack.length;++i){
            if(stack[i]!=null){
                count++;
            }
        }
        return count;
    }
    /**
     * Adds an element to the top of the Stack
     * @param e the element to add to the top of the Stack
     * @return true if the add was successful, false if not
     * @throws StackOverflowException if stack is full
     */
    @Override
    public boolean push(T e) throws StackOverflowException {
        boolean truth=false;
       if(isFull()){
           throw new StackOverflowException();
       }else{
           stack[topIndex+1]=e;
           topIndex++;
           truth=true;
       }
       return truth;
   }



    /**
     * Returns the elements of the Stack in a string from bottom to top, the beginning
     * of the String is the bottom of the stack
     * @return an string which represent the Objects in the Stack from bottom to top
     */
    @Override
    public String toString(){
        String result="";

        for(int i=0;i<stack.length;++i){
        	if(stack[i]!=null) {
            result+=stack[i];
         }
        }
        return result;

    }
    /**
     * Returns the string representation of the elements in the Stack, the beginning of the
     * string is the bottom of the stack
     * Place the delimiter between all elements of the Stack
     * @return string representation of the Stack from bottom to top with elements
     * separated with the delimiter
     */

    @Override
    public String toString(String delimiter) {
       String result="";
       
       
       for( int i=0; i< stack.length;++i) {
    	   
    	   if(stack[i]!=null) {
    		   result+=stack[i];
    		   
    		   if(i!=topIndex) {
        		   result+= delimiter;
        	   }
    	   }
    	  
       }
      
       
       return result;
       
    }


    /**
     * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
     * is the first bottom element of the Stack
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
     * list reference within your Stack, you will be allowing direct access to the data of
     * your Stack causing a possible security breech.
     * @param list elements to be added to the Stack from bottom to top
     * @throws StackOverflowException if stack gets full
     */

    @Override
    public void fill(ArrayList<T> list) throws StackOverflowException {
    	
    	ArrayList<T> copyList= new ArrayList<>(list);

        for(int i=0;i< list.size();++i){
            if(stack.length==list.size()){
                throw new StackOverflowException();
            }
            stack[i]= copyList.get(i);
            topIndex++;
        }

    }
}

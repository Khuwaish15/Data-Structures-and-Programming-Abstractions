package CSE260;

public class GenericStackWithArrayB {
	public static void main(String[]args) {
        GenericStackWithArray<Integer>stack = new GenericStackWithArray<Integer>();
        
		stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
    }

}

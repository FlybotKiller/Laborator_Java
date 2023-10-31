public class Main {
    public static void main(String[] args) {
        DynStack stack = new DynStack(6);
        System.out.println(stack);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(1);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack); //follows the "First in, last out" rule
    }
}
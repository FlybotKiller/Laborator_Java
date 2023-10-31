import java.util.Arrays;

public class DynStack implements IntStack {
    private int[] values;
    private int top;

    public DynStack(int size) {
        values = new int[size];
        top = -1;
    }
    //constructor used to declare a size for our stack, top
    //is used as an index for the value on top of our stack,
    //it will be -1 by default to indicate an empty stack

    @Override
    public String toString() {
        if (top == -1) {
            return "Stack is empty.";
            //if our top value index is -1, the stack is empty.
        }

        StringBuilder stackContent = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            stackContent.append(values[i]);
            if (i != top) {
                stackContent.append(", ");
            }
        }
        return "Stack: " + stackContent.toString();
    }
    //Using the StringBuilder class, we have a more efficient way of displaying
    //our stack contents

    @Override
    public void push(int item) {
        if (top == values.length - 1) {
            int[] temp = new int[values.length * 2];
            System.arraycopy(values, 0, temp, 0, values.length);
            values = temp;
            values[++top] = item;
        } else {
            values[++top] = item;
        }
    }
    //this method adds an element to the stack,if the stack is full,
    //it doubles the capacity of the stack then adds the item

    @Override
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return 0;
        } else {
            return values[top--];
        }
    }
    //returns the element located on the top index and decrements the stack by 1,
    //thus removing the element
}

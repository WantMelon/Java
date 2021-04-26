public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(10);
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
    }
}

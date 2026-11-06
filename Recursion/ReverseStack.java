package Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Original Stack: " + st);
        ReverseStack rs = new ReverseStack();
        rs.reverseStack(st);
        System.out.println("Reversed Stack: " + st);
    }
    public void reverseStack(Stack<Integer> st) {
       if(st.isEmpty()) return;
       int top = st.pop();
       reverseStack(st);
       rev(st , top);
    }
    void rev(Stack<Integer> st , int top){
        if(st.isEmpty()){
            st.push(top);
            return;
        }
        int bott = st.pop();
        rev(st , top);
        st.push(bott);
    }
}

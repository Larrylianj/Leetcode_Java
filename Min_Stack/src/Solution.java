import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class Node {
    int val;
    Node preMin;
    Node next;
    Node pre;
    Node(int x){this.val = x;}
}

class MinStack {
    
    Node head;
    Node end;
    Node min;
    MinStack(){
        head = new Node(0);
        end = head;
    }
    
    public void push(int x) {
        Node newNode = new Node(x);
        if(head == end){
            newNode.pre = head;
            head.next = newNode;
            end = newNode;
            min = newNode;
        }else{
            newNode.pre = end;
            end.next = newNode;
            newNode.preMin = min;
            if(x < min.val){
                min = newNode;
            }
            end = newNode;
        }
    }

    public void pop() {
        if(head != end){
            min = end.preMin;
            end.pre.next = null;
        }
    }

    public int top() {
        if(head != end){
            return end.val;
        }else{
            return 0;
        }
    }

    public int getMin() {
        return min.val;
    }
}

public class Solution{
	public static void main(String arg[]){
		MinStack s = new MinStack();
		s.push(-3);
		s.push(0);
		s.push(3);
		System.out.print(s.top());
	}
}
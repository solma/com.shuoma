package com.shuoma;
import java.util.*;
public class MinStack {
    public static class MinEle {
        int val;
        int cnt;
        public MinEle(int val, int cnt) { 
            this.val = val;
            this.cnt = cnt;
        }
        
        public void incr() {
            cnt++;
        }
        
        public void decr() {
            cnt--;
        }
        
        public int getCnt() {
            return cnt;
        }
        
        public int getVal() {
            return val;
        }
    }
    
    Stack<Integer> stack;
    ArrayList<MinEle> mins;
	
	public MinStack() {
		stack = new Stack<Integer>();
		mins = new ArrayList<MinEle>();
	}
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || mins.get(0).getVal() > x) {
            mins.add(0, new MinEle(x, 1));
        } else {
            mins.get(0).incr();
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int top = stack.pop();
        mins.get(0).decr();
        if (mins.get(0).getCnt() == 0)
            mins.remove(0);
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty())
            return -1;
        return mins.get(0).getVal();
    }
	
	public static void main(String[] args){
		MinStack ms = new MinStack();
		ms.push(5);
		//ms.push(1);
		//ms.push(3);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
	}
}
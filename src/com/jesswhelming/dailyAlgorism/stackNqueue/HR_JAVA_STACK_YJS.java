package com.jesswhelming.dailyAlgorism.stackNqueue;

import java.util.Scanner;
import java.util.Stack;

class Parser{

    public boolean isBalanced(String next) {
        if(next.length()%2 != 0) {
            return false;
        }
        Stack st = new Stack();
        for(int i=0; i<next.length(); i++) {
            if(st.size()==0) {
                st.add((int) next.charAt(i));
            }else {
                if((int)st.peek()<(int)next.charAt(i)) {
                    if((int)st.peek() == 123) {
                        if((int)next.charAt(i) == 125)
                            st.pop();
                    }else if((int)st.peek() == 40) {
                        if((int)next.charAt(i) == 41)
                            st.pop();
                    }
                }else {
                    st.add((int) next.charAt(i));
                }
            }
        }
        if(st.size() > 0) {
            return false;
        }else {
            return true;
        }
    }
}

public class HR_JAVA_STACK_YJS {

	public static void main(String[] args) {
		Parser parser = new Parser();
        
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}
        
		in.close();
	}

}

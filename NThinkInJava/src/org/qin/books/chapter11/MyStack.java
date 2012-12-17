package org.qin.books.chapter11;
import static org.qin.books.util.PrintClass.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {
	private LinkedList<T> list = new LinkedList<T>();
	public T pop() {
		return list.removeFirst();
	}
	public T peek() {
		return list.getFirst();
	}
	public void push(T t) {
		list.addFirst(t);
	}
	public String toString() {
		return list.toString();
	}
	public boolean empty() {
		return list.isEmpty();
	}
	public static void main(String[] args) {
		/*MyStack<String> strStack = new MyStack<String>();
		String[] words = "I a not a hero, but I can't give up Gotham city.".split(" ");
		for (String word : words ) {
			strStack.push(word);
		}
		print(strStack);
		while(!strStack.empty()) {
			print(strStack.pop());
		}*/
		MyStack<Character> charList = new MyStack<Character>();
		char[] toHandled = args[0].toCharArray();
		//List<Character> toHandled = new LinkedList<Character>();
		
		//Collections.addAll(toHandled, args[0].toCharArray());
		for (int i = 0; i < toHandled.length; i++) {
			switch(toHandled[i]) {
			case '+':
				if(++i < toHandled.length) 
					charList.push(toHandled[i]);				
				else System.exit(0);
				break;
			case '-':
				print(charList.pop());				
			}			
		}
		print(charList);
	}
}

/*x class MyStack {
	
}*/

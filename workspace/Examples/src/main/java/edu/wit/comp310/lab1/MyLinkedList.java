package edu.wit.comp310.lab1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;


/**
 * Roll your own Singly-linked list.
 * 
 * This means that we implement ourselves.
 * 
 * The List interface is described here:
 * 
 * @see http://docs.oracle.com/javase/7/docs/api/java/util/List.html
 *
 *loooping example:
 *int i = 0;
 *int index = 5; //n
 *Node<ValueType> current;
 *for( current = first; current.next != null && i < index-1; current = current.next, i++){//brings current to the nth node};
 */


public class MyLinkedList<ValueType> implements List<ValueType> {
	public int numOfEntries = 0;
	Node<ValueType> first;
	Node<ValueType> last;
	public static class Node<T>{
		T data;
		Node<T> next;
	}
	public Node<ValueType> getNodeAt(int arg0){
		//System.out.println("From getNodeAt: arg0="+ arg0 + " size=" + size());
		if (arg0<0 || arg0>size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		Node<ValueType> current = first;
		if(arg0==1){
			i++;
			//System.out.println("from getNodeAt: i = " + i + "\targ0 = " + arg0 + "\targ0==1");
			return first.next;
		} else {
			while(i<arg0){
				i++;
				current=current.next;
			}
		}
		//System.out.println("from getNodeAt: i = " + i + "\targ0 = " + arg0);
		return current;
	}
	
	@Override
	public boolean add(ValueType arg0) {
		if(this.isEmpty()){
			Node<ValueType> newNode = new Node<ValueType>();
			newNode.data = arg0;
			first = newNode;
			last = newNode;
		}else{
			 Node<ValueType> newNode = new Node<ValueType>();
			 newNode.data = arg0;
			 last.next = newNode;
			 last = newNode;
		}
		numOfEntries++;
		//System.out.println("from add: " + size());
		return true;
	}

	@Override
	public void add(int arg0, ValueType arg1) {
		// TODO Auto-generated method stub
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node<ValueType> newNode = new Node<ValueType>();
		newNode.data = arg1;
		Node<ValueType> temp = new Node<ValueType>();
		Node<ValueType> current = first;
		if(arg0-1<0){
			first = newNode;
			newNode.next = current;
		} else {
			current = getNodeAt(arg0-1);
			temp = current.next;
			current.next = newNode;
			newNode.next = temp;
		}
		numOfEntries++;
	}

	@Override
	public boolean addAll(Collection<? extends ValueType> arg0) {
		for (ValueType arg : arg0){
			add(arg);
			numOfEntries++;
		}
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends ValueType> arg1) {
		if(arg0 < 0){
			throw new IndexOutOfBoundsException();
		}
		return false;
	}
	@Override
	public void clear() {
		first = null;
		last = null;
		numOfEntries = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		Node<ValueType> current = first;
		for(;; current = current.next){
			if((arg0).equals(current.data)){
				return true;
			}
			if(current.next == null){
				return false;
			}
		}
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object arg : arg0){
			if(!contains(arg)){
				return false;
			}
		}
		return true;
	}

	@Override
	public ValueType get(int arg0) {
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		return getNodeAt(arg0).data;
	}
	@Override
	public int indexOf(Object arg0) {
		Node<ValueType> current = first;
		int pos = 0;
		for(; pos<numOfEntries; current = current.next, pos++){
			if(current.data.equals(arg0)){
				return pos;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if(numOfEntries==0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<ValueType> iterator() {
		return new Iterator<ValueType>(){
			Node<ValueType> current = first;
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public ValueType next() {
				ValueType tmp = current.data;
				current = current.next;
				return tmp;
			}

			@Override
			public void remove() {
				// ignore
			}
		};
	}

	@Override
	public int lastIndexOf(Object arg0) {
		Node<ValueType> current;
		int pos, lastMatchPos=0;
		for(current = first, pos=1; current.next != null; current = current.next, pos++){
			if(current.data == arg0){
				lastMatchPos = pos;
			}
		}
		if(lastMatchPos==0){
			return -1;
		}else{
			return lastMatchPos;
		}
	}

	@Override
	public ListIterator<ValueType> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ValueType> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		if(indexOf(arg0) == -1){
			new IndexOutOfBoundsException();
		}
		int pos = indexOf(arg0);
		if(pos<0){
			return false;
		} else if(pos==0){
			first = first.next;
			numOfEntries--;
			return true;
		} else if(pos>0){
			//System.out.println("from remove: pos > 0, " + pos);
			Node<ValueType> before = getNodeAt(pos-1);
			//System.out.println("removing: " + before.next.data);
			before.next = before.next.next;
			numOfEntries--;
			return true;
		} else {
			//System.out.println("???");
			return false;
		}
		
		
		
	}

	@Override
	public ValueType remove(int arg0) {
		
		if(arg0 < 0 || arg0>size()){
			new IndexOutOfBoundsException();
		}
		Node<ValueType> before = getNodeAt(arg0-1);
		before.next = before.next.next;
		
		//Node<ValueType> before = first;
		/*ValueType prevData = null;
		if(arg0<0){
			//System.out.println("arg0<0");
			throw new IndexOutOfBoundsException();
		} else
		if(arg0==0){
			//System.out.println("arg0==0");
			prevData = first.data;
			first = first.next;
			before = null;
			numOfEntries--;
			return prevData;
		} else
		if (arg0>0){
			//System.out.println("arg0>0");
			before = getNodeAt(arg0-1);
			prevData = before.next.data;
			before = (before.next.next);
			numOfEntries--;
			return prevData;
		} else {*/
			return null;
		//}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
			for (Object item : arg0){
				while(contains(item)){
					remove(item);
				}
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		for (ValueType data : this){
			boolean found = false;
			for ( Object arg : arg0){
				if((data.equals(arg))){
					found = true;
				}
			}
			if(!found){
				remove(data);
			}
		}

		return false;
	}

	@Override
	public ValueType set(int arg0, ValueType arg1) {
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node<ValueType> current = getNodeAt(arg0);
		ValueType prevData = current.data;
		current.data = arg1;
		return prevData;
	}

	@Override
	public int size() {
		return numOfEntries;
	}

	@Override
	public List<ValueType> subList(int arg0, int arg1) {
		Node<ValueType> current = getNodeAt(arg0);
		List<ValueType> portion = new ArrayList<ValueType>();
		int i = 0;
		for(; current.next != null && i < (arg1-arg0); current = current.next, i++){
			portion.add(current.data);
		}
		return portion;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[numOfEntries];
		int i = 0;
		for(ValueType obj : this)
		{
			arr[i] = obj;
			i++;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		String[] arr = new String[numOfEntries];
		int i = 0;
		for(ValueType obj : this)
		{
			arr[i] = (String) obj;
			i++;
		}
		return (T[]) arr;
	}
}

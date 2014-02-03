package edu.wit.comp310.lab1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import edu.wit.comp310.TreeDemo.Node;


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
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		Node<ValueType> current;
		for( current = first; current.next != null && i < arg0-1; current = current.next, i++){
		}
		return current;
	}
	
	@Override
	public boolean add(ValueType arg0) {
		if(this.isEmpty()){
			Node<ValueType> newNode = new Node<ValueType>();
			newNode.data = arg0;
			first = newNode;
			last = newNode;
			numOfEntries++;
			return true;
		}else{
			 Node<ValueType> newNode = new Node<ValueType>();
			 last.next = newNode;
			 last = newNode;
			 newNode.data = arg0;
			 numOfEntries++;
			 return true;
		}
	}

	@Override
	public void add(int arg0, ValueType arg1) {
		// TODO Auto-generated method stub
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node<ValueType> current = new Node<ValueType>();
		int i=0;
		for( current = first; current.next != null && i < arg0-1; current = current.next, i++){
		}
		Node<ValueType> newNode = new Node<ValueType>();
		newNode.next = current.next;
		current = newNode;
		newNode.data = arg1;
		numOfEntries++;
	}

	@Override
	public boolean addAll(Collection<? extends ValueType> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends ValueType> arg1) {
		// TODO Auto-generated method stub
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
		Node<ValueType> current;
		for( current = first; current.next != null; current = current.next){
			if(current.data == arg0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType get(int arg0) {
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		return (ValueType) getNodeAt(arg0).data;
	}
	@Override
	public int indexOf(Object arg0) {
		Node<ValueType> current = first;
		int pos = 0;
		for(; current.next != null || pos<=numOfEntries; current = current.next, pos++){
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
		}
		return false;
	}

	@Override
	public Iterator<ValueType> iterator() {
		return new Iterator<ValueType>(){
			Node<ValueType> current = first;
			@Override
			public boolean hasNext() {
				return current.next != null;
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
		int pos = indexOf(arg0);
		if(pos<0){
			return false;
		}
		Node<ValueType> current = getNodeAt(pos);
		Node<ValueType> before = getNodeAt(pos-1);
		before.next = current.next;
		current = null;
		numOfEntries--;
		return true;
	}

	@Override
	public ValueType remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType set(int arg0, ValueType arg1) {
		if (arg0<0 || arg0 > size()){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		Node<ValueType> current;
		for( current = first; current.next != null && i < arg0-1; current = current.next, i++){
		}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}

/**
 * this class is designed as a storage structure for a hash table implementing separate chaining mechanism, every cell in the hashtable will be occupied by a chain with/without the data.
 * a chain is a doubly linked list, a bucket is a node in the list. the data(pair type) is stored in a bucket.
 * the put operation is implemented by means of head inserting which ensure the O(1) time complexity in the case of collision
 * the remove and get operation are undertaken in O(n) time complexity to iterate all element in the chain
 * */
public class chain {
	private bucket head;
	private int countItems;
	private class bucket{
		private pair element;
		private bucket next;
		private bucket previous;
		
		public bucket() {
			this.element = null;
			this.next = null;
			this.previous = null;
		}
		
		public bucket(pair element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}

		public pair getElement() {
			return element;
		}

		public void setElement(pair element) {
			this.element = element;
		}

		public bucket getNext() {
			return next;
		}

		public void setNext(bucket next) {
			this.next = next;
		}

		public bucket getPrevious() {
			return previous;
		}

		public void setPrevious(bucket previous) {
			this.previous = previous;
		}
		
	}
	
	public chain() {
		this.head = new bucket();
		this.countItems = 0;
	}
	public chain(pair element) {
		this.head = new bucket();
		bucket newBucket = new bucket(element);
		this.head.setNext(newBucket);
		newBucket.setPrevious(this.head);
		this.countItems = 0;
	}
	public bucket getHead() {
		return head;
	}
	public void setHead(bucket head) {
		this.head = head;
	}
	
	public pair put(pair element) {
		if(this.head.getNext()==null) {
			bucket newBucket = new bucket(element);
			this.head.setNext(newBucket);
			newBucket.setPrevious(this.head);
			return null;
		}
		else {
			this.setCountItems(0);
			bucket curPointer = this.head.getNext();
			while(curPointer!=null) {
				if(curPointer.element.getKey()==element.getKey()) {
					pair oldPair = curPointer.getElement();
					curPointer.element.setValue(element.getValue());
					return oldPair;
				}
				curPointer = curPointer.getNext();
				this.setCountItems(this.getCountItems()+1);
			}
			bucket newBucket = new bucket(element);
			newBucket.setNext(this.head.getNext());
			newBucket.setPrevious(this.head);
			this.head.getNext().setPrevious(newBucket);
			this.head.setNext(newBucket);
			this.setCountItems(this.getCountItems()+1);
			return null;
		}
	}
	
	public int getCountItems() {
		return countItems;
	}
	public void setCountItems(int countItems) {
		this.countItems = countItems;
	}
	public pair remove(int key) {
		if(this.head.getNext()==null) {
			return null;
		}
		else {
			bucket curPointer = this.head.getNext();
			while(curPointer!=null) {
				if(curPointer.element.getKey()==key) {
					bucket buckBefore = curPointer.getPrevious();
					bucket buckAfter = curPointer.getNext();
					if(buckBefore!=null) {
						buckBefore.setNext(buckAfter);
					}
					if(buckAfter!=null) {
						buckAfter.setPrevious(buckBefore);
					}
					pair removedPair = curPointer.getElement();
					curPointer = null;
					return removedPair; 
				}
				curPointer = curPointer.getNext();
			}
			return null;
		}
	}
	
	public pair get(int key) {
		if(this.head.getNext()==null) {
			return null;
		}
		else {
			bucket curPointer = this.head.getNext();
			while(curPointer!=null) {
				if(curPointer.element.getKey()==key) {
					return curPointer.getElement();
				}
				curPointer = curPointer.getNext();
			}
			return null;
		}
	}
}

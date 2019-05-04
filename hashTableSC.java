/**
 * this class is designed to implement the hash table solving collision under separate chain mechanism
 * the number of collision will increase by 1 every time when putting a new pair in the table while the certain cell is not null(has been occupied by a chain)
 * checking if the key in the table is same as the one to be inserted is not considered collision
 * */
public class hashTableSC extends hashTable {
	private chain[] arrHashTable;
	private int size;
	private int countCollision;
	private int countItems;
	
	public hashTableSC(int capacity) {
		super(capacity);
		this.arrHashTable = new chain[capacity];
		this.size = 0;
		this.countCollision = 0;
		this.countItems = 0;
	}
	
	public int getCountItems() {
		return countItems;
	}

	public void setCountItems(int countItems) {
		this.countItems = countItems;
	}

	public chain[] getArrHashTable() {
		return arrHashTable;
	}

	public void setArrHashTable(chain[] arrHashTable) {
		this.arrHashTable = arrHashTable;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int size() {
		return this.size;
	}
	
	public pair get(int Key) {
		int index = compression(pair.hashCode(Key));
		return this.arrHashTable[index].get(Key);
	}
	public int getCountCollision() {
		return countCollision;
	}
	public void setCountCollision(int countCollision) {
		this.countCollision = countCollision;
	}

	public pair put(pair element) {
		int index = compression(element.getHashCode());
		if(this.arrHashTable[index]==null) {
			chain newChain = new chain(element);
			this.arrHashTable[index] = newChain;
			this.size++;
			this.setCountItems(1);
			return null;
		}
		else {
			this.setCountItems(0);
			pair res = this.arrHashTable[index].put(element);
			this.setCountCollision(this.getCountCollision()+1);
			this.setCountItems(this.arrHashTable[index].getCountItems());
			if(res==null) {
				this.size++;
			}
			return res;
		}
		
	}
	
	public pair remove(int Key) {
		int index = compression(pair.hashCode(Key));
		pair res = this.arrHashTable[index].remove(Key);
		if(res!=null) {
			this.size--;
		}
		return res;
	}
	public int compression(int hashKey) {
		return hashKey % super.getCapacity();
	}
}

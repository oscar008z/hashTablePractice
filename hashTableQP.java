/**
 * this class is designed to implement the hash table solving collision under quadratic probing mechanism
 * the number of collision will increase by 1 every time when putting a new pair in the table while the certain cell is not null or avaiable(has been occupied by a pair)
 * checking if the key already in the table is same as the one to be inserted is not considered collision
 * 
 * */

public class hashTableQP extends hashTable {
	private pair[] arrHashTable;
	private int size;
	private int countCollision;
	private int probAttempts;
	
	public hashTableQP(int capacity) {
		super(capacity);
		this.arrHashTable = new pair[capacity];
		this.size = 0;
		this.countCollision = 0;
		this.probAttempts = 0;
	}
	
	public int getProbAttempts() {
		return probAttempts;
	}

	public void setProbAttempts(int probAttempts) {
		this.probAttempts = probAttempts;
	}

	public pair[] getArrHashTable() {
		return arrHashTable;
	}

	public void setArrHashTable(pair[] arrHashTable) {
		this.arrHashTable = arrHashTable;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCountCollision() {
		return countCollision;
	}

	public void setCountCollision(int countCollision) {
		this.countCollision = countCollision;
	}

	public int size() {
		return this.size;
	}
	
	public pair get(int Key) {
		if(this.arrHashTable==null || super.isEmpty(this.size())) {
			return null;
		}
		else {
			int index = pair.hashCode(Key);
			int counter = index % super.getCapacity();
			int n = 0;
			int step = 1;
			while(n<super.getCapacity()) {
				if((this.arrHashTable[counter]!=null) && (this.arrHashTable[counter].getKey()==Key)) {
					return this.arrHashTable[counter];
				}
				counter = (counter+((step)^2))%super.getCapacity();
				n++;
				step++;
			}
			return null;
		}
	}
	
	public pair put(pair element) {
		if(this.size()==super.getCapacity()) {
			for(int i=0; i<this.size(); i++) {
				if(this.arrHashTable[i].getKey()==element.getKey()) {
					pair oldElement = this.arrHashTable[i];
					this.arrHashTable[i].setValue(element.getValue());
					return oldElement;
				}
			}
			return null;
		}
		else {
			for(int i=0; i<super.getCapacity(); i++) {
				if(this.arrHashTable[i]!=null && this.arrHashTable[i].getKey()==element.getKey()) {
					pair oldElement = this.arrHashTable[i];
					this.arrHashTable[i].setValue(element.getValue());
					return oldElement;
				}
			}
			this.setProbAttempts(1);
			int index = pair.hashCode(element.getKey());
			int counter = index % super.getCapacity();
			int n = 0;
			int step = 1;
			int flag = 0;
			while(n<super.getCapacity()) {
				if(this.arrHashTable[counter]==null || this.arrHashTable[counter].getValue()==-1) {
					this.arrHashTable[counter] = element;
					this.size++;
					return null;
				}
				if(flag == 0) {
					this.setCountCollision(this.getCountCollision()+1);
					flag = 1;
				}
				this.setProbAttempts(this.getProbAttempts()+1);
				counter = (counter+(step^2)) % super.getCapacity();
				n++;
				step++;
			}
			return null;
		}
	}
	
	public pair remove(int Key) {
		if(this.arrHashTable==null || super.isEmpty(this.size())) {
			return null;
		}
		else {
			int index = pair.hashCode(Key);
			int counter = index % super.getCapacity();
			int n = 0;
			int step = 1;
			while(n<super.getCapacity()) {
				if(this.arrHashTable[counter].getKey()==Key) {
					pair oldElement = this.arrHashTable[counter];
					pair symbol = new pair(-1,-1);
					this.arrHashTable[counter] = symbol;
					this.size--;
					return oldElement;
				}
				counter = (counter+(step^2))%super.getCapacity();
				n++;
				step++;
			}
			return null;
		}
	}
}

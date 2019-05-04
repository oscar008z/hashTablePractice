/**
 * this class is designed as the parent class 
 * main operations required to be executed on any hash tables are designed as an abstract method here
 * common method used by sub classes is designed here as a non-abstract method here
 * */
abstract public class hashTable {
	private int capacity;

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public hashTable(int capacity) {
		this.capacity = capacity;
	}
	public boolean isEmpty(int size) {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	abstract public int size();
	abstract public pair get(int Key);
	abstract public pair put(pair element);
	abstract public pair remove(int Key);
}

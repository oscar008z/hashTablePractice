import java.util.Random;
/**
 * this class is designed to produce objects of pair type which stores a (key,value) data and the hashcode based on its key
 * according to thr requirement, the key of any pair object ranges from 970 which has 16 bits to  1999970 which has 32 bits
 * the hashcode is produced by means of accumulation of polynomial in using horner rule, and hashcode() is defined as a static method to make sure an enough flexibility of calls.
 * */
public class pair {
	private int key;
	private int value;
	private int hashCode;
	
	
	public pair(int value) {
		this.key = new Random().nextInt(1999000)+970;
		this.value = value;
		this.hashCode = this.hashCode();
	}
	
	public pair(int key, int value) {
		this.key = key;
		this.value = value;
		this.hashCode = this.hashCode();
	}

	public int getHashCode() {
		return this.hashCode;
	}

	private void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
		this.hashCode = this.hashCode();
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}
	
	public int hashCode() {
		int hashCode = 0;
		int[] keyArr = new int[10];
		int tempKey = this.key;
		int i = 0;
		while(tempKey>0) {
			keyArr[i] = tempKey % 10;
			tempKey = tempKey / 10;
			i++;
		}
		hashCode = pair.honrer(keyArr);
		return hashCode;
	}
	
	public static int hashCode(int key) {
		int hashCode = 0;
		int[] keyArr = new int[10];
		int tempKey = key;
		int i = 0;
		while(tempKey>0) {
			keyArr[i] = tempKey % 10;
			tempKey = tempKey / 10;
			i++;
		}
		hashCode = pair.honrer(keyArr);
		return hashCode;
	}
	
	public static int honrer(int[] keyArr) {
		final int coefficient = 33;
		int res = keyArr[keyArr.length-1];
		for(int i=0; i<=keyArr.length-1; i++) {
			res = coefficient * res + keyArr[keyArr.length-i-1];
		}
		return res;
	}
}

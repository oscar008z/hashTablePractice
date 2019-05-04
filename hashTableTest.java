/**
 * this class is designed to be the main entry of the program
 * as the consle is not enough to save all information as an output, the excecution information will be stored in 'hashTableTestResult.txt'
 * 
 * */

import java.util.Random;
import java.io.*;
public class hashTableTest {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resTotal = "";
		pair[] arrOriginPairs = new pair[50];
		pair[] arrOriginPairs_1 = new pair[150];
		pair[] arrOriginPairs_2 = new pair[10000];
		Random r = new Random();
		long timeBegin;
		long timeEnd;
		long runTime;
		
		for(int i=0; i<50; i++) {
			arrOriginPairs[i] = new pair(r.nextInt(100000));
		}
		for(int i=0; i<150; i++) {
			arrOriginPairs_1[i] = new pair(r.nextInt(100000));
		}
		for(int i=0; i<10000; i++) {
			arrOriginPairs_2[i] = new pair(r.nextInt(100000));
		}
		
		hashTableSC tableSC = new hashTableSC(100);
		hashTableLP tableLP = new hashTableLP(100);
		hashTableQP tableQP = new hashTableQP(100);
		
		hashTableSC tableSC_1 = new hashTableSC(100);
		hashTableLP tableLP_1 = new hashTableLP(100);
		hashTableLP tableLP_2 = new hashTableLP();
		hashTableLP tableLP_3 = new hashTableLP(10000);
		hashTableQP tableQP_1 = new hashTableQP(100);
		hashTableQP tableQP_2 = new hashTableQP(101);
		
		resTotal += "========================================Step 4: Validate========================================" + System.lineSeparator(); 
		System.out.println("========================================Step 4: Validate========================================");
		resTotal += "1.1.Begin of the 'put()' test for hash table in separating chainning mechanism:" + System.lineSeparator();
		System.out.println("1.1.Begin of the 'put()' test for hash table in separating chainning mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			tableSC.put(arrOriginPairs[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableSC.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableSC.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableSC.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableSC.getCountItems());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableSC.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableSC.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableSC.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableSC.getCountItems() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in separating chainning mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in separating chainning mechanism:\n\n");
		
		resTotal += "1.2.Begin of the 'get()' test for hash table in separating chainning mechanism:" + System.lineSeparator();
		System.out.println("1.2.Begin of the 'get()' test for hash table in separating chainning mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableSC.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'get()' test for hash table in separating chainning mechanism。" + System.lineSeparator();
		System.out.println("End of the 'get()' test for hash table in separating chainning mechanism。\n\n");
		
		resTotal += "1.3.Begin of the 'remove()' and 'get()' test for hash table in separating chainning mechanism:" + System.lineSeparator();
		System.out.println("1.3.Begin of the 'remove()' and 'get()' test for hash table in separating chainning mechanism:");
		resTotal += "  1.3.1.Remove the first 25 pairs in the table:" + System.lineSeparator();
		System.out.println("  1.3.1.Remove the first 25 pairs in the table:");
		for(int i=0; i<25;i++) {
			timeBegin = System.nanoTime();
			pair res = tableSC.remove(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			resTotal += (i+1) + ".The run time of this remove is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this remove is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "  1.3.2.Get the 50 pairs in the table:" + System.lineSeparator();
		System.out.println("  1.3.2.Get the 50 pairs in the table:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableSC.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'remove()' and 'get()' test for hash table in separating chainning mechanism。" + System.lineSeparator();
		System.out.println("End of the 'remove()' and 'get()' test for hash table in separating chainning mechanism。");
		resTotal += "2.1.Begin of the 'put()' test for hash table in linear probing mechanism:" + System.lineSeparator();
		System.out.println("2.1.Begin of the 'put()' test for hash table in linear probing mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			tableLP.put(arrOriginPairs[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableLP.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableLP.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableLP.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableLP.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableLP.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableLP.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableLP.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableLP.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in linear probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in linear probing mechanism.\n\n");
		resTotal += "2.2.Begin of the 'get()' test for hash table in linear probing mechanism:" + System.lineSeparator();
		System.out.println("2.2.Begin of the 'get()' test for hash table in linear probing mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableLP.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'get()' test for hash table in linear probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'get()' test for hash table in linear probing mechanism.\n\n");
		
		resTotal += "2.3.Begin of the 'remove()' and 'get()' test for hash table in linear probing mechanism:" + System.lineSeparator();
		System.out.println("2.3.Begin of the 'remove()' and 'get()' test for hash table in linear probing mechanism:");
		resTotal += "  2.3.1.Remove the first 25 pairs in the table:" + System.lineSeparator();
		System.out.println("  2.3.1.Remove the first 25 pairs in the table:");
		for(int i=0; i<25;i++) {
			timeBegin = System.nanoTime();
			pair res = tableLP.remove(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			resTotal += (i+1) + ".The run time of this remove is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this remove is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "  2.3.2.Get the 50 pairs in the table:" + System.lineSeparator();
		System.out.println("  2.3.2.Get the 50 pairs in the table:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableLP.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'remove()' and 'get()' test for hash table in linear probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'remove()' and 'get()' test for hash table in linear probing mechanism.\n\n");
		
		resTotal += "3.1.Begin of the 'put()' test for hash table in quadratic probing mechanism:" + System.lineSeparator();
		System.out.println("3.1.Begin of the 'put()' test for hash table in quadratic probing mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			tableQP.put(arrOriginPairs[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableQP.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableQP.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableQP.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableQP.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableQP.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableQP.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableQP.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableQP.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in quadratic probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in quadratic probing mechanism.\n\n");
		
		resTotal += "3.2.Begin of the 'get()' test for hash table in quadratic probing mechanism:" + System.lineSeparator();
		System.out.println("3.2.Begin of the 'get()' test for hash table in quadratic probing mechanism:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableQP.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'get()' test for hash table in quadratic probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'get()' test for hash table in quadratic probing mechanism.\n\n");
		
		resTotal += "3.3.Begin of the 'remove()' and 'get()' test for hash table in quadratic probing mechanism:" + System.lineSeparator();
		System.out.println("3.3.Begin of the 'remove()' and 'get()' test for hash table in quadratic probing mechanism:");
		resTotal += "  3.3.1.Remove the first 25 pairs in the table:" + System.lineSeparator();
		System.out.println("  3.3.1.Remove the first 25 pairs in the table:");
		for(int i=0; i<25;i++) {
			timeBegin = System.nanoTime();
			pair res = tableQP.remove(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			resTotal += (i+1) + ".The run time of this remove is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this remove is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "  3.3.2.Get the 50 pairs in the table:" + System.lineSeparator();
		System.out.println("  3.3.2.Get the 50 pairs in the table:");
		for(int i=0; i<arrOriginPairs.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableQP.get(arrOriginPairs[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs[i].getKey() + " is : " + res.getValue());
			}
			else {
				resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs[i].getKey());
			}
			resTotal += (i+1) + ".The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println((i+1) + ".The run time of this get is: " + runTime + " nano seconds");
			resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal += "End of the 'remove()' and 'get()' test for hash table in quadratic probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'remove()' and 'get()' test for hash table in quadratic probing mechanism.\n\n");
		
		resTotal += "========================================Step 5: Experiment and Interpret.========================================" + System.lineSeparator();
		System.out.println("========================================Step 5: Experiment and Interpret.========================================");
		resTotal += "1.1.Begin of the 'put()' test for hash table in separating chainning mechanism:" + System.lineSeparator();;
		System.out.println("1.1.Begin of the 'put()' test for hash table in separating chainning mechanism:");
		for(int i=0; i<arrOriginPairs_1.length;i++) {
			timeBegin = System.nanoTime();
			tableSC_1.put(arrOriginPairs_1[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableSC_1.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableSC_1.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableSC_1.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableSC_1.getCountItems());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableSC_1.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableSC_1.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableSC_1.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableSC_1.getCountItems() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in separating chainning mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in separating chainning mechanism.\n\n");
		resTotal += "2.1.Begin of the 'put()' test for hash table in linear probing mechanism:" + System.lineSeparator();
		System.out.println("2.1.Begin of the 'put()' test for hash table in linear probing mechanism:");
		for(int i=0; i<arrOriginPairs_1.length;i++) {
			timeBegin = System.nanoTime();
			tableLP_1.put(arrOriginPairs_1[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableLP_1.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableLP_1.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableLP_1.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableLP_1.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableLP_1.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableLP_1.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableLP_1.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableLP_1.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in linear probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in linear probing mechanism.\n\n");
		resTotal += "3.1.Begin of the 'put()' test for hash table in quadratic probing mechanism:" + System.lineSeparator();
		System.out.println("3.1.Begin of the 'put()' test for hash table in quadratic probing mechanism:");
		for(int i=0; i<arrOriginPairs_1.length;i++) {
			timeBegin = System.nanoTime();
			tableQP_1.put(arrOriginPairs_1[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableQP_1.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableQP_1.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableQP_1.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableQP_1.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableQP_1.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableQP_1.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableQP_1.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableQP_1.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in quadratic probing mechanism." + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in quadratic probing mechanism.\n\n");
		resTotal += "3.2.Begin of the 'put()' test for hash table in quadratic probing mechanism with a prime number capacity:" + System.lineSeparator();
		System.out.println("3.2.Begin of the 'put()' test for hash table in quadratic probing mechanism with a prime number capacity:");
		for(int i=0; i<arrOriginPairs_1.length;i++) {
			timeBegin = System.nanoTime();
			tableQP_2.put(arrOriginPairs_1[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableQP_2.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableQP_2.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableQP_2.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableQP_2.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			
			resTotal += (i+1) + ".The size of the table is: " + tableQP_2.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableQP_2.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableQP_2.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableQP_2.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();
		}
		resTotal += "End of the 'put()' test for hash table in quadratic probing mechanism。" + System.lineSeparator();
		System.out.println("End of the 'put()' test for hash table in quadratic probing mechanism。\n\n");
		
		resTotal += "========================================Step 6: Dynamic Resizing.========================================" + System.lineSeparator();
		System.out.println("========================================Step 6: Dynamic Resizing.========================================");
		resTotal += "1.Begin of the 'put()' test for hash table in linear probing mechanism with a dynamic capacity." + System.lineSeparator();
		System.out.println("1.Begin of the 'put()' test for hash table in linear probing mechanism with a dynamic capacity.");
		long totalRuntime = 0;
		for(int i=0; i<arrOriginPairs_2.length;i++) {
			timeBegin = System.nanoTime();
			tableLP_2.put(arrOriginPairs_2[i]);
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			System.out.println((i+1) + ".The size of the table is: " + tableLP_2.getCapacity());
			System.out.println((i+1) + ".The number of elements in the table after the method is: " + tableLP_2.getSize());
			System.out.println((i+1) + ".The number of keys that resulted in a collision is: " + tableLP_2.getCountCollision());
			System.out.println((i+1) + ".The number of probing attempts before adding the element: " + tableLP_2.getProbAttempts());
			System.out.println((i+1) + ".The run time of this put is: " + runTime + " nano seconds");
			System.out.println("------------------------------------------------------");
			totalRuntime += runTime;
			/*resTotal += (i+1) + ".The size of the table is: " + tableLP_2.getCapacity() + System.lineSeparator();
			resTotal += (i+1) + ".The number of elements in the table after the method is: " + tableLP_2.getSize() + System.lineSeparator();
			resTotal += (i+1) + ".The number of keys that resulted in a collision is: " + tableLP_2.getCountCollision() + System.lineSeparator();
			resTotal += (i+1) + ".The number of probing attempts before adding the element: " + tableLP_2.getProbAttempts() + System.lineSeparator();
			resTotal += (i+1) + ".The run time of this put is: " + runTime + " nano seconds" + System.lineSeparator();
			resTotal += "------------------------------------------------------" + System.lineSeparator();*/
		}
		resTotal += "The total run time to put 10000 pairs into the table is: " + (totalRuntime/1000000) + " ms" + System.lineSeparator();
		System.out.println("The total run time to put 10000 pairs into the table is: " + (totalRuntime/1000000) + " ms");
		resTotal += "------------------------------------------------------" + System.lineSeparator();
		System.out.println("------------------------------------------------------");
		resTotal += "2.Get all pairs from the table:" + System.lineSeparator();
		System.out.println("2.Get all pairs from the table:");
		totalRuntime = 0;
		for(int i=0; i<arrOriginPairs_2.length;i++) {
			timeBegin = System.nanoTime();
			pair res = tableLP_2.get(arrOriginPairs_2[i].getKey());
			timeEnd = System.nanoTime();
			runTime = timeEnd - timeBegin;
			if(res!=null) {
				//resTotal += (i+1) + ".The value matched with the key " + arrOriginPairs_2[i].getKey() + " is : " + res.getValue() + System.lineSeparator();
				System.out.println((i+1) + ".The value matched with the key " + arrOriginPairs_2[i].getKey() + " is : " + res.getValue());
			}
			else {
				//resTotal += (i+1) + ".There is no pair matched with the key " + arrOriginPairs_2[i].getKey() + System.lineSeparator();
				System.out.println((i+1) + ".There is no pair matched with the key " + arrOriginPairs_2[i].getKey());
			}
			//resTotal += "The run time of this get is: " + runTime + " nano seconds" + System.lineSeparator();
			System.out.println("The run time of this get is: " + runTime + " nano seconds");
			totalRuntime += runTime;
			//resTotal += "------------------------------------------------------" + System.lineSeparator();
			System.out.println("------------------------------------------------------");
		}
		resTotal +="The total run time to get all pairs from the table is: " + (totalRuntime/1000000) + " ms" + System.lineSeparator();
		resTotal += "------------------------------------------------------" + System.lineSeparator();
		pair newPair = new pair(r.nextInt(100000));
		resTotal += "3.Begin to put one pair into a hash table with a capacity of 10000 in linear probing mechanism." + System.lineSeparator();
		System.out.println("3.Begin to put one pair into a hash table with a capacity of 10000 in linear probing mechanism.");
		timeBegin = System.nanoTime();
		tableLP_3.put(newPair);
		timeEnd = System.nanoTime();
		runTime = timeEnd - timeBegin;
		resTotal += "The total run time to put 1 pairs into the table with a capacity of 10000 is: " + (totalRuntime/1000000) + " ms" + System.lineSeparator();
		System.out.println("The total run time to put 1 pairs into the table with a capacity of 10000 is: " + (totalRuntime/1000000) + " ms\n");
		resTotal += "==========================================End of all tests==============================" + System.lineSeparator();
		System.out.println("==========================================End of all tests==============================\n");
		File file = new File("hashTableTestResult.txt");	//create an object of File class for storing the result of program execution
		if(!file.exists())
			file.createNewFile();	//if the file doesn't exist, create the file
		BufferedWriter bwr = new BufferedWriter(new FileWriter(file,true));	//create the object of IO write stream
		bwr.write(resTotal);	//write the result of program execution to the target file
		bwr.close();	//close the IO stream	
	}
}

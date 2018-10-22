package test.java;


import main.java.SortDemoData;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class AlgoTest {
	SortDemoData dataSet = new SortDemoData();
	SortDemoData dataSet1 = new SortDemoData();
	SortDemoData sort = new SortDemoData();
	SortDemoData sort1 = new SortDemoData();
	SortDemoData dataSet2 = new SortDemoData();
	SortDemoData dataSet3 = new SortDemoData();
	SortDemoData dataSet4 = new SortDemoData();
	SortDemoData dataSet5 = new SortDemoData();
	

	@Test
	public void test() {
		

		
		dataSet.initializeArray("1 4 2 ");
		sort.initializeArray("1 2 4  ");
		dataSet1.initializeArray("7 2 18 1 3 5 12 9 10 19 20 13 15 14 6 4 16 17 8 11 ");
		sort1.initializeArray("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ");


		// To cover edge
		//20-22-24-25-26-27-28-29-28-27-36
		dataSet2.initializeArray("2 3");
		dataSet2.runAlgo(0);
		
		dataSet3.initializeArray("5 1 ");

		dataSet3.runAlgo(4);
		
		
		
		
		
		dataSet4.initializeArray("2 3 3 4 9 5 5 1 4");
		
		dataSet4.runAlgo(0);
		
		dataSet4.runAlgo(1);
		dataSet4.runAlgo(2);
		dataSet4.runAlgo(3);
		dataSet4.runAlgo(4);
		dataSet4.runAlgo(5);

		//20-22-24-25-26-27-28-29-30-31-32-33-34-28-27-28-29-30-31-32-33-34-35-27-36
		//covers all edges, nodes and conditions
		// To cover both nodes and condition for the test sequence
		//20-22-24-25-26-27-28-29-30-31-32-33-34-35-36
		
		//even covers most of the edges
		dataSet.runAlgo(0);
		sort.runAlgo(0);
		dataSet.runAlgo(1);
		sort.runAlgo(1);
		dataSet.runAlgo(2);
		sort.runAlgo(2);
		dataSet.runAlgo(3);
		sort.runAlgo(3);
		dataSet.runAlgo(4);
		sort.runAlgo(4);
		dataSet.runAlgo(5);
		sort.runAlgo(5);
		dataSet.runAlgo(9);
		sort.runAlgo(9);
		
		dataSet1.runAlgo(0);
		sort1.runAlgo(0);
		dataSet1.runAlgo(1);
		sort1.runAlgo(1);
		dataSet1.runAlgo(2);
		sort1.runAlgo(2);
		dataSet1.runAlgo(3);
		sort1.runAlgo(3);
		dataSet1.runAlgo(4);
		sort1.runAlgo(4);
		dataSet1.runAlgo(5);
		sort1.runAlgo(5);
		dataSet1.runAlgo(9);
		sort1.runAlgo(9);
		
		
	}

}

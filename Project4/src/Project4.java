/**
 * Project 4
 * @author Zach Tebow
 * @version 2/28/17
 * 
 */
import java.lang.Math;

public class Project4 {
	/**
	 * main method
	 * This method has an array of tideData and calls the printReport method to analyze it
	 * @param args
	 */
	public static void main(String[] args) {
		//jan 10 data
		double[][] tideData = {{3.11,1.929,1.856},
				{3.5,0.992,0.858},
				{4.08,0.063,-0.1},
				{7.97,-0.526,-0.674},
				{4.28,-0.605,-0.602},
				{3.69,-0.198,-0.388},
				{3.3,0.627,0.461},
				{3.69,1.756,1.583},
				{2.92,2.921,2.774},
				{2.14,3.768,3.611},
				{5.64,4.102,3.765},
				{10.5,3.944,3.581},
				{8.55,3.36,2.974},
				{3.89,2.4,1.967},
				{6.8,1.245,0.888},
				{6.41,0.231,0.169},
				{6.03,-0.363,-0.471},
				{2.33,-0.463,-0.526},
				{1.17,-0.101,-0.064},
				{2.14,0.672,0.776},
				{2.33,1.678,1.646},
				{1.75,2.576,2.564},
				{3.3,3.069,3.096},
				{4.47,3.087,3.06},
				{2.53,2.692,2.673},
				{3.11,1.93,1.869},
				{6.8,0.916,0.835},
				{10.3,-0.054,-0.254},
				{15.36,-0.642,-0.838},
				{14.38,-0.696,-0.792},
				{12.63,-0.24,-0.336},
				{14,0.662,0.573},
				{19.63,1.873,1.583},
				{14,3.082,2.781},
				{6.03,3.926,3.788},
				{6.8,4.228,3.788},
				{4.28,4.017,3.503},
				{7.97,3.35,2.669},
				{9.33,2.294,1.908},
				{10.89,1.071,0.816},
				{8.55,0.042,-0.264},
				{8.16,-0.53,-1.045},
				{6.8,-0.584,-1.114},
				{7,-0.146,-0.605},
				{5.05,0.72,0.173},
				{8.36,1.798,1.36},
				{13.8,2.716,2.289},
				{6.03,3.191,2.643}};
		printReport(tideData);
	}
	/**
	 * printReport method
	 * This method calls the print methods for each specific measurement
	 * @param double[][] tideData
	 */
	public static void printReport(double[][] tideData){
		printWindSpeed(tideData);
		printPredictedHeight(tideData);
		printActualHeight(tideData);
		//calls the tideDifferences method inside calling the printHeightDifferences method
		//so the print method can use an array the same way as the first three print methods
		printHeightDifferences(tideDifferences(tideData));
	}
	/**
	 * findAverage method
	 * This method returns an array with the data for the average of the column in the given 2D array
	 * @param int column tells which column from the 2D Array to look through
	 * @param double[][] tideData is a 2D array with the tide information to look through that is set in the main method
	 * @return double[] is an array holding two spots, the first tells the time, which isn't important when calculating average
	 * and the second spot is the average of all the numbers in the chosen column of the tideData array
	 */
	public static double[] findAverage(int column, double[][] tideData){
		double sum = 0;
		int hour = 0;
		int time = 0;
		//for loop runs through tideData adding up the sums
		for(hour = 0; hour < tideData.length; hour++){
			sum = sum + tideData[hour][column];
			time = hour;
		}
		double average = sum / (tideData.length);
		double[] myArray = new double[2];
		//time isn't useful information when finding an average, I just did this to stay consistent
		//with my findHighest and findLowest methods to make things easier
		myArray[0] = time;
		myArray[1] = average;
		return myArray;
	}
	/**
	 * findHighest method
	 * This method returns an array with the data for the highest number in the given column in the given 2D 
	 * array and at what point the highest number occurred
	 * @param int column tells which column from the 2D Array to look through
	 * @param double[][] tideData is a 2D array with the tide information to look through that is set in the main method
	 * @return double[] is an array holding two spots, the first tells the time that the high number occurred at,
	 * and the second spot tells what the highest number in the chosen column of the tideData array is.
	 */
	public static double[] findHighest(int column, double[][] tideData){
		//sets variable highest equal to first number in the column of the array
		double highest = tideData[0][column];
		int hour = 0;
		int time = 0;
		//for loop runs through tideData array looking for highest number
		for(hour = 0; hour < tideData.length; hour++){
			//if statement sets a new highest if it finds a number bigger than the current highest
			if((tideData[hour][column]) > highest){
				highest = tideData[hour][column];
				time = hour;
			}
		}
		double[] myArray = new double[2];
		myArray[0] = time;
		myArray[1] = highest;
		return myArray;
	}
	/**
	 * findLowest method
	 * This method returns an array with the data for the lowest number in the given column in the given 2D 
	 * array and at what point the lowest number occurred
	 * @param int column tells which column from the 2D Array to look through
	 * @param double[][] tideData is a 2D array with the tide information to look through that is set in the main method
	 * @return double[] is an array holding two spots, the first tells the time that the low number occurred at,
	 * and the second spot tells what the lowest number in the chosen column of the tideData array is.
	 */
	public static double[] findLowest(int column, double[][] tideData){
		//sets variable lowest equal to first number in the column in tideData
		double lowest = tideData[0][column];
		int hour = 0;
		int time = 0;
		//for loop searches through tideData
		for(hour = 0; hour < tideData.length; hour++){
			//if statement sets new lowest when a number lower than the current lowest is found
			if((tideData[hour][column]) < lowest){
				lowest = tideData[hour][column];
				time = hour;
			}
		}
		double[] myArray = new double[2];
		myArray[0] = time;
		myArray[1] = lowest;
		return myArray;
	}
	/**
	 * tideDifferences method
	 * This method returns a 2D array which is the difference between the 2nd and 3rd columns in the tideData Array, it makes
	 * a 2D array just for consistency with the findAverage, findHighest, and findLowest methods so I could use the new 2D
	 * array work in those
	 * @param double[][] tideData is a 2D array with the tide information to look through that is set in the main method
	 * @return double[] is an array holding two spots, the first tells the difference at that point between the 2nd and 3rd columns in the
	 * tideData array.
	 */
	public static double[][] tideDifferences(double[][] tideData){
		//makes a 2D array which has as many rows as tideData but only has two columns just so I can be consistent with
		//sending a 2D array to the findAverage, findHighest, and findLowest methods, the second column isn't actually needed
		double[][] tideDifferences = new double[(tideData.length)][2];
		//for loop running through tideData
		for(int hour = 0; hour < tideData.length; hour++){
			//calculates absolute value of difference between 2nd and 3rd column of tideData
			tideDifferences[hour][0] = Math.abs(tideData[hour][1] - tideData[hour][2]);
			//just sets each value in the second column to 0 because that isn't important space
			tideDifferences[hour][1] = 0;
		}
		return tideDifferences;
	}
	/**
	 * printWindSpeed method
	 * This method prints out the average, highest, and lowest wind speed information using the findAverage,
	 * findHighest, and findLowest methods
	 * @param double[][] tideData is a 2D array with the tide information to send to other methods that was set in the main method
	 */
	public static void printWindSpeed(double[][] tideData){
		double average[] = findAverage(0, tideData);
		double highest[] = findHighest(0, tideData);
		double lowest[] = findLowest(0, tideData);
		System.out.println("The average wind speed is " + average[1] + "mph.");
		System.out.println("The highest wind speed occurred at " + highest[0] + " and was " + highest[1] + "mph.");
		System.out.println("The lowest wind speed occurred at " + lowest[0] + " and was " + lowest[1] + "mph.");
		System.out.println();
	}
	/**
	 * printPredictedHeight method
	 * This method prints out the average, highest, and lowest predicted tide height information using the findAverage,
	 * findHighest, and findLowest methods
	 * @param double[][] tideData is a 2D array with the tide information to send to other methods that was set in the main method
	 */
	public static void printPredictedHeight(double[][] tideData){
		double average[] = findAverage(1, tideData);
		double highest[] = findHighest(1, tideData);
		double lowest[] = findLowest(1, tideData);
		System.out.println("The average predicted tide height is " + average[1] + "mph.");
		System.out.println("The highest predicted tide height occurred at " + highest[0] + " and was " + highest[1] + "mph.");
		System.out.println("The lowest predicted tide occurred at " + lowest[0] + " and was " + lowest[1] + "mph.");
		System.out.println();
	}
	/**
	 * printActualHeight method
	 * This method prints out the average, highest, and lowest actual tide height information using the findAverage,
	 * findHighest, and findLowest methods
	 * @param double[][] tideData is a 2D array with the tide information to send to other methods that was set in the main method
	 */
	public static void printActualHeight(double[][] tideData){
		double average[] = findAverage(2, tideData);
		double highest[] = findHighest(2, tideData);
		double lowest[] = findLowest(2, tideData);
		System.out.println("The average actual tide height is " + average[1] + "mph.");
		System.out.println("The highest actual tide height occurred at " + highest[0] + " and was " + highest[1] + "mph.");
		System.out.println("The lowest actual tide height occurred at " + lowest[0] + " and was " + lowest[1] + "mph.");
		System.out.println();
	}
	/**
	 * printHeightDifferences method
	 * This method prints out the average, highest, and lowest wind speed information using the findAverage,
	 * findHighest, and findLowest methods
	 * @param double[][] tideDifferences is a 2D array made in the tideDifferences method
	 * which holds the differences between actual and predicted tide height information to send to other methods
	 */
	public static void printHeightDifferences(double[][] tideDifferences){
		double average[] = findAverage(0, tideDifferences);
		double highest[] = findHighest(0, tideDifferences);
		double lowest[] = findLowest(0, tideDifferences);
		System.out.println("The average tide height difference was " + average[1] + "mph.");
		System.out.println("The highest tide height difference occurred at " + highest[0] + " and was " + highest[1] + "mph.");
		System.out.println("The lowest tide height difference occurred at " + lowest[0] + " and was " + lowest[1] + "mph.");
		System.out.println();
	}
}

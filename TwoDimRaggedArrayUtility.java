/**
 * Class: CMSC203 CRN 30338 

 Program: Assignment 5 Design 

 Instructor: Ahmed Tarek 

 Summary of Description: The program calculates bonuses for the stores 

 Due Date: 04/01/2024 

 Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 I have not copied the code from a student or any source. 

 Student: @author Mariia Leskovets 
 */






import java.io.File;
import java.math.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.lang.Double; 

public class TwoDimRaggedArrayUtility {
	
	//countstructor
	
	public TwoDimRaggedArrayUtility() {}
	
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		
		
		Scanner inputFile=new Scanner(file);

		int count=0;
		ArrayList<String> list_array=new ArrayList<String>();

		while(inputFile.hasNext()) {
			String str=inputFile.nextLine();
			list_array.add(str);
			++count;
		}
		double[][] answer=new double[count][];
		
		for (int index=0;index<count;index++) 
		{
			
			String [] arr=list_array.get(index).split(" ");
			int length=arr.length;
			answer[index]=new double[length];
			
			for (int i=0;i<length;i++)
			{
				answer[index][i]=Double.parseDouble(arr[i]);
			}
		}
		
		inputFile.close();
		return answer;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		PrintWriter output=new PrintWriter(outputFile);
		int length=data.length;
		for (int index=0;index<length;index++) 
		{
			int count=data[index].length;

			
			for (int i=0;i<count;i++)
			{
				output.print(data[index][i]+" ");
			}
			output.println();

		}
		output.close();
	}
	
	public static double getTotal(double[][] data) {
		int length=data.length;
		double total=0.0;
		for (int index=0;index<length;index++) {
			int count=data[index].length;
			for (int i=0;i<count;i++) {
				total+=data[index][i];
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] data) {
		double total=TwoDimRaggedArrayUtility.getTotal(data);
		int count=0;
		int length=data.length;
		for (int index=0;index<length;index++) {
			count+=data[index].length;
		}
		double average=total/count;
		return average;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double total=0.0;
		int length=data[row].length;
		for (int index=0;index<length;index++) {
			total+=data[row][index];
		}
		
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		int length=data.length;
		double total=0.0;
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col)
			{
				total+=data[index][col];
			}
		}
		
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		int length=data[row].length;
		double biggest=data[row][0];
		for(int index=0;index<length;index++) {
			if (Double.compare(biggest,data[row][index])<0) {
				biggest=data[row][index];
			}
		}
		
		return biggest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int length=data[row].length;
		double biggest=data[row][0];
		int count=0;
		for(int index=0;index<length;index++)
		{
			if (Double.compare(biggest,data[row][index])<0) 
			{
				biggest=data[row][index];
				count=index;
			}
		}
		return count;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		int length=data[row].length;
		double smallest=data[row][0];
		for(int index=0;index<length;index++)
		{
			if (Double.compare(data[row][index],smallest)<0) 
			{
				smallest=data[row][index];
			}
		}
		
		return smallest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int length=data[row].length;
		double smallest=data[row][0];
		int count=0;
		for(int index=0;index<length;index++)
		{
			if (Double.compare(data[row][index],smallest)<0) 
			{
				smallest=data[row][index];
				count=index;
			}
		}
		
		return count;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		int length=data.length;
		
		double biggest=0.0;
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				biggest=data[index][col];
			}
		}
		
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				if (data[index].length>col && Double.compare(biggest,data[index][col])<0) 
				{
					biggest=data[index][col];
				}
			}
		}
		return biggest;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int length=data.length;
		double biggest=0.0;
		int count=0;
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				biggest=data[index][col];
			}
		}
		
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				if (data[index].length>col && Double.compare(biggest,data[index][col])<0) 
				{
					biggest=data[index][col];
					count=index;
				}
			}
		}
		return count;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		int length=data.length;
		double smallest=0.0;
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				smallest=data[index][col];
			}
		}
		
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				if (data[index].length>col && Double.compare(data[index][col],smallest)<0) 
				{
					smallest=data[index][col];
				}
			}
		}
		return smallest;
	}
	
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int length=data.length;
		double smallest=0.0;
		int count=0;
		
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				smallest=data[index][col];
			}
		}
		for (int index=0;index<length;index++) 
		{
			if (data[index].length>col) 
			{
				if (data[index].length>col && Double.compare(data[index][col],smallest)<0) 
				{
					smallest=data[index][col];
					count=index;
				}
			}
		}
		return count;
	}
	
	
	
	
	public static double getHighestInArray(double[][] data) {
		int length=data.length;
		double biggest=data[0][0];
		for (int index=0;index<length;index++){
			int col=data[index].length;
			for (int i=0;i<col;i++) {
				if (Double.compare(biggest,data[index][i])<0) {
					biggest=data[index][i];
				}
			}
		}
		return biggest;
	}
	
	public static double getLowestInArray(double[][] data)
	{
		int length=data.length;
		double smallest=data[0][0];
		for (int index=0;index<length;index++)
		{
			int col=data[index].length;
			for (int i=0;i<col;i++)
			{
				if (Double.compare(data[index][i],smallest)<0) 
				{
					smallest=data[index][i];
				}
			}
		}
		return smallest;
	}

}
	

		



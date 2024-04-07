
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



public final class HolidayBonus  extends Object {
	public static final double HIEST_BONUS=5000.0;
	public static final double LOWEST_BONUS=1000.0;
	public static final double OTHER_BONUS=2000.0;
	
	
	public HolidayBonus() {}
	
	public static double[] calculateHolidayBonus(double[][] data) {
		
		int length=data.length;
		
		double[] bonuses=new double[length]; 
		
		for (int index=0;index<length;index++)
		{
			int row=data[index].length;
			double sum=0.0;
			
			for (int i=0;i<row;i++)
			{
				double sale=data[index][i];
				double highest=TwoDimRaggedArrayUtility.getHighestInColumn(data,i);
				double lowest=TwoDimRaggedArrayUtility.getLowestInColumn(data,i);
				
				if(sale==highest && data[index][i]>0 ) 
				{
					sum+=HIEST_BONUS;
				}
				else if (sale<=0)
				{
					sum+=0;
				}
				else if (sale==lowest && sale>0 ) 
				{
					sum+=LOWEST_BONUS;
				}
				else if(sale!=lowest && sale>0 && sale!=highest)
				{
					sum+=OTHER_BONUS;
				}	
			}
			bonuses[index]=sum;
		}
		return bonuses;
	}
	
	
	
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double [] total=calculateHolidayBonus(data);
		int length=total.length;
		double result=0.0;
		
		for (int index=0;index<length;index++) {
			result+=total[index];
		}
		return result;
	}
	

}

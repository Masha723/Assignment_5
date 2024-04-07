import java.io.File;
import java.io.FileNotFoundException;


public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file=new File("/Users/mariialeskovets/Desktop/eclipse-workspace/Assignment_5/src/dataSet2.txt");
		File file_1=new File("/Users/mariialeskovets/Desktop/eclipse-workspace/Assignment_5/src/dataSet7.txt");
		
		double[][] answer=TwoDimRaggedArrayUtility.readFile(file);
		int length=answer.length;
		for (int index=0;index<length;index++) 
		{
			int count=answer[index].length;
			for(int i=0;i<count;i++) 
			{
				System.out.print(answer[index][i]+" ");
			}
			System.out.println();
		}
		
		TwoDimRaggedArrayUtility.writeToFile(answer,file_1);
		
	}
}

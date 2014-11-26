
import java.util.*;

public class Test {

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int lineCount = scan.nextInt();
        String[] lines = new String[lineCount];
        
        for(int i = 0; i < lineCount; i ++) {
            lines[i] = scan.nextLine();
        }
        
        int[][] matrix = new int[lineCount][3];
        for(int i = 0; i < lineCount; i ++) {
            String[] splits = lines[i].split(",");
            for(int j = 0; j < 3; j ++) {
                matrix[i][j] = Integer.parseInt(splits[j]);
            }
        }
        
        int result = 0;
        int start = 0;
        //matrix[0][0] --> matrix[lineCount-1][2]
        int end = matrix[0][0];
        int i = 0;
        while(i < lineCount) {
            if(i == 0) {
                result += matrix[i][0] - 0;
                result += matrix[i][2] + matrix[i][1] - matrix[1][0] + matrix[i][2];
            } else {
                if(matrix[i][0] >= matrix[i-1][1]) {
                    result += matrix[i][0] - matrix[i-1][1];
                    result += matrix[i][2] + matrix[i][2] + (matrix[i][1] - matrix[i][0]);
                } else {
                    result -= matrix[i-1][2];
                    result -= matrix[i][0] - matrix[i-1][1];
                    result += matrix[i][2] - matrix[i-1][2];
                    result += matrix[i][1] - matrix[i][0];
                    result += matrix[i][2];
                }
            }
            i++;
        }
        
        System.out.println(result);
    }
	
}

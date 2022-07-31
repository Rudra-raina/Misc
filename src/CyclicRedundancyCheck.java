import java.util.Arrays;
import java.util.Scanner;

public class CyclicRedundancyCheck {

    // Given a divisor and a dividend. We need to calcualte the CRC ramiander & append it in our dividend
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        // Get the message from the user
        System.out.print("Enter the message : ");
        String message=input.nextLine();
        // Get the checker from the user
        System.out.print("Enter the checker : ");
        String checker=input.nextLine();
        // Create array since strings are immutable
        // The dividend used in CRC has 0's appened at the end and count of 0's is : length of divisor-1
        int[] dataArr=new int[message.length()+checker.length()-1];
        // By default, every value is 0 in array. So 0's are already appended in the divisor towards the
        // end. Hence we just have to copy value of 'message' string.
        for(int i=0;i<message.length();i++){
            dataArr[i]=message.charAt(i)-'0';
        }
        // Create array. The divisor array & string will be same
        int[] divisorArr=new int[checker.length()];
        for(int i=0;i<checker.length();i++){
            divisorArr[i]=checker.charAt(i)-'0';
        }
        // Now traverse every window of divident
        int n=dataArr.length;
        int m=divisorArr.length;
        for(int i=0;i<n-m+1;i++){
            if(dataArr[i]==1){
                for(int j=0;j<checker.length();j++){
                    dataArr[i+j]^=divisorArr[j];
                }
            }
        }
        // We initially appended (length of divisor-1) 0's at the end. Now our CRC remainder will be of
        // the same length & it has updated the values of those 0's
        // Hence it woulr start from (m-1)th posiiton from behind : n-(m-1) = n-m+1
        // We just need to append that remainder
        String output=message;
        for(int i=n-m+1;i<n;i++){
            output+=dataArr[i];
        }
        System.out.println(output);
    }
}

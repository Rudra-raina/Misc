import java.util.Arrays;
import java.util.Scanner;

public class HammingCode {

    // We need to calculate hamming code for a 7 bit data
    // We need to find redundant bits first via 2^r>=m+r+1
    // Here m=7, and we  need to calculate smallest value of 'r' which satisfies this condition.
    // Therefore, we get m=7 & r=4
    // So our hamming code will be a 11-digit number, containing 7 data bits & 4 redundant bits
    // These 7 bits will be user dfined input & we just need to calculate value of these 4 redundant bits
    // These redundant bits will be at posiiton 2^x where x can be 0,1,2,.... Hence 1,2,4,8
    // We need to calculate the parity of these bits
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 7 bit data : ");
        String str=input.nextLine();
        int m=7;
        int r=4;
        // This array will contain our final hamming code of 11 digits
        // We have added +1 because we wanted to access 11th index , hence we need array of size 12
        // Therfore hamming code will be from index 1 to 11.We are'nt concenrned with value at 0th index
        int[] arr=new int[m+r+1];
        // Parity bits will be at posiiton : 1,2,4,8 & will be reffered as P1,P2,P4,P8
        // Let us assign it as -1
        arr[1]=-1;
        arr[2]=-1;
        arr[4]=-1;
        arr[8]=-1;
        // Rest of our array values will be assigned to the input data
        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=-1){ // Access posiitons which are not parity bits
                arr[i]=str.charAt(j)-'0'; // subtract ascii value of 0 to get real value
                j++;
            }
        }
        // Suppose input was 1001101, then array would look like : # -1 -1 1 -1 0 0 1 -1 1 0  1
        //                                          Index value:   0  1  2 3  4 5 6 7  8 9 10 11
        // # represents index 0, we are not concerned with it
        // Now we need to fill these parity values which currently are as -1.
        // We will use even parity to calculate value of parity bits
        
        // For P1 we check at 3 5 7 9 11 ( We check for 1 , skip for 1, ignoring the current value)
        // we check for 1 , skip 2, check for 3, skip 4, check for 5 , skip 6
        // Since 1 is the parity itselt, we skip it
        
        // For P2 we check at 3 6 7 10 11 ( We check for 2 skip for 2,gnoring the current value)
        // we check for 2,3 , skip 4,5, check for 6,7, skip 8,9, check for 10,11 
        // Since 2 is the parity itselt, we skip it


        // For p4 we check at 5 6 7 ( We check for 4 , skip for 4,gnoring the current value)
        // we check for 4,5,6,7 , skip for 8,9,10,11, check for 12,13,14,15, skip for 16,17,18,19 
        // Since 4 is the parity itselt, we skip it and we dont have access after 11th position
        
        // For P8 we check at 9 10 11 ( We check for 8, skip for 8,gnoring the current value)
        // we check for 8,9,10,11,12,13,14,15 , skip for 16,17,18,19,20,21,22,23
        // Since 8 is the parity itselt, we skip it and we dont have access after 11th position

        // For P1. If sum is divisible by 2, then it means it has even number of 1's. Hence we add 0
        // If sum was not divisble by 2, it means it had odd number of 1's, we would have added 1 as
        // we are using even parity concept.
        if((arr[3]+arr[5]+arr[7]+arr[9]+arr[11])%2==0){
            arr[1]=0;
        }else{
            arr[1]=1;
        }
        // For P2
        if((arr[3]+arr[6]+arr[7]+arr[10]+arr[11])%2==0){
            arr[2]=0;
        }else{
            arr[2]=1;
        }
        // For p4
        if((arr[5]+arr[6]+arr[7])%2==0){
            arr[4]=0;
        }else{
            arr[4]=1;
        }
        if((arr[9]+arr[10]+arr[11])%2==0){
            arr[8]=0;
        }else{
            arr[8]=1;
        }
        // Final output
        String output="";
        for(int i=1;i<arr.length;i++){
            output+=arr[i];
        }
        System.out.println(output);
    }


}

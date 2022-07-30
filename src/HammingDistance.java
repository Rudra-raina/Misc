import java.util.Scanner;

public class HammingDistance {

    // We need to calculate the hamming distance between 2 binary values
    // We will have 2 equal length strings, representing the binary values
    // The Hamming distance between two equal-length strings representing binary values, is the
    // number of positions at which the corresponding symbols are different
    public static void main(String[] args) {
        // Take user input
        Scanner input=new Scanner(System.in);
        System.out.print("Enter 1st string : "+" ");
        String str1=input.nextLine();
        System.out.print("Enter 2nd string : "+" ");
        String str2=input.nextLine();

        // Calculating hamming distance
        int count=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!= str2.charAt(i)){ // compare corresponding symbols
                count++;
            }
        }
        System.out.print("Hamming distance is "+count);
    }

}

import java.util.Scanner;

public class EvenParity {

    // We need to generate even parity code
    // We will be given a bit number in form of a string. Even parity means that total count of 1's should
    // be even. Even parity code is generated by appending 1 bit to the string.
    // If count of 1's is even, then we add 0 to the string as it already contains even number of 1's
    // If count of 1's is odd, we add 1 to the string , hence it now contains even number of 1's
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter string : ");
        String str=input.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        if(count%2==0){ // Even number of 1's
            str=str+'0';
        }else{ // odd number of 1's
            str=str+'1';
        }
        System.out.println(str);
    }
}
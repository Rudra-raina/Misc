import java.util.Scanner;

public class UnicastMulticast {

    // Given a MAC address, we need to find if its unicast or multicast
    // It will be of the type -> XX : XX : XX : XX : XX : XX
    // We will need to check the 2nd character. It can be from 0-9 or A-E.
    // We convert it to binary and if its last digit is 0, then its unicast , else its multicast
    // 2 : 0010, 4 : 0100 , 6 : 0110 , 8: 1000
    // A(10) : 1010 , C(12) : 1100, E(14) : 1110
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter hexadecimal code :");
        String str=input.nextLine();
        int val=str.charAt(1);
        if(val=='2' || val=='4' || val=='6' || val=='8' || val=='A' || val=='C' || val=='E'){
            System.out.println("Unicast");
        }else{
            System.out.println("Multicast");
        }
    }
}

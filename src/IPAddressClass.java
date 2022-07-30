import java.util.Scanner;

public class IPAddressClass {

    // Given an IP address, we need to find its class
    // The IP address can be of type binary or decimal
    // For binary, rules are as follows :
    // Class A must begin with 0, Class B must begin with 10, Class C must begin with 110, Class D with
    // 1110 & rest are Class E
    // For Decimal (192.200.100.1) , we check for number before the 1st decimal ,rules are as follows :
    // 0-127 for A , 128-191 for B , 192-223 for C, 224-239 for D, rest for E
    public static void main(String[] args) {
        // Take input from user
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the IP Address : ");
        String str=input.nextLine();
        boolean decimal=false;
        // Check for decimal
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                decimal=true; // Decimal type IP
                decimal(str);
            }
        }
        if(!decimal){  // This means IP is not of the type decimal, hence it has to be binary
            binary(str);
        }
    }

    // Binary IP
    public static void binary(String str){
        if(str.substring(0,1)=="0"){
            System.out.println("A");
        }else if(str.substring(0,2)=="10"){
            System.out.println("B");
        }else if(str.substring(0,3)=="110"){
            System.out.println("C");
        }else if(str.substring(0,4)=="1110"){
            System.out.println("D");
        }else{
            System.out.println("E");
        }
    }

    // Decimal IP
    public static void decimal(String str){
        // Calculate length till 1st decimal
        int count=0;
        int i=0;
        while(str.charAt(i)!='.'){
            count++;
            i++;
        }
        // Convert string to integer
        // Suppose we have 142.18.9.10, so count will be 3
        // We need to convert string 142 into integer 142
        // We need to perform (10^2)*1 + (10^1)*4 + (10^0)*2
        i=0;
        int res=0;
        while(str.charAt(i)!='.'){
            res+=Math.pow(10,count-1)*(str.charAt(i)-'0');
            count--;
            i++;
        }
        // Now compare
        if(0<=res && res<=127){
            System.out.print("A");
        }else if(128<=res && res<=191){
            System.out.print("B");
        }else if(192<= res && res<=223){
            System.out.print("C");
        }else if(224<= res && res<=229){
            System.out.print("D");
        }else{
            System.out.print("E");
        }
    }
}

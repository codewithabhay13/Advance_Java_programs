// 


// package JavaAdvCoding;
import java.util.Scanner;
public class CreditCardValidation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number Of Cards:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter Card Number:");
            String card=sc.nextLine();
            if(card.matches("^[456]\\d{3}(-\\d{4}){3}$|^[456]\\d{15}$") && !card.replace("-","").matches(".*(\\d)\\1\\1\\1.*")){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
        }
    }
}
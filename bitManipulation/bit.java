package bitManipulation;
import java.util.*;

public class bit {
    public static void main(String[] args) {

//        // set bit
//        int n = 1;  // 0001
//        int pos =2;
//        int bitmask = 1<<pos;
//        System.out.println(n | bitmask);

//        // clear bit
//        int n = 7;  // 0101
//        int pos =2;
//        int bitmask = 1<<pos;
//        int notBitmask= ~bitmask;
//
//        int newNumber = notBitmask & n;
//        System.out.println(newNumber);

        // update Bit
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        // oper=1 -> set; oper=0 -> clear
        int n = 5;
        int pos = 1;

        int bitMask = 1<<pos;
        if(oper == 1) {
            //set
            int newNumber = bitMask | n;
            System.out.println(newNumber);
        } else {
            //clear
            int newBitMask = ~(bitMask);
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }
    }
}

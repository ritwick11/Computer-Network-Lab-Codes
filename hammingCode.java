import java.util.*;
class hammingCode
{
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("HAMMING CODE PROCESS FOR 7bit DATA");
        System.out.println();
        System.out.println();
        System.out.println("DATA ENCODING PART STARTS HERE");
        System.out.println();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int[] data = new int[10];
        System.out.printf("\nEnter the D7 bit: ");
        data[7] = sc.nextInt();
        System.out.printf("\nEnter the D6 bit: ");
        data[6] = sc.nextInt();
        System.out.printf("\nEnter the D5 bit: ");
        data[5] = sc.nextInt();
        System.out.printf("\nEnter the D3 bit: ");
        data[3] = sc.nextInt();

        data[1] = data[3]^data[5]^data[7];
        data[2] = data[3]^data[6]^data[7];
        data[4] = data[5]^data[6]^data[7];

        System.out.println();
        
        System.out.printf("The new data with Hamming Code is: ");
        System.out.println();

        for(int i=7; i>0; i--)
            System.out.print(data[i]);

        System.out.println();
        System.out.println();
        System.out.println("DATA DECODING PART STARTS HERE");
        System.out.println();
        System.out.println();
            
        int[] tempData = new int[10];
            for(int i=7; i>=1; i--)
            {
                System.out.printf("\nEnter the D" + i + " bit : ");
                tempData[i]=sc.nextInt();
            }
        
        int P1 = tempData[3]^tempData[5]^tempData[7]^tempData[1];
        int P2 = tempData[3]^tempData[6]^tempData[7]^tempData[2];
        int P4 = tempData[5]^tempData[6]^tempData[7]^tempData[4]; 
                                         
        int binaryToDecimal = ((P4*4) + (P2*2) + (P1*1));

        System.out.println();
        System.out.println();

        if(binaryToDecimal==0)
            System.out.println("No error found. The data received perfectly!");
        else
        {
            System.out.println("Error found at bit number "+ binaryToDecimal +" of the data");

            if(tempData[binaryToDecimal]==0)
                tempData[binaryToDecimal]=1;

            else
                tempData[binaryToDecimal]=0;

            System.out.println();

            System.out.printf("The corrected data is: ");

            for(int i=7; i>=1; i--)
                System.out.print(tempData[i]);
            System.out.println();
        }
    }
}   

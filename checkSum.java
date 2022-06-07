import java.util.*;
class checkSum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("What will be the data size?(max:8): ");
        int dataSize = sc.nextInt();

        int[] data1 = new int [10];
        int[] data2 = new int [10];
    
        System.out.printf("Enter the first data: \n");
        for(int i=0; i<dataSize; i++)
            data1[i] = sc.nextInt();
    
        System.out.printf("Enter the second data: \n");
        for(int i=0; i<dataSize; i++)
            data2[i] = sc.nextInt();

        System.out.printf("The first data is: ");
        for(int i=0; i<dataSize; i++)
            System.out.print(data1[i]);
        
        System.out.printf("\nThe second data is: ");
        for(int i=0; i<dataSize; i++)
            System.out.print(data2[i]);
        
        System.out.println();
        System.out.println();
        System.out.println();

        // LOGIC OF BOTH DATA ADDITION 

        int carry=0;
        int[] sum = new int[10];
        for(int i=dataSize-1; i>=0; i--)
        {
            sum[i] = data1[i] + data2[i] + carry;
            
            if(sum[i]==0)
            {
                sum[i] = 0;
                carry = 0;
            }
            else if(sum[i]==1)
            {
                sum[i] = 1;
                carry = 0;
            }
            else if(sum[i]==2)
            {
                sum[i] = 0;
                carry = 1;
            }
            else if(sum[i]==3)
            {
                sum[i] = 1;
                carry = 1;
            }
        }  
            //NOW ADD THE CARRY
            if(carry == 1)
            {
                for(int i=dataSize-1; i>=0; i--)
                {
                    sum[i] = sum[i] + carry;
                    if(sum[i]==1)
                    {
                        sum[i] = 1;
                        carry = 0;
                    }
                    else if(sum[i]==2)
                    {
                        sum[i] = 0;
                        carry = 1;
                    }
                }
            }

            //COPY THE SUM IN A DIFFERENT ARRAY
            int[] tempSum = new int[10];
            for(int i=0; i<=dataSize; i++)
                tempSum[i] = sum[i];

            //NOW COMPLEMENT OF THE SUM ARRAY
            for(int i=0; i<dataSize; i++)
            {
                if(sum[i] == 0)
                    sum[i] = 1;
                else
                    sum[i] = 0;
            }

            System.out.printf("\nThe CheckSum Code is: ");
            for(int i=0; i<dataSize; i++)
                System.out.print(sum[i]);
        
            //TX ENDS HERE
            //RX STARTS HERE

            int[] rec = new int[10];
            for(int i=dataSize-1; i>=0; i--)
                rec[i] = tempSum[i]^sum[i];
            
            for(int i=0; i<dataSize; i++)
            {
                if(rec[i]==1)
                    rec[i] = 0;
                else
                    rec[i] = 1;
            }     
            int count = 0;
            for(int i=0; i<dataSize; i++)
                if(rec[i]==1)
                    count++;
            
            if(count==0)
                System.out.println("\nData received perfectly! No error found.");
            else
                System.out.println("\nData have error!.");       
    }
}
     


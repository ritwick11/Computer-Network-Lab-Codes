import java.util.*;

class evenOddParity
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter '0' for Odd parity & '1' for Even parity: ");
        int parity = sc.nextInt();
        int [] data = new int[10];
        int count = 0;

        System.out.println();
        System.out.println("Enter the four data bits one by one:");
        for(int i=1; i<=4; i++)
        {
            data[i] = sc.nextInt();
            if(data[i]==1)
                count++;
        }

        if(parity==1)
        {
            if (count%2==0)
                data[5] = 0;
            else
                data[5] = 1;
        }
        else if(parity==1)
        {
            if (count%2==0)
                data[5] = 1;
            else
                data[5] = 0;
        }

        data = sendData(data);
        receiveData(data, parity);
    }
    
    public static int[] sendData(int[] data)
    {
        System.out.println();
        System.out.printf("After adding the parity bit the data is: ");
        for(int i=1; i<=5; i++)
        {
            System.out.print(data[i]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.printf("\nPress 0 to introduce error in the data: ");
        int parity = sc.nextInt();

        if(parity==0)
        {
            System.out.printf("Which bit of the data needs to be changed?:  ");
            int position = sc.nextInt();
            System.out.printf("What is the new data bit after changing?: ");
            int bit = sc.nextInt();
            data[position] = bit;
            return data;
        }

        else
        return data;
    }

    public static void receiveData(int[] data, int parity)
    {
        System.out.println();
        System.out.printf("Received data is: ");
        int count = 0;

        for(int i=1; i<=5; i++)
        {
            System.out.print(data[i]);
            if(data[i]==1)
                count++;
        }
        
        System.out.println();
        System.out.println();

        if(parity==1)
        {
            if (count%2==0)
                System.out.println("\n.....No Error!.....");
            else
                System.out.println("\n.....Error Found!.....");
        }
        else if(parity==0)
        {
            if (count%2==0)
                System.out.println("\n.....Error Found!.....");
            
            else
                System.out.println("\n.....No Error!.....");
        }       
    }
}
import java.util.*;
class both2D 
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter '0' for Odd parity & '1' for Even parity: ");
        int parity = sc.nextInt();
        int i, j;
        int [][] data = new int [4][4];

        if(parity==0)
        {
            System.out.println("\nWelcome to 2D ODD Parity Generation and Detection\n\n");
            System.out.println("Enter the data in a matrix form one by one..... \n");
            for(i=0; i<3; i++)
            {
                int check = 0;
                for(j=0; j<3; j++)
                {
                    data[i][j] = sc.nextInt();
                    if(data[i][j]==1)
                    check++;
                }

                if(check%2 == 0)
                    data[i][3] = 1;
                else
                    data[i][3] = 0;
            }
            for(j=0; j<3; j++)
            {
                int check = 0;
                for(i=0; i<3; i++)
            {
                    if(data[i][j]==1)
                        check++;
                }
    
                if(check%2 == 0)
                    data[3][j] = 1;
                else
                    data[3][j] = 0;
            }
        }

        else if(parity==1)
        {
            System.out.println("\nWelcome to 2D EVEN Parity Generation and Detection\n\n");
            System.out.println("Enter the data in a matrix form one by one..... \n");
            for(i=0;i<3;i++)
		    {
			    int check=0;
			    for(j=0;j<3;j++)
			    {
				    data[i][j]=sc.nextInt();
				    if(data[i][j]==1)
					    check++;
			    }
			
			    if(check%2==0)
				    data[i][3]=0;
			    else
				    data[i][3]=1;
		    }
	
		    for(j=0;j<=3;j++)
		    {
			    int check=0;
			    for(i=0;i<3;i++)
			    {
				
				    if(data[i][j]==1)
					check++;
			    }
			
			    if(check%2==0)
				data[3][j]=0;
			    else
				    data[3][j]=1;
		    }
	    }
    
        printParityData(data);
        addError(data);
        receive(data);
        if(parity==0)
            checkDataOdd(data);
        else if(parity==1)
            checkDataEven(data);
    }

    public static void printParityData(int[][] data)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println(".....Data after adding parity bits to rows and columns.....");
        System.out.println();

        for(int i=0; i<=3; i++)
        {
            for(int j=0; j<=3; j++)
                System.out.print(data[i][j]+" ");

            System.out.println();
        }
    }

    public static void addError(int[][] data)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.printf("Enter '0' to introduce error in the data & any other number to send the same data: ");
        int choice = sc.nextInt();
        System.out.println();
        
        if(choice==0)
        {
            System.out.printf("In which Row: ");
            int row = sc.nextInt();
            System.out.printf("In which Column: ");
            int column = sc.nextInt();
            System.out.printf("What is the new Data Bit: ");
            int dataBit = sc.nextInt();
            if(dataBit>1)
            {
                System.out.println("\n\n**********ERROR**********\n\n");
                addError(data);
            }
            else
            data[row][column] = dataBit;
            System.out.println("\nSending data.....\n");
        }
        else 
        System.out.println("\nSending data.....\n");    
        return ;
    }
    
    public static void receive(int[][] data)
    {
        System.out.println("\nReceiving data.....\n");
        for(int i=0; i<=3; i++)
        {
            for(int j=0; j<=3; j++)
            {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void checkDataOdd(int[][] data)
    {   
        for(int i=0; i<3; i++)
        {
            int check = 0;
            for(int j=0; j<3; j++)
            {
                if(data[i][j]==1)
                    check++;
            }
            if(check%2 == 0 && data[i][3] == 0)
            {
                System.out.println("\nError Found! Transmit data again.");
                return;
            }
            else if(check%2 != 0 && data[i][3] == 1)
            {
                System.out.println("\nError Found! Transmit data again.");
                return;
            }
        }
        for(int j=0; j<3; j++)
        {
            int check = 0;
            for(int i=0; i<3; i++)
            {
                if(data[i][j]==1)
                    check++;
            }
            if(check%2 == 0 && data[3][j]==0)
            {
                System.out.println("\nError Found! Transmit data again.");
                return;
            }
            else if(check%2 != 0 && data[3][j]==1)
            {
                System.out.println("\nError Found! Transmit data again.");
                return;
            }
        }
        System.out.println("\nGood");
        return;
    }

    public static void checkDataEven(int[][] data)
	{
	int i,j;
		for(i=0;i<3;i++)
		{
			int check=0;
			for(j=0;j<3;j++)
			{
				if(data[i][j]==1)
					check++;
			}
			
			if(check%2==0 && data[i][3]==1)
			{
				System.out.println("\nError Found! Transmit data again.");
				return;
			}
				
			
			else if(check%2!=0 && data[i][3]==0)
			{
				System.out.println("\nError Found! Transmit data again.");
				return;
			}
				
		}
		
		for(j=0;j<3;j++)
		{
			int check=0;
			for(i=0;i<3;i++)
			{
				if(data[i][j]==1)
					check++;
			}
			
			if(check%2==0 && data[3][j]==1)
			{
				System.out.println("\nError Found! Transmit data again.");
				return;
			}
				
			
			else if(check%2!=0 && data[3][j]==0)
			{
				System.out.println("\nError Found! Transmit data again.");
				return;
			}
				
		}
		System.out.println();
		System.out.println("\n. No error found! Data received perfectly.");
		        return;
	}
}

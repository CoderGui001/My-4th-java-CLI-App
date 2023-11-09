import java.util.*;
import java.text.DecimalFormat;

class PRF_Final_CourseworkJ{
	public static DecimalFormat df = new DecimalFormat("0.00");
	public static Scanner input=new Scanner(System.in);
	
	public final static void clearConsole() {
		try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		  }
		} catch (final Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public static String[] OrderId={"ODR#00001","ODR#00002","ODR#00003","ODR#00004","ODR#00005","ODR#00006","ODR#00007","ODR#00008"};
	public static String[] PhoneNumber={"0776198410","0703859852","0769854321","0776198410","0703859852","0775544336","0703859852","0712002200"};
	public static String[] SizeArr={"XS","XL","XXL","M","M","S","XXL","M"};
	public static int[] QTYarr={3,4,1,3,6,2,1,3};
	public static String[] status ={"processing","delivering","delivered","delivering","processing","delivered","processing","delivered"};
	public static String[] Amount={"1800.00","4400.00","1200.00","2700.00","5400.00","1600.00","1200.00","2700.00"};
	//public static String[] OrderId2=new String[OrderId.length-1];
	public static final String[] Sizz={"XS","S","M","L","XL","XXL"};
	
	public static int[] StatusReading1=new int[0];
	public static int[] StatusReading2=new int[0];
	public static int[] StatusReading3=new int[0];
	
	
	public static int Status=-1;
	
	public static final int  PROCESSING=0,DELIVERING=1,DELIVERED=2;
	public static final double XS = 600.00;
	public static final double S = 800.00;
	public static final double M = 900.00;
	public static final double L = 1000.00;
	public static final double XL = 1100.00;
	public static final double XXL = 1200.00;
	
	
	public static String[] DelelteArrayElement(String[] br,String IDs){
		
		String[] temp=new String[br.length-1];
		int  newindex=0;
		for(int i=0;i<br.length;i++){
			if(!(IDs.equals(br[i]))){
			
				temp[newindex]=br[i];
				newindex++;
			}
			
		}
		
		//System.out.println(Arrays.toString(temp));
		
		return temp;
	}
	public static double[] Convert_String_Array_to_Double(String[] ar){
		
		double[] DArray = new double[ar.length];
		for(int i=0;i<ar.length;i++){
			DArray[i]=Double.parseDouble(ar[i]);
		}
		
		
		
		return DArray;
	}
	public static double[] Convert_String_Array_to_Double_array_And_SortIT(String[] ar){
		
		double[] DArray = new double[ar.length];
		for(int i=0;i<ar.length;i++){
			DArray[i]=Double.parseDouble(ar[i]);
		}
		
		for(int i=1;i<DArray.length;i++){
			
			for(int j=0;j<i;j++){
				if(DArray[i]>DArray[j]){
					double temp=DArray[j];
					DArray[j]=DArray[i];
					DArray[i]	=temp;
						
				}	
				
			}
			
		}
		
		return DArray;
	}
	public static void Answere(){
		
		System.out.print("\tDo you want to place another order? (y/n):");
		String Ans3=input.next().toLowerCase();
		clearConsole();
							
		if(Ans3.equals("y")){
			PlaceOrder();
		}
		
		else if(Ans3.equals("n")){
			MainMenu();
		}
		
		
		
	}
	public static String[] extendArray(String[] br){
	
		String[] temp=new String[br.length+1];
		
		for(int i=0;i<br.length;i++){
			
			temp[i]=br[i];
			
		}
		
		return temp;
		
	}
	public static double[] extendArrayDouble(double[] br){
	
		double[] temp=new double[br.length+1];
		
		for(int i=0;i<br.length;i++){
			
			temp[i]=br[i];
			
		}
		
		return temp;
		
	}
	public static int[] extendArrayInteger(int[] br){
	
		int[] temp=new int[br.length+1];
		
		for(int i=0;i<br.length;i++){
			
			temp[i]=br[i];
			
		}
		
		return temp;
		
	}
	public static String Qty(String s,int a){
		
		double[] price={600,800,900,1000,1100,1200};
		double Qty=0;
		
		if(s.equals("XS")){
			Qty=price[0]*a;
		}
		else if(s.equals("S")){
			Qty=price[1]*a;	
		}
		
		else if(s.equals("M")){
			Qty=price[2]*a;	
		}
		
		else if(s.equals("L")){
			Qty=price[3]*a;	
		}
		
		else if(s.equals("XL")){
			Qty=price[4]*a;	
		}
		
		else if(s.equals("XXL")){
			Qty=price[5]*a;	
		}
		
		else{
			System.out.println("\t\tEnter Valid Size...");
		}
		
		String Qty2=df.format(Qty);
		
		return Qty2;
		
	}
	public static String GeneratedId(){
		if(OrderId.length>0){
			
			int id =
			Integer.parseInt(OrderId[OrderId.length-1].split("[#]")[1]);
				id++;
				
			return String.format("ODR#%05d",id);
		}
		
		return "ODR#00001";
	}
	public static boolean isValid4nNumber(String Number){
			
			if((Number.charAt(0)!='0')||(Number.length()!=10)){
					return false;
			}
				return true;
		
	}
	public static boolean PhoneNumberSearch(String a,String[] b){
		
		for(int i=0;i<b.length;i++){
			
			if(b[i].equals(a)){
			
				return true;	
			}
		}
		return false;
	}
	
	
	public static void CustomerReports(){
		System.out.println("\r\n\t   _____          _                              _____                       _       \r\n\t  / ____|        | |                            |  __ \\                     | |      \r\n\t | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n\t | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n\t | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n\t  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n\t                                                           | |                       \r\n\t                                                           |_|");
		System.out.println(" \t\b\b___________________________________________________________________________________________");
		System.out.println();
		
		System.out.printf("\t\t\t\b%-23s","[1] Best in Customers");
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[2] View Customers");
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[3] All Customer Report");
		System.out.println();
		
		System.out.print("\tEnter option :");
		int option=input.nextInt();
		clearConsole();
		
				switch(option){
					
					case 1:BestInCustomers();break;
					case 2:ViewCustomers();break;
					case 3:AllCustomerReport();break;
					default:
				}
		
		
		
	}
	public static void BestInCustomers(){
		System.out.println("\r\n\t  ____            _     _____          _____          _                                \r\n\t |  _ \\          | |   |_   _|        / ____|        | |                               \r\n\t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n\t |  _ < / _ \\/ __| __|   | | | \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n\t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n\t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println(" \t\b\b___________________________________________________________________________________________");
		System.out.println();
		
		System.out.println("\t\t+-----------------+---------+-----------------+");
		System.out.printf("\t\t|%17s|%9s|%17s|%n","   Customer ID   "," All QTY ","   Total Amount  ");
		System.out.println("\t\t+-----------------+---------+-----------------+");
		
		String[] CustomerID = new String[0];
		double[] totalA=new double[0];
		int[] Sum1=new int[0];
		
		if (PhoneNumber.length>0){
			
			L1:for (int i = 0; i < PhoneNumber.length; i++){
				
				for (int j = 0; j < CustomerID.length; j++){
					if (PhoneNumber[i].equals(CustomerID[j])){
						
						continue L1;
					}
				}
				
				CustomerID=extendArray(CustomerID);
				CustomerID[CustomerID.length-1]=PhoneNumber[i];
			}	
		}		
		
		
		for(int i=0;i<CustomerID.length;i++){
				int[] QTYtemp=new int[6];
				int Sum=0;
				
				for(int j=0;j<PhoneNumber.length;j++){
					if(CustomerID[i].equals(PhoneNumber[j])){
							
							switch(SizeArr[j]){
								case "XS":QTYtemp[0]+=QTYarr[j];
											if(QTYtemp[0]>0){
												Sum+=QTYtemp[0];
											}
										
										  break;
								case "S":QTYtemp[1]+=QTYarr[j];
											if(QTYtemp[1]>0){
												Sum+=QTYtemp[1];
											}
										
										  break;
								case "M":QTYtemp[2]+=QTYarr[j];
											if(QTYtemp[2]>0){
												Sum+=QTYtemp[2];
											}
										
										  break;
								case "L":QTYtemp[3]+=QTYarr[j];
											if(QTYtemp[3]>0){
												Sum+=QTYtemp[3];
											}
										  
										  break;
								case "XL":QTYtemp[4]+=QTYarr[j];
											if(QTYtemp[4]>0){
												Sum+=QTYtemp[4];
											}
										
										  break;
								case "XXL":QTYtemp[5]+=QTYarr[j];
											if(QTYtemp[5]>0){
												Sum+=QTYtemp[5];
											}
										  break;
				
							}	
							

							
							
					
					
					}	
					
				}
				
				
				double total=0;
				total+=QTYtemp[0]*XS;
				total+=QTYtemp[1]*S;
				total+=QTYtemp[2]*M;
				total+=QTYtemp[3]*L;
				total+=QTYtemp[4]*XL;
				total+=QTYtemp[5]*XXL;
				
				totalA=extendArrayDouble(totalA);
				totalA[totalA.length-1]=total;
				
				Sum1=extendArrayInteger(Sum1);
				Sum1[Sum1.length-1]=Sum;
				
		
		
		}
		
			//	System.out.println(Arrays.toString(Sum1));
			//	System.out.println(Arrays.toString(totalA));
			//	System.out.println(Arrays.toString(CustomerID));
				
		
		
		for(int k=0;k<CustomerID.length;k++){
					
					for(int l=0;l<k;l++){
						if(totalA[k]>totalA[l]){
							
							double t=totalA[k];
							totalA[k]=totalA[l];
							totalA[l]=t;
							
							int t1=Sum1[k];
							Sum1[k]=Sum1[l];
							Sum1[l]=t1;
							
							String t2=CustomerID[k];
							CustomerID[k]=CustomerID[l];
							CustomerID[l]=t2;
							
						}
						
						
					}	
					
					
				}
				
				//System.out.println(Arrays.toString(Sum1));
				//System.out.println(Arrays.toString(totalA));
				//System.out.println(Arrays.toString(CustomerID));
				
		for(int i=0;i<CustomerID.length;i++){
			
			System.out.printf("\t\t|%17s|%9s|%17s|%n","   "+CustomerID[i]+"   ","    "+Sum1[i]+"   ","   "+df.format(totalA[i])+"  ");
			System.out.printf("\t\t|%17s|%9s|%17s|%n","","","");
			
		}		
				
		
		System.out.println("\t\t+-----------------+---------+-----------------+");
		System.out.println();
		System.out.print("\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
		
	
	}
	public static void ViewCustomers(){
		System.out.println("\r\n\t __      ___                  _____          _                                \r\n\t \\ \\    / (_)                / ____|        | |                               \r\n\t  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n\t    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n\t     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
		System.out.println(" \t\b\b_______________________________________________________________________________________");
		System.out.println("\n");	
		System.out.println("\t\t+-----------------+---------+-----------------+");
		System.out.printf("\t\t|%17s|%9s|%17s|%n","   Customer ID   "," All QTY ","   Total Amount  ");
		System.out.println("\t\t+-----------------+---------+-----------------+");	
		
		String[] CustomerID = new String[0];
		
		if (PhoneNumber.length>0){
			L1:for (int i = 0; i < PhoneNumber.length; i++){
				
				for (int j = 0; j < CustomerID.length; j++){
					if (PhoneNumber[i].equals(CustomerID[j])){
						
						continue L1;
					}
				}
				
				CustomerID=extendArray(CustomerID);
				CustomerID[CustomerID.length-1]=PhoneNumber[i];
			}	
		}		

		for(int i=0;i<CustomerID.length;i++){
			int[] QTYtemp=new int[6];
			int Sum=0;
			for(int j=0;j<PhoneNumber.length;j++){
				
				if(CustomerID[i].equals(PhoneNumber[j])){
					
					switch(SizeArr[j]){
						case "XS":QTYtemp[0]+=QTYarr[j];
									if(QTYtemp[0]>0){
										Sum+=QTYtemp[0];
									}
								 // System.out.println(Sum);
								  break;
						case "S":QTYtemp[1]+=QTYarr[j];
									if(QTYtemp[1]>0){
										Sum+=QTYtemp[1];
									}
								//  System.out.println(Sum);
								  break;
						case "M":QTYtemp[2]+=QTYarr[j];
									if(QTYtemp[2]>0){
										Sum+=QTYtemp[2];
									}
								 // System.out.println(Sum);
								  break;
						case "L":QTYtemp[3]+=QTYarr[j];
									if(QTYtemp[3]>0){
										Sum+=QTYtemp[3];
									}
								  //System.out.println(Sum);
								  break;
						case "XL":QTYtemp[4]+=QTYarr[j];
									if(QTYtemp[4]>0){
										Sum+=QTYtemp[4];
									}
								 // System.out.println(Sum);
								  break;
						case "XXL":QTYtemp[5]+=QTYarr[j];
									if(QTYtemp[5]>0){
										Sum+=QTYtemp[5];
									}
								 // System.out.println(Sum);
								  break;
		
					}	
					

					
					
				
				}	
				
				
			
			}	
			
			
			
			
				double total=0;
				total+=QTYtemp[0]*XS;
				total+=QTYtemp[1]*S;
				total+=QTYtemp[2]*M;
				total+=QTYtemp[3]*L;
				total+=QTYtemp[4]*XL;
				total+=QTYtemp[5]*XXL;
				
				
				
			
				
				
				
				System.out.printf("\t\t|%17s|%9s|%17s|%n","   "+CustomerID[i]+"   ","    "+Sum+"   ","   "+df.format(total)+"  ");
				System.out.printf("\t\t|%17s|%9s|%17s|%n","","","");
		}
		
		
		System.out.println("\t\t+-----------------+---------+-----------------+");	
		
		System.out.println();
		System.out.print("\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
			if(enterZero==0){
				MainMenu();	
			}
	
	}
	public static void AllCustomerReport(){
		System.out.println("\r\n\t           _ _    _____          _                              _____                       _       \r\n\t     /\\   | | |  / ____|        | |                            |  __ \\                     | |      \r\n\t    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n\t   / /\\ \\ | | | | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n\t  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n\t /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n\t                                                                          | |                       \r\n\t                                                                          |_|");
		System.out.println(" \t\b\b_________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%-15s|%n"," Phone Number","  XS","   S","   M","   L","  XL","  XXL"," Total Amount");
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		
		String[] PNnew= new String[0];
		
		if (PhoneNumber.length>0){
			L1:for (int i = 0; i < PhoneNumber.length; i++){
				
				for (int j = 0; j < PNnew.length; j++){
					if (PhoneNumber[i].equals(PNnew[j])){
					
						continue L1;
					}
				}
				
				
				PNnew = extendArray(PNnew); 
				PNnew[PNnew.length-1] = PhoneNumber[i];
			}
			
		}
		
		//System.out.println(Arrays.toString(PNnew));
		
		for (int i = 0; i < PNnew.length; i++){
				int[] tempQTY = new int[6];
				
				for (int j = 0; j < PhoneNumber.length; j++){
					if (PNnew[i].equals(PhoneNumber[j])){
							switch (SizeArr[j]){
								
								 case "XS": tempQTY[0] += QTYarr[j];break; 
								 case "S": tempQTY[1] += QTYarr[j];break;
								 case "M": tempQTY[2] += QTYarr[j];break;
								 case "L": tempQTY[3] += QTYarr[j];break;
								 case "XL": tempQTY[4] += QTYarr[j];break;
								 case "XXL": tempQTY[5] += QTYarr[j];break; 
							}
						 
					}
				}
				
			//System.out.println(Arrays.toString(tempQTY));	
			 
			 double total = 0;
			 
			 total += tempQTY[0] * XS;
			 total += tempQTY[1] * S;
			 total += tempQTY[2] * M;
			 total += tempQTY[3] * L;
			 total += tempQTY[4] * XL;
			 total += tempQTY[5] * XXL;
			 
			 
			 System.out.printf("\t\t|%15s|%7s|%7s|%7s|%7s|%7s|%7s|%15s|%n","","","","","","","","");
			 System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%13s  |%n"," "+PNnew[i]+"    ","  "+tempQTY[0],"  "+tempQTY[1],"  "+tempQTY[2],"  "+tempQTY[3],"  "+tempQTY[4],"  "+tempQTY[5],df.format(total));
			 
		}
		
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		
		
		
		System.out.print("\n\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
	
	}
	
	
	
	public static void ItemReports(){
		System.out.println("\r\n\t  _____ _                   _____                       _       \r\n\t |_   _| |                 |  __ \\                     | |      \r\n\t   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ \r\n\t   | | | __/ _ \\ \'_ ` _ \\  |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n\t  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n\t |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n\t                                      | |                       \r\n\t                                      |_|");
		System.out.println(" \t\b\b__________________________________________________________________________");


		System.out.printf("\t\t\t\b%-23s","[1] Best Selling Categories Sorted by QTY");
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[2] Best Selling Categories Sorted by Amount");
		System.out.println("\n");

		System.out.print("\tEnter oprion :");
		int option=input.nextInt();
		clearConsole();
		
			switch(option){
				case 1: SortedByQTY();break;
				case 2: SortedByAmount();break;	
				default:
				
			}
		
	
	}
	public static void SortedByQTY(){
		System.out.println("\r\n\t   _____            _           _   ____           ____ _________     __\r\n\t  / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /\r\n\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / \r\n\t  \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  \r\n\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   \r\n\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   \r\n\t                                           __/ |                        \r\n\t                                          |___/");
		System.out.println(" \t\b\b______________________________________________________________________________");
		System.out.println();
		
			int[] QTYtemp=new int[6];
			double TOT[]=new double[6];
			String Sz[]=new String[6];
			
			for(int i=0;i<SizeArr.length;i++){
					
				int tot1=0;
				switch(SizeArr[i]){
					
					case "XS":QTYtemp[0]+=QTYarr[i];break; //3,0,0,0,0,0,0,0
					case "S": QTYtemp[1]+=QTYarr[i];break; //0,0,0,0,0,2,0,0
					case "M": QTYtemp[2]+=QTYarr[i];break; //0,0,0,3,6,0,0,3
					case "L": QTYtemp[3]+=QTYarr[i];break; //0,0,0,0,0,0,0,0
					case "XL": QTYtemp[4]+=QTYarr[i];break;//0,4,0,0,0,0,0,0
					case "XXL":QTYtemp[5]+=QTYarr[i];break;//0,0,1,0,0,0,1,0
					
					
				}
	
		
			}
			
			for(int i=0;i<SizeArr.length;i++){
			
				switch(SizeArr[i]){
						
						case "XS":Sz[0]="XS";break; 
						case "S":Sz[1]="S";break; 
						case "M":Sz[2]="M";break;
						case "L":Sz[3]="L";break; 
						case "XL":Sz[4]="XL";break;
						case "XXL":Sz[5]="XXL";break;
			
				}

			}
			
			//System.out.println(Arrays.toString(Sz));
			
			if(Sz[0]==null){Sz[0]="XS";}
			else if(Sz[1]==null){Sz[1]="S";}
			else if(Sz[2]==null){Sz[2]="M";}
			else if(Sz[3]==null){Sz[3]="L";}
			else if(Sz[4]==null){Sz[4]="XL";}
			else{Sz[5]="XXL";}
			
			
			
			//System.out.println(Arrays.toString(Sz));	
				
			
			for(int i=0;i<SizeArr.length;i++){
			
				switch(SizeArr[i]){
						
						case "XS":TOT[0]=(QTYtemp[0]*XS);break; 
						case "S":TOT[1]=(QTYtemp[1]*S);break; 
						case "M":TOT[2]=(QTYtemp[2]*M);break;
						case "L":TOT[3]=(QTYtemp[3]*L);break; 
						case "XL":TOT[4]=(QTYtemp[4]*XL);break;
						case "XXL":TOT[5]=(QTYtemp[5]*XXL);break;
			
				}
			
			}
			
			
			
			
			for(int i=1;i<QTYtemp.length;i++){
				for(int j=0;j<i;j++){
					if(QTYtemp[i]>QTYtemp[j]){
						
						int t1=	QTYtemp[i];
						QTYtemp[i]=QTYtemp[j];
						QTYtemp[j]=t1;
						
						double t2=	TOT[i];
						TOT[i]=TOT[j];
						TOT[j]=t2;
						
						String t3=	Sz[i];
						Sz[i]=Sz[j];
						Sz[j]=t3;
						
					}
					
					
				}	
				
				
				
			}
			
			
			//System.out.println(Arrays.toString(QTYtemp));
			//System.out.println(Arrays.toString(TOT));
			//System.out.println(Arrays.toString(Sz));
			
		System.out.println();				
		System.out.println("\t\t+----------+----------+---------------+");
		System.out.printf("\t\t|%-10s|%-10s|%-15s|%n","   Size","   QTY","     Amount ");
		System.out.println("\t\t+----------+----------+---------------+");
		
		
		for(int i=0;i<6;i++){
			
			System.out.printf("\t\t|%-10s|%-10s|%-15s|%n","   ","   ","      ");
			System.out.printf("\t\t|%-10s|%10s|%15s|%n","   "+Sz[i],"    "+QTYtemp[i]+"    ","    "+df.format(TOT[i])+"  ");
			
		}	
		
		System.out.println("\t\t+----------+----------+---------------+");	
		
		System.out.println();
		System.out.print("\n\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
			
	}
	public static void SortedByAmount(){
		System.out.println("\r\n\t   _____            _           _   ____                                               _   \r\n\t  / ____|          | |         | | |  _ \\            /\\                               | |  \r\n\t | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n\t  \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n\t  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n\t |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n\t                                           __/ |                                           \r\n\t                                          |___/");
		System.out.println(" \t\b\b___________________________________________________________________________________________");
		System.out.println();
		
			int[] QTYtemp=new int[6];
			double TOT[]=new double[6];
			String Sz[]=new String[6];
			
			for(int i=0;i<SizeArr.length;i++){
					
				int tot1=0;
				switch(SizeArr[i]){
					
					case "XS":QTYtemp[0]+=QTYarr[i];break; //3,0,0,0,0,0,0,0
					case "S": QTYtemp[1]+=QTYarr[i];break; //0,0,0,0,0,2,0,0
					case "M": QTYtemp[2]+=QTYarr[i];break; //0,0,0,3,6,0,0,3
					case "L": QTYtemp[3]+=QTYarr[i];break; //0,0,0,0,0,0,0,0
					case "XL": QTYtemp[4]+=QTYarr[i];break;//0,4,0,0,0,0,0,0
					case "XXL":QTYtemp[5]+=QTYarr[i];break;//0,0,1,0,0,0,1,0
					
					
				}
	
		
			}
			
			for(int i=0;i<SizeArr.length;i++){
			
				switch(SizeArr[i]){
						
						case "XS":Sz[0]="XS";break; 
						case "S":Sz[1]="S";break; 
						case "M":Sz[2]="M";break;
						case "L":Sz[3]="L";break; 
						case "XL":Sz[4]="XL";break;
						case "XXL":Sz[5]="XXL";break;
			
				}

			}
			
			//System.out.println(Arrays.toString(Sz));
			
			if(Sz[0]==null){Sz[0]="XS";}
			else if(Sz[1]==null){Sz[1]="S";}
			else if(Sz[2]==null){Sz[2]="M";}
			else if(Sz[3]==null){Sz[3]="L";}
			else if(Sz[4]==null){Sz[4]="XL";}
			else{Sz[5]="XXL";}
			
			
			
			//System.out.println(Arrays.toString(Sz));	
				
			
			for(int i=0;i<SizeArr.length;i++){
			
				switch(SizeArr[i]){
						
						case "XS":TOT[0]=(QTYtemp[0]*XS);break; 
						case "S":TOT[1]=(QTYtemp[1]*S);break; 
						case "M":TOT[2]=(QTYtemp[2]*M);break;
						case "L":TOT[3]=(QTYtemp[3]*L);break; 
						case "XL":TOT[4]=(QTYtemp[4]*XL);break;
						case "XXL":TOT[5]=(QTYtemp[5]*XXL);break;
			
				}
			
			}
			
			
			
			
			for(int i=1;i<QTYtemp.length;i++){
				for(int j=0;j<i;j++){
					if(TOT[i]>TOT[j]){
						
						double t2=	TOT[i];
						TOT[i]=TOT[j];
						TOT[j]=t2;
						
						int t1=	QTYtemp[i];
						QTYtemp[i]=QTYtemp[j];
						QTYtemp[j]=t1;
						
						
						
						String t3=	Sz[i];
						Sz[i]=Sz[j];
						Sz[j]=t3;
						
					}
					
					
				}	
				
				
				
			}
			
			
			//System.out.println(Arrays.toString(QTYtemp));
			//System.out.println(Arrays.toString(TOT));
			//System.out.println(Arrays.toString(Sz));
			
		System.out.println();				
		System.out.println("\t\t+----------+----------+---------------+");
		System.out.printf("\t\t|%-10s|%-10s|%-15s|%n","   Size","   QTY","     Amount ");
		System.out.println("\t\t+----------+----------+---------------+");
		
		
		for(int i=0;i<6;i++){
			
			System.out.printf("\t\t|%-10s|%-10s|%-15s|%n","   ","   ","      ");
			System.out.printf("\t\t|%-10s|%10s|%15s|%n","   "+Sz[i],"    "+QTYtemp[i]+"    ","    "+df.format(TOT[i])+"  ");
			
		}	
		
		System.out.println("\t\t+----------+----------+---------------+");	
		
		System.out.println();
		System.out.print("\n\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
		
		
	}
	
	
	
	public static void OrdersReports(){
		
		System.out.println("\r\n\t   ____          _             _____                       _       \r\n\t  / __ \\        | |           |  __ \\                     | |      \r\n\t | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n\t | |  | | \'__/ _` |/ _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n\t | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n\t  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n\t                                         | |                       \r\n\t                                         |_|");
		System.out.println(" \t\b\b__________________________________________________________________________");
		
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[1] All orders");
		System.out.println("\n");
		System.out.printf("\t\t\t\b%-23s","[2] Orders By Amount");
		System.out.println();

		System.out.print("\tEnter oprion :");
		int option=input.nextInt();
		clearConsole();
		
			switch(option){
				case 1: AllOrders();break;
				case 2: OrdersByAmount();break;	
				default:
				
			}
		
	}
	public static void AllOrders(){
		System.out.println("\r\n\t __      ___                  ____          _               \r\n\t \\ \\    / (_)                / __ \\        | |              \r\n\t  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ \r\n\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | \'__/ _` |/ _ \\ \'__/ __|\r\n\t    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\\r\n\t     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
		System.out.println(" \t\b\b__________________________________________________________________________");
		System.out.println();
		
		System.out.println("\t+----------+----------------+--------+----------+---------------+-----------------+");
		System.out.printf("\t|%-10s|%-16s|%-8s|%-10s|%-15s|%-17s|%n"," Order ID ","  Customer ID  ","  Size  ","   QTY    ","    Amount     ","     Status    ");
		System.out.println("\t+----------+----------------+--------+----------+---------------+-----------------+");
		
		int[] tot1temp=new int[SizeArr.length];
		double[] Amounttemp=new double[Amount.length];
		
		int tot1=0;
		double Amou=0;
		
		
		for(int i=0;i<SizeArr.length;i++){
					
				
				switch(SizeArr[i]){
					
					case "XS":tot1=QTYarr[i];break;
					case "S": tot1=QTYarr[i];break; 
					case "M": tot1=QTYarr[i];break; 
					case "L": tot1=QTYarr[i];break;
					case "XL": tot1=QTYarr[i];break;
					case "XXL":tot1=QTYarr[i];break;
					
					
				}
				
				switch(SizeArr[i]){
					
					case "XS":Amou=QTYarr[i]*XS;break;
					case "S": Amou=QTYarr[i]*S;break; 
					case "M": Amou=QTYarr[i]*M;break; 
					case "L": Amou=QTYarr[i]*L;break;
					case "XL": Amou=QTYarr[i]*XL;break;
					case "XXL":Amou=QTYarr[i]*XXL;break;
					
					
				}
	
				//System.out.println(tot1);
				tot1temp[i]=tot1;
				
				//System.out.println(Amou);
				Amounttemp[i]=Amou;
			}
		
			//System.out.println(Arrays.toString(tot1temp));
			//System.out.println(Arrays.toString(Amounttemp));
			
			String[] OIDtemp=new String[OrderId.length];
			String[] Sizetemp=new String[SizeArr.length];
			double[] Amounttempnew=new double[Amount.length];
			String[] StatusTemp=new String[OrderId.length];
			String[] CIDtemp=new String[PhoneNumber.length];
			int[] tot1temp2=new int[QTYarr.length];
			
			for(int i=OrderId.length-1;i>=0;i--){
				
					OIDtemp[OrderId.length-1-i]=OrderId[i];
					Sizetemp[OrderId.length-1-i]=SizeArr[i];
					Amounttempnew[OrderId.length-1-i]=Amounttemp[i];
					StatusTemp[OrderId.length-1-i]=status[i];
					CIDtemp[OrderId.length-1-i]=PhoneNumber[i];
					tot1temp2[OrderId.length-1-i]=tot1temp[i];
		
				
			}
			
			//System.out.println(Arrays.toString(OIDtemp));
		for(int i=0;i<OrderId.length;i++){	
			
			System.out.printf("\t|%-10s|%-16s|%-8s|%-10s|%-15s|%-17s|%n"," "+OIDtemp[i]+""," "+CIDtemp[i]+"   ","  "+Sizetemp[i]+"   ","    "+tot1temp2[i]+"    ","      "+df.format(Amounttempnew[i])+"  ","  "+StatusTemp[i]+"    ");
		}
		
		System.out.println("\t+----------+----------------+--------+----------+---------------+-----------------+");
		
		System.out.print("\n\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
	}
	public static void OrdersByAmount(){
		System.out.println("\r\n\t   ____          _                 ____                                               _   \r\n\t  / __ \\        | |               |  _ \\            /\\                               | |  \r\n\t | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n\t | |  | | \'__/ _` |/ _ \\ \'__/ __| |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n\t | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n\t  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n\t                                          __/ |                                           \r\n\t                                         |___/");
		System.out.println(" \t\b\b____________________________________________________________________________________________");
		System.out.println();
		
		System.out.println("\t\t+----------+----------------+--------+----------+---------------+-----------------+");
		System.out.printf("\t\t|%-10s|%-16s|%-8s|%-10s|%-15s|%-17s|%n"," Order ID ","  Customer ID  ","  Size  ","   QTY    ","    Amount     ","     Status    ");
		System.out.println("\t\t+----------+----------------+--------+----------+---------------+-----------------+");
		
		int[] tot1temp=new int[SizeArr.length];
		double[] Amounttemp=new double[Amount.length];
		
		int tot1=0;
		double Amou=0;
		
		
		for(int i=0;i<SizeArr.length;i++){
					
				
				switch(SizeArr[i]){
					
					case "XS":tot1=QTYarr[i];break;
					case "S": tot1=QTYarr[i];break; 
					case "M": tot1=QTYarr[i];break; 
					case "L": tot1=QTYarr[i];break;
					case "XL": tot1=QTYarr[i];break;
					case "XXL":tot1=QTYarr[i];break;
					
					
				}
				
				switch(SizeArr[i]){
					
					case "XS":Amou=QTYarr[i]*XS;break;
					case "S": Amou=QTYarr[i]*S;break; 
					case "M": Amou=QTYarr[i]*M;break; 
					case "L": Amou=QTYarr[i]*L;break;
					case "XL": Amou=QTYarr[i]*XL;break;
					case "XXL":Amou=QTYarr[i]*XXL;break;
					
					
				}
	
				//System.out.println(tot1);
				tot1temp[i]=tot1;
				
				//System.out.println(Amou);
				Amounttemp[i]=Amou;
			}
		
			
						
			
			for(int i=0;i<OrderId.length;i++){
				for(int j=0;j<i;j++){
					if(Amounttemp[i]>Amounttemp[j]){
						
						double t1=Amounttemp[i];
						Amounttemp[i]=Amounttemp[j];
						Amounttemp[j]=t1;
							
						int t2=tot1temp[i];
						tot1temp[i]=tot1temp[j];
						tot1temp[j]=t2;
						
						String t3=OrderId[i];
						OrderId[i]=OrderId[j];
						OrderId[j]=t3;
						
						String t4=PhoneNumber[i];
						PhoneNumber[i]=PhoneNumber[j];
						PhoneNumber[j]=t4;
						
						String t5=SizeArr[i];
						SizeArr[i]=SizeArr[j];
						SizeArr[j]=t5;
						
						String t6=status[i];
						status[i]=status[j];
						status[j]=t6;
						
	
						
					}
					
					
					
				}
					
				
				
			}
			
			//System.out.println(Arrays.toString(OIDtemp));
		for(int i=0;i<OrderId.length;i++){	
			
			System.out.printf("\t\t|%-10s|%-16s|%-8s|%-10s|%-15s|%-17s|%n"," "+OrderId[i]+""," "+PhoneNumber[i]+"   ","  "+SizeArr[i]+"   ","    "+tot1temp[i]+"    ","      "+df.format(Amounttemp[i])+"  ","  "+status[i]+"    ");
		}
		
		
		
		
		
		System.out.println("\t\t+----------+----------------+--------+----------+---------------+-----------------+");
		
		
		System.out.print("\n\tTo access the Main Menu, please enter 0: ");
		int enterZero=input.nextInt();
		clearConsole();
		
		if(enterZero==0){
			MainMenu();	
		}
		
	}
	
	
	public static void ChangeOrderStatus(){
		OrderStatus();
			
		
				
		
	}
	public static void OrderStatus(){
			
		System.out.println("\r\n\t   ____          _              _____ _        _             \r\n\t  / __ \\        | |            / ____| |      | |            \r\n\t | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ \r\n\t | |  | | \'__/ _` |/ _ \\ \'__|  \\___ \\| __/ _` | __| | | / __|\r\n\t | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\\r\n\t  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
		System.out.println(" \t\b\b____________________________________________________________________");
		System.out.println();
		
		System.out.print("\tEnter Order ID : ");
		String ID=input.next();
		System.out.println();
		
		
			for(int i=0;i<OrderId.length;i++){
				
				if(ID.equals(OrderId[i])){
					
							System.out.println("\tPhone Number : "+PhoneNumber[i]);
							System.out.println("\tSize         : "+SizeArr[i]);	
							System.out.println("\tQTY          : "+QTYarr[i]);	
							System.out.println("\tAmount       : "+Amount[i]);
							System.out.println("\tStatus       : "+status[i]);
							
							//System.out.println(Status);
							//System.out.println(Arrays.toString(StatusReading1));
							//System.out.println(Arrays.toString(StatusReading2));
							
						if(OrderId.length>8){
								if(StatusReading1.length>StatusReading2.length){
									
									System.out.println("\tStatus       : "+"PROCESSING");
									status[i]="PROCESSING";
									status=extendArray(status);
									status[status.length-1]=status[i];
								}
								
								if(StatusReading1.length==StatusReading2.length){
									
									System.out.println("\tStatus       : "+"DELIVERING");
									
									status[i]="DELIVERING";
									status=extendArray(status);
									status[status.length-1]=status[i];
									
								}   
								
						
						}
								
								
								//clearConsole();
								
									if(status[i].equals("processing")){
													
													System.out.print("\n\tDo you want to Change this order Status? (y/n):");
													String Ans3=input.next().toLowerCase();
										
													
													if(Ans3.equals("y")){
										
														System.out.printf("\t\t\t\b%-23s","[1] Order Delivering");
														System.out.println();
														System.out.printf("\t\t\t\b%-23s","[2] Order Delivered");
														System.out.println();	
										
														System.out.print("\tEnter option :");
														int option=input.nextInt();
														//clearConsole();	
														switch(option){
															
																case 1:	System.out.println("\n\t\tStatus Updated..!"); 
															
																		status[i]="DELEVERING";
														
																		System.out.print("\tDo you want to Change another order Status? (y/n):");
																		String Ans6=input.next().toLowerCase();
																		clearConsole();
																							
																		if(Ans6.equals("y")){
																			OrderStatus();
																		}
																		
																		else if(Ans6.equals("n")){
																			MainMenu();
																		}
																		
																		;break;
																		
																case 2:	System.out.println("\n\t\tStatus Updated..!"); 
															
																		status[i]="DELEVERDED";
														
																		System.out.print("\tDo you want to Change another order Status? (y/n):");
																		String Ans7=input.next().toLowerCase();
																		clearConsole();
																							
																		if(Ans7.equals("y")){
																			OrderStatus();
																		}
																		
																		else if(Ans7.equals("n")){
																			MainMenu();
																		}
																		
																		;break;	
																		
																	
														}			
												  	
														 
													}		
															
															
									}						
															
												    
										if(status[i].equals("delivering")){	
														
														System.out.print("\tDo you want to Change this order Status? (y/n):");
														String Ans5=input.next().toLowerCase();
															
															if(Ans5.equals("y")){
																
																System.out.printf("\t\t\t\b%-23s","[1] Order Delivered");
																System.out.println();
																
																										
																	
																System.out.print("\tEnter option :");
																int option2=input.nextInt();
																	
																	if(option2==1){
																		
																		System.out.println("\n\t\tStatus Updated..!"); 
																		
																		status[i]="DELIVERDED";	
																		
																		System.out.print("\tDo you want to Change another order Status? (y/n):");
																		String Ans3=input.next().toLowerCase();
																		clearConsole();
																							
																				if(Ans3.equals("y")){
																					OrderStatus();
																				}
																				
																				else if(Ans3.equals("n")){    
																					MainMenu();
																				}
																			
																	}
																		
																	if(option2!=1){
																			
																		System.out.println("Invalid Input..!");	
																			
																			
																	}	
																			
																			
															}
															
																			
															else if(Ans5.equals("n")){
										
																System.out.print("\tDo you want to Change this order Status? (y/n):");
																String Ans4=input.next().toLowerCase();
																clearConsole();
																
																	if(Ans4.equals("y")){
																		
																		ChangeOrderStatus();
																	}
																	
																	else if(Ans4.equals("n")){
																		 
																		MainMenu();
																	}
										
										
											
																			
																			
																			
																			
																	
															}
															
										}
															
										if(status[i].equals("delivered")){	
															
									    	System.out.println("\n\t\tCan't Change, Already Deliverded!");	
									    	
									    	System.out.print("\n\tDo you want to Change another order Status? (y/n):");
														String Ans7=input.next().toLowerCase();
														clearConsole();
																					
															if(Ans7.equals("y")){
																OrderStatus();
															}
																
															else if(Ans7.equals("n")){
																MainMenu();
															}	
									    	
									    	
									    	
									    	
										}			
												
								}			
										
										
									
									
								
					
					  			
							
					
				}
				
			for(int i=0;i<OrderId.length;i++){
								
				if(!(OrderId[i].equals(ID))){
							
					System.out.println();			
					System.out.println("\t\tINnvalid ID..\n");	
					System.out.print("\tDo you want to Change another order Status? (y/n):");
					String Ans3=input.next().toLowerCase();
					clearConsole();
															
							if(Ans3.equals("y")){
									OrderStatus();
							}
										
							else if(Ans3.equals("n")){    
								MainMenu();
							}
								
				}
									
					

			}   
				
					
	}	
		
				
	
	public static void DeleteOrder(){
		System.out.println("\r\n\t  _____       _      _          ____          _           \r\n\t |  __ \\     | |    | |        / __ \\        | |          \r\n\t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ \r\n\t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n\t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   \r\n\t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|");
		System.out.println(" \t\b\b____________________________________________________________________");
		System.out.println();	
		
		System.out.print("\tEnter Order ID : ");
		String ID=input.next();
		
		
		
			for(int i=0;i<OrderId.length;i++){
				
				if(ID.equals(OrderId[i])){
					
							System.out.println("\tPhone Number : "+PhoneNumber[i]);
							System.out.println("\tSize         : "+SizeArr[i]);	
							System.out.println("\tQTY          : "+QTYarr[i]);	
							System.out.println("\tAmount       : "+Amount[i]);
							System.out.println("\tStatus       : "+status[i]);
							
								
							System.out.print("\tDo you want to delete this order? (y/n):");
							String Ans3=input.next().toLowerCase();
							//clearConsole();
										
							if(Ans3.equals("y")){
										
								OrderId=DelelteArrayElement(OrderId,ID);		
								System.out.println("\n\t\tOrder Deleted..!");
								
								
										
								System.out.print("\n\tDo you want to delete another order? (y/n):");
								String Ans4=input.next().toLowerCase();
								clearConsole();
										
											if(Ans4.equals("y")){
												
												DeleteOrder();
											}
											
											else if(Ans4.equals("n")){
												
												MainMenu();
												
											}
										
									}
					
									else if(Ans3.equals("n")){
										MainMenu();
									}
							
					
				}	
			}	
			
			
			for(int i=0;i<OrderId.length;i++){
					
				if(!(OrderId[i].equals(ID))){
					
							System.out.println("\t\tINnvalid ID..\n");	
							System.out.print("\tDo you want to delete another order? (y/n):");
							String Ans3=input.next().toLowerCase();
							clearConsole();
												
							if(Ans3.equals("y")){
								DeleteOrder();
							}
							
							else if(Ans3.equals("n")){
								MainMenu();
							}
					
				}
			
		    }	
				
	}
	
	
	public static void ViewReports(){
		System.out.println("\r\n\t  _____                       _       \r\n\t |  __ \\                     | |      \r\n\t | |__) |___ _ __   ___  _ __| |_ ___ \r\n\t |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n\t | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n\t |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n\t            | |                       \r\n\t            |_|");
		System.out.println(" \t\b\b_________________________________________");
		System.out.println();
		
		System.out.printf("\t\t\b%-23s","[1] Customer Reports");
		System.out.println();
		System.out.printf("\t\t\b%-23s","[2] Item Reports");
		System.out.println();
		System.out.printf("\t\t\b%-23s","[3] Orders Reports");
		System.out.println();
		
		System.out.print("\n\tEnter option :");
		int option=input.nextInt();
		clearConsole();
		
				switch(option){
					
					case 1:CustomerReports();break;
					case 2:ItemReports();break;
					case 3:OrdersReports();break;
					default:
				}
		
		
	}
	public static void SearchOrder(){
			
		System.out.println("\r\n\t   _____                     _        ____          _           \r\n\t  / ____|                   | |      / __ \\        | |          \r\n\t | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ \r\n\t  \\___ \\ / _ \\/ _` | \'__/ __| \'_ \\  | |  | | \'__/ _` |/ _ \\ \'__|\r\n\t  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   \r\n\t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_| ");
		System.out.println(" \t\b\b____________________________________________________________________");
		System.out.println();
		
		System.out.print("\tEnter Order ID : ");
		String ID=input.next();
		
			for(int i=0;i<OrderId.length;i++){
				
				if(ID.equals(OrderId[i])){
					
							System.out.println("\tPhone Number : "+PhoneNumber[i]);
							System.out.println("\tSize         : "+SizeArr[i]);	
							System.out.println("\tQTY          : "+QTYarr[i]);	
							System.out.println("\tAmount       : "+Amount[i]);
							System.out.println("\tStatus       : "+status[i]);
							
							
						if(OrderId.length>8){
							
								if(StatusReading1.length>StatusReading2.length){
									
									System.out.println("\tStatus       : "+"PROCESSING");
								}
								
								//if(StatusReading1.length==StatusReading2.length){
									
								//	System.out.println("\tStatus       : "+"DELIVERING");
								//}   
								
								
							
						}
								
								System.out.print("\tDo you want to Search another order? (y/n):");
								String Ans3=input.next().toLowerCase();
								clearConsole();
										
									if(Ans3.equals("y")){
										SearchOrder();
									}
					
									else if(Ans3.equals("n")){
										MainMenu();
									}
							
					
				}	
			}	
				
			for(int i=0;i<OrderId.length;i++){
					
				if(!(OrderId[i].equals(ID))){
					
							System.out.println("\t\tINnvalid ID..\n");	
							System.out.print("\tDo you want to Search another order? (y/n):");
							String Ans3=input.next().toLowerCase();
							clearConsole();
												
							if(Ans3.equals("y")){
								SearchOrder();
							}
							
							else if(Ans3.equals("n")){
								MainMenu();
							}
					
				}
						
			}
			
					
					

	}
	public static void SearchCustomer(){
		
		
	
			String str = "\r\n\t" +
				   "   _____            " +
				   "         _        __" +
				   "___          _      " +
				   "                    " +
				   "  \r\n\t" +
				   "  / ____|           " +
				   "        | |      / _" +
				   "___|        | |     " +
				   "                    " +
				   "  \r\n\t" +
				   " | (___   ___  __ _ " +
				   "_ __ ___| |__   | | " +
				   "   _   _ ___| |_ ___" +
				   "  _ __ ___   ___ _ _" +
				   "_ \r\n\t" +
				   "  \\___ \\ / _ \\/ _" +
				   "` | \'__/ __| \'_ \\" +
				   "  | |   | | | / __| " +
				   "__/ _ \\| \'_ ` _ \\" +
				   " / _ \\ \'__|\r\n\t" +
				   "  ____) |  __/ (_| |" +
				   " | | (__| | | | | |_" +
				   "__| |_| \\__ \\ || (" +
				   "_) | | | | | |  __/ " +
				   "|   \r\n\t" +
				   " |_____/ \\___|\\__," +
				   "_|_|  \\___|_| |_|  " +
				   "\\_____\\__,_|___/\\" +
				   "__\\___/|_| |_| |_|" +
				   "\\___|_|   \r" +
				   " ";
		System.out.println(str);
		System.out.println(" \t______________________________________________________________________________");
		System.out.println();
		
		
		
			
	L1:do{			
			System.out.print("\n\tEnter Customer Phone Number : ");
			String PN=input.next();
			
					if(isValid4nNumber(PN)==true&&PhoneNumberSearch(PN,PhoneNumber)==true){
								
							double[] doubleAmount=new double[6];
							int [] QTY=new int[6];
							int tot3=0;
							
							for(int i =0;i<OrderId.length;i++){
									
								if(PN.equals(PhoneNumber[i])){	
									
									switch(SizeArr[i]){
										
										case "XS":doubleAmount[0]=QTYarr[i]*XS;
												  tot3+=doubleAmount[0];
												  QTY[0]+=QTYarr[i];
												  break;
												  
										case "S":doubleAmount[1]=QTYarr[i]*S;
											     tot3+=doubleAmount[1];
											     QTY[1]+=QTYarr[i];
												 break;
												
										case "M":doubleAmount[2]=QTYarr[i]*M;
												 tot3+=doubleAmount[2];
												 QTY[2]+=QTYarr[i];
												 break;
												 
										case "L":doubleAmount[3]=QTYarr[i]*L;
												 tot3+=doubleAmount[3];
												 QTY[3]+=QTYarr[i];
												 break;
										
										case "XL":doubleAmount[4]=QTYarr[i]*XL;
												  tot3+=doubleAmount[4];
												  QTY[4]+=QTYarr[i];
												  break;
										case "XXL":doubleAmount[5]=QTYarr[i]*XXL;
												   tot3+=doubleAmount[5];
												   QTY[5]+=QTYarr[i];
												   break;
										
										
									}
								}
								
								
							}
							
					
							System.out.println();				
							System.out.println("\t\t+----------+----------+---------------+");
							System.out.printf("\t\t|%-10s|%-10s|%-15s|%n","   Size","   QTY","     Amount ");
							System.out.println("\t\t+----------+----------+---------------+");
						
							
							for(int i=1;i<doubleAmount.length;i++){
								
								for(int j=0;j<i;j++){
									
									
										if(doubleAmount[i]>doubleAmount[j]){
											
											double temp=doubleAmount[i];
											doubleAmount[i]=doubleAmount[j];
											doubleAmount[j]=temp;
											
											int tem=QTY[i];
											QTY[i]=QTY[j];
											QTY[j]=tem;
											
											String t=Sizz[i];
											Sizz[i]=Sizz[j];
											Sizz[j]=t;
											
										}
										
								}	
								
							}	
							
				
							
							for(int i=0;i<doubleAmount.length;i++){
								
								System.out.printf("\t\t|%-10s|%-10s|%15s|%n","  "+Sizz[i],"      "+QTY[i],"   "+df.format(doubleAmount[i])+"  ");				
									
							}			
							
							
							
							
								
							System.out.println("\t\t+----------+----------+---------------+");
							System.out.printf("\t\t|%-21s|%15s|%n","  Total Amount","     "+df.format(tot3)+"  ");
							System.out.println("\t\t+---------------------+---------------+");
							
						
							
							System.out.print("\n\tDo you want to Search another customer report? (y/n):");
							String Ans1=input.next().toLowerCase();
							clearConsole();
							
							
							
							
								if(Ans1.equals("y")){
									
									SearchCustomer();
								}
								else if(Ans1.equals("n")){
									
									MainMenu();
								}
						
					}   
				
					
					
					
					
					
					else{
						
						System.out.println("\n\t\t Invalid Input...!");
						
						System.out.print("\n\tDo you want to Search another customer report? (y/n):");
						String Ans1=input.next().toLowerCase();
						clearConsole();
						
						
							if(Ans1.equals("y")){
								
								SearchCustomer();
							}
							else if(Ans1.equals("n")){
								clearConsole();
								MainMenu();
							}
						
					}
					
		}while(true);
		
		
	}
	
	
	public static void PlaceOrder(){
		
		System.out.println("\r\n\t  _____  _                   ____          _           \r\n\t |  __ \\| |                 / __ \\        | |          \r\n\t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ \r\n\t |  ___/| |/ _` |/ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n\t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   \r\n\t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
		System.out.println("\t\b___________________________________________________________");
		System.out.println();
		
		String id= GeneratedId();
		OrderId =extendArray(OrderId);
		OrderId[OrderId.length-1]=id;
		System.out.println("\tEnter Order ID : "+id);
		
		
		
		L1:do{
		
			Status=PROCESSING;
			StatusReading1= extendArrayInteger(StatusReading1);
			StatusReading1[StatusReading1.length-1]=Status;
			
			
			
			
			
			System.out.print("\tEnter Customer Phone Number : ");
			String Number=input.next();
			
			
						
				if(isValid4nNumber(Number)==true){
					
					PhoneNumber= extendArray(PhoneNumber);
					PhoneNumber[PhoneNumber.length-1]=Number;
					
				}   
			
				else{
					
					System.out.println("\t\t Invalid Phone number.. Try again!");
					
					System.out.print
						("\tDo you want to enter phone number again? (y/n):");
					String Ans1=input.next().toLowerCase();
					System.out.print("\033[3A");
					System.out.print("\033[0J");
					
					
						if(Ans1.equals("y")){
							continue L1;
						}
						else if(Ans1.equals("n")){
							MainMenu();
						}
					
					
				}
				
				
				System.out.print("\tEnter T-Shirt Size(XS/S/M/L/XL/XXL) :");
				String Size=input.next().toUpperCase();
							
				if (!(Size.equals("XS") || Size.equals("S") || Size.equals("M") || Size.equals("L") || Size.equals("XL") || Size.equals("XXL"))){
					
					System.out.println("\t\tEnter Valid Size...");
					System.out.print("\tDo you want to place order again? (y/n):");
					String Ans4=input.next().toLowerCase();
					clearConsole();
					
										
					if(Ans4.equals("y")){
						
						PlaceOrder();
					}
					
					else if(Ans4.equals("n")){
						
						MainMenu();
					}
				}
				
				
				
				SizeArr=extendArray(SizeArr);
				SizeArr[SizeArr.length-1]=Size;
					
				
							
			
			System.out.print("\tEnter QTY :");
			int Q=input.nextInt();
			
			
			if(Q>0){
				
				QTYarr=extendArrayInteger(QTYarr);
				QTYarr[QTYarr.length-1]=Q;
				
				System.out.println("\tAmount :"+Qty(Size,Q));
				
				Amount= extendArray(Amount);
				Amount[Amount.length-1]=Qty(Size,Q);
				
			}
			
			else{
				System.out.println("\tEnter Valid QTY...");
				Answere();
			}
			
					System.out.print("\tDo you want to place this order? (y/n):");
					String Ans2=input.next().toLowerCase();
					
						if(Ans2.equals("y")){
							
							System.out.println("\n\tOrder Placed..!");
							
							Status=DELIVERING;
							
							StatusReading2= extendArrayInteger(StatusReading2);
							StatusReading2[StatusReading2.length-1]=Status;
							
							status= extendArray(status);
							status[status.length-1]="DELIVERING";
								
						
							
							Answere();
							
						}
						else if(Ans2.equals("n")){
							
							Answere();
						}
						
		
		} while (true);
		
	}
	
	
	public static void MyDetails(){
	
		System.out.println("\t\t\t\t\t\t  PRF Final Coursework");
		System.out.println("\t\t\t\t\t\tTharaka Gihan Dhananjaya");
		System.out.println("\t\t\t\t\t\t       iCM_104011\n\n");	
		
	}
	public static void MainMenu(){
		
	do{
		System.out.println("\r\n\t /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          \r\n\t| $$_____/                | $$      |__/                           /$$__  $$| $$                          \r\n\t| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ \r\n\t| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$\r\n\t| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$\r\n\t| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$\r\n\t| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/\r\n\t|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ \r\n\t                                                                                                | $$      \r\n\t                                                                                                | $$      \r\n\t                                                                                                |__/      ");
		System.out.println("\n\n\t\b------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		System.out.printf("\t\t\t\b%-23s","[1] Place Order");
		System.out.printf("\t\t\t\t\t\t%-19s","[2] Search Customer");
		System.out.println();
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[3] Search Order");
		System.out.printf("\t\t\t\t\t\t%-19s","[4] View Reports");
		System.out.println();
		System.out.println();
		System.out.printf("\t\t\t\b%-23s","[5] Change Order Status");
		System.out.printf("\t\t\t\t\t\t%-19s","[6] Delete Order");
	
		
		
		
			
				
				System.out.print("\n\n\n\t\t\t\bInput Option : ");
				int option=input.nextInt();
				clearConsole();
				
				
				switch (option){
					case 1:PlaceOrder();break;
					case 2:SearchCustomer();break;
					case 3:SearchOrder();break;
					case 4:ViewReports();break;
					case 5:ChangeOrderStatus();break;
					case 6:DeleteOrder();break;
					default:
				}
			
			}while(true);	
		
		
		
	}
	public static void main(String[] args){
		
		MyDetails();
		MainMenu();
		
	}
	
}

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import LinkedList.*;
import java.util.*;
import java.lang.*;
import static java.lang.Character.isDigit;
import java.util.HashMap;
/**
 *
 * @author Karthik Sekar, kxs167130, CS 2336 .002
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        HashMap users = new HashMap();//create map
        File userlist = new File("userdb.dat"); //file
        DoubleLinkNode dummy = new DoubleLinkNode(0,0);
        LinkedL free = new LinkedL(dummy);
        LinkedL res = new LinkedL(dummy);
        Scanner usc = new Scanner(userlist);
        String user = "";
        int cchoice = 0;
        while(usc.hasNextLine()) //reading and verifying username and password
        {
            String username = usc.next();
            users.put(username, new String(usc.next()));
        }
        boolean valid = false; 
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while(!valid)
        {
        System.out.println("Enter Username");
        user = in.next();
        for(int i = 0; i <3; i++)
        {
            System.out.println("Password: ");
            String pass = in.next();
            if(((String)users.get(user)).equals(pass))
            {
                valid = true;
                break;
            }                
        }
        }
        while (choice != 5){
            valid = false;
        while(!valid) //menu
        {
        System.out.println("1. Reserve Seats");     //taking inputs
        System.out.println("2. View Orders");
        System.out.println("3. Update Orders");
        System.out.println("4. Print Receipt");
        String kitty = in.next();
        if(isValidInt(kitty))
        {
        choice = Integer.parseInt(kitty); //VALIDATE**********************************************************************
        if(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)
        {
            break;
        }  
        }
        }
        if (choice == 1)
        {
            boolean vald = false;
            cchoice = 0;
            
            while(!valid)
        {
            System.out.println("1. Auditorium 1"); //print out Auditorium
            System.out.println("2. Auditorium 2");
            System.out.println("3. Auditorium 3");
        String kitty = in.next(); //validate
        if(isValidInt(kitty))
        {
        cchoice = Integer.parseInt(kitty); //VALIDATE**********************************************************************
        if(cchoice == 1 || cchoice == 2 || cchoice == 3)
        {
            break;
        }
        
        
        }
        }
            outputAuditorium(cchoice); //call method to output auditorium
            
            dummy = new DoubleLinkNode(0,0);
            free = new LinkedL(dummy); //Lists and add a dummy node that will be deleted later to the list
            res = new LinkedL(dummy);   //Lists and add a dummy node that will be deleted later to the list
            free = readIntoList(free,cchoice,'#'); //read all # into a list of free seats
            res = readIntoList(res,cchoice,'.');    //read all . into a list of reserved seats
            int row = 0;
            int seat = 0;
            int seatNum = 0;
            int AdultTick = 0;
            int SeniorTick = 0;
            int ChildTick = 0;
            while(!valid)
            {
                System.out.println("Num of adult");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            AdultTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            String aarray[] = new String[AdultTick];
            for(int i = 0; i < AdultTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               aarray[i] = new String(row+" "+seat);
            }
            
            while(!valid)
            {
                System.out.println("Num of senior");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            SeniorTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            
            
            String sarray[] = new String[SeniorTick];
            for(int i = 0; i < SeniorTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               sarray[i] = new String(row+" "+seat);
            }
            
            while(!valid)
            {
                System.out.println("Num of Child");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            ChildTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            
            
            String carray[] = new String[ChildTick];
            for(int i = 0; i < ChildTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               carray[i] = new String(row+" "+seat);
            }
            int totseats = AdultTick+SeniorTick+ChildTick;
            
            
             if(checkAvailable(res,aarray,sarray,carray)) //check if all seats subsequent to the seat selected till the amounts of seats desired are available
                    {
                        res = MoveToRes(free,res,aarray,sarray,carray); //if available, move to reserved seat lists
                        free.deleteNode(aarray,sarray,carray,free); //delete the moved nodes from the lsit of free seats
                        res.sortList(); //sort list by row and seat in ascending order
                        System.out.println("Successfully Booked");
                      
                    }
                else{
                    DoubleLinkNode best = findBest(free, res,totseats, cchoice); //if not available find the best available seat
                    System.out.println("We could not reserve your selected seat as it is taken, we have however found the nearest convenient seat for you at row " + best.getRow() +", seat Number "+best.getSeat()+", Would you Like to reserve it? (Y/N)");
                    String yn = in.next(); //VALIDATE**********************************************************************
                    if(yn.charAt(0)== 'y')
                    {
                        
                    res = MoveToRes(free,res,best.getRow(),best.getSeat(),seatNum); //move new seats to reserved
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+i));
                        }
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+AdultTick+i));
                        }
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+AdultTick+SeniorTick+i));
                        }
                        free.deleteNode(row, seat, seatNum, free); //delete moved seats from free seats list
                        res.sortList();
                    }
                    else
                    {
                        //Loop back to main menu
                    }
                    
                }
                
                String Filename = "A"+cchoice+".txt";
                    File f = new File(Filename);
                    Scanner ll = new Scanner(f);
                    int rows = 0;
                    int seats =0;
                    while(ll.hasNextLine())
                    {
                        seats = ll.nextLine().length();
                        rows = rows+1;
                    }
                    char[][] aud = new char[rows][seats]; //create a 2d array to store the entire auditorium
                    aud = intoArray(free, res,aud);
                    printToFile(aud,cchoice,rows,seats);
                    String newvalue = returnstringorder(((String)users.get(user)),cchoice,aarray,sarray,carray);
                    users.remove(user);
                    users.put(user, newvalue);
                
        }
        if (choice == 2)
        {
            ViewOrders(users,user); //display orders
        }
        if (choice == 3)
        {
            ViewOrders(users,user); //display orders
            valid = false;
            while(!valid)
            {
            System.out.println("Enter the order number you wish to update: "); //enter ordernum
            int ordernum = in.nextInt();
            if(isDigit(ordernum))
            {
                break;
            }
            }
            while(!valid)
            {
            System.out.println("1. Add tickets to Order");
            System.out.println("2. Delete Tickets from Order");
            System.out.println("3. Cancel Order");
            int cheese = in.nextInt();
            
                if (cheese == 1||cheese == 2 || cheese == 3)
                {
                    break;
                }
            }
            if(choice == 1)
            {
            boolean vald = false;
            cchoice = 0;
            
            while(!valid)
        {
            System.out.println("1. Auditorium 1"); //print out Auditorium
            System.out.println("2. Auditorium 2");
            System.out.println("3. Auditorium 3");
        String kitty = in.next(); //validate
        if(isValidInt(kitty))
        {
        cchoice = Integer.parseInt(kitty); //VALIDATE**********************************************************************
        if(cchoice == 1 || cchoice == 2 || cchoice == 3)
        {
            break;
        }
        
        
        }
        }
            outputAuditorium(cchoice); //call method to output auditorium
            
            dummy = new DoubleLinkNode(0,0);
            free = readIntoList(free,cchoice,'#'); //read all # into a list of free seats
            res = readIntoList(res,cchoice,'.');    //read all . into a list of reserved seats
            int row = 0;
            int seat = 0;
            int seatNum = 0;
            int AdultTick = 0;
            int SeniorTick = 0;
            int ChildTick = 0;
            while(!valid)
            {
                System.out.println("Num of adult");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            AdultTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            String aarray[] = new String[AdultTick];
            for(int i = 0; i < AdultTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               aarray[i] = new String(row+" "+seat);
            }
            
            while(!valid)
            {
                System.out.println("Num of senior");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            SeniorTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            
            
            String sarray[] = new String[SeniorTick];
            for(int i = 0; i < SeniorTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               sarray[i] = new String(row+" "+seat);
            }
            
            while(!valid)
            {
                System.out.println("Num of Child");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            ChildTick = Integer.parseInt(kitty);
            
            break;
             //VALIDATE**********************************************************************
            }
            }
            
            
            String carray[] = new String[ChildTick];
            for(int i = 0; i < ChildTick; i++)
            {
               while(!valid)
            {
                System.out.println("Row Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            row = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               while(!valid)
            {
                System.out.println("Seat Number");
                String kitty = in.next();
                if(isValidInt(kitty))
            {
            seat = Integer.parseInt(kitty);
            break;
             //VALIDATE**********************************************************************
            }
            }
               carray[i] = new String(row+" "+seat);
            }
            int totseats = AdultTick+SeniorTick+ChildTick;
            
            
             if(checkAvailable(res,aarray,sarray,carray)) //check if all seats subsequent to the seat selected till the amounts of seats desired are available
                    {
                        res = MoveToRes(free,res,aarray,sarray,carray); //if available, move to reserved seat lists
                        free.deleteNode(aarray,sarray,carray,free); //delete the moved nodes from the lsit of free seats
                        res.sortList(); //sort list by row and seat in ascending order
                        System.out.println("Successfully Booked");
                      
                    }
                else{
                    DoubleLinkNode best = findBest(free, res,totseats, cchoice); //if not available find the best available seat
                    System.out.println("We could not reserve your selected seat as it is taken, we have however found the nearest convenient seat for you at row " + best.getRow() +", seat Number "+best.getSeat()+", Would you Like to reserve it? (Y/N)");
                    String yn = in.next(); //VALIDATE**********************************************************************
                    if(yn.charAt(0)== 'y')
                    {
                        
                    res = MoveToRes(free,res,best.getRow(),best.getSeat(),seatNum); //move new seats to reserved
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+i));
                        }
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+AdultTick+i));
                        }
                        for(int i = 0; i < aarray.length; i++)
                        {
                            aarray[i] = new String(best.getRow()+" "+(best.getSeat()+AdultTick+SeniorTick+i));
                        }
                        free.deleteNode(row, seat, seatNum, free); //delete moved seats from free seats list
                        res.sortList();
                        
                    }
                    else
                    {
                        //Loop back to main menu
                    }
                    
                }
                
                String Filename = "A"+cchoice+".txt";
                    File f = new File(Filename);
                    Scanner ll = new Scanner(f);
                    int rows = 0;
                    int seats =0;
                    while(ll.hasNextLine())
                    {
                        seats = ll.nextLine().length();
                        rows = rows+1;
                    }
                    char[][] aud = new char[rows][seats]; //create a 2d array to store the entire auditorium
                    aud = intoArray(free, res,aud);
                    printToFile(aud,cchoice,rows,seats);
                    //****************update hash
            }
            if (choice == 2)
            {  
                System.out.println("Row Number: ");
                int rownum = Integer.parseInt(in.next());
                System.out.println("Seat number: ");
                int snum = Integer.parseInt(in.next());
                free = MoveToRes(res,free,rownum,snum,1);
                //update hash
                
                
                //printToFile(aud,cchoice,rows,seats);
            }
            if (choice == 3)
            {
                String Filename = "A"+cchoice+".txt";
                    File f = new File(Filename);
                    Scanner ll = new Scanner(f);
                    int rows = 0;
                    int seats =0;
                    while(ll.hasNextLine())
                    {
                        seats = ll.nextLine().length();
                        rows = rows+1;
                    }
                char[][] aud = new char[rows][seats]; //create a 2d array to store the entire auditorium
                    aud = intoArray(free, res,aud);
                    printToFile(aud,cchoice,rows,seats);
                //delete order
            }
            
        }
        if (choice == 4)
        {
            printReport();
        }
        }
    }
    
    public static void outputAuditorium(int in)throws FileNotFoundException, IOException
    {
            int choice = in;
            String filename = "A"+choice+".txt"; //name of txt file
            File f = new File(filename); 
            Scanner fscan = new Scanner (f);
            Scanner tempscan = new Scanner(f);
            int count = tempscan.nextLine().length(); // scan to print out the number of seats in a row
            System.out.print(" ");
            int k = 0;
            for(int i = 1; i <= count; i++)
            {
                k = k+1;
                if(k == 10)k = 0; //if the number hits 10, set to 0 so the counter resets
                System.out.print(k);
            }
            System.out.println("");
            int c = 0;
            while(fscan.hasNextLine())
            {
                c = c+1;
                String line = fscan.nextLine();
                System.out.print(c); //print column numbers
                System.out.println(line); //print the entire row
            }
    }
    
    public static void printReport() throws FileNotFoundException
    {
        int reserved1 = 0; //Use basic math to add and print a report on the seats taken
        int reserved2 = 0;
        int reserved3 = 0;
        
        int open1 = 0;
        int open2 = 0;
        int open3 = 0;
        
        File f1 = new File("A1.txt");
        File f2 = new File("A2.txt");
        File f3 = new File("A3.txt");
        
        Scanner f = new Scanner(f1);
        while(f.hasNextLine())
        {
            String temp = f.nextLine();
            for(int i = 0; i < temp.length(); i ++)
            {
                if(temp.charAt(i) == '.')
                {
                    reserved1 = reserved1+1;
                }
                else if(temp.charAt(i) == '#')
                {
                    open1 = open1+1;
                }
            }
        }
        
        f = new Scanner(f2);
        while(f.hasNextLine())
        {
            String temp = f.nextLine();
            for(int i = 0; i < temp.length(); i ++)
            {
                if(temp.charAt(i) == '.')
                {
                    reserved2 = reserved2+1;
                }
                else if(temp.charAt(i) == '#')
                {
                    open2 = open2+1;
                }
            }
        }
        
        
        int sales1 = reserved1 * 7;
        int sales2 = reserved2 * 7;
        int sales3 = reserved3 * 7;
        
        System.out.format("%32s%10d%16d%14d", "Auditorium 1", reserved1, open1, sales1); //Printing
        System.out.println("");
        System.out.format("%32s%10d%16d%14d", "Auditorium 2", reserved2, open2, sales2); 
        System.out.println("");
        System.out.format("%32s%10d%16d%14d", "Auditorium 3", reserved3, open3, sales3); 
        System.out.println("");
        System.out.format("%32s%10d%16d%14d", "Total Sale", reserved3+reserved2+reserved1, open3+open2+open1, sales1+sales2+sales3); 
        System.out.println("");
    }
    
    public static LinkedL readIntoList(LinkedL list, int choice, char c) throws FileNotFoundException
    {
        String filename = "A"+choice+".txt"; //read every type of the char entered into a linked list
        File f = new File(filename);
        Scanner fread = new Scanner(f);
        int count = 0;
        while(fread.hasNextLine())
        {
            count = count+1;
            String temp = fread.nextLine();
            for(int i = 0; i < temp.length(); i++)
            {
                if(temp.charAt(i) == c)
                {
                    DoubleLinkNode t = new DoubleLinkNode(count,i+1);
                    list.addNode(t);
                }
            }
        }
        list.setHead(list.getHead().getNext());
        list.getHead().setPrev(null);
        return list;
    }
    
    public static boolean checkAvailable(LinkedL res, String[] aarray,String[]sarray,String[]carray)
    {
        DoubleLinkNode ptr = res.getHead(); //Checks if every seat after a selected seat till the desired number of seats is available
        while(ptr!=null)
        {
            for (int j = 0; j < aarray.length;j++)
            {
                Scanner asc = new Scanner(aarray[j]);
                if(ptr.getRow() == asc.nextInt() && ptr.getSeat() == asc.nextInt()) return false;
            }
            for (int j = 0; j < sarray.length;j++)
            {
                Scanner asc = new Scanner(sarray[j]);
                if(ptr.getRow() == asc.nextInt() && ptr.getSeat() == asc.nextInt()) return false;
            }
            for (int j = 0; j < carray.length;j++)
            {
                Scanner asc = new Scanner(carray[j]);
                if(ptr.getRow() == asc.nextInt() && ptr.getSeat() == asc.nextInt()) return false;
            }
                ptr = ptr.getNext();
        }
        
        return true;
    }
    
    public static LinkedL MoveToRes(LinkedL free, LinkedL res, int r, int s, int seatNum)
    {
        for(int i = 0; i < seatNum; i++)
        {
            DoubleLinkNode teemp = new DoubleLinkNode(r,s+i); //create a new node with the values of the seat number and use
            res.addNode(teemp); //addnode to add it to the Linked list
            //1ptrf = ptrf.getNext();
        }
        
        return res;
    }
    
    public static LinkedL MoveToRes(LinkedL free, LinkedL res, String[] aarray, String[] sarray, String[] carray)
    {
        for (int i = 1; i < aarray.length; i++)
        {
            Scanner lsc = new Scanner(aarray[i]);
            DoubleLinkNode teemp = new DoubleLinkNode(lsc.nextInt(),lsc.nextInt()); //create a new node with the values of the seat number and use
            res.addNode(teemp); //addnode to add it to the Linked list
            //1ptrf = ptrf.getNext();
        }
        
        for (int i = 1; i < sarray.length; i++)
        {
            Scanner lsc = new Scanner(sarray[i]);
            DoubleLinkNode teemp = new DoubleLinkNode(lsc.nextInt(),lsc.nextInt()); //create a new node with the values of the seat number and use
            res.addNode(teemp); //addnode to add it to the Linked list
            //1ptrf = ptrf.getNext();
        }
        
        for (int i = 1; i < carray.length; i++)
        {
            Scanner lsc = new Scanner(carray[i]);
            DoubleLinkNode teemp = new DoubleLinkNode(lsc.nextInt(),lsc.nextInt()); //create a new node with the values of the seat number and use
            res.addNode(teemp); //addnode to add it to the Linked list
            //1ptrf = ptrf.getNext();
        }
        
        return res;
    }
    
    public static boolean checkAvailable(LinkedL res, int row, int seat, int seatNum)
    {
        DoubleLinkNode ptr = res.getHead(); //Checks if every seat after a selected seat till the desired number of seats is available
        while(ptr!=null)
        {
                for(int i = 0; i < seatNum; i++)
                    {
                        if(ptr.getRow() == row && ptr.getSeat() == seat+i) return false; 
                    }
                ptr = ptr.getNext();
        }
        
        return true;
    }
    
    public static DoubleLinkNode findBest(LinkedL free,LinkedL res, int SeatNum, int choice) throws FileNotFoundException
    {
        String filename = "A"+choice+".txt";
        File f = new File(filename);
        Scanner sc = new Scanner(f);
        int count = 0;
        while(sc.hasNextLine()) //count the number of rows
        {
            count = count+1;
            sc.nextLine();
        }
        int middle = (count+1)/2; //use number of rows to find the middle row
        double distance;
        double mistance = 99999;
        DoubleLinkNode ret = new DoubleLinkNode(0,0); 
        DoubleLinkNode fptr = free.getHead();
        while(fptr != null)
        {
            if(checkAvailable(res,fptr.getRow(),fptr.getSeat(),SeatNum)) //find all seats that are available till the number of seats requested
            {
              distance =  Math.sqrt((Math.pow(middle-fptr.getRow(),2))+(Math.pow(1-fptr.getSeat(),2))); //use math to find the distance between two points
              if(mistance > distance)
              {
                  ret = fptr;
                  mistance = distance;
              } //get the Node with the smallest distance
            }
            fptr = fptr.getNext();
        } 
        return ret; //return that node
    }
    
    public static char[][] intoArray(LinkedL free, LinkedL res, char[][] arr)
    {
        DoubleLinkNode fptr = free.getHead(); //move everything into a 2d array to print out
        while(fptr != null)
        {
            arr[fptr.getRow()-1][fptr.getSeat()-1] = '#';
            fptr = fptr.getNext();
        }
        DoubleLinkNode rptr = res.getHead();
        while(rptr != null)
        {
            arr[rptr.getRow()-1][rptr.getSeat()-1] = '.';
            rptr = rptr.getNext();
        }
        return arr;
    }
    
    public static void printToFile(char[][] arr, int c,  int rows, int seats) throws IOException
    {
        String fname = "A"+c+".txt"; //print the 2d array to file
        File f = new File(fname);
        //f.createNewFile();
        PrintWriter pw = new PrintWriter(f);
        for(int i = 0; i < rows; i++)
        {
            String temp = "";
            for(int j = 0; j < seats; j++)
            {
                temp = temp+arr[i][j];
            }
            pw.println(temp);
            
        }
        pw.close();
    }    
    public static boolean isValidInt(String kitty) //check if a string is an integer
    {
        boolean k = true;
        for(int i = 0; i < kitty.length(); i++)
        {
            char c = kitty.charAt(i);
            if(isDigit(c))
            {
               k = true;
            }
            else return false;
        }
        return k;
    }
    public static String returnstringorder(String f, int choice, String[] aarray, String[] sarray, String[] carray) 
    {
        f = f+" ";
        
        f= f+(choice+" ");
        
        f= f+(aarray.length+" "+sarray.length+" "+carray.length)+" ";
        
        for(int i = 0;i < aarray.length-1; i++)f= f+(aarray[i]+" , ");
        if(aarray.length != 0)f= f+(aarray[aarray.length-1]+";");
        
        for(int i = 0;i < sarray.length-1; i++)f= f+(sarray[i]+" , ");
        if(sarray.length != 0)f= f+(sarray[sarray.length-1]+";");
        
        for(int i = 0;i < carray.length-1; i++)f= f+(carray[i]+" , ");
        if(carray.length != 0)f= f+(carray[carray.length-1]+";");
        
        f= f+("! ");
        return f;
    }

    private static void ViewOrders(HashMap users,String username) { //parses the hash value which is a string
        String parsed = (String)users.get(username);
        Scanner psc = new Scanner(parsed);
        psc.next();
        String onlyOrders = psc.nextLine();
        int i = 0;
        String[] Orders = onlyOrders.split("!");
        for(int k = 0; k < Orders.length; k++)
        {
            psc = new Scanner(Orders[k]);
        while(psc.hasNext())
        {
            i = i+1;
            System.out.println("Order "+i+": ");
            System.out.println("\t Auditorium Number:" + psc.nextInt());
            System.out.println("\t Number of Adult tickets: "+psc.nextInt());
            System.out.println("\t Number of Senior tickets: "+psc.nextInt());
            System.out.println("\t Number of Child tickets: "+psc.nextInt());
            String Order = psc.nextLine();
            System.out.println("\t Reserved seat locations: ");
            String[]lineVector = Order.split(";");
            for(int j = 0; j < lineVector.length;j++)
            {
                Scanner lsc = new Scanner(lineVector[j]);
                while(lsc.hasNextInt())
                {
                    System.out.print("\t\t Row: "+lsc.nextInt()); System.out.println(" Seat Number: "+lsc.nextInt());
                }
            }
            
            
        }
        }
    }
}
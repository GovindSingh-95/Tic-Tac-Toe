import java.util.*;
public class TicTacToe{
    static HashSet<Integer> user_set=new HashSet<Integer>();
    static HashSet<Integer> Pc_set=new HashSet<Integer>();
    public static void main(String[] args){
        Scanner Sc=new Scanner(System.in);
        char[][] ch={
              {' ','|',' ','|',' '},
              {'-','|','-','|','-'},
              {' ','|',' ','|',' '},
              {'-','|','-','|','-'},
              {' ','|',' ','|',' '}
      };
       print_board(ch);
       while(true){
           System.out.print("Enter a number between 1-9: ");
           int user_position=Sc.nextInt();
           while(user_set.contains(user_position)||Pc_set.contains(user_position)){
               System.out.println();
               System.out.print("Retry a number between 1-9: ");
                user_position=Sc.nextInt();
           }
           gaming(ch,user_position,"You");
            String Result=check();
            if(Result.length()>0) {
                System.out.println(Result);
                break;
            }
           int Pc_position=random_generator();
           while(user_set.contains(Pc_position)||Pc_set.contains(Pc_position)){
               Pc_position=random_generator();
           }
           gaming(ch,Pc_position,"Pc");
           Result=check();
           if(Result.length()>0) {
               System.out.println(Result);
               break;
           }
       }
    }
    static void print_board(char[][] board){
        for(char[] ele:board){
         for(char x:ele) System.out.print(x+" ");
         System.out.println();
        }
        System.out.println();
    }
    static void gaming(char[][] board,int position,String user){
        char symbl='X';
        if(user.equals("You")){
             symbl='X';
            user_set.add(position);
        }
        else if(user.equals("Pc")){
            symbl='O';
            Pc_set.add(position);
        }
        else System.out.print("Invalid");
        switch(position){
            case 1:
                board[0][0]=symbl;
                break;
            case 2:
                board[0][2]=symbl;
                break;
            case 3:
                board[0][4]=symbl;
                break;
            case 4:
                board[2][0]=symbl;
                break;
            case 5:
                board[2][2]=symbl;
                break;
            case 6:
                board[2][4]=symbl;
                break;
            case 7:
                board[4][0]=symbl;
                break;
            case 8:
                board[4][2]=symbl;
                break;
            case 9:
                board[4][4]=symbl;
                break;
            default:
                System.out.print("Invalid Input");
        }
        print_board(board);
    }
    static int random_generator(){
        int upper=9;
        int lower=1;
        int range=upper-lower+2;
        int ans=(int)(Math.random()*range)+lower;
        return ans;
    }
    static String check(){
        HashSet<Integer> r1=new HashSet<>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2=new HashSet<>();
        r2.add(4);r2.add(5);r2.add(6);
        HashSet<Integer> r3=new HashSet<>();
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> r4=new HashSet<>();
        r4.add(1);r4.add(4);r4.add(7);
        HashSet<Integer> r5=new HashSet<>();
        r5.add(2);r5.add(5);r5.add(8);
        HashSet<Integer> r6=new HashSet<>();
        r6.add(3);r6.add(6);r6.add(9);
        HashSet<Integer> r7=new HashSet<>();
        r7.add(1);r5.add(5);r5.add(9);
        HashSet<Integer> r8=new HashSet<>();
        r8.add(3);r8.add(5);r8.add(7);
        HashSet<HashSet> set =new HashSet<HashSet>();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(r4);set.add(r5);set.add(r6);
        set.add(r7);set.add(r8);
        for(HashSet  c:set){
            if(user_set.containsAll(c))
                return "You won";
            else if(Pc_set.containsAll(c))
                return "You lost";
        }
        if(user_set.size()+Pc_set.size()==9)
            return "Draw";
        return "";
    }
}


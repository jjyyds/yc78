import java.util.Scanner;
public class Main{
    public static void main(String []args){
    	 Scanner sc=new Scanner(System.in);
         int N=sc.nextInt();
         String [] str=new String [N];
         sc.nextLine();
         for(int i=0;i<N;i++){
             String a=sc.nextLine();
             str[i]=a;
         }
         int [] grd=new int [N];
         for(int i=0;i<N;i++){
             String [] str2=new String [20];
             str2=str[i].split(" ");
             grd[i]=Integer.parseInt(str2[2])+Integer.parseInt(str2[3])+Integer.parseInt(str2[4]);
         }
         int max=0;
         for(int i=0;i<N;i++){
             if(grd[max]<grd[i]){
                 max=i;
             }
         }
         String [] str3=new String [20];
         str3=str[max].split(" ");
         System.out.print(str3[1]+" "+str3[0]+" "+grd[max]);
    }
}

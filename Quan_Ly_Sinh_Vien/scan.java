package Quan_Ly_Sinh_Vien;

import java.util.Scanner;

public class scan {
    public static Scanner scan = new Scanner(System.in);
    public static int scanInteger(){
        boolean flag = true;
        int number =0;
        do{
            try {
                number = Integer.parseInt(scan.nextLine());
                flag = true;
            } catch (Exception e
            ){
                System.out.print("Data error, again :");
                flag = false;
            }
        }while (!flag);
        return number;
    }
    public static float scanFloat(){
        boolean flag = true;
        float number =0;
        do{
            try {
                number = Float.parseFloat(scan.nextLine());
                flag = true;
            } catch (Exception e
            ){
                System.out.print("Data error, again :");
                flag = false;
            }
        }while (!flag);
        return number;
    }
    public static double scanDouble(){
        boolean flag = true;
        double number =0;
        do{
            try {
                number = Double.parseDouble(scan.nextLine());
                flag = true;
            } catch (Exception e
            ){
                System.out.print("Data error, again :");
                flag = false;
            }
        }while (!flag);
        return number;
    }
    public static String scanNextLine(){
        String text = scan.nextLine();
        return text;
    }

}

package Quan_Ly_Sinh_Vien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StudentList {
    // Attributes
    private ArrayList<Students> studentsList;
    // get and set methods

    public ArrayList<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Students> studentsList) {
        this.studentsList = studentsList;
    }
    // Constructors
    public StudentList(){
        this.studentsList = new ArrayList<Students>();
    }
    public StudentList(ArrayList<Students> studentsList){
        this.studentsList = studentsList;
    }
    public void addStudentIntoStudentList(){
        boolean flag = true;
        do {
            Students students = new Students();
            students.inputStudentInfo();
            students.averageScore();
            students.rankClassify();
            this.studentsList.add(students);
            System.out.println("Enter 1 to continue, any number other to exit :");
            int number = scan.scanInteger();
            if(number !=1) flag = false;

        }while (flag);
    }
    public void outputStudentList(){
       ouputFormatInfoFollowStudentArrayList("Danh Sach Sinh Vien",this.studentsList);
    }
    // xuất file
    public void fileOutput(){
        System.out.print("Enter File Name ( Press Enter to skip ) :");
        String fileName = scan.scanNextLine();
        if(fileName.isEmpty()) fileName ="StudentList.dat";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.studentsList);
            oos.close();
            fos.close();
            System.out.println("Output file success !");
        } catch (Exception e){
            System.out.println("Error output file !");
        }

    }
    public void fileInput(){
        System.out.print("Enter File Name (Press Enter to skip ) :");
        String fileName = scan.scanNextLine();
        if(fileName.isEmpty()) fileName = "StudentList.dat";


        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.studentsList = (ArrayList<Students>) ois.readObject();
            System.out.println("Input file success !");
        } catch (Exception e){
            System.out.println("Error input file !");
        }
    }
    // tìm sinh viên có điểm trung bình cao nhất
    public void studentHaveAvgMaxScore(){
        ArrayList<Students> studentsListAvgMaxScore = new ArrayList<Students>();
        Students studentsMax;
        int indexMax = -1;
        if(this.studentsList!=null){
            studentsMax = this.studentsList.get(0);
            indexMax = 0;
            // tim sinh vien co diem trung binh cao nhat
            for(int i =0;i<studentsList.size();i++){
                if(this.studentsList.get(i).getAvgScore()>studentsMax.getAvgScore()){
                    studentsMax = studentsList.get(i);
                    indexMax =i;
                }
            }
            for(int i = indexMax; i<studentsList.size();i++){
                if(studentsList.get(i).getAvgScore()==studentsMax.getAvgScore()){
                    studentsListAvgMaxScore.add(this.studentsList.get(i));
                }
            }
        }
        if(studentsListAvgMaxScore.size()<1) System.out.println("Khong co sinh vien nao");
        else ouputFormatInfoFollowStudentArrayList("Danh Sach Sinh Vien Co Diem Trung Binh Cao Nhat",studentsListAvgMaxScore);


    }
    // danh sách sinh viên xếp loại yếu (weak raiting)
    public void outputStudentListWeakRaiting(){
        ArrayList<Students> studentsListWeakRaiting = new ArrayList<Students>();
        for(Students students : this.studentsList){
            if(students.getRank().equalsIgnoreCase("Yếu")){
                studentsListWeakRaiting.add(students);
            }
        }
        if(studentsListWeakRaiting.size()<1) System.out.println("Khong co sinh vien nao !");
        else ouputFormatInfoFollowStudentArrayList("Danh Sach Sinh Vien Xep Loai Yeu",studentsListWeakRaiting);
    }
    // tim sinh vien theo tên
    public void findStudentFollowName(){
        ArrayList<Students> studentLikeName = new ArrayList<Students>();
        System.out.println("Enter students name need to find : ");
        String studentName = scan.scanNextLine();
        for(Students students : this.studentsList){
            if(students.getFullName().equalsIgnoreCase(studentName)){
                studentLikeName.add(students);
            }
        }
        if(studentLikeName.size()<1){
            String []arrayStudentName = studentName.split(" ");
            String studentLastName = arrayStudentName[arrayStudentName.length-1];
            for(Students students : this.studentsList){
                String []arrayName =students.getFullName().split(" ");
                if(studentLastName.equalsIgnoreCase(arrayName[arrayName.length-1])){
                    studentLikeName.add(students);
                }

            }
        }
        if(studentLikeName.size()<1) System.out.println("Khong ton tai sinh vien nao !");
        else ouputFormatInfoFollowStudentArrayList("Danh Sach Tim Kiem Sinh Vien Theo Ten",studentLikeName);
    }
    // tìm sinh viên theo mã
    public void findStudentFollowStudentCode(){
        System.out.print("Enter Student Code need to find :");
        String studentCode = scan.scanNextLine();
        boolean flag = false;
        for(Students students : this.studentsList){
            if(students.getStudentCode().equalsIgnoreCase(studentCode)){
                flag = true;
                ouputFormatInfo("Tim Kiem Sinh Vien Theo Ma",students);
            }
        }
        if(!flag) System.out.println("Khong ton tai sinh vien nao");
    }
    // xoa sinh vien theo ma
    public void deleteStudentFollowStudentCode(){
        System.out.print("Enter Student Code need to delete :");
        String studentCode = scan.scanNextLine();
        boolean flag = false;
        for(Students students : this.studentsList){
            if(students.getStudentCode().equalsIgnoreCase(studentCode)){
                flag = true;
                this.studentsList.remove(students);
                System.out.println("Xoa thanh cong !");
                break;
            }
        }
        if(!flag) System.out.println("Khong ton tai sinh vien nao");
    }
    public void ouputFormatInfoFollowStudentArrayList(String title,ArrayList<Students> studentsList){
        System.out.println(String.format("%50s",title));
        String hr = "-------------------------------------------------------------------------------------------";

        String header = String.format("%-10s%-30s%-10s%-10s%-10s%-10s%-30s","Mã SV","Họ và Tên","Điểm Toán","Điểm Lý","Điểm Hóa","Điểm TB","Xếp Loại");
        System.out.println(hr);
        System.out.println(header);
        System.out.println(hr);
        for(Students students : studentsList){
            System.out.println(String.format("%-10s%-30s%-10.3s%-10.3s%-10.3s%-10.3s%-30s",students.getStudentCode(),students.getFullName(),students.getMathScore(),students.getPhysicsScore(),students.getChemistryScore(),students.getAvgScore(),students.getRank()));
            System.out.println(hr);
        }
    }
    public void ouputFormatInfo(String title,Students students){
        System.out.println(String.format("%50s",title));
        String hr = "---------------------------------------------------------------------------";
        String header = String.format("%-10s%-30s%-10s%-10s%-10s%-10s%-30s","Mã SV","Họ và Tên","Điểm Toán","Điểm Lý","Điểm Hóa","Điểm TB","Xếp Loại");
        System.out.println(hr);
        System.out.println(header);
        System.out.println(hr);
            System.out.println(String.format("%-10s%-30s%-10.3s%-10.3s%-10.3s%-10.3s%-30s",students.getStudentCode(),students.getFullName(),students.getMathScore(),students.getPhysicsScore(),students.getChemistryScore(),students.getAvgScore(),students.getRank()));
            System.out.println(hr);
    }
    // menu student management
    public void menuStudentManager (){
        boolean flag = true;
        do{
            int choose;

                System.out.println(String.format("%60s","***** MENU STUDENT MANAGER *****"));
                System.out.println("1. Doc File");
                System.out.println("2. Luu File");
                System.out.println("3. Nhap Sinh Vien");
                System.out.println("4. Xuat Sinh Vien");
                System.out.println("5. Danh Sach Sinh Vien Co Diem TB Cao Nhat");
                System.out.println("6. Danh Sach Sinh Vien Yeu");
                System.out.println("7. Tim Kiem Sinh Vien Theo Ten");
                System.out.println("8. Tim Sinh Vien Theo Ma");
                System.out.println("9. Xoa Sinh Vien Theo Ma");
                System.out.println("0. Thoat Chuong Trinh");
                System.out.print("Moi Nhap Lua Chon :");

            do{
                choose = scan.scanInteger();
            }while(choose<0||choose>9);
            switch (choose){
                case 0:
                    flag = false;
                    break;
                case 1 :
                    fileInput();
                    break;
                case 2:
                    fileOutput();
                    break;
                case 3:
                    addStudentIntoStudentList();
                    break;
                case 4:
                    outputStudentList();
                    break;
                case 5:
                    studentHaveAvgMaxScore();
                    break;
                case 6:
                    outputStudentListWeakRaiting();
                    break;
                case 7:
                    findStudentFollowName();
                    break;
                case 8:
                    findStudentFollowStudentCode();
                    break;
                case 9:
                    deleteStudentFollowStudentCode();
                    break;
            }

        }while (flag);

    }

}

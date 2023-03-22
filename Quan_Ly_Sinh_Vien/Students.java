// project :Student Management
// Version :1.0

package Quan_Ly_Sinh_Vien;

import java.io.Serializable;

public class Students implements Serializable {
    // attributes of Students
    private String fullName;
    private String studentCode;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double avgScore;
    // get and set methods
    private String rank;

    public String getRank() {
        return rank;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public double getMathScore() {
        return mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public void setPhysicsScore(double physicsScore) {
        this.physicsScore = physicsScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    // constructors
    public Students() {

    }

    public Students(String fullName, String studentCode, double mathScore, double physicsScore, double chemistryScore) {
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;

    }

    // input output methods
    public void inputStudentInfo() {
        System.out.print("Enter Full Name :");
        this.fullName = scan.scan.nextLine();
        System.out.print("Enter Student Code :");
        this.studentCode = scan.scanNextLine();
        System.out.print("Enter Math Score :");
        do{
            this.mathScore = scan.scanDouble();
          //  System.out.println("Kiem tra mathscore :"+mathScore);
        }while(this.mathScore<0||this.mathScore>10);
        System.out.print("Enter Physics Score :");
        do {
            this.physicsScore = scan.scanDouble();
        }while (this.physicsScore<0||this.physicsScore>10);
        System.out.print("Enter Chemistry Score :");
        do {
            this.chemistryScore = scan.scanDouble();

        }while (this.chemistryScore<0||this.chemistryScore>10);
    }

    public void outputStudentInfo() {
        System.out.println("Full name :" + this.fullName);
        System.out.println("Student Code :" + this.studentCode);
        System.out.print("Math Score :"+this.mathScore);
        System.out.println("Physics Score :"+this.physicsScore);
        System.out.println("Chemistry Score :"+this.mathScore);
        System.out.println("Average Score :"+this.avgScore);
        System.out.println("Rank :"+this.rank);


    }
    // tính điểm trung bình
    public void averageScore (){
        if((this.mathScore+this.chemistryScore+this.physicsScore) >0){
            this.avgScore = (this.chemistryScore +this.mathScore+this.physicsScore)/3;
        }
    }
    // xếp loại học lực
    // >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<TB Khá <=6, <6 <TB <=5, còn lại Yếu
    //
    public void rankClassify (){
        if(this.avgScore>=9) this.rank = "Xuất Sắc";
        else if(this.avgScore>=8) this.rank ="Giỏi";
        else if(this.avgScore>=7) this.rank = "Khá";
        else if(this.avgScore>=6) this.rank = "TB Khá";
        else if(this.avgScore >=5) this.rank = "TB";
        else this.rank = "Yếu";
    }

}

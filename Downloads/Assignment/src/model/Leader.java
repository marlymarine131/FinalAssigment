/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Leader extends NhanVienModel{
    private int ReviewTaskNumber;
    private int SupportTaskNumber;

    public Leader(int Role, String Empld, String Account, int WorkStartingDay, double Productivity, int NgayLamViecHienTai, int ReviewTaskNumber, int SupportTaskNumber) {
        super(Role, Empld, Account, WorkStartingDay, Productivity, NgayLamViecHienTai);
        this.ReviewTaskNumber = ReviewTaskNumber;
        this.SupportTaskNumber = SupportTaskNumber;
    }

    public Leader() {
    }
 
    public int getReviewTaskNumber() {
        return ReviewTaskNumber;
    }

    public void setReviewTaskNumber(int ReviewTaskNumber) {
        this.ReviewTaskNumber = ReviewTaskNumber;
    }

    public int getSupportTaskNumber() {
        return SupportTaskNumber;
    }

    public void setSupportTaskNumber(int SupportTaskNumber) {
        this.SupportTaskNumber = SupportTaskNumber;
    }

    @Override
    public String toString() {
        return "Leader{" + super.toString() + "ReviewTaskNumber=" + ReviewTaskNumber + ", SupportTaskNumber=" + SupportTaskNumber + '}';
    }

    @Override
    public double Reward() {
        return (double) (this.getProductivity()*3000000);
    }

    @Override
    public int soThangLamViec() {
        return (int) (this.getNgayLamViecHienTai()-this.getWorkStartingDay()) ;
    }

    @Override
    public double Allowance() {
        if(soThangLamViec()>=36){
            return (double) (2000000*this.getProductivity());
        } else if (soThangLamViec()<36){
            return (double) (1200000*this.getProductivity());
        } else {
            return 0;
        }
    }

    @Override
    public double MonthlyIncome() {
        return (double) ((this.ReviewTaskNumber*4000000) + (this.SupportTaskNumber*400000) + Reward() + Allowance());
    }

    @Override
    public void inputThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ReviewTaskNumber:");
        ReviewTaskNumber = sc.nextInt();
        System.out.println("Nhap SupportTaskNumber:");
        SupportTaskNumber = sc.nextInt();
    }
}

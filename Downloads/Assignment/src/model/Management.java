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
public class Management extends NhanVienModel{
    private int ResolveIssueNumber;
    private int OtherTaskNumber;

    public Management(int Role, String Empld, String Account, int WorkStartingDay, double Productivity, int NgayLamViecHienTai, int ResolveIssueNumber, int OtherTaskNumber) {
        super(Role, Empld, Account, WorkStartingDay, Productivity, NgayLamViecHienTai);
        this.ResolveIssueNumber = ResolveIssueNumber;
        this.OtherTaskNumber = OtherTaskNumber;
    }

    public Management() {
    }    

    public int getResolveIssueNumber() {
        return ResolveIssueNumber;
    }

    public void setResolveIssueNumber(int ResolveIssueNumber) {
        this.ResolveIssueNumber = ResolveIssueNumber;
    }

    public int getOtherTaskNumber() {
        return OtherTaskNumber;
    }

    public void setOtherTaskNumber(int OtherTaskNumber) {
        this.OtherTaskNumber = OtherTaskNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Management{" + "ResolveIssueNumber=" + ResolveIssueNumber + ", OtherTaskNumber=" + OtherTaskNumber + '}';
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
        return (double) ((this.ResolveIssueNumber*5000000) + (this.OtherTaskNumber*500000) + Reward() + Allowance());
    }

    @Override
    public void inputThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ResolveIssueNumber:");
        ResolveIssueNumber = sc.nextInt();
        System.out.println("Nhap OtherTaskNumber:");
        OtherTaskNumber = sc.nextInt();
    }
}

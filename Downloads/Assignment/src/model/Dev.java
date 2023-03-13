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
public class Dev extends NhanVienModel{
    private int DoneTaskNumber;

    public Dev(int Role, String Empld, String Account, int WorkStartingDay, double Productivity, int NgayLamViecHienTai, int DoneTaskNumber) {
        super(Role, Empld, Account, WorkStartingDay, Productivity, NgayLamViecHienTai);
        this.DoneTaskNumber = DoneTaskNumber;
    }

    public Dev() {
    }   

    public int getDoneTaskNumber() {
        return DoneTaskNumber;
    }

    public void setDoneTaskNumber(int DoneTaskNumber) {
        this.DoneTaskNumber = DoneTaskNumber;
    }

    @Override
    public String toString() {
        return "Dev{" + super.toString() + "DoneTaskNumber=" + DoneTaskNumber + '}';
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
        return (double) ((this.DoneTaskNumber*160*1500000) + Reward() + Allowance());
    }

    @Override
    public void inputThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap DoneTaskNumber:");
        DoneTaskNumber = sc.nextInt();
    }
}

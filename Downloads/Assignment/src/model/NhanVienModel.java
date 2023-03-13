/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public abstract class NhanVienModel {
    private int Role;
    private String Empld;
    private String Account;
    private int WorkStartingDay;
    private double Productivity;
    private int NgayLamViecHienTai;

    public NhanVienModel(int Role, String Empld, String Account, int WorkStartingDay, double Productivity, int NgayLamViecHienTai) {
        this.Role = Role;
        this.Empld = Empld;
        this.Account = Account;
        this.WorkStartingDay = WorkStartingDay;
        this.Productivity = Productivity;
        this.NgayLamViecHienTai = NgayLamViecHienTai;
        
    }

    public NhanVienModel() {
    }
    
    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        if(this.Role > 4 && this.Role <=0){
            this.Role = Role;
        } else {
            System.err.println("Vui long nhap lai!");
        }        
    }    
    
    public String getEmpld() {
        return Empld;
    }

    public void setEmpld(String Empld) {
        if(Empld != null && Empld.length() == 6 && Empld.startsWith("NMV")){
            this.Empld = Empld;
        } else {
            System.err.println("Ma nhan vien khong dung format (phai bat dau MNV va co 3 ki tu)");
        }
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        if(this.Account == null){
            System.err.println("Vui long nhap lai");
        } else {
            this.Account = Account;
        }
    }

    public int getWorkStartingDay() {
        return WorkStartingDay;
    }

    public void setWorkStartingDay(int WorkStartingDay) {
        if(this.WorkStartingDay > this.NgayLamViecHienTai){
            System.err.println("Ngay vao cong ty phai nho hon ngay hien tai");
        } else {
            this.WorkStartingDay = WorkStartingDay;
        }
    }

    public double getProductivity() {
        return Productivity;
    }

    public void setProductivity(double Productivity) {
        this.Productivity = Productivity;
    }

    public int getNgayLamViecHienTai() {
        return NgayLamViecHienTai;
    }

    public void setNgayLamViecHienTai(int NgayLamViecHienTai) {
        this.NgayLamViecHienTai = NgayLamViecHienTai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + " Role=" + Role + ", Empld=" + Empld + ", Account=" + Account + ", WorkStartingDay=" + WorkStartingDay + ", Productivity=" + Productivity + ", NgayLamViecHienTai=" + NgayLamViecHienTai + '}';
    }      

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVienModel other = (NhanVienModel) obj;
        if (this.Role != other.Role) {
            return false;
        }
        if (this.WorkStartingDay != other.WorkStartingDay) {
            return false;
        }
        if (Double.doubleToLongBits(this.Productivity) != Double.doubleToLongBits(other.Productivity)) {
            return false;
        }
        if (this.NgayLamViecHienTai != other.NgayLamViecHienTai) {
            return false;
        }
        if (!Objects.equals(this.Empld, other.Empld)) {
            return false;
        }
        return Objects.equals(this.Account, other.Account);
    }
    
    public abstract double Reward();
    public abstract int soThangLamViec();
    public abstract double Allowance();
    public abstract double MonthlyIncome();
    public abstract void inputThongTin();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.NhanVienController;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import model.Dev;
import model.Leader;
import model.Management;
import model.NhanVienModel;

/**
 *
 * @author Asus
 */
public class NhanVienView extends Menu{
    private Management Role1;
    private Leader Role2;
    private Dev Role3;
    public static void main(String[] args) throws IOException{
        NhanVienController ds = new NhanVienController();
        Management m = new Management();
        Leader ld = new Leader();
        Dev d = new Dev();
        ArrayList<NhanVienModel> kt =null;
        ArrayList<NhanVienModel> kp =null;
        Scanner sc = new Scanner(System.in);  
        Menu mn = new Menu() {      
            @Override
            public void menu(){
            System.out.println("Quan li nhan vien");
            System.out.println("------------------------");
            System.out.println("1.In danh sach nhan vien");
            System.out.println("2.Tim kiem nhan vien");
            System.out.println("3.Kiem tra danh sach nhan vien");
            System.out.println("4.Them nhan vien vao danh sach");
            System.out.println("5.Sap xep nhan vien");
            System.out.println("6.In danh sach nhan vien theo Role");            
            System.out.println("7.Xoa nhan vien");                        
            System.out.println("9.Viet danh sach vao text tu chuong trinh");  
            System.out.println("10.Doc danh sach trong text ngoai chuong trinh");
            System.out.println("0.Exit");
            System.out.println("------------------------");
            System.out.print("Enter selection: ");
            }           
        };        
        int chose = 0;
        do{
            mn.menu();
            chose = sc.nextInt();
            sc.nextLine();
            switch(chose){
                case 1:
                   ds.inDanhSachNhanVien();
                   break;
                case 2:
                    int chon;                    
                    System.out.println("1.Tim kiem ID:");
                    System.out.println("2.Tim kiem account:");
                    System.out.print("Moi ban chon:");
                    chon = sc.nextInt();
                    sc.nextLine();
                    switch(chon){
                        case 1:
                            System.out.println("Nhap ID can tim:"); String Empld = sc.nextLine();
                            System.out.println("Ket qua tim kiem:");
                            ds.timKiemNhanVien(Empld, "------");
                            break;
                        case 2:
                            System.out.println("Nhap account can tim:"); String Account = sc.nextLine();
                            System.out.println("Ket qua tim kiem:");
                            ds.timKiemNhanVien("-----", Account);
                            break;
                    }
                    break;
                case 3:
                    ds.kTraDSNV();
                    break;
                case 4:
                    System.out.println("Nhap Role:"); int Role = sc.nextInt();
                    System.out.println("Nhap Empld:"); String Empld = sc.nextLine(); sc.nextLine();
                    System.out.println("Nhap Account:"); String Account = sc.nextLine();
                    System.out.println("Nhap ngay bat dau lam viec:"); int WorkStartingDay = sc.nextInt();
                    System.out.println("Nhap hieu suat lam viec:"); double Productivity = sc.nextDouble();
                    System.out.println("Nhap ngay lam viec hien tai:"); int NgayLamViecHienTai = sc.nextInt();
                    NhanVienModel nvm = new NhanVienModel(Role, Empld, Account, WorkStartingDay, Productivity, NgayLamViecHienTai) {
                        @Override
                        public double Reward() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                        
                        @Override
                        public int soThangLamViec() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                        
                        @Override
                        public double Allowance() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                        
                        @Override
                        public double MonthlyIncome() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                        
                        @Override
                        public void inputThongTin() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    };
                    ds.themNhanVien(nvm);
                    break;
                case 5:
                    int chon1;
                    System.out.println("1.Sap xep Role");
                    System.out.println("2.Sap xep Empld");
                    System.out.println("3.Sap xep Account");
                    System.out.println("4.Sap xep MonthlyIncome");
                    System.out.print("Moi ban chon:");
                    chon1 = sc.nextInt();
                    sc.nextLine();
                    switch(chon1){
                        case 1:
                            ds.sapXepGiamDanTheoRole();
                            ds.inDanhSachNhanVien();
                            break;
                        case 2:
                            ds.sapXepEmpld();
                            ds.inDanhSachNhanVien();
                            break;
                        case 3:
                            ds.sapXepAccount();
                            ds.inDanhSachNhanVien();
                            break;
                        case 4:
                            ds.sapXepMonthlyIncome();
                            ds.inDanhSachNhanVien();
                    }
                    break;
                case 6:
                    int chon2;
                    System.out.println("1.In ra Management:");
                    System.out.println("2.In ra Leader:");
                    System.out.println("3.In ra Dev:");
                    System.out.print("Moi ban chon:");
                    chon2 = sc.nextInt();
                    sc.nextLine();
                    switch(chon2){
                        case 1:
                            m.inputThongTin();
                            System.out.println("" + m.toString());
                            System.out.println("--------------------------------------------------");
                            System.out.println("Tu cach la nhan vien Management: "+ "Reward: " + m.Reward() + ", Allowance: " + m.Allowance() + ", So thang lam viec: " + m.soThangLamViec() + ", MonthlyIncome: " + m.MonthlyIncome());
                            System.out.println("--------------------------------------------------");
                            ds.inDanhSachNhanVien();
                            break;
                        case 2:
                            ld.inputThongTin();
                            System.out.println("" + ld.toString());
                            System.out.println("--------------------------------------------------");
                            System.out.println("Tu cach la nhan vien Management: "+ "Reward: " + ld.Reward() + ", Allowance: " + ld.Allowance() + ", So thang lam viec: " + ld.soThangLamViec() + ", MonthlyIncome: " + ld.MonthlyIncome());
                            System.out.println("--------------------------------------------------");
                            ds.inDanhSachNhanVien();
                            break;
                        case 3:
                            d.inputThongTin();
                            System.out.println("" + d.toString());
                            System.out.println("--------------------------------------------------");
                            System.out.println("Tu cach la nhan vien Management: "+ "Reward: " + d.Reward() + ", Allowance: " + d.Allowance() + ", So thang lam viec: " + d.soThangLamViec() + ", MonthlyIncome: " + d.MonthlyIncome());
                            System.out.println("--------------------------------------------------");
                            ds.inDanhSachNhanVien();
                            break;
                    }
                    break;
                case 7:
                    int chon3;                   
                    System.out.println("1.Xoa toan bo danh sach");
                    System.out.println("2.Xoa id nhan vien");
                    System.out.println("3.Xoa account nhan vien");
                    System.out.print("Moi ban chon:");
                    chon3 = sc.nextInt();
                    sc.nextLine();
                    switch(chon3){
                        case 1:
                            ds.xoaToanBoNhanVien();
                            System.out.println("--------Sau khi xoa----------");
                            ds.inDanhSachNhanVien();
                            break;
                        case 2:
                            ds.xoaNhanVienTheoID(kt);
                            System.out.println("--------Sau khi xoa----------");
                            ds.inDanhSachNhanVien();
                            break;
                        case 3:
                            ds.xoaNhanVienTheoTen(kp);
                            System.out.println("--------Sau khi xoa----------");
                            ds.inDanhSachNhanVien();
                            break;
                    }
                    break;
                case 9:
                    File file = new File("D:\\PRO192\\Assignment\\new2.txt");
                    try{
                        PrintWriter pw = new PrintWriter(file);
                        pw.println("List of students:");
                        pw.println("------------------------------------");
                        ds.vietVaoFile(file, pw);
                        pw.println("------------------------------------");
                        pw.flush();
                        pw.close();
                    } catch (Exception e){
                           e.printStackTrace();
                        }
                    break;
                case 10:
                    File f = new File("D:\\PRO192\\Assignment\\new1.txt");
                    try{
                        BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
                        String line = null;
                        while(true){
                                line = br.readLine();
                                if(line==null){
                                    break;
                                } else {
                                    String[] temp = line.split(",");
                                    int role = Integer.parseInt(temp [0]);
                                    String id = temp [1];
                                    String account = temp [2];
                                    int ngayBatDau = Integer.parseInt(temp [3]);
                                    double hieuSuat = Double.parseDouble(temp [4]);
                                    int ngayHienTai = Integer.parseInt(temp[5]);
                                    NhanVienModel n =  new NhanVienModel(role, id, account, ngayBatDau, hieuSuat, ngayHienTai) {
                                        @Override
                                        public double Reward() {
                                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                        }

                                        @Override
                                        public int soThangLamViec() {
                                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                        }

                                        @Override
                                        public double Allowance() {
                                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                        }

                                        @Override
                                        public double MonthlyIncome() {
                                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                        }

                                        @Override
                                        public void inputThongTin() {
                                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                        }
                                    };                                        
                                    ds.themNhanVien(n);
                                }
                        }
                        } catch (Exception e){
                                e.printStackTrace();
                                }
                        break;
                case 0:
                    System.out.println("Out of order.");
                    break;
            }
        }while(chose!=0);
    }

    @Override
    public void menu() {
            System.out.println("Quan li nhan vien");
            System.out.println("------------------------");
            System.out.println("1.In danh sach nhan vien");
            System.out.println("2.Tim kiem nhan vien");
            System.out.println("3.Them nhan vien");
            System.out.println("4.Sorting display");
            System.out.println("5.Exit");            
            System.out.println("6.Write file text from inside");                        
            System.out.println("7.Read file text from outside");  
            System.out.println("8.Delete student");
            System.out.println("------------------------");
            System.out.print("Enter selection: ");
            }           
        };

    

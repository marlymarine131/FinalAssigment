/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Dev;
import model.Leader;
import model.Management;
import model.NhanVienModel;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;


/**
 *
 * @author Asus
 */
public class NhanVienController {
    private Management Role1;
    private Leader Role2;
    private Dev Role3;
    private ArrayList<NhanVienModel> danhSachNhanVien;
    
    private static Scanner sc = new Scanner(System.in);

    public NhanVienController(ArrayList<NhanVienModel> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }
  
    public NhanVienController() {
        this.danhSachNhanVien = new ArrayList<NhanVienModel>();
    }
    
    public void inDanhSachNhanVien(){
        System.out.println("Danh sach nhan vien:");
        for(NhanVienModel snv: danhSachNhanVien){
            System.out.println(snv);
        }
    }
    
    public boolean kTraDSNV(){
        if(danhSachNhanVien == null){
            System.out.println("Khong co!");
            return false;
        } else {
            System.out.println("Co!");
            return true;
        }
    }
    
    public void themNhanVien(NhanVienModel nv){
        this.danhSachNhanVien.add(nv);
    }
    
    public void xoaToanBoNhanVien(){
        this.danhSachNhanVien.removeAll(danhSachNhanVien);
    }
    
    public void capNhatDachSachNhanVien(NhanVienModel nv){
        for(NhanVienModel dsnv: danhSachNhanVien){
            if(dsnv.getEmpld().equals(nv.getEmpld())){
                dsnv.getAccount().equals(nv.getAccount());
            }
        }
    }

    public void timKiemNhanVien(String id, String account){
        for(NhanVienModel nv1:danhSachNhanVien){
            if(nv1.getEmpld().indexOf(id)>=0){
                System.out.println(nv1);
            } else if (nv1.getEmpld().indexOf(id)<0) {
                break;
            } else {
                System.out.println("Khong co ID nhan vien can tim!");
            } 
        }
        
        for(NhanVienModel nv2:danhSachNhanVien){
            if(nv2.getAccount().indexOf(account)>=0){
                System.out.println(nv2);
            } else if (nv2.getAccount().indexOf(account)<0) {
                break;
            } else {
                System.out.println("Khong co thong tin nhan vien can tim!");
            }
        }
    }

    public void sapXepGiamDanTheoRole(){
        Collections.sort(danhSachNhanVien, new Comparator<NhanVienModel>
        () {
            @Override
            public int compare(NhanVienModel o1, NhanVienModel o2) {
                if(o1.getRole() > o2.getRole()){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }
    
    public void sapXepEmpld(){
        Collections.sort(danhSachNhanVien, new Comparator<NhanVienModel>
        () {
            @Override
            public int compare(NhanVienModel d1, NhanVienModel d2) {
                int sx = d1.getEmpld().compareTo(d2.getEmpld());
                if (sx>=0){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
    
    public void sapXepAccount(){
        Collections.sort(danhSachNhanVien, new Comparator<NhanVienModel>
        () {
            @Override
            public int compare(NhanVienModel t1, NhanVienModel t2) {
                int sxa = t1.getAccount().compareTo(t2.getAccount());
                if (sxa>=0){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
    
    public void vietVaoFile(File file, PrintWriter pw){
        for (NhanVienModel nv : danhSachNhanVien){
            pw.println(nv);
        }
    }
    
    public void xoaNhanVienTheoTen(ArrayList<NhanVienModel> kp){
        System.out.println("Nhap ten nhan vien can xoa:");
        String keyNameRemove = sc.nextLine();
        for(int i=0;i<kp.size();i++){
            if(kp.get(i).getAccount().equals(keyNameRemove)){
                kp.remove(i);
                System.out.println("Sau khi xoa:\n" + keyNameRemove);
            } else {
                System.out.println("Khong tim thay ten nhan vien can xoa!");
            }
        }
    }
    
    public void xoaNhanVienTheoID(ArrayList<NhanVienModel> kt){
        System.out.println("Nhap id nhan vien can xoa:");
        String keyIDRemove = sc.nextLine();
        for(int i=0;i<kt.size();i++){
            if(kt.get(i).getEmpld().equals(keyIDRemove)){
                kt.remove(i);
                System.out.println("Sau khi xoa:\n" + keyIDRemove);
            } else {
                System.out.println("Khong tim thay id nhan vien can xoa!");
            }
        }
    }
    
    public void sapXepMonthlyIncome(){
        Collections.sort(danhSachNhanVien, new Comparator<NhanVienModel>
        () {
            @Override
            public int compare(NhanVienModel z1, NhanVienModel z2) {
                if(z1.MonthlyIncome() > z2.MonthlyIncome()){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
}

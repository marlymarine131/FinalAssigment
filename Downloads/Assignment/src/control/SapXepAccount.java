/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Comparator;
import model.NhanVienModel;

/**
 *
 * @author Asus
 */
public class SapXepAccount implements Comparator<NhanVienModel>{

    @Override
    public int compare(NhanVienModel o1, NhanVienModel o2) {
        return o1.getAccount().compareTo(o2.getAccount());
    }   
}

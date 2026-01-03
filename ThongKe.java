
package com.mycompany.quanlyshipper;


import java.util.ArrayList;
import java.util.HashMap;
import  java.util.HashSet;

public class ThongKe {
    private ArrayList<QuanLyDonHang>danhSachDonHang;
    

    public ThongKe(ArrayList<QuanLyDonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

  
    public float tongDoanhThu() {
        float tong = 0;
        for (QuanLyDonHang dh : danhSachDonHang) {
            tong += dh.getDoanhThu();
        }
        return tong;
    }
   

    //   Thống kê doanh thu theo từng shipper 
    public void doanhThuTheoShipper() {
        System.out.println(" DOANH THU THEO SHIPPER ");
        
        HashMap<String, Float> map = new HashMap<>();

        for (QuanLyDonHang dh : danhSachDonHang) {
            String idShipper = dh.getIDShipper();
            float doanhThu = dh.getDoanhThu();
            
            map.put(idShipper, map.getOrDefault(idShipper, 0f) + doanhThu);

        }
  

        for (String id : map.keySet()) {
            System.out.println("Shipper " + id + " co doanh thu: " + map.get(id));
        }
    }

    //   Đếm số đơn hàng 
    public int soDonHang() {
        return danhSachDonHang.size();
    }


    //   Đếm số khách hàng đã phục vụ
    public int soKhachHangPhucVu() {
        HashSet<String> tapKhachHang = new HashSet<>();
        for (QuanLyDonHang dh : danhSachDonHang) {
            tapKhachHang.add(dh.getIDKhachHangGui());
            tapKhachHang.add(dh.getIDKhachHangNhan());
        }
        return tapKhachHang.size();
    }

    
    public void inThongKe() {
        System.out.println("----- BÁO CÁO THỐNG KÊ ------");
        System.out.println("Tổng doanh thu hệ thống: " + tongDoanhThu());
        System.out.println("Tổng số đơn hàng: " + soDonHang());
        System.out.println("Số khách hàng đã phục vụ: " + soKhachHangPhucVu());
        doanhThuTheoShipper();
        System.out.println("==Hết==");
    }
public String thongKeGUI() {
    StringBuilder sb = new StringBuilder();

    sb.append("----- BÁO CÁO THỐNG KÊ -----\n");
    sb.append("Tổng doanh thu hệ thống: ").append(tongDoanhThu()).append("\n");
    sb.append("Tổng số đơn hàng: ").append(soDonHang()).append("\n");
    sb.append("Số khách hàng đã phục vụ: ").append(soKhachHangPhucVu()).append("\n\n");

    sb.append("DOANH THU THEO SHIPPER:\n");

    HashMap<String, Float> map = new HashMap<>();
    for (QuanLyDonHang dh : danhSachDonHang) {
        String idShipper = dh.getIDShipper();
        float doanhThu = dh.getDoanhThu();
        map.put(idShipper, map.getOrDefault(idShipper, 0f) + doanhThu);
    }

    for (String id : map.keySet()) {
        sb.append("Shipper ")
          .append(id)
          .append(" có doanh thu: ")
          .append(map.get(id))
          .append("\n");
    }

    sb.append("\n== HẾT ==");
    return sb.toString();
}

}
public String thongKeGUI() {
    StringBuilder sb = new StringBuilder();

    sb.append("----- BÁO CÁO THỐNG KÊ -----\n");
    sb.append("Tổng doanh thu hệ thống: ")
      .append(tongDoanhThu()).append("\n");

    sb.append("Tổng số đơn hàng: ")
      .append(soDonHang()).append("\n");

    sb.append("Số khách hàng đã phục vụ: ")
      .append(soKhachHangPhucVu()).append("\n\n");

    sb.append("DOANH THU THEO SHIPPER:\n");

    HashMap<String, Float> map = new HashMap<>();
    for (QuanLyDonHang dh : danhSachDonHang) {
        map.put(
            dh.getIDShipper(),
            map.getOrDefault(dh.getIDShipper(), 0f) + dh.getDoanhThu()
        );
    }

    for (String id : map.keySet()) {
        sb.append("Shipper ")
          .append(id)
          .append(" : ")
          .append(map.get(id))
          .append(" VND\n");
    }

    sb.append("\n== HẾT ==");
    return sb.toString();
}




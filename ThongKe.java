

import java.util.ArrayList;
import java.util.HashMap;
import  java.util.HashSet;

public class ThongKe {
    private ArrayList<QuanLyDonHang>danhSachDonHang;
    

    public ThongKe(ArrayList<QuanLyDonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

    //  Tính tổng doanh thu của hệ thống 
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
}


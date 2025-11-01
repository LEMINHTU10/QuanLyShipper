import java.util.ArrayList;
import java.util.HashSet;

public class ThongKe {
    private ArrayList<QuanLyDonHang> danhSachDonHang;

    public ThongKe(ArrayList<QuanLyDonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

    // ===== 1️⃣ Tính tổng doanh thu của hệ thống =====
    public float tongDoanhThu() {
        float tong = 0;
        for (QuanLyDonHang dh : danhSachDonHang) {
            tong += dh.getDoanhThu();
        }
        return tong;
    }

    // ===== 2️⃣ Thống kê doanh thu theo từng shipper =====
    public void doanhThuTheoShipper() {
        System.out.println("===== DOANH THU THEO SHIPPER =====");
        // Sử dụng HashMap để cộng dồn doanh thu
        java.util.HashMap<String, Float> map = new java.util.HashMap<>();

        for (QuanLyDonHang dh : danhSachDonHang) {
            String idShipper = dh.getIDShipper();
            float doanhThu = dh.getDoanhThu();

            map.put(idShipper, map.getOrDefault(idShipper, 0f) + doanhThu);
        }

        for (String id : map.keySet()) {
            System.out.println("Shipper " + id + " có doanh thu: " + map.get(id));
        }
    }

    // ===== 3️⃣ Đếm số đơn hàng =====
    public int soDonHang() {
        return danhSachDonHang.size();
    }

    // ===== 4️⃣ Đếm số khách hàng đã phục vụ (gửi hoặc nhận) =====
    public int soKhachHangPhucVu() {
        HashSet<String> tapKhachHang = new HashSet<>();
        for (QuanLyDonHang dh : danhSachDonHang) {
            tapKhachHang.add(dh.getIDKhachHangGui());
            tapKhachHang.add(dh.getIDKhachHangNhan());
        }
        return tapKhachHang.size();
    }

    // ===== Hàm in tổng hợp =====
    public void inThongKe() {
        System.out.println("===== BÁO CÁO THỐNG KÊ =====");
        System.out.println("Tổng doanh thu hệ thống: " + tongDoanhThu());
        System.out.println("Tổng số đơn hàng: " + soDonHang());
        System.out.println("Số khách hàng đã phục vụ: " + soKhachHangPhucVu());
        doanhThuTheoShipper();
        System.out.println("=============================");
    }
}

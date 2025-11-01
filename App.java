import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // ===== TẠO DỮ LIỆU KHÁCH HÀNG & SHIPPER =====
        KhachHang gui1 = new KhachHang("KH01", "Nguyễn Văn A", "0909123123", "123 Nguyễn Huệ", 4);
        KhachHang nhan1 = new KhachHang("KH02", "Trần Thị B", "0909888777", "456 Lê Lợi", 6);
        Shipper sp1 = new Shipper("SP01", "Lê Văn C", "0909555666");
        DonHang don1 = new DonHang("DH01", "Áo sơ mi", 250000, 20000, "Đang giao");

        KhachHang gui2 = new KhachHang("KH03", "Phạm Minh D", "0909111222", "789 Hai Bà Trưng", 3);
        KhachHang nhan2 = new KhachHang("KH04", "Lý Thị E", "0911222333", "111 Nguyễn Trãi", 7);
        Shipper sp2 = new Shipper("SP02", "Trần Văn F", "0909777666");
        DonHang don2 = new DonHang("DH02", "Giày thể thao", 500000, 30000, "Hoàn thành");

        // 🆕 Đơn hàng thứ 3
        KhachHang gui3 = new KhachHang("KH05", "Ngô Văn G", "0911777888", "222 Điện Biên Phủ", 8);
        KhachHang nhan3 = new KhachHang("KH06", "Phạm Thị H", "0911333444", "333 Võ Thị Sáu", 5);
        Shipper sp1_lan2 = new Shipper("SP01", "Lê Văn C", "0909555666"); // Shipper SP01 nhận thêm đơn khác
        DonHang don3 = new DonHang("DH03", "Điện thoại Samsung", 12000000, 50000, "Đang giao");

        // 🆕 Đơn hàng thứ 4
        KhachHang gui4 = new KhachHang("KH07", "Lưu Minh I", "0911444555", "99 Nguyễn Văn Linh", 2);
        KhachHang nhan4 = new KhachHang("KH08", "Trịnh Thị K", "0911666777", "555 Phan Đăng Lưu", 10);
        Shipper sp3 = new Shipper("SP03", "Đỗ Quốc L", "0909333222");
        DonHang don4 = new DonHang("DH04", "Laptop Dell", 15000000, 60000, "Hoàn thành");

        // 🆕 Đơn hàng thứ 5
        KhachHang gui5 = new KhachHang("KH09", "Huỳnh Anh M", "0911999000", "88 Pasteur", 1);
        KhachHang nhan5 = new KhachHang("KH10", "Bùi Văn N", "0911555666", "222 Nguyễn Thị Minh Khai", 12);
        Shipper sp2_lan2 = new Shipper("SP02", "Trần Văn F", "0909777666");
        DonHang don5 = new DonHang("DH05", "Bàn phím cơ", 900000, 25000, "Đã hủy");

        // ===== TẠO DANH SÁCH ĐƠN HÀNG =====
        ArrayList<QuanLyDonHang> ds = new ArrayList<>();

        QuanLyDonHang q1 = new QuanLyDonHang();
        q1.ThemDonHang(gui1, nhan1, sp1, don1);
        ds.add(q1);

        QuanLyDonHang q2 = new QuanLyDonHang();
        q2.ThemDonHang(gui2, nhan2, sp2, don2);
        ds.add(q2);

        QuanLyDonHang q3 = new QuanLyDonHang();
        q3.ThemDonHang(gui3, nhan3, sp1_lan2, don3);
        ds.add(q3);

        QuanLyDonHang q4 = new QuanLyDonHang();
        q4.ThemDonHang(gui4, nhan4, sp3, don4);
        ds.add(q4);

        QuanLyDonHang q5 = new QuanLyDonHang();
        q5.ThemDonHang(gui5, nhan5, sp2_lan2, don5);
        ds.add(q5);

        // ===== THỐNG KÊ TỔNG HỢP =====
        ThongKe tk = new ThongKe(ds);
        tk.inThongKe();
    }
}

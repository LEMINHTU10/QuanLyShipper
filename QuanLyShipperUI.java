package com.mycompany.quanlyshipper;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class QuanLyShipperUI extends JFrame {

    ArrayList<KhachHang> KH = new ArrayList<>();
    ArrayList<Shipper> Shippers = new ArrayList<>();
    ArrayList<DonHang> Donhangs = new ArrayList<>();
    ArrayList<QuanLyDonHang> ds = new ArrayList<>();

    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSHIPPER;encrypt=true;trustServerCertificate=true";
    String user = "sa"; 
    String pass = "1234"; 

    public QuanLyShipperUI() {
        setTitle("HỆ THỐNG QUẢN LÝ SHIPPER");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData(); 
        initUI();   

        setVisible(true);
    }

    private void initData() {
        loadDataFromSQL();
    }

    private void loadDataFromSQL() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            Statement st = conn.createStatement();
            
            ResultSet rsKH = st.executeQuery("SELECT N.ID, N.Ten, N.SDT, K.DiaChi, K.KhoangCach FROM KhachHang K JOIN Nguoi N ON K.ID_KH = N.ID");
            KH.clear();
            while (rsKH.next()) {
                KH.add(new KhachHang(rsKH.getString("ID"), rsKH.getString("Ten"), rsKH.getString("SDT"), rsKH.getString("DiaChi"), rsKH.getInt("KhoangCach")));
            }

            ResultSet rsSP = st.executeQuery("SELECT N.ID, N.Ten, N.SDT FROM Shipper S JOIN Nguoi N ON S.ID_Shipper = N.ID");
            Shippers.clear();
            while (rsSP.next()) {
                Shippers.add(new Shipper(rsSP.getString("ID"), rsSP.getString("Ten"), rsSP.getString("SDT")));
            }

            // Load DonHang
            ResultSet rsDH = st.executeQuery("SELECT * FROM DonHang");
            Donhangs.clear();
            while (rsDH.next()) {
                Donhangs.add(new DonHang(rsDH.getString("MaDon"), rsDH.getString("TenHang"), rsDH.getFloat("GiaTri"), rsDH.getFloat("PhiShip"), rsDH.getString("TrangThai")));
            }

            ResultSet rsQL = st.executeQuery("SELECT * FROM QuanLyDonHang");
            ds.clear();
            while (rsQL.next()) {
                QuanLyDonHang q = new QuanLyDonHang();
                q.setMaDon(rsQL.getString("MaDon"));
                q.setIDKhachHanggui(rsQL.getString("IDKhachHangGui"));
                q.setIDKhachHangnhan(rsQL.getString("IDKhachHangNhan"));
                q.setIDShipper(rsQL.getString("IDShipper"));
                q.setTongTien(rsQL.getFloat("TongTien"));
                q.setDoanhThu(rsQL.getFloat("DoanhThu"));
                q.setTrangThai(rsQL.getString("TrangThaiQuanLy"));
                ds.add(q);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi SQL: " + e.getMessage());
        }
    }


    private void insertKhachHangToSQL(KhachHang kh) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Nguoi (ID, Ten, SDT) VALUES (?, ?, ?)");
            ps1.setString(1, kh.getID());
            ps1.setString(2, kh.getTen());
            ps1.setString(3, kh.getSDT());
            ps1.executeUpdate();
            
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO KhachHang (ID_KH, DiaChi, KhoangCach) VALUES (?, ?, ?)");
            ps2.setString(1, kh.getID());
            ps2.setString(2, kh.getDiaChi());
            ps2.setInt(3, kh.getKhoangCach());
            ps2.executeUpdate();
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "Lỗi lưu KH: " + e.getMessage()); }
    }

    private void insertShipperToSQL(Shipper sp) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO Nguoi (ID, Ten, SDT) VALUES (?, ?, ?)");
            ps1.setString(1, sp.getID());
            ps1.setString(2, sp.getTen());
            ps1.setString(3, sp.getSDT());
            ps1.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement("INSERT INTO Shipper (ID_Shipper) VALUES (?)");
            ps2.setString(1, sp.getID());
            ps2.executeUpdate();
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "Lỗi lưu Shipper: " + e.getMessage()); }
    }

    private void insertDonHangToSQL(DonHang dh) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO DonHang (MaDon, TenHang, GiaTri, PhiShip, TrangThai) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, dh.getMaDon());
            ps.setString(2, dh.getTenHang());
            ps.setFloat(3, dh.getGiaTri());
            ps.setFloat(4, dh.getPhiShip());
            ps.setString(5, dh.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "Lỗi lưu Đơn hàng: " + e.getMessage()); }
    }

    private void insertQuanLyDonHangToSQL(QuanLyDonHang q) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO QuanLyDonHang (MaDon, IDKhachHangGui, IDKhachHangNhan, IDShipper, TongTien, DoanhThu, TrangThaiQuanLy) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, q.getMaDon());
            ps.setString(2, q.getIDKhachHangGui());
            ps.setString(3, q.getIDKhachHangNhan());
            ps.setString(4, q.getIDShipper());
            ps.setFloat(5, q.getTongTien());
            ps.setFloat(6, q.getDoanhThu());
            ps.setString(7, q.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "Lỗi lưu Giao dịch: " + e.getMessage()); }
    }

    private void initUI() {
        JButton btnXemShipper = new JButton("0. Xem danh sách shipper");
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnXemDon = new JButton("1. Xem danh sách");
        JButton btnThemKH = new JButton("2. Thêm Khách hàng");
        JButton btnThemShipper = new JButton("3. Thêm Shipper");
        JButton btnTaoDon = new JButton("4. Tạo Đơn hàng gốc");
        JButton btnThemDonGiao = new JButton("5. Thực hiện giao đơn");
        JButton btnTinhPhi = new JButton("6. Tính phí ship");
        JButton btnThongKe = new JButton("7. Thống kê");
        JButton btnThoat = new JButton("8. Thoát");
        panel.add(btnXemShipper);
        panel.add(btnXemDon); panel.add(btnThemKH);
        panel.add(btnThemShipper); panel.add(btnTaoDon);
        panel.add(btnThemDonGiao); panel.add(btnTinhPhi);
        panel.add(btnThongKe); panel.add(btnThoat);
        add(panel);


        btnThemKH.addActionListener(e -> {
            try {
                String id = JOptionPane.showInputDialog("ID KH:");
                String ten = JOptionPane.showInputDialog("Tên:");
                String sdt = JOptionPane.showInputDialog("SĐT:");
                String dc = JOptionPane.showInputDialog("Địa chỉ:");
                int kc = Integer.parseInt(JOptionPane.showInputDialog("Khoảng cách (km):"));
                KhachHang newKH = new KhachHang(id, ten, sdt, dc, kc);
                KH.add(newKH);
                insertKhachHangToSQL(newKH);
                JOptionPane.showMessageDialog(this, "Thêm KH thành công!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Lỗi nhập liệu!"); }
        });

        btnThemShipper.addActionListener(e -> {
            try {
                String id = JOptionPane.showInputDialog("ID Shipper:");
                String ten = JOptionPane.showInputDialog("Tên:");
                String sdt = JOptionPane.showInputDialog("SĐT:");
                Shipper newSP = new Shipper(id, ten, sdt);
                Shippers.add(newSP);
                insertShipperToSQL(newSP);
                JOptionPane.showMessageDialog(this, "Thêm Shipper thành công!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Lỗi nhập liệu!"); }
        });

        btnTaoDon.addActionListener(e -> {
            try {
                String ma = JOptionPane.showInputDialog("Mã đơn:");
                String ten = JOptionPane.showInputDialog("Tên hàng:");
                float gia = Float.parseFloat(JOptionPane.showInputDialog("Giá trị:"));
                float phi = Float.parseFloat(JOptionPane.showInputDialog("Phí ship:"));
                String tt = JOptionPane.showInputDialog("Trạng thái:");
                DonHang newDH = new DonHang(ma, ten, gia, phi, tt);
                Donhangs.add(newDH);
                insertDonHangToSQL(newDH);
                JOptionPane.showMessageDialog(this, "Tạo đơn gốc thành công!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Lỗi nhập liệu!"); }
        });

        btnThemDonGiao.addActionListener(e -> {
            try {
                int gui = Integer.parseInt(JOptionPane.showInputDialog("Index KH gửi (0-" + (KH.size()-1) + "):"));
                int nhan = Integer.parseInt(JOptionPane.showInputDialog("Index KH nhận (0-" + (KH.size()-1) + "):"));
                int ship = Integer.parseInt(JOptionPane.showInputDialog("Index Shipper (0-" + (Shippers.size()-1) + "):"));
                int don = Integer.parseInt(JOptionPane.showInputDialog("Index Đơn (0-" + (Donhangs.size()-1) + "):"));

                QuanLyDonHang q = new QuanLyDonHang();
                q.ThemDonHang(KH.get(gui), KH.get(nhan), Shippers.get(ship), Donhangs.get(don), "Da Them");
                ds.add(q);
                insertQuanLyDonHangToSQL(q);
                JOptionPane.showMessageDialog(this, "Thực hiện đơn giao thành công!");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Lỗi chỉ số hoặc nhập liệu!"); }
        });

        btnXemDon.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("DANH SÁCH ĐƠN:\n");
            for (QuanLyDonHang q : ds) sb.append(q.getMaDon() + " | Ship: " + q.getIDShipper() + " | " + q.getTrangThai() + "\n");
            showScroll(sb.toString());
        });
        btnXemShipper.addActionListener(e -> {
    if (Shippers.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Chưa có shipper!");
        return;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("----- DANH SÁCH SHIPPER -----\n");

    for (int i = 0; i < Shippers.size(); i++) {
        Shipper sp = Shippers.get(i);
        sb.append(i + 1).append(". ")
          .append("ID: ").append(sp.getID())
          .append(" | Tên: ").append(sp.getTen())
          .append("\n");
    }

    showScroll(sb.toString());
});

        btnTinhPhi.addActionListener(e -> {
            try {
                int g = Integer.parseInt(JOptionPane.showInputDialog("Index KH gửi:"));
                int n = Integer.parseInt(JOptionPane.showInputDialog("Index KH nhận:"));
                QuanLyDonHang q = new QuanLyDonHang();
                JOptionPane.showMessageDialog(this, "Phí: " + q.Phi(KH.get(g), KH.get(n)) + " VND");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Lỗi!"); }
        });

btnThongKe.addActionListener(e -> {
    if (ds.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Chưa có dữ liệu!");
        return;
    }

    ThongKe tk = new ThongKe(ds);

    JTextArea textArea = new JTextArea(tk.thongKeGUI());
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

    JOptionPane.showMessageDialog(
        this,
        new JScrollPane(textArea),
        "BÁO CÁO THỐNG KÊ",
        JOptionPane.INFORMATION_MESSAGE
    );
});
        btnThoat.addActionListener(e -> System.exit(0));
    }

    private void showScroll(String text) {
        JTextArea area = new JTextArea(text);
        JScrollPane sc = new JScrollPane(area);
        sc.setPreferredSize(new Dimension(450, 300));
        JOptionPane.showMessageDialog(this, sc);
    }
}

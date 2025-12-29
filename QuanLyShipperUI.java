package com.mycompany.quanlyshipper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class QuanLyShipperUI extends JFrame {
    JTable table;
    DefaultTableModel tableModel;
    ArrayList<KhachHang> KH = new ArrayList<>();
    ArrayList<Shipper> Shippers = new ArrayList<>();
    ArrayList<DonHang> Donhangs = new ArrayList<>();
    ArrayList<QuanLyDonHang> ds = new ArrayList<>();

    public QuanLyShipperUI() {
        setTitle("QUẢN LÝ SHIPPER");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData();
        initUI();

        setVisible(true);
    } 

    private void initData() {

    
    KhachHang kh1 = new KhachHang("KH01", "Nguyễn A", "0901", "HN", 5);
    KhachHang kh2 = new KhachHang("KH02", "Trần B", "0902", "HCM", 8);
    KH.add(kh1);
    KH.add(kh2);

    Shipper sp1 = new Shipper("SP01", "Shipper Nam", "0911");
    Shipper sp2 = new Shipper("SP02", "Shipper Hùng", "0922");
    Shippers.add(sp1);
    Shippers.add(sp2);

    DonHang dh1 = new DonHang("DH01", "Laptop", 10000000, 0, "Mới");
    DonHang dh2 = new DonHang("DH02", "Điện thoại", 8000000, 0, "Mới");
    Donhangs.add(dh1);
    Donhangs.add(dh2);

    QuanLyDonHang ql1 = new QuanLyDonHang();
    ql1.ThemDonHang(kh1, kh2, sp1, dh1, "Đang giao");

    QuanLyDonHang ql2 = new QuanLyDonHang();
    ql2.ThemDonHang(kh2, kh1, sp2, dh2, "Chưa giao");

    ds.add(ql1);
    ds.add(ql2);
    }

    private void initUI() {
        
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 15, 15));

    JButton btnXemDon = new JButton("Xem đơn hàng");
    JButton btnThemKH = new JButton("Thêm khách hàng");
    JButton btnLietKeShipper = new JButton("Liệt kê shipper");
    JButton btnThongKe = new JButton("Báo cáo thống kê");
    JButton btnThoat = new JButton("Thoát");

    panel.add(btnXemDon);
    panel.add(btnThemKH);
    panel.add(btnLietKeShipper);
    panel.add(btnThongKe);
    panel.add(btnThoat);

    add(panel, BorderLayout.CENTER);
btnXemDon.addActionListener(e -> {
    StringBuilder sb = new StringBuilder("DANH SÁCH ĐƠN HÀNG:\n");

    for (QuanLyDonHang q : ds) {
        sb.append("Mã đơn: ").append(q.getMaDon())
          .append(" | KH gửi: ").append(q.getIDKhachHangGui())
          .append(" | KH nhận: ").append(q.getIDKhachHangNhan())
          .append(" | Shipper: ").append(q.getIDShipper())
          .append(" | Trạng thái: ").append(q.getTrangThai())
          .append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
});
    btnThemKH.addActionListener(e -> {
        String id = JOptionPane.showInputDialog("Nhập ID KH:");
        String ten = JOptionPane.showInputDialog("Nhập tên:");
        String sdt = JOptionPane.showInputDialog("Nhập SĐT:");
        String dc = JOptionPane.showInputDialog("Nhập địa chỉ:");
        int kc = Integer.parseInt(
                JOptionPane.showInputDialog("Khoảng cách:")
        );

        KH.add(new KhachHang(id, ten, sdt, dc, kc));
        JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
    });
    btnLietKeShipper.addActionListener(e -> {
        StringBuilder sb = new StringBuilder("DANH SÁCH SHIPPER:\n");
        for (Shipper sp : Shippers) {
            sb.append(sp.getTen()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    });
    btnThongKe.addActionListener(e -> {
        ThongKe tk = new ThongKe(ds);
        tk.inThongKe(); 
    });
    btnThoat.addActionListener(e -> {
        System.exit(0);
    });
}

    }


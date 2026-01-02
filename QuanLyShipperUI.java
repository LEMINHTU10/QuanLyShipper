package com.mycompany.quanlyshipper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuanLyShipperUI extends JFrame {

    ArrayList<KhachHang> KH = new ArrayList<>();
    ArrayList<Shipper> Shippers = new ArrayList<>();
    ArrayList<DonHang> Donhangs = new ArrayList<>();
    ArrayList<QuanLyDonHang> ds = new ArrayList<>();

    public QuanLyShipperUI() {
        setTitle("QUẢN LÝ SHIPPER");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData();
        initUI();

        setVisible(true);
    }

    // DỮ LIỆU MẪU 
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

        QuanLyDonHang q1 = new QuanLyDonHang();
        q1.ThemDonHang(kh1, kh2, sp1, dh1, "Đang giao");
        ds.add(q1);
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JButton btnXemDon = new JButton("Xem đơn hàng");
        JButton btnThemKH = new JButton("Thêm khách hàng");
        JButton btnThemShipper = new JButton("Thêm shipper");
        JButton btnTaoDon = new JButton("Tạo đơn hàng");
        JButton btnThemDonGiao = new JButton("Thêm đơn cần giao");
        JButton btnTinhPhi = new JButton("Tính phí giao hàng");
        JButton btnThongKe = new JButton("Báo cáo thống kê");
        JButton btnThoat = new JButton("Thoát");

        panel.add(btnXemDon);
        panel.add(btnThemKH);
        panel.add(btnThemShipper);
        panel.add(btnTaoDon);
        panel.add(btnThemDonGiao);
        panel.add(btnTinhPhi);
        panel.add(btnThongKe);
        panel.add(btnThoat);

        add(panel);


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
            String id = JOptionPane.showInputDialog("ID KH:");
            String ten = JOptionPane.showInputDialog("Tên:");
            String sdt = JOptionPane.showInputDialog("SĐT:");
            String dc = JOptionPane.showInputDialog("Địa chỉ:");
            int kc = Integer.parseInt(JOptionPane.showInputDialog("Khoảng cách:"));

            KH.add(new KhachHang(id, ten, sdt, dc, kc));
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
        });

  
        btnThemShipper.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("ID shipper:");
            String ten = JOptionPane.showInputDialog("Tên shipper:");
            String sdt = JOptionPane.showInputDialog("SĐT:");

            Shippers.add(new Shipper(id, ten, sdt));
            JOptionPane.showMessageDialog(this, "Thêm shipper thành công!");
        });

 
        btnTaoDon.addActionListener(e -> {
            String ma = JOptionPane.showInputDialog("Mã đơn:");
            String tenHang = JOptionPane.showInputDialog("Tên hàng:");
            float gia = Float.parseFloat(JOptionPane.showInputDialog("Giá trị:"));
            float phi = Float.parseFloat(JOptionPane.showInputDialog("Phí ship:"));
            String tt = JOptionPane.showInputDialog("Trạng thái:");

            Donhangs.add(new DonHang(ma, tenHang, gia, phi, tt));
            JOptionPane.showMessageDialog(this, "Tạo đơn hàng thành công!");
        });


        btnThemDonGiao.addActionListener(e -> {
            int gui = Integer.parseInt(JOptionPane.showInputDialog("Chọn KH gửi (0-" + (KH.size()-1) + ")"));
            int nhan = Integer.parseInt(JOptionPane.showInputDialog("Chọn KH nhận (0-" + (KH.size()-1) + ")"));
            int ship = Integer.parseInt(JOptionPane.showInputDialog("Chọn shipper (0-" + (Shippers.size()-1) + ")"));
            int don = Integer.parseInt(JOptionPane.showInputDialog("Chọn đơn (0-" + (Donhangs.size()-1) + ")"));

            QuanLyDonHang q = new QuanLyDonHang();
            q.ThemDonHang(KH.get(gui), KH.get(nhan), Shippers.get(ship), Donhangs.get(don), "Đã thêm");
            ds.add(q);

            JOptionPane.showMessageDialog(this, "Thêm đơn cần giao thành công!");
        });


        btnTinhPhi.addActionListener(e -> {
            int gui = Integer.parseInt(JOptionPane.showInputDialog("Chọn KH gửi (0-" + (KH.size()-1) + ")"));
            int nhan = Integer.parseInt(JOptionPane.showInputDialog("Chọn KH nhận (0-" + (KH.size()-1) + ")"));

            QuanLyDonHang q = new QuanLyDonHang();
            float phi = q.Phi(KH.get(gui), KH.get(nhan));

            JOptionPane.showMessageDialog(this, "Phí giao hàng: " + phi + " VND");
        });


        btnThongKe.addActionListener(e ->  {
    ThongKe tk = new ThongKe(ds);
    String baoCao = tk.thongKeGUI();

    JTextArea textArea = new JTextArea(baoCao);
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
}

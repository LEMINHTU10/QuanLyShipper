public class QuanLyDonHang {
    private String MaDon;
    private String IDKhachHanggui;
    private String IDKhachHangnhan;
    private String IDShipper;
    private float TongTien;
    private float DoanhThu;

    void ThemDonHang(KhachHang khachHangGui, KhachHang khachHangNhan, Shipper shipper, DonHang donHang) {
        this.MaDon = donHang.getMaDon();
        this.IDKhachHanggui = khachHangGui.getID();
        this.IDKhachHangnhan = khachHangNhan.getID();
        this.IDShipper = shipper.getID();
        this.TongTien = donHang.TongTien()+(khachHangGui.getKhoangCach()+khachHangNhan.getKhoangCach())*3000;
        this.DoanhThu=this.TongTien*8/100;}
    public String getMaDon() {
    return MaDon;
}

public String getIDKhachHangGui() {
    return IDKhachHanggui;
}

public String getIDKhachHangNhan() {
    return IDKhachHangnhan;
}

public String getIDShipper() {
    return IDShipper;
}

public float getTongTien() {
    return TongTien;
}

public float getDoanhThu() {
    return DoanhThu;
}

}

package com.mycompany.quanlyshipper;

public class QuanLyDonHang {
    private String MaDon;
    private String IDKhachHanggui;
    private String IDKhachHangnhan;
    private String IDShipper;
    private float TongTien;
    private float DoanhThu;
    private String TrangThai;
    private float PhiGiaoHang;

    public float Phi(KhachHang khachHangGui, KhachHang khachHangNhan){
        this.PhiGiaoHang=(khachHangGui.getKhoangCach()+khachHangNhan.getKhoangCach())*3000;
        return PhiGiaoHang;
    }

    void ThemDonHang(KhachHang khachHangGui, KhachHang khachHangNhan, Shipper shipper, DonHang donHang, String TrangThai){
        this.MaDon = donHang.getMaDon();
        this.IDKhachHanggui = khachHangGui.getID();
        this.IDKhachHangnhan = khachHangNhan.getID();
        this.IDShipper = shipper.getID();
        this.TrangThai = TrangThai;
        this.TongTien = donHang.TongTien()+(khachHangGui.getKhoangCach()+khachHangNhan.getKhoangCach())*3000;
        this.DoanhThu = this.TongTien*8/100;
    }

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

    public String getTrangThai() {
        return TrangThai;
    }


    public void setMaDon(String MaDon) {
        this.MaDon = MaDon;
    }

    public void setIDKhachHanggui(String IDKhachHanggui) {
        this.IDKhachHanggui = IDKhachHanggui;
    }

    public void setIDKhachHangnhan(String IDKhachHangnhan) {
        this.IDKhachHangnhan = IDKhachHangnhan;
    }

    public void setIDShipper(String IDShipper) {
        this.IDShipper = IDShipper;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
}

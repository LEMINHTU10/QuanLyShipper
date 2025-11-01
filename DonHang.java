public class DonHang {
    private String MaDon;
    private String TenHang;
    private float GiaTri;
    private float PhiShip;
    private String TrangThai;

    // Constructor
    public DonHang(String MaDon, String TenHang, float GiaTri, float PhiShip, String TrangThai) {
        this.MaDon = MaDon;
        this.TenHang = TenHang;
        this.GiaTri = GiaTri;
        this.PhiShip = PhiShip;
        this.TrangThai = TrangThai;
    }

    // Getter & Setter
    public String getMaDon() {
        return MaDon;
    }

    public void setMaDon(String MaDon) {
        this.MaDon = MaDon;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public float getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(float GiaTri) {
        this.GiaTri = GiaTri;
    }

    public float getPhiShip() {
        return PhiShip;
    }

    public void setPhiShip(float PhiShip) {
        this.PhiShip = PhiShip;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    // Tính tổng tiền
    public float TongTien() {
        return GiaTri + PhiShip;
    }

    // In thông tin đơn hàng
    public void InRa() {
        System.out.println("Mã đơn: " + MaDon);
        System.out.println("Tên hàng: " + TenHang);
        System.out.println("Giá trị hàng: " + GiaTri);
        System.out.println("Phí ship: " + PhiShip);
        System.out.println("Tổng tiền: " + TongTien());
        System.out.println("Trạng thái: " + TrangThai);
    }
}

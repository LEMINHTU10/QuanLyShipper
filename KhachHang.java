
public class KhachHang extends Nguoi {
    private String DiaChi;
    private int KhoangCach;

    public KhachHang(String ID, String Ten, String SDT, String DiaChi, int KhoangCach) {
        super(ID, Ten, SDT);
        this.DiaChi = DiaChi;
        this.KhoangCach = KhoangCach;
    }

   

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public int getKhoangCach() {
        return KhoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.KhoangCach = khoangCach;
    }

  
    @Override
    public void InRa() {
    System.out.println("ID: " + getID());
    System.out.println("Tên: " + getTen());
    System.out.println("SĐT: " + getSDT());
    System.out.println("Địa chỉ: "+this.DiaChi );
    System.out.println("Địa chỉ: "+this.KhoangCach );
};
}


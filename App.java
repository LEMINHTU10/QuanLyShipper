import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<KhachHang> KH =new ArrayList<>();
        ArrayList<Shipper> Shipper =new ArrayList<>();
        ArrayList<DonHang> Donhang =new ArrayList<>();
        ArrayList<QuanLyDonHang> ds = new ArrayList<>();

        
        KhachHang gui1 = new KhachHang("KH01", "Nguyễn Văn A", "0909123123", "123 Nguyễn Huệ", 4);
        KhachHang nhan1 = new KhachHang("KH02", "Trần Thị B", "0909888777", "456 Lê Lợi", 6);
        Shipper sp1 = new Shipper("SP01", "Lê Văn C", "0909555666");
        DonHang don1 = new DonHang("DH01", "Áo sơ mi", 250000, 20000, "Đang giao");
        

        KhachHang gui2 = new KhachHang("KH03", "Phạm Minh D", "0909111222", "789 Hai Bà Trưng", 3);
        KhachHang nhan2 = new KhachHang("KH04", "Lý Thị E", "0911222333", "111 Nguyễn Trãi", 7);
        Shipper sp2 = new Shipper("SP02", "Trần Văn F", "0909777666");
        DonHang don2 = new DonHang("DH02", "Giày thể thao", 500000, 30000, "Hoàn thành");

        
        KhachHang gui3 = new KhachHang("KH05", "Ngô Văn G", "0911777888", "222 Điện Biên Phủ", 8);
        KhachHang nhan3 = new KhachHang("KH06", "Phạm Thị H", "0911333444", "333 Võ Thị Sáu", 5);
        DonHang don3 = new DonHang("DH03", "Điện thoại Samsung", 12000000, 50000, "Đang giao");

       
        KhachHang gui4 = new KhachHang("KH07", "Lưu Minh I", "0911444555", "99 Nguyễn Văn Linh", 2);
        KhachHang nhan4 = new KhachHang("KH08", "Trịnh Thị K", "0911666777", "555 Phan Đăng Lưu", 10);
        Shipper sp3 = new Shipper("SP03", "Đỗ Quốc L", "0909333222");
        DonHang don4 = new DonHang("DH04", "Laptop Dell", 15000000, 60000, "Hoàn thành");

        
        KhachHang gui5 = new KhachHang("KH09", "Huỳnh Anh M", "0911999000", "88 Pasteur", 1);
        KhachHang nhan5 = new KhachHang("KH10", "Bùi Văn N", "0911555666", "222 Nguyễn Thị Minh Khai", 12);
        Shipper sp4 = new Shipper("SP04", "Trần Văn K", "0909777666");
        DonHang don5 = new DonHang("DH05", "Bàn phím cơ", 900000, 25000, "Đã hủy");
        KH.add(nhan2);
        KH.add(gui2);
        KH.add(gui1);
        KH.add(nhan1);
        KH.add(nhan3);
        KH.add(gui3);
        Shipper.add(sp1);
        Shipper.add(sp2);
        Shipper.add(sp3);
        Shipper.add(sp4);
        Donhang.add(don1);
        Donhang.add(don2);
        Donhang.add(don3);
        Donhang.add(don4);
        Donhang.add(don5);

        

        // DANH SÁCH ĐƠN HÀNG 

        QuanLyDonHang q1 = new QuanLyDonHang();
        q1.ThemDonHang(gui1, nhan1, sp1, don1,"dang xu ly");
        ds.add(q1);

        QuanLyDonHang q2 = new QuanLyDonHang();
        q2.ThemDonHang(gui2, nhan2, sp2, don2,"dang xu ly");
        ds.add(q2);

        QuanLyDonHang q3 = new QuanLyDonHang();
        q3.ThemDonHang(gui3, nhan3, sp1, don3,"dang xu ly");
        ds.add(q3);

        QuanLyDonHang q4 = new QuanLyDonHang();
        q4.ThemDonHang(gui4, nhan4, sp3, don4,"dang xu ly");
        ds.add(q4);

        QuanLyDonHang q5 = new QuanLyDonHang();
        q5.ThemDonHang(gui5, nhan5, sp4, don5,"dang xu ly");
        ds.add(q5);

        int choice =-1;
        Scanner sc =new Scanner(System.in);
        while(choice !=0){
            System.out.println("===================MenU================");
            System.out.println("10.Xem don hang can giao\n20.Tao don hang\n21.Them don hang can giao\n22.Tinh phi giao hang\n30.Them khach hang\n31.Them shipper\n32.Tim kiem shipper \n33.Bao cao thong ke\n0.Thoat CT");
            choice = sc.nextInt();
        switch (choice){
        case 0:
            choice=0;
        break;
         case 30:
            System.out.println("Nhap ID:"); String IDKH=sc.nextLine();
            System.out.println("Nhap Ten"); String TenKH=sc.nextLine();
            System.out.println("Nhap SDT"); String SDTKH=sc.nextLine();
            System.out.println("Nhap DiaChi"); String DiaChiKH=sc.nextLine();
            System.out.println("KhoangCach"); int KhoangCachKH=sc.nextInt();
            KhachHang kh=new KhachHang(IDKH,TenKH,SDTKH,DiaChiKH,KhoangCachKH);
            KH.add(kh);
            
        break;
         case 31:
        System.out.println("Nhap ID:"); String IDSP=sc.nextLine();
        System.out.println("Nhap Ten"); String TenSP=sc.nextLine();
        System.out.println("Nhap SDT"); String SDTSP=sc.nextLine();
        Shipper sp=new Shipper( IDSP,TenSP,SDTSP);
        Shipper.add(sp);
        break;
        case 20:
        System.out.println("Nhap Ma Don:"); 
        String MaDon = sc.nextLine();

        System.out.println("Nhap Ten Hang:"); 
        String TenHang = sc.nextLine();

        System.out.println("Nhap Gia Tri:"); 
        float GiaTri = sc.nextFloat();

        System.out.println("Nhap Phi Ship:"); 
        float PhiShip = sc.nextFloat();

        sc.nextLine();

        System.out.println("Nhap Trang Thai:"); 
        String TrangThai = sc.nextLine();

        DonHang dh = new DonHang(MaDon, TenHang, GiaTri, PhiShip, TrangThai);
        Donhang.add(dh);       

        break;
       
        case 21:
       sc.nextLine(); 

    System.out.println(" Chon nguoi gui");
    for (int i = 0; i < KH.size(); i++) {
        System.out.println(i + "." + KH.get(i).getID());
    }
    int guiIndex = sc.nextInt();

    System.out.println("Chon nguoi nhan ");
    for (int i = 0; i < KH.size(); i++) {
        System.out.println(i + "." + KH.get(i).getID());
    }
    int nhanIndex = sc.nextInt();

    System.out.println(" Chon shipper ");
    for (int i = 0; i < Shipper.size(); i++) {
        System.out.println(i + "." + Shipper.get(i).getID());
    }
    int shipIndex = sc.nextInt();

    System.out.println("   Chon don hang:");
    for (int i = 0; i < Donhang.size(); i++) {
        System.out.println(i + "." + Donhang.get(i).getTenHang());
    }
    int donIndex = sc.nextInt();

    sc.nextLine();

    QuanLyDonHang q = new QuanLyDonHang();
    q.ThemDonHang(KH.get(guiIndex),KH.get(nhanIndex),Shipper.get(shipIndex),Donhang.get(donIndex),"Da Them");
   

    ds.add(q);
    System.out.println("Them don hang can giao thanh cong");

        break;
        case 22:
        System.out.println("Nhap nguoi gui");
        int IDgui ;
        for (int i = 0; i < KH.size(); i++) {
            System.out.println( i+"."+ KH.get(i).getID());  
        }
        IDgui=sc.nextInt();
        System.out.println(" Nhap nguoi nhan");
        int IDnhan ;
        for (int i = 0; i < KH.size(); i++) {
            System.out.println( i+"."+ KH.get(i).getID());  
        }
        IDnhan=sc.nextInt();
        QuanLyDonHang ql=new QuanLyDonHang();
        System.out.println(ql.Phi(KH.get(IDgui),KH.get(IDnhan)));
        break;
        case 32:

        break;
        case 33:
        ThongKe qldh=new ThongKe(ds);
        qldh.inThongKe();

        break;
        case 10:
        System.out.println("Cac don hang can giao");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println("Don so"+ (i+1) + "la:"+ds.get(i));
        }
        break;
        
      

        }
    }
}
}

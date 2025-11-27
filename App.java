
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyShipper {

    public static void main(String[] args) {
 
        ArrayList<KhachHang> KH =new ArrayList<>();
        ArrayList<Shipper> Shipper =new ArrayList<>();
        ArrayList<DonHang> Donhang =new ArrayList<>();
        ArrayList<QuanLyDonHang> ds = new ArrayList<>();

        
        KhachHang gui1 = new KhachHang("KH01", "Nguyen Van A", "0909123123", "123 Nguyen Hue", 4);
        KhachHang nhan1 = new KhachHang("KH02", "Tran Thi B", "0909888777", "456 Le Loi", 6);
        Shipper sp1 = new Shipper("SP01", "Le Van C", "0909555666");
        DonHang don1 = new DonHang("DH01", "Ao so mi", 250000, 20000, "Dang giao");

        KhachHang gui2 = new KhachHang("KH03", "Pham Minh D", "0909111222", "789 Hai Ba Trung", 3);
        KhachHang nhan2 = new KhachHang("KH04", "Ly Thi E", "0911222333", "111 Nguyen Trai", 7);
        Shipper sp2 = new Shipper("SP02", "Tran Van F", "0909777666");
        DonHang don2 = new DonHang("DH02", "Giay the thao", 500000, 30000, "Hoan thanh");

        KhachHang gui3 = new KhachHang("KH05", "Ngo Van G", "0911777888", "222 Dien Bien Phu", 8);
        KhachHang nhan3 = new KhachHang("KH06", "Pham Thi H", "0911333444", "333 Vo Thi Sau", 5);
        DonHang don3 = new DonHang("DH03", "Dien thoai Samsung", 12000000, 50000, "Dang giao");

        KhachHang gui4 = new KhachHang("KH07", "Luu Minh I", "0911444555", "99 Nguyen Van Linh", 2);
        KhachHang nhan4 = new KhachHang("KH08", "Trinh Thi K", "0911666777", "555 Phan Dang Luu", 10);
        Shipper sp3 = new Shipper("SP03", "Do Quoc L", "0909333222");
        DonHang don4 = new DonHang("DH04", "Laptop Dell", 15000000, 60000, "Hoan thanh");

        KhachHang gui5 = new KhachHang("KH09", "Huynh Anh M", "0911999000", "88 Pasteur", 1);
        KhachHang nhan5 = new KhachHang("KH10", "Bui Van N", "0911555666", "222 Nguyen Thi Minh Khai", 12);
        Shipper sp4 = new Shipper("SP04", "Tran Van K", "0909777666");
        DonHang don5 = new DonHang("DH05", "Ban phim co", 900000, 25000, "Da huy");

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
            System.out.println("10.Xem don hang can giao\n20.Tao don hang\n21.Them don hang can giao\n22.Tinh phi giao hang\n30.Them khach hang\n31.Them shipper\n32.Liet Ke shipper \n33.Bao cao thong ke\n0.Thoat CT");
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
            System.out.println("Cac Shipper: ");
            for (int i = 0; i < Shipper.size(); i++) {
                    System.out.println((i+1)+" "+Shipper.get(i).getTen());
            }

        break;
        case 33:
        ThongKe qldh=new ThongKe(ds);
        qldh.inThongKe();

        break;
        case 10:
        System.out.println("Cac don hang can giao");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println("Don so "+ (i+1) + " la: "+ds.get(i).getMaDon());
        }
        break;
        
      

        }
    }
}
    }


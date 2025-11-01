public class Shipper extends Nguoi {
 
    public Shipper(String ID, String Ten, String SDT) {
        super(ID, Ten, SDT);
       
    }
@Override
public void InRa() {
    System.out.println("ID: " + getID());
    System.out.println("Tên: " + getTen());
    System.out.println("SĐT: " + getSDT());
   
};

}

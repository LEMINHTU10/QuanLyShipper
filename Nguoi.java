
public class Nguoi {
    private String ID;
    private String Ten;
    private String SDT;

    public Nguoi(String ID, String Ten, String SDT) {
        this.ID = ID;
        this.Ten = Ten;
        this.SDT = SDT;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void InRa() {
    System.out.println("ID: " + ID);
    System.out.println("Tên: " + Ten);
    System.out.println("SĐT: " + SDT);
}

}




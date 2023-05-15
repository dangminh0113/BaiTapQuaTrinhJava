
public class MonHoc {
    private String tenMonHoc;
    private String maMon;
    private double diemTB;

    public MonHoc(String tenMonHoc, String maMon, double diemTB) {
        this.tenMonHoc = tenMonHoc;
        this.maMon = maMon;
        this.diemTB = diemTB;
    }

    public void getInfo() {
        System.out.print("Ten Mon Hoc : " + tenMonHoc + " | ");
        System.out.print("Ma Mon Hoc : " + maMon + " | ");
        System.out.print("Diem TB Mon Hoc : " + diemTB );
        System.out.println();
    }

    public double getDTB() {
        return diemTB;
    }
}

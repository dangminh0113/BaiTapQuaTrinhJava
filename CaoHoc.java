import java.util.LinkedList;
import java.util.Map;

public class CaoHoc extends HocVien {

    private String dh;
    private String ngayTN;
    private String vB;

    public CaoHoc() {
        super("", "", "", 0, 0);
        dh = "";
        ngayTN = "";
        vB = "";

    }


    public CaoHoc(CaoHoc sv) {
        super(sv.getMaHV(), sv.getHoTen(), sv.getSinhNhat(), sv.getNamHoc(), sv.getDiemDauVao());
        this.dh = sv.getDH();
        this.ngayTN = sv.getNgayTN();
        this.vB = sv.getVB();
    }


    public CaoHoc(String maHV, String hoTen, String sinhNhat, int namHoc, double diemDauVao, String dh, String ngayTN, String vB) {
        super(maHV, hoTen, sinhNhat, namHoc, diemDauVao);
        this.dh = dh;
        this.ngayTN = ngayTN;
        this.vB = vB;
    }

    public String getDH() {
        return dh;
    }

    public String getNgayTN() {
        return ngayTN;
    }

    public String getVB() {
        return vB;
    }

    @Override
    public void getKetQuaHocTap() {
        for (Map.Entry<Integer, LinkedList<MonHoc>> entry : dsMonHoc.entrySet()) {
            System.out.print("HOC KI " + entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {

                entry.getValue().get(i).getInfo();
            }
        }
    }

    @Override
    public String getCaoHocInfo(CaoHoc sv) {
        return "[Hoc Vien Cao Hoc " + sv.getHoTen() + " | MSSV : " + sv.getMaHV() + " | Ngay Sinh : "
                + sv.getSinhNhat() + " | Nam Hoc : " + sv.getNamHoc() + " | Diem Dau Vao : " + sv.getDiemDauVao()
                + " | Tot Nghiep DH : " + sv.getDH() + " | Ngay Tot Nghiep : " + sv.getNgayTN() + " | Ma Van Bang : " + sv.getVB() + "]";

    }

    @Override
    public String toString() {
        return "ChinhQuy [" + hoTen + " | MSSV : " + maHV + " | Ngay Sinh : " + sinhNhat + " | Nam Hoc : "
                + namHoc + " | Diem Dau Vao : " + diemDauVao + " | Tot Nghiep DH : " + getDH() + " | Ngay Tot Nghiep : " + getNgayTN() + " | Ma Van Bang : " + getVB() + "]";
    }

}

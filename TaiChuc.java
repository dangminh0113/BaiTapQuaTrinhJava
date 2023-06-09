import java.util.LinkedList;
import java.util.Map;

public class TaiChuc extends HocVien {

    private String lienket;

    public TaiChuc() {
        super("", "", "", 0, 0);
        lienket = "";
    }

    public TaiChuc(String maHV, String hoTen, String sinhNhat, int namHoc, double diemDauVao, String lienket) {
        super(maHV, hoTen, sinhNhat, namHoc, diemDauVao);
        this.lienket = lienket;
    }

    public TaiChuc(TaiChuc sv) {
        super(sv.getMaHV(), sv.getHoTen(), sv.getSinhNhat(), sv.getNamHoc(), sv.getDiemDauVao());
        this.lienket = sv.getLienKet();
    }

    public String getLienKet() {
        return lienket;
    }

    @Override
    public void getKetQuaHocTap() {

        for(Map.Entry<Integer, LinkedList<MonHoc>> entry : dsMonHoc.entrySet()) {
            System.out.println("HOC KI " + entry.getKey() + " : ");
            for (int i = 0; i < entry.getValue().size(); i++) {
                
                entry.getValue().get(i).getInfo();
            }
        }
    }

    @Override
    public String getTaiChucInfo(TaiChuc sv) {
        return "[Hoc Vien Tai Chuc " + sv.getHoTen() + " | MSSV : " + sv.getMaHV() + " | Ngay Sinh : "
                + sv.getSinhNhat() + " | Nam Hoc : " + sv.getNamHoc() + " | Diem Dau Vao : " + sv.getDiemDauVao()
                + " | Noi Lien Ket : " + sv.getLienKet() + "]";

    }

    @Override
    public String toString() {
        return "TaiChuc [" + hoTen + " | MSSV : " + maHV + " | Ngay Sinh : " + sinhNhat + " | Nam Hoc : "
                + namHoc + " | Diem Dau Vao : " + diemDauVao + " | Noi Lien Ket : " + lienket + "]";
    }

}

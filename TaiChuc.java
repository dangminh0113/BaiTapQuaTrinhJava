import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;

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

    public void getInfo() {

        for(Map.Entry<Integer, LinkedList<MonHoc>> entry : dsMonHoc.entrySet()) {
            System.out.println("HOC KI " + entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                
                entry.getValue().get(i).getInfo();
            }
        }

        /* for (int i = 1; i <= dsMonHoc.size(); i++) {
            Set<Map.Entry<Integer, LinkedList<MonHoc>>> set = dsMonHoc.entrySet();
            for (Map.Entry<Integer, LinkedList<MonHoc>> e : set) {
                System.out.println("HOC KI " + e.getKey() + " : ");
                for (int j = 0; j < e.getValue().size(); j++) {
                    e.getValue().get(i).getInfo();
                }
            }
        } */

    }

    public String getLienKet() {
        return lienket;
    }

    public String getTaiChucInfo(TaiChuc sv) {
        return "[Hoc Vien Tai Chuc " + sv.getHoTen() + " | MSSV : " + sv.getMaHV() + " | Ngay Sinh : "
                + sv.getSinhNhat() + " | Nam Hoc : " + sv.getNamHoc() + " | Diem Dau Vao : " + sv.getDiemDauVao()
                + " | Noi Lien Ket : " + sv.getLienKet() + "]";

    }

}

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class ChinhQuy extends HocVien {

    public ChinhQuy() {

    }

    public ChinhQuy(String maHV, String hoTen, String sinhNhat, int namHoc, double diemDauVao) {
        super(maHV, hoTen, sinhNhat, namHoc, diemDauVao);
    }

    public ChinhQuy(ChinhQuy tmp) {
        super(tmp);
    }

    public void getInfo() {
        for (Map.Entry<Integer, LinkedList<MonHoc>> entry : dsMonHoc.entrySet()) {
            System.out.print("HOC KI " + entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {

                entry.getValue().get(i).getInfo();
            }
        }
        /*
         * for (int i = 1; i <= dsMonHoc.size(); i++) {
         * Set<Map.Entry<Integer,LinkedList<MonHoc>>> set = dsMonHoc.entrySet();
         * for (Map.Entry<Integer, LinkedList<MonHoc>> e : set) {
         * System.out.println("HOC KI " + e.getKey() + " : ");
         * for (int j = 0; j < e.getValue().size(); j++) {
         * e.getValue().get(i).getInfo();
         * }
         * }
         * }
         */

    }

    public String getChinhQuyInfo(ChinhQuy sv) {
        return "[Hoc Vien Chinh Quy " + sv.getHoTen() + " | MSSV : " + sv.getMaHV() + " | Ngay Sinh : "
                + sv.getSinhNhat() + " | Nam Hoc : " + sv.getNamHoc() + " | Diem Dau Vao : " + sv.getDiemDauVao()
                + " ]";
    }

}

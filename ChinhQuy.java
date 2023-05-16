import java.util.LinkedList;
import java.util.Map;

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
    }

    public String getChinhQuyInfo(ChinhQuy sv) {
        return "[Hoc Vien Chinh Quy " + sv.getHoTen() + " | MSSV : " + sv.getMaHV() + " | Ngay Sinh : "
                + sv.getSinhNhat() + " | Nam Hoc : " + sv.getNamHoc() + " | Diem Dau Vao : " + sv.getDiemDauVao()
                + " ]";
    }

    @Override
    public String toString() {
        return "ChinhQuy [" + hoTen + " | MSSV : " + maHV + " | Ngay Sinh : " + sinhNhat + " | Nam Hoc : "
                + namHoc + " | Diem Dau Vao : " + diemDauVao + " ]";
    }

}

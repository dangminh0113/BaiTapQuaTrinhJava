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
    public String getChinhQuyInfo(ChinhQuy sv) {
        return "HOC VIEN CHINH QUY | Ho Va Ten : " + hoTen + " | MSSV : " + maHV + " | Ngay Sinh : " + sinhNhat + " | Nam Hoc : "
        + namHoc + " | Diem Dau Vao : " + diemDauVao + " ]";
    }

    @Override
    public String toString() {
        return "ChinhQuy [" + hoTen + " | MSSV : " + maHV + " | Ngay Sinh : " + sinhNhat + " | Nam Hoc : "
                + namHoc + " | Diem Dau Vao : " + diemDauVao + " ]";
    }

}

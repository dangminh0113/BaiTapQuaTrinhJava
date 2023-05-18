
import java.util.LinkedList;
import java.util.HashMap;

public class HocVien {
  // cac dac diem chung cua 3 class
  protected String maHV;
  protected String hoTen;
  protected String sinhNhat;
  protected int namHoc;
  protected double diemDauVao;

  protected HashMap<Integer, LinkedList<MonHoc>> dsMonHoc = new HashMap<Integer, LinkedList<MonHoc>>();

  // gia su co MonHoc : "BLA BLA", 0123, 7.5
  // la se co dang dsMonHoc.get(hocki).addMonHoc(blabla);
  // vay la hoc ki dau co mon bla bla

  protected HashMap<Integer, Double> kqht = new HashMap<Integer, Double>();

  // la se co dang kqht.get(hocki).get(dtb)

  public HocVien() {

  }

  public HocVien(String maHV, String hoTen, String sinhNhat, int namHoc, double diemDauVao) {
    setMaHV(maHV);
    setHoTen(hoTen);
    setSinhNhat(sinhNhat);
    setNamHoc(namHoc);
    setDiemDauVao(diemDauVao);
  }

  public HocVien(HocVien hv) {
    setMaHV(hv.maHV);
    setHoTen(hv.hoTen);
    setSinhNhat(hv.sinhNhat);
    setNamHoc(hv.namHoc);
    setDiemDauVao(hv.diemDauVao);
  }

  // CAC HAM GETTER, SETTER
  public String getMaHV() {
    return maHV;
  }

  public String getHoTen() {
    return hoTen;
  }

  public String getSinhNhat() {
    return sinhNhat;
  }

  public int getNamHoc() {
    return namHoc;
  }

  public double getDiemDauVao() {
    return diemDauVao;
  }

  public void setMaHV(String maHV) {
    this.maHV = maHV;
  }

  public void setHoTen(String hoTen) {
    this.hoTen = hoTen;
  }

  public void setSinhNhat(String sinhNhat) {
    this.sinhNhat = sinhNhat;
  }

  public void setNamHoc(int namHoc) {
    this.namHoc = namHoc;
  }

  public void setDiemDauVao(double diemDauVao) {
    this.diemDauVao = diemDauVao;
  }

  // them hoc ki (key) va LinkedList MonHoc (empty) vao trong HASH MAP dsMonHoc
  private void addHocki(int hocki) {
    LinkedList<MonHoc> mh = new LinkedList<MonHoc>();
    dsMonHoc.put(hocki, mh);
  }

  public void printMonHocInfo() {
    for (int i = 0; i < dsMonHoc.size(); i++) {
      if (dsMonHoc.containsKey(i)) {
        for (int j = 0; j < dsMonHoc.get(i).size(); j++) {
          dsMonHoc.get(i).get(j).getInfo();
        }
      }
      else continue;
    }
  }

  public void addMonHoc(int hocki, MonHoc mon) {
    if (dsMonHoc.containsKey(hocki) == false) {
      addHocki(hocki);
    }
    dsMonHoc.get(hocki).add(mon);
  }

  public void addDiemHocKi(int hocki) {

    double sum = 0;
    int deno = 0;
    for (int i = 0; i < dsMonHoc.get(hocki).size(); i++) {
      sum += dsMonHoc.get(hocki).get(i).getDTB();
      deno++;
    }

    sum /= deno;
    kqht.put(hocki, sum);
  }

  public void xoaMonHoc(int hocki) {
    dsMonHoc.get(hocki).removeAll(null);
  }

  public void suaDiemHocKi(int hocki) {
    double sum = 0;
    int deno = 0;
    for (int i = 0; i < dsMonHoc.get(hocki).size(); i++) {
      sum += dsMonHoc.get(hocki).get(i).getDTB();
      deno++;
    }

    sum /= deno;
    kqht.put(hocki, sum);
  }

  public double xuatDTB(int hocki) {
    return kqht.get(hocki);
  }

  public boolean compareHocKi(int hocki) {
    if (dsMonHoc.containsKey(hocki)) return true;
    return false;
  }

  public String getChinhQuyInfo(ChinhQuy sv) {
    return "";
  }

  public String getTaiChucInfo(TaiChuc sv) {
    return "";
  }

  public String getCaoHocInfo(CaoHoc sv) {
    return "";
  }

  public void getKetQuaHocTap() {

  }

}
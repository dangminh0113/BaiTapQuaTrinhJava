import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Khoa {
    String tenKhoa;
    protected ArrayList<HocVien> hv = new ArrayList<HocVien>();

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void addHocVien(HocVien sv) {
        if (sv instanceof ChinhQuy) {
            ChinhQuy tmp = (ChinhQuy) sv;
            hv.add(tmp);
        }
        if (sv instanceof TaiChuc) {
            TaiChuc tmp = (TaiChuc) sv;
            hv.add(tmp);
        }

    }

    public int updateHocVien(String mssv) {
        for (int i = 0; i < hv.size(); i++) {
            if (hv.get(i).getMaHV().compareToIgnoreCase(mssv) == 0) {
                Scanner sc = new Scanner(System.in);
                String name = "";
                String hoTen = "";
                String snhat = "";
                int namHoc = 0;
                double diemDauVao = 0;
                int type = 0;
                int err = 0;
                while (err == 0) {
                    try {
                        sc = new Scanner(System.in);
                        System.out.println("Bat Dau Cap Nhat Thong Tin ... ");
                        System.out.print("Nhap Vao Ma So Sinh Vien : ");
                        name = sc.next();
                        System.out.print("Nhap Vao Ho Va Ten : ");
                        hoTen = sc.next();
                        hoTen = hoTen.concat(sc.nextLine());
                        System.out.print("Nhap Vao Sinh Nhat : ");
                        snhat = sc.next();
                        System.out.print("Nhap Vao Nam Hoc : ");
                        namHoc = sc.nextInt();
                        System.out.print("Nhap Vao Diem Dau Vao : ");
                        diemDauVao = sc.nextDouble();
                        System.out
                                .print("Sinh Vien Thuoc Loai Nao ? : 1. Chinh Quy --- 2. Tai Chuc : --- 3. Cao Hoc :");
                        type = sc.nextInt();
                        err = 1;
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Ban Da Nhap Sai Kieu Du Lieu, Moi Ban Nhap Lai Tu Dau !");
                    }
                }
                if (type == 1) {
                    ChinhQuy tmptChinhQuy = new ChinhQuy(name, hoTen, snhat, namHoc, diemDauVao);
                    hv.set(i, tmptChinhQuy);
                }
                if (type == 2) {
                    System.out.println("Hoc Vien Thuoc Dang Tai Chuc, Moi Ban Nhap Vao Noi Lien Ket : ");
                    String lienKet = sc.next();
                    TaiChuc tmptTaiChuc = new TaiChuc(name, hoTen, snhat, namHoc, diemDauVao, lienKet);
                    hv.set(i, tmptTaiChuc);
                }
                if (type == 3) {
                    System.out.println("Hoc Vien Thuoc Dang Cao Hoc, Moi Ban Tiep Tuc Bo Sung Thong tin : ");
                    System.out.print("Nhap Vao Truong Dai Hoc Da Tot Nghiep : ");
                    String dh = sc.next();
                    dh = dh.concat(sc.nextLine());
                    System.out.print("Nhap Vao Ngay Tot Nghiep Dai Hoc : ");
                    String ngayTN = sc.next();
                    ngayTN = ngayTN.concat(sc.nextLine());
                    System.out.print("Nhap Vao Ma Van Bang : ");
                    String vB = sc.next();
                    CaoHoc tmptCaoHoc = new CaoHoc(name, hoTen, snhat, namHoc, diemDauVao, dh, ngayTN, vB);
                    hv.set(i, tmptCaoHoc);
                }
                return 1;
            }
        }
        System.out.println("Cap Nhat Thong Tin Hoc Vien That Bai !");
        return 0;
    }

    public void printHocVien() {
        for (int i = 0; i < hv.size(); i++) {
            System.out.println("---Bat Dau Xuat Danh Sach Sinh Vien ---");

            if (hv.get(i) instanceof ChinhQuy) {
                ChinhQuy tmp = (ChinhQuy) hv.get(i);
                System.out.println(tmp.getChinhQuyInfo(tmp));
            }
            if (hv.get(i) instanceof TaiChuc) {
                TaiChuc tmp = (TaiChuc) hv.get(i);
                System.out.println(tmp.getTaiChucInfo(tmp));
            }
            if (hv.get(i) instanceof CaoHoc) {
                CaoHoc tmp = (CaoHoc) hv.get(i);
                System.out.println(tmp.getCaoHocInfo(tmp));
            }
        }
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void getDsHocVien() {
        for (int i = 0; i < hv.size(); i++)
            System.out.println(hv.get(i).toString() + " | Khoa : " + tenKhoa);

    }

    public HocVien maxDTB() {
        HocVien max = hv.get(0);
        for (int i = 1; i < hv.size(); i++)
            if (max.getDiemDauVao() < hv.get(i).diemDauVao)
                max = hv.get(i);

        return max;
    }

}

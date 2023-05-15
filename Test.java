import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------MENU QUAN LY SINH VIEN----------");
        System.out.println("---1. Danh Sach Hoc Vien---");
        System.out.println("---2. Xem Chi Tiet Thong Tin Hoc Vien---");
        System.out.println("---3. Them Hoc Vien---");
        System.out.println("---4. Cap Nhat Hoc Vien---");
        System.out.println("---5. Them Danh Sach Mon Hoc---");
        System.out.println("---6. Thoat Chuong Trinh---");

        ArrayList<Khoa> khoa = new ArrayList<Khoa>();
        int out = 0;
        do {

            System.out.print("Moi Ban Nhap Lua Chon : ");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Nhap Ten Khoa Muon Hien Danh Sach : ");
                    String tenKhoa = sc.next();
                    tenKhoa = tenKhoa.concat(sc.nextLine());
                    int check = 0;
                    for (int i = 0; i < khoa.size(); i++)
                        if (khoa.get(i).getTenKhoa().compareToIgnoreCase(tenKhoa) == 0) {
                            khoa.get(i).printHocVien();
                            check = 1;
                        }

                    if (check == 1)
                        break;

                    Khoa tmp = new Khoa(tenKhoa);
                    khoa.add(tmp);
                    int index = khoa.indexOf(tmp);
                    System.out.println("Khoa " + khoa.get(index).getTenKhoa() + " La Khoa Moi Nen Chua Co Sinh Vien");
                    break;

                case 2:
                    System.out.println("Moi Ban Nhap Ma Hoc Vien : ");
                    String mssv = sc.next();
                    for (int i = 0; i < khoa.size(); i++) {
                        for (int j = 0; j < khoa.get(i).hv.size(); j++) {
                            if (khoa.get(i).hv.get(j).getMaHV().compareToIgnoreCase(mssv) == 0) {

                                if (khoa.get(i).hv.get(j) instanceof ChinhQuy) {
                                    ChinhQuy cqtmp = (ChinhQuy) khoa.get(i).hv.get(j);
                                    System.out.println(khoa.get(i).hv.get(j).getChinhQuyInfo(cqtmp) + "|");
                                    khoa.get(i).hv.get(j).getInfo();
                                    break;
                                }

                                if (khoa.get(i).hv.get(j) instanceof TaiChuc) {
                                    TaiChuc tctmp = (TaiChuc) khoa.get(i).hv.get(j);
                                    System.out.println(khoa.get(i).hv.get(j).getTaiChucInfo(tctmp));
                                    khoa.get(i).hv.get(j).getInfo();
                                    break;
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Bat Dau Them Hoc Vien :");
                    System.out.print("Ban Muon Them Sinh Vien Vao Khoa Nao ? :");
                    String addTenKhoa = sc.next();
                    for (int i = 0; i < khoa.size(); i++) {
                        if (khoa.get(i).getTenKhoa().compareToIgnoreCase(addTenKhoa) == 0) {
                            check = 0;
                            System.out.print("Nhap Vao Ma So Sinh Vien : ");
                            String name = sc.next();
                            for (int j = 0; j < khoa.get(i).hv.size(); j++) {
                                if (khoa.get(i).hv.get(j).getMaHV().compareToIgnoreCase(name) == 0) {
                                    System.out.println("MSSV NAY Da BI TRUNG, MOI BAN NHAP LAI");
                                    check = 1;
                                }
                            }
                            if (check == 1)
                                break;
                            System.out.print("Nhap Vao Ho Va Ten : ");
                            String hoTen = sc.next();
                            hoTen = hoTen.concat(sc.nextLine());
                            System.out.print("Nhap Vao Sinh Nhat : ");
                            String snhat = sc.next();
                            System.out.print("Nhap Vao Nam Hoc : ");
                            int namHoc = sc.nextInt();
                            System.out.print("Nhap Vao Diem Dau Vao : ");
                            double diemDauVao = sc.nextDouble();
                            System.out.print("Sinh Vien Thuoc Loai Nao ? : 1. Chinh Quy --- 2. Tai Chuc : ");
                            int type = sc.nextInt();
                            if (type == 1) {
                                ChinhQuy tmptChinhQuy = new ChinhQuy(name, hoTen, snhat, namHoc, diemDauVao);
                                khoa.get(i).addHocVien(tmptChinhQuy);
                            }
                            if (type == 2) {
                                System.out.println("Hoc Vien Thuoc Dang Tai Chuc, Moi Ban Nhap Vao Noi Lien Ket : ");
                                String lienKet = sc.next();
                                TaiChuc tmptTaiChuc = new TaiChuc(name, hoTen, snhat, namHoc, diemDauVao, lienKet);
                                khoa.get(i).addHocVien(tmptTaiChuc);
                            }
                            if (type == 3) {
                                System.out
                                        .println("Hoc Vien Thuoc Dang Cao Hoc, Moi Ban Tiep Tuc Bo Sung Thong tin : ");
                                System.out.print("Nhap Vao Truong Dai Hoc Da Tot Nghiep : ");
                                String dh = sc.next();
                                dh = dh.concat(sc.nextLine());
                                System.out.print("Nhap Vao Ngay Tot Nghiep Dai Hoc : ");
                                String ngayTN = sc.next();
                                ngayTN = ngayTN.concat(sc.nextLine());
                                System.out.print("Nhap Vao Ma Van Bang : ");
                                String vB = sc.next();
                                CaoHoc tmptCaoHoc = new CaoHoc(name, hoTen, snhat, namHoc, diemDauVao, dh, ngayTN, vB);
                                khoa.get(i).addHocVien(tmptCaoHoc);
                            }
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nhap Ma Hoc Vien Ban Muon Cap Nhat : ");
                    String updateHV = sc.next();
                    for (int i = 0; i < khoa.size(); i++) {
                        int res = khoa.get(i).updateHocVien(updateHV);
                        if (res == 0)
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Nhap Ma Hoc Vien Ban Muon Cap Nhat : ");
                    String updateHVByFile = sc.next();
                    System.out.println("Nhap Vao Hoc Ky Ban Muon Chinh Sua : ");
                    int hk5 = sc.nextInt();
                    System.out.println("Nhap Vao Ten File Ban Muon Su Dung : ");
                    String tenFile = sc.next();
                    BufferedReader input = new BufferedReader(new FileReader(tenFile));
                    String str;
                    for (int i = 0; i < khoa.size(); i++) {
                        for (int j = 0; j < khoa.get(i).hv.size(); j++) {
                            if (khoa.get(i).hv.get(j).getMaHV().compareTo(updateHVByFile) == 0) {
                                if (khoa.get(i).hv.get(j).compareHocKi(hk5)) {
                                    khoa.get(i).hv.get(j).xoaMonHoc(hk5);
                                }
                            }
                        }
                    }

                    do {
                        str = input.readLine();
                        if (str == null)
                            break;
                        String[] info = str.split(" ");
                        String tenMonHoc = info[0];
                        String maMon = info[1];
                        double diemTB = Double.parseDouble(info[2]);
                        MonHoc monHocTmp = new MonHoc(tenMonHoc, maMon, diemTB);
                        for (int i = 0; i < khoa.size(); i++) {
                            for (int j = 0; j < khoa.get(i).hv.size(); j++) {
                                if (updateHVByFile.compareToIgnoreCase(khoa.get(i).hv.get(j).getMaHV()) == 0) {

                                    khoa.get(i).hv.get(j).addMonHoc(hk5, monHocTmp);
                                    khoa.get(i).hv.get(j).addDiemHocKi(hk5);
                                    break;

                                }
                            }
                        }
                    } while (true);
                    System.out.println("Da Cap Nhat Xong !!!");
                    break;
                case 6:
                    out = 1;
                    System.out.println("Chuong trinh ket thuc !!!");
                    break;
            }
        } while (out != 1);

        sc.close();

    }
}

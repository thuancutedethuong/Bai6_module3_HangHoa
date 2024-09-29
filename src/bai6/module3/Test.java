package bai6.module3;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        DanhSachHangHoa dshh = new DanhSachHangHoa(100);

        HangDienMay emp1 = new HangDienMay("A101", "Máy lạnh", 1000.0, 1,12,12);
        HangThucPham emp2 = new HangThucPham("A102", "Cá", 100.0, 4,"Bach Hoa Xanh", LocalDate.of(2023,9,2),LocalDate.of(2024,10,1));
        HangSanhSu emp3 = new HangSanhSu("A103", "Bình thủy tinh", 1050.0, 2,"Samsung",LocalDate.of(2022,8,3));

        dshh.themHangHoa(emp1);
        dshh.themHangHoa(emp2);
        dshh.themHangHoa(emp3);

        int choice = 0;

        do{
//            int choice;
            System.out.println("=======MENU=======");
            System.out.println("1. Thêm một hàng hóa vào danh sách.");
            System.out.println("2. Lấy thông tin toàn bộ danh sách các hàng hóa.");
            System.out.println("3. Lấy thông tin từng loại hàng hóa.");
            System.out.println("4. Tìm kiếm hàng hóa khi biết mã hàng.");
            System.out.println("5. Sắp xếp hàng hóa theo tên hàng tăng dần.");
            System.out.println("6. Sắp xếp hàng hóa theo số lượng tồn giảm dần.");
            System.out.println("7. Lấy thông tin các hàng thực phẩm khó bán.");
            System.out.println("8. Sửa thông tin đơn giá của hàng hóa khi biết mã hàng.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Hãy chọn: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    themHangHoa(dshh, sc );
                    break;
                case 2:
                    dshh.getThongTinToanBo();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Hãy nhập loại hàng hóa(thucpham/dienmay/sanhsu): ");
                    String loaiHangHoa = sc.nextLine();
                    if(loaiHangHoa.equalsIgnoreCase("thucpham"))
                        dshh.getThongTinTungLoai(HangThucPham.class);
                    else if(loaiHangHoa.equalsIgnoreCase("dienmay"))
                        dshh.getThongTinTungLoai(HangDienMay.class);
                    else if(loaiHangHoa.equalsIgnoreCase("sanhsu"))
                        dshh.getThongTinTungLoai(HangSanhSu.class);
                    else
                        System.out.println("Loại hàng hóa không hợp lệ.");
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Nhập mã hàng hóa cần tìm: ");
                    String needID = sc.nextLine();
                    HangHoa foundItem = dshh.findHangHoaByID(needID);

                    if(foundItem != null){
                        System.out.println(foundItem);
                    }else
                        System.out.println("Không tìm thấy hàng hóa với mã: " + needID);
                    break;
                case 5:
                    dshh.sapXepHangHoaTenTangDan();
                    System.out.println("Đã sắp xếp theo tên hàng tăng dần.");
                    break;
                case 6:
                    dshh.sapXepHangHoaSlTonGiamDan();
                    System.out.println("Đã sắp xếp theo số lượng tồn giảm dần.");
                    break;
                case 7:
                    dshh.getCacThucPhamKhoBan();
                    break;
                case 8:
                    sc.nextLine();
                    System.out.println("Nhập mã hàng hóa cần sửa: ");
                    String MODIFYid = sc.nextLine();
                    System.out.println("Nhập đơn giá mới cho sản phẩm: ");
                    double dgia = sc.nextDouble();
                    dshh.suaDonGiaTheoID(MODIFYid,dgia);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lê. Vui lòng nhập lại.");
            }

        }while(choice != 0);
    }

    private static void themHangHoa(DanhSachHangHoa dshh, Scanner sc){
        System.out.println("Chọn loại hàng hóa để thêm: ");
        System.out.println("1. Hàng thực phẩm");
        System.out.println("2. Hàng điện máy");
        System.out.println("3. Hàng sành sứ");
        int loaiHang = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhập mã hàng: ");
        String maHang = sc.nextLine();
        System.out.println("Nhập tên hàng: ");
        String tenHang = sc.nextLine();
        System.out.println("Nhập đơn giá: ");
        Double donGia = sc.nextDouble();
        System.out.println("Nhập số lượng tồn: ");
        int soLuongTon = sc.nextInt();
        sc.nextLine();
        switch(loaiHang){
            case 1:
                System.out.println("Nhập nhà cung cấp: ");
                String nhaCungCap = sc.nextLine();
                System.out.println("Nhập ngày sản xuất(yyyy-mm-dd): ");
                LocalDate ngaySanXuat = LocalDate.parse(sc.nextLine());
                System.out.println("Nhập ngày hết hạn(yyyy-mm-dd): ");
                LocalDate ngayHetHan = LocalDate.parse(sc.nextLine());
                HangThucPham hangThucPham = new HangThucPham(maHang,tenHang,donGia,soLuongTon,nhaCungCap,ngaySanXuat,ngayHetHan);
                dshh.themHangHoa(hangThucPham);
                break;
            case 2:
                System.out.println("Nhập thời gian bảo hành(tháng): ");
                int thoiGianBaoHanh = sc.nextInt();
                System.out.println("Nhập công suất(KW): ");
                double congSuat = sc.nextDouble();
                HangDienMay hangDienMay = new HangDienMay(maHang,tenHang,donGia,soLuongTon,thoiGianBaoHanh,congSuat);
                dshh.themHangHoa(hangDienMay);
                break;
            case 3:
                System.out.println("Nhập nhà sản xuất: ");
                String nhaSanXuat = sc.nextLine();
                System.out.println("Nhập ngày nhập kho: ");
                LocalDate ngayNhapKho = LocalDate.parse(sc.nextLine());
                HangSanhSu hangSanhSu = new HangSanhSu(maHang,tenHang,donGia,soLuongTon,nhaSanXuat,ngayNhapKho);
                dshh.themHangHoa(hangSanhSu);
                break;
            default:
                System.out.println("Loại hàng không hợp lệ.");
                break;
        }

    }
}

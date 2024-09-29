package bai6.module3;

import java.util.Arrays;

public class DanhSachHangHoa {
    private HangHoa[] dshh;
    private int count = 0;

    public DanhSachHangHoa(int n){
        if(n < 0)
            throw new RuntimeException("Mảng rỗng");
        this.dshh = new HangHoa[n];
    }

    public HangHoa[] themHangHoa(HangHoa hanghoa){
        if(hanghoa == null)
            throw new RuntimeException("Mảng không được rỗng");

        for(int i = 0; i < count ; i++){
//            HangHoa temp = dshh[i];
            if(dshh[i].getMaHang().equalsIgnoreCase(hanghoa.getMaHang()))
                throw new RuntimeException("Trùng mã");
        }
        dshh[count++] = hanghoa;
        return null;
    }

    public void getThongTinToanBo(){
        for(int i = 0; i < count ; i++){
            System.out.println(dshh[i]);
        }
    }

    public void getThongTinTungLoai(Class<?> loaiHangHoa){
        for(int i = 0; i < count ; i++){
            if(loaiHangHoa.isInstance(dshh[i])){
                System.out.println(dshh[i]);
            }
        }
    }

    public HangHoa findHangHoaByID(String ID){
        for(int i = 0; i < count ; i++){
            if(dshh[i].getMaHang().equalsIgnoreCase(ID))
                return dshh[i];
        }
        return null;
    }

    public void sapXepHangHoaTenTangDan(){
        Arrays.sort(dshh,0,count,(h1,h2) -> h1.getTenHang().compareTo(h2.getTenHang()));
    }

    public void sapXepHangHoaSlTonGiamDan(){
        Arrays.sort(dshh,0,count,(h1,h2) -> Integer.compare(h2.getSlTon(), h1.getSlTon()));
    }

    public void getCacThucPhamKhoBan(){
        boolean found = false;
        for(int i = 0; i < count ; i++){
            if(dshh[i] instanceof HangThucPham && "khó bán".equals(dshh[i].getMucDo())){
                System.out.println(dshh[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có thực phẩm nào khó bán."); // Thông báo nếu không tìm thấy
        }
    }

    public boolean xoaHangHoa(String ID){
        for(int i = 0 ; i < count ; i++){
            if(dshh[i].getMaHang().equalsIgnoreCase(ID))
                for(int j = i ; j < count - 1 ; j++){
                    dshh[j] = dshh[j + 1];
                }
            dshh[count - 1] = null;
            count--;
            return true;
        }
        System.out.println("Không tìm thấy mã hàng hóa để xóa!");
        return false;
    }

    public boolean suaDonGiaTheoID(String ID, double donGiaMoi){
        HangHoa hanghoa = findHangHoaByID(ID);
        if(hanghoa != null){
            hanghoa.setDonGia(donGiaMoi);
            return true;
        }
        System.out.println("Không tìm thấy mãm hàng để sửa");
        return false;
    }
}

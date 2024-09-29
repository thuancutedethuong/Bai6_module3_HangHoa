package bai6.module3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa{
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(){
        this("","",0.0,0,"",LocalDate.now());
    }

    public HangSanhSu(String maHang, String tenHang, double donGia, int slTon, String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, donGia, slTon);
        this.setNhaSanXuat(nhaSanXuat);
        this.setNgayNhapKho(ngayNhapKho);
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        if(nhaSanXuat == null || nhaSanXuat.trim().length()==0)
            throw new RuntimeException("Nhà sản xuất không được rỗng");
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if(ngayNhapKho.isAfter(LocalDate.now()))
            throw new RuntimeException("Ngầy nhập kho phải trước ngày hiện tại");
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String getMucDo() {
        long tgLuuKho = ChronoUnit.DAYS.between(ngayNhapKho,LocalDate.now());
        if(getSlTon() > 50 && tgLuuKho > 10){
            return "bán chậm";
        }
        return null;
    }

    @Override
    public double getVAT() {
        return getDonGia() * 0.1;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " | " + nhaSanXuat
                                + " | " + dtf.format(ngayNhapKho);
    }
}

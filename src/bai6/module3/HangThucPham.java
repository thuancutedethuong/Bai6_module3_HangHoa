package bai6.module3;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa{
    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(){
        this("","",0.0,0,"",LocalDate.now(),LocalDate.now());
    }

    public HangThucPham(String maHang, String tenHang, double donGia, int slTon, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        super(maHang, tenHang, donGia, slTon);
        this.setNhaCungCap(nhaCungCap);
        this.setNgaySanXuat(ngaySanXuat);
        this.setNgayHetHan(ngayHetHan);
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        if(nhaCungCap == null || nhaCungCap.trim().length()==0)
            throw new RuntimeException("Nhà cung cấp không được rỗng");
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if(ngaySanXuat.isAfter(LocalDate.now()))
            throw new RuntimeException("Ngày sản xuất phải trước ngày hiện tại");
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if(ngayHetHan.isBefore(ngaySanXuat))
            throw new RuntimeException("Ngày hết hạn phải sau ngày sản xuất");
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String getMucDo() {
        if(getSlTon() > 0 && LocalDate.now().isAfter(ngayHetHan))
            return "khó bán";
        return "không đánh giá";
    }

    @Override
    public double getVAT() {
        return getDonGia() * 0.05;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return super.toString() + " | " + nhaCungCap
                                + " | " + dtf.format(ngaySanXuat)
                                + " | " + dtf.format(ngayHetHan);
    }
}

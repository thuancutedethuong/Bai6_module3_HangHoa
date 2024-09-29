package bai6.module3;

public abstract class HangHoa {
    private final String maHang;
    private String tenHang;
    private double donGia;
    private int slTon;

    public HangHoa() {
        this("xxx","",0.0,0);
    }

    public HangHoa(String maHang, String tenHang, double donGia, int slTon) {
        this.maHang = maHang;
        this.setTenHang(tenHang);
        this.setDonGia(donGia);
        this.setSlTon(slTon);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if(tenHang == null || tenHang.trim().length()==0)
            throw new RuntimeException("Tên hàng không được để trống");
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if(donGia < 0)
            throw new RuntimeException("Đơn giá phải lớn hơn hoặc bằng 0");
        this.donGia = donGia;
    }

    public int getSlTon() {
        return slTon;
    }

    public void setSlTon(int slTon) {
        if(slTon < 0)
            throw new RuntimeException("Số lượng tồn phải lớn hơn hoặc bằng 0");
        this.slTon = slTon;
    }

    public abstract String getMucDo();

    public abstract double getVAT();

    @Override
    public String toString() {
        return String.format("%s | %s | %.2f | %d", maHang, tenHang, donGia, slTon);
    }
}

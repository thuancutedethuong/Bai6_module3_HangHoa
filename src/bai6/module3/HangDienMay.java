package bai6.module3;


public class HangDienMay extends HangHoa{
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(){
        this("","",0.0,0,0,0.0);
    }

    public HangDienMay(String maHang, String tenHang, double donGia, int slTon, int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, donGia, slTon);
        this.setThoiGianBaoHanh(thoiGianBaoHanh);
        this.setCongSuat(congSuat);
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if(thoiGianBaoHanh < 0 )
            throw new RuntimeException("Thời gian bảo hành >= 0");
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if(congSuat < 0)
            throw new RuntimeException("Công suất >= 0");
        this.congSuat = congSuat;
    }

    @Override
    public String getMucDo() {
        if(getSlTon() < 3)
            return "bán được";
        return "không đánh giá";
    }

    @Override
    public double getVAT() {
        return getDonGia() * 0.1;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + thoiGianBaoHanh
                                + " | " + congSuat;
    }
}

package DomainModels;

/**
 *
 * @author chutu
 */
public class LoaiSp {

    private String idLoai1;
    private String idLoai2;
    private String ma;
    private String ten;
    private Integer trangThai;

    public LoaiSp() {
    }

    public LoaiSp(String idLoai1, String idLoai2, String ma, String ten, Integer trangThai) {
        this.idLoai1 = idLoai1;
        this.idLoai2 = idLoai2;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public String getIdLoai1() {
        return idLoai1;
    }

    public void setIdLoai1(String idLoai1) {
        this.idLoai1 = idLoai1;
    }

    public String getIdLoai2() {
        return idLoai2;
    }

    public void setIdLoai2(String idLoai2) {
        this.idLoai2 = idLoai2;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}

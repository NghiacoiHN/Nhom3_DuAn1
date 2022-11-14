package ViewModels;

/**
 *
 * @author chutu
 */
public class SizeResponse {

    private String id;
    private String ma;
    private String soSize;
    private Integer trangThai;

    public SizeResponse() {
    }

    public SizeResponse(String id, String ma, String soSize, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.soSize = soSize;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSoSize() {
        return soSize;
    }

    public void setSoSize(String soSize) {
        this.soSize = soSize;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    @Override
    public String toString() {
        return soSize;
    }
}

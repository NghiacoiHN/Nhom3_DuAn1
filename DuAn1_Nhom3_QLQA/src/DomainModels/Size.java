package DomainModels;

/**
 *
 * @author chutu
 */
public class Size {

    private String id;
    private String ma;
    private String coSize;
    private Integer trangThai;

    public Size() {
    }

    public Size(String id, String ma, String coSize, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.coSize = coSize;
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

    public String getCoSize() {
        return coSize;
    }

    public void setCoSize(String coSize) {
        this.coSize = coSize;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return coSize;
    }
    
    
}

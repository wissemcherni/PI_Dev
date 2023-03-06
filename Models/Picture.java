package production.x_change.Models;

import java.util.Objects;

public class Picture {
    private String id;
    private String picture_type;
    private String picture_id;
    private String url;

    public Picture() {
    }

    public Picture(String picture_type, String picture_id, String url) {
        this.picture_type = picture_type;
        this.picture_id = picture_id;
        this.url = url;
    }

    public Picture(String id, String picture_type, String picture_id, String url) {
        this.id = id;
        this.picture_type = picture_type;
        this.picture_id = picture_id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture_type() {
        return picture_type;
    }

    public void setPicture_type(String picture_type) {
        this.picture_type = picture_type;
    }

    public String getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(String picture_id) {
        this.picture_id = picture_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return id.equals(picture.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

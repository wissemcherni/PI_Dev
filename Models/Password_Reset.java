package production.x_change.Models;

import java.sql.Timestamp;

public class Password_Reset {
    private String id;
    private String email;

    public Password_Reset(String id, String email, String token, Timestamp expire_at, Integer status) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.expire_at = expire_at;
        this.status = status;
    }

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Timestamp expire_at;
    private Integer status;

    public Password_Reset() {
    }

    public Password_Reset(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpire_at() {
        return expire_at;
    }

    public void setExpire_at(Timestamp expire_at) {
        this.expire_at = expire_at;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

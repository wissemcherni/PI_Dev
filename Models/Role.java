package production.x_change.Models;

import java.util.Objects;

public class Role {
    private String id;
    private String user_id;
    private String role;

    public Role() {
    }

    public Role(String user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public Role(String id, String user_id, String role) {
        this.id = id;
        this.user_id = user_id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return role.equals(role1.role) && this.user_id.equals(role1.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
    @Override
    public String toString(){
        return this.role;
    }
}

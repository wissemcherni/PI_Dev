package production.x_change.Services;

import java.util.HashMap;

public interface IService <T> {
    public T CREATE(T t);
    public HashMap<Integer,T> READALL();
    public T READONE(T t);
    public boolean DELETE(T t);
    public T MODIFY(T t);
}

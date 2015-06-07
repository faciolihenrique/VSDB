import java.io.*;

public interface iDB{
    public String getFromDB();
    public String[] getFromDB(String info);
    public String[] getFromDB(String info1, String info2);
    public boolean saveDB(Object obj);
    public Object getObject();
}

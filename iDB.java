import java.io.*;

//Pattern Minimalist
public interface iDB{
    public BufferedReader readDB();
    public String[] searchDB(String info);
    public String[] searchDB(String info1, String info2);
}

public interface iDB{
    public String getFromDB() throws NullPointerException, NoMethod;
    public String[] getFromDB(String info) throws NullPointerException, NoMethod;
    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod;
    public void saveDB(Object obj) throws NullPointerException, NoMethod;
    public Object getObject() throws NullPointerException, NoMethod;
}

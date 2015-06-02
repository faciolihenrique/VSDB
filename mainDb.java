public class mainDb{
    public static void main(String args[]){
        DBFactory factory = new DBFactory("teste.csvdb");

        iDB dataBase = factory.getDB(TypeDB.CSV);

        String[] valores = null;
        try{
            valores = dataBase.searchDB("Ola","meu amor");
            System.out.println(valores[3]);
        }
        catch(NullPointerException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /*public static void main(String args[]){
        umbraDBCSV dataBase = new umbraDBCSV("teste.csvdb");

        String[] valores = null;
        try{
            valores = dataBase.searchDB("meudeus","foi");
            System.out.println(valores[2]);
        }
        catch(NullPointerException e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }*/
}

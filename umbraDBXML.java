import java.io.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public class umbraDBXML implements iDB{
	private String path;
    private File file;

    public umbraDBXML(String name_of_file){
    	path = name_of_file + ".xmldb";

    	try {
            file = new File(path);
            if( !file.exists() ) {
                file.createNewFile();
            }
        }
        //Caso nao tenha encontrado o arquivo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Caso tenha dado algum outro erro
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader readDB() throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }

    public XMLDecoder decodeDB(){
    	XMLDecoder decoder = null;
    	BufferedInputStream bufferedFile = null;
    	FileInputStream openedFile = null;

    	try {
    		openedFile = new FileInputStream(file);
    		bufferedFile = new BufferedInputStream(openedFile);
            decoder = new XMLDecoder(bufferedFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    	return decoder;
    }

    public XMLEncoder encodeDB(){
    	XMLEncoder encoder = null;
    	BufferedOutputStream bufferedFile = null;
    	FileOutputStream openedFile = null;

    	try {
    		openedFile = new FileOutputStream(file);
    		bufferedFile = new BufferedOutputStream(openedFile);
            encoder = new XMLEncoder(bufferedFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    	return encoder;
    }

    public void closeDecoderDB(XMLDecoder decoder){
        try{
            decoder.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeEncoderDB(XMLEncoder encoder){
        try{
            encoder.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean saveDB(Object obj){
    	XMLEncoder encoder = this.encodeDB();
    	boolean salvou = false;
    	try{
    		encoder.writeObject(obj);
    		salvou = true;
    	}
    	catch(Exception e){
            e.printStackTrace();
        }
    	finally{
    		this.closeEncoderDB(encoder);
    	}
    	return salvou;
    }

    public Object getObject() throws NullPointerException {
    	XMLDecoder decoder = this.decodeDB();
    	Object obj = null;
    	try{
    		obj = decoder.readObject();
    		return obj;
    	}
    	catch(Exception e){
            e.printStackTrace();
        }
    	finally{
            this.closeDecoderDB(decoder);
        }

        throw new NullPointerException();

    }

    public String getFromDB() throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }

    public String[] getFromDB(String info) throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }

    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod{
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }

}

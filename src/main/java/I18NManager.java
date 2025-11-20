import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {

    private static I18NManager instance;

    private HashMap<String, ResourceBundle> cache;

    private I18NManager(){
        this.cache = new HashMap<String, ResourceBundle>();
    }
    public static I18NManager getInstance(){
        if(instance == null){
            instance = new I18NManager();
        }
        return instance;
    }

    public String getText(String idioma, String line){
        ResourceBundle rb = cache.get(idioma);
        if (rb == null) {
            rb = ResourceBundle.getBundle(idioma);
            cache.put(idioma, rb);
        }
        return rb.getString(line);
    }

    public void clear(){
        instance = null;
    }


}

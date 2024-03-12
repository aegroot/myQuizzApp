package alex.app.myQuizzApp.utils;

import java.util.ArrayList;
import java.util.List;

public class ListValidation {
    
    public static boolean enforceDistinctValues(List<Object> list){
        List<Object> objects=new ArrayList<>();
        for (Object o:list){
            if (objects.contains(o))
                return false;
            else objects.add(o);
        }
        
        return true;
    }
    
}

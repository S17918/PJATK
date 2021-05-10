package MP01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
    Piotr Wasilewski
    S17918
*/

public abstract class ObjectPlus implements Serializable{
    
    private static Map<Class, List<ObjectPlus>> extents = new Hashtable<>();

    public ObjectPlus(){
        Class theClass = this.getClass();
        List<ObjectPlus> extent = null;

        if(extents.containsKey(theClass)){
            extent = extents.get(theClass);
        }else{

            extent = new ArrayList<>();
            extents.put(theClass, extent);
        }

        extent.add(this);

    }



    public static void writeExtent(ObjectOutputStream out) throws IOException{
        out.writeObject(extents);
    }



    public static void readExtent(ObjectInputStream in) throws IOException, ClassNotFoundException{
        extents = (Hashtable)in.readObject();
    }



    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException{
        if(extents.containsKey(type)){
            return (Iterable<T>) extents.get(type);
        }

        throw new ClassNotFoundException(
            String.format("%s. Stored extents: %s", type.toString(), extents.keySet())
        );
    }



    public static void showExtent(Class theClass) throws Exception{
        List<ObjectPlus> extent = null;

        if(extents.containsKey(theClass)){
            extent = extents.get(theClass);
        }else{
            throw new Exception("Unknown class" + theClass);
        }

        System.out.println("Extent of the class: " + theClass.getSimpleName()+"\n\n");

        for(Object obj : extent){
            System.out.println(obj.toString());
        }
    }
    
}
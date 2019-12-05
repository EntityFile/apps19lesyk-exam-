package json;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private final Dictionary items;

    public JsonObject(JsonPair... jsonPairs) {
        Dictionary items = new Hashtable<>();
        for (JsonPair pair : jsonPairs) {
            items.put(pair.key, pair.value.toJson());
        }
        this.items = items;
    }


    @Override
    public String toJson() {
        /*
        Dictionary elements = new Hashtable();
        StringBuilder s = new StringBuilder();
        for (Enumeration i = items.keys(); i.hasMoreElements();)
        {
            elements.put(i.nextElement(), items.get(i.nextElement()).toJson());
        }
        */
        return items.toString();
    }

    public void add(JsonPair jsonPair) {
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}

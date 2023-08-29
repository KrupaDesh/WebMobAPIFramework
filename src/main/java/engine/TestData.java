package engine;

import engine.reader.MyJsonReader;

import java.util.HashMap;


public class TestData {

    private final HashMap<Class<?> , Object> dataChainer= new HashMap<Class<?>, Object>();

    //If Test data object is directly passed to add
    public TestData addTestData(Object object)
    {
        dataChainer.put(object.getClass(), object);
        return this;
    }

    public TestData addTestData(String key, Class<?> tclass)
    {
        Object dataObject = MyJsonReader.getDataObject(key, tclass);
        dataChainer.put(dataObject.getClass(),dataObject);
        return this;
    }

    public <T> T getTestData(Class<T> className)
    {
        return(T) this.dataChainer.get(className);
    }
}

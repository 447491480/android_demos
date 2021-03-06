package com.example.sqlite_01;

import java.util.List;
import java.util.Map;

/**
 * Created by chang on 14-10-10.
 */
public interface IPersionService {
    public boolean addPerson(Object[] params);

    public boolean deletePerson(Object[] params);

    public boolean updatePerson(Object[] params);

    public Map<String,String> viewPerson(String[] selectionArgs);

    public List<Map<String,String>> listPersonMaps(String[] selectionArgs);
}

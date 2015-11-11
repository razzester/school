package common.operations;
import common.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import java.util.List;
import java.util.ArrayList;

public class AddRoomsOperation implements Operation<Boolean> {
    int id;
    String location;
    int count;
    int price;

    public AddRoomsOperation(int id, String location, int count, int price) {
        this.id = id;
        this.location = location;
        this.count = count;
        this.price = price;
    }

    @Override
    public List<Object> getParameters() {
        final List<Object> l = new ArrayList<Object>();
        l.add(id);
        l.add(location);
        l.add(count);
        l.add(price);
        return l;
    }

    @Override
    public Boolean invoke(Hashtable<String, ItemGroup> data) {
    final String key = location;

    ItemGroup g = data.get(key);
    if(g == null) {
        g = new ItemGroup("room", key, count, location);
        data.put(key, g);
    }
    else {
        if(flightPrice > 0)
            g.setPrice(price);
        g.setCount(g.getCount() + count);
    }

    return true;
    }
}


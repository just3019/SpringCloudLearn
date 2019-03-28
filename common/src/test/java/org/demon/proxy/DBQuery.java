package org.demon.proxy;

public class DBQuery implements IDBQuery {

    public DBQuery() {
    }

    @Override
    public String request() {
        return "request string";
    }
}

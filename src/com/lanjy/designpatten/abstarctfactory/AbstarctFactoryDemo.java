package com.lanjy.designpatten.abstarctfactory;

/**
 * 抽象工厂模式
 */
public class AbstarctFactoryDemo {

    public static void main(String[] args) {
        IDataBaseUtil mySQLDataBaseUtil = new MySQLDataBaseUtil();
        IConnection connection = mySQLDataBaseUtil.getConnection();
        connection.connection();
        ICommand icommand = mySQLDataBaseUtil.getIcommand();
        icommand.command();
    }
}

interface IConnection{
    void connection();
}
class MySQLConnection implements IConnection{
    @Override
    public void connection() {
        System.out.println("MySQL connection.");
    }
}
class OracleConnection implements IConnection{
    @Override
    public void connection() {
        System.out.println("Oracle connection.");
    }
}

interface ICommand{
    void command();
}
class MySQLCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("MySQL command.");
    }
}
class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("Oracle command.");
    }
}
interface IDataBaseUtil{
    IConnection getConnection();
    ICommand getIcommand();
}

class MySQLDataBaseUtil implements IDataBaseUtil{

    @Override
    public IConnection getConnection() {
        return new MySQLConnection();
    }

    @Override
    public ICommand getIcommand() {
        return new MySQLCommand();
    }
}

class OracleDataBaseUtil implements IDataBaseUtil{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getIcommand() {
        return new OracleCommand();
    }
}
package co.jeongeun.dbPrj;

import co.jeongeun.dbPrj.db.DevSerivceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        DataSource dao = new DataSource();
    	DevSerivceImpl dao = new DevSerivceImpl();
    	dao.selectList();
    }
}

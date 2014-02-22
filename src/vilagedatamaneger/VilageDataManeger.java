package vilagedatamaneger;

import DBConections.DBCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import windows.Welcome;

public class VilageDataManeger {

    private static final Logger log = LoggerFactory.getLogger(VilageDataManeger.class);

    public static void main(String[] args) throws InterruptedException {
        DBCon db = new DBCon();
        db.crateDatabase();

        log.info("Started to run");
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
    }
}

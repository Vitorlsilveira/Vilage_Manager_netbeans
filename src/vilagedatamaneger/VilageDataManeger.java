package vilagedatamaneger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import windows.Welcome;

public class VilageDataManeger {

    private static final Logger log = LoggerFactory.getLogger(VilageDataManeger.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("Started to run");
        Welcome.running();
    }
}

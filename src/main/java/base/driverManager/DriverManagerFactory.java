package base.driverManager;

import base.BaseMobile;
import base.driverManager.InitDrivers.RemoteDriverManager;
import base.driverManager.InitDrivers.android.AndroidDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriverManagerFactory extends BaseMobile {
    /**
     * This class init the driver instance by is type chrome/fire/driver etc...
     * Its hold the driver manager instance and will return the driver
     * chrome - firefox - android driver
     * each class here is an class the extend the abstract class driver manager
     * and create the object from each case
     * than once the object is created the driverManager will return the placement driver instance
     */
    public static DriverManager getManager(String type) {
        DriverManager driverManager;
        switch (type) {
            case PlatformsType.ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            case PlatformsType.IOS:
                driverManager = new AndroidDriverManager();
                break;
            case PlatformsType.REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            default: throw new IllegalStateException("Unexpected value: " + type);
        }
        log.debug("init " + type + " before test");
        return driverManager;
    }
}

package de.jonasrottmann.realmsample;

import com.squareup.leakcanary.LeakCanary;

import de.jonasrottmann.realmbrowser.RealmBrowser;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class Application extends android.app.Application {

    public static final String REALM_FILE_NAME = "db10.realm";

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        Timber.plant(new Timber.DebugTree());

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(REALM_FILE_NAME)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);

        RealmBrowser.showRealmModelsNotification(this, config);

        RealmBrowser.addFilesShortcut(this);

        RealmBrowser.addModelsShortcut(this, config);
    }
}
package com.example.webprog26.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by webprog26 on 22.11.17.
 */

public class App extends Application {

    private static final String REALM_DB_NAME = "test_realm_db.realm";

    public static final long SCHEMA_VERSION = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(REALM_DB_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .migration(new Migration())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}

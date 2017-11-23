package com.example.webprog26.realm;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by webprog26 on 23.11.17.
 */

public class Migration implements RealmMigration{

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema realmSchema = realm.getSchema();

        if(oldVersion == 0) {
            RealmObjectSchema realmObjectSchema = realmSchema.get("Task");

            realmObjectSchema.addField("timestamp", long.class)
            .transform(new RealmObjectSchema.Function() {
                @Override
                public void apply(DynamicRealmObject obj) {
                    obj.set("timestamp", 0);
                }
            });
            oldVersion++;
        }
    }
}

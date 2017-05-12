package de.jonasrottmann.realmbrowser.helper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import java.lang.reflect.Field;

import io.realm.DynamicRealmObject;
import io.realm.RealmConfiguration;

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class RealmHolder {

    private static final RealmHolder instance = new RealmHolder();

    private DynamicRealmObject object;
    private Field field;
    private RealmConfiguration realmConfiguration;

    @NonNull
    public static RealmHolder getInstance() {
        return instance;
    }


    /*
    Object
    */
    @Nullable
    public DynamicRealmObject getObject() {
        return object;
    }


    public void setObject(DynamicRealmObject object) {
        this.object = object;
    }

    /*
     Field
    */
    @Nullable
    public Field getField() {
        return field;
    }


    public void setField(Field field) {
        this.field = field;
    }

    /*
     Realm Config
    */
    @Nullable
    public RealmConfiguration getRealmConfiguration() {
        return realmConfiguration;
    }


    public void setRealmConfiguration(RealmConfiguration realmConfig) {
        realmConfiguration = realmConfig;
    }
}

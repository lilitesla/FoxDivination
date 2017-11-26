package lili.tesla.foxdivination.presentation.application;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import lili.tesla.foxdivination.BuildConfig;
import lili.tesla.foxdivination.data.database.DataBaseAccess;

/**
 * Created by Лилия on 24.11.2017.
 */

public class App extends Application {

    private static Context context;

    private static App instance;
    public static DataBaseAccess dataBaseAccess;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        dataBaseAccess = new DataBaseAccess(this);
        context = this.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static App getInstance() {
        return instance;
    }

    //процедура для просмотра базы с компа
    private void stethoInit() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }

}

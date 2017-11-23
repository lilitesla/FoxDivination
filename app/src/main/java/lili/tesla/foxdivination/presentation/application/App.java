package lili.tesla.foxdivination.presentation.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import lili.tesla.foxdivination.BuildConfig;

/**
 * Created by Лилия on 24.11.2017.
 */

public class App extends Application {

    private static App instance;
    //public static DataBaseAccess dataBaseAccess;


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            stethoInit();
        }

        //dataBaseAccess = new DataBaseAccess(this);
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

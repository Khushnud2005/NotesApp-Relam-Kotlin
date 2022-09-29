package uz.exemple.notesapp_relam_kotlin

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class App:Application() {

    override fun onCreate() {
        super.onCreate()

        initRealm()
    }

    private fun initRealm(){
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}
package uz.exemple.notesapp_relam_kotlin.managers

import io.realm.Realm
import uz.exemple.notes_room_kotlin.model.Notes


class RealmManager {
    val TAG = RealmManager::class.java.simpleName

    companion object{
        private var realmManager:RealmManager? = null
        private lateinit var realm:Realm
        val instance:RealmManager?
        get(){
            if (realmManager == null){
                realmManager = RealmManager()
            }
            return realmManager
        }
    }

    init {
        realm = Realm.getDefaultInstance()
    }

    fun saveNotes(note: Notes) {
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(note)
        realm.commitTransaction()
    }

    fun loadNotes(): ArrayList<Notes> {
        val notes = ArrayList<Notes>()
        val results = realm.where(Notes::class.java).findAll()
        for (note in results) {
            notes.add(note)
        }
        return notes
    }

    fun deleteNote(id: Int) {
        realm.executeTransaction { transactionRealm: Realm ->
            val item = transactionRealm.where(Notes::class.java).equalTo("id", id).findFirst()
            item!!.deleteFromRealm()
        }
    }
}
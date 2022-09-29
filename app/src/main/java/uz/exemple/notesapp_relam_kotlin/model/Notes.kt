package uz.exemple.notes_room_kotlin.model


import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Notes : RealmObject {
    @PrimaryKey()
    var id = 0
    lateinit var note: String
    lateinit var date: String

    constructor() {}

    constructor(note: String, date: String) {
        id = 0
        this.note = note
        this.date = date
    }


    constructor(id: Int, note: String, date: String) {
        this.id = id
        this.note = note
        this.date = date
    }
}
package com.example.pharmine.models.appointments

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
class Appointment {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "apt_id")
    var aptId: Int = 0

    @ColumnInfo(name = "doc_name")
    var docName: String = ""

    @ColumnInfo(name = "apt_date")
    var aptDate: String = ""

    @ColumnInfo(name = "apt_status")
    var aptComplete: Boolean = false

    constructor(docName: String, aptDate: String, aptStatus: Boolean = false) {
        this.docName = docName
        this.aptDate = aptDate
        this.aptComplete = aptStatus
    }
}
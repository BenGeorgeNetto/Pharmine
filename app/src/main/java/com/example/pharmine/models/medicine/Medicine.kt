package com.example.pharmine.models.medicine

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicines")
class Medicine {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "med_name")
    var medName: String = ""

    @ColumnInfo(name = "med_price")
    var medPrice: Int = 0

    @ColumnInfo(name = "use_description")
    var useDescription: String = ""

    @ColumnInfo(name = "med_dosage")
    var medDosage: String = ""

    @ColumnInfo(name = "med_amt")
    var medAmt: Int = 0

    @ColumnInfo(name = "image")
    var medImage: String = ""

    @ColumnInfo(name = "arrival")
    var medArrival: String = ""

    constructor() {}

    constructor(name: String, price: Int, useDesc: String = "", dosage: String = "As per prescription.", amt: Int = 0, image: String, arrival: String = "Arrived") {
        medName = name
        medPrice = price
        useDescription = useDesc
        medDosage = dosage
        medAmt = amt
        medImage = image
        medArrival = arrival
    }
}
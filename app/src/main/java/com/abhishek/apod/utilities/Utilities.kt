/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */
package com.abhishek.apod.utilities

import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utilities {

    fun getCurrentDate(calendar: Calendar): String {
        return "${calendar.get(Calendar.YEAR)}-" +
                "${calendar.get(Calendar.MONTH) + 1}-" +
                "${calendar.get(Calendar.DATE)}"
    }

    fun convertStringToDate(givenDate: String): Date {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        var date = Date()
        try {
            date = format.parse(givenDate)
        } catch (e: ParseException) {
            Timber.e(e, "Error in converting date")
        }
        return date
    }

    fun convertDateFormat(date: Date?): String {
        if (date == null) return ""
        val spf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return spf.format(date)
    }
}
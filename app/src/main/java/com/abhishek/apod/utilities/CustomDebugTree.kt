/*
 * Copyright 2020 Abhishek.pathak
 * #myofficework000@gmail.com
 */

package com.abhishek.apod.utilities

import timber.log.Timber

class CustomDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return "(${element.fileName}:${element.lineNumber}) # ${element.methodName}"
    }
}
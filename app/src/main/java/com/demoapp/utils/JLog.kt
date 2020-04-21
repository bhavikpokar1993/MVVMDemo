/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 https://www.spaceotechnologies.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.demoapp.utils

import android.util.Log
import com.demoapp.BuildConfig

object JLog {


    private val LOG = BuildConfig.DEBUG
    fun i(string: String) {
        if (LOG) {
            Log.i(TAG, string)
        }
    }

    fun e(string: String) {
        if (LOG) {
            Log.e(TAG, string)
        }
    }

    fun d(string: String) {
        if (LOG) {
            Log.d(TAG, string)
        }
    }

    fun v(string: String) {
        if (LOG) {
            Log.v(TAG, string)
        }
    }

    fun w(string: String) {
        if (LOG) {
            Log.w(TAG, string)
        }
    }

    fun isLog(): Boolean {
        return LOG
    }

}
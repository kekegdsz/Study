package com.kye.android.sdk.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
        var num = sum(5, 7)
        Log.i(TAG, num?.toString())
        vars(1, 2, 3, 4, 5)
        //模版
        var a = 1
        val s1 = "a is $a"
        Log.i(TAG, s1)
        a = 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        Log.i(TAG, s2)
    }

    fun vars(vararg v: Int) {
        for (vt in v) {
            Log.i(TAG, vt.toString())
        }
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun test() {
        Log.i(TAG, "test")
    }
}
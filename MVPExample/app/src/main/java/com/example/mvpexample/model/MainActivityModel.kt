package com.example.mvpexample.model

import com.example.mvpexample.contract.ContractInterface.*

class MainActivityModel: Model {

    private var mCounter = 0

    override fun getCounter()= mCounter

    override fun incrementCounter() {
        mCounter++
    }
}
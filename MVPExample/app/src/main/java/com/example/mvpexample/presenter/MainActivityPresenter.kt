package com.example.mvpexample.presenter

import com.example.mvpexample.contract.ContractInterface.*
import com.example.mvpexample.model.MainActivityModel

class MainActivityPresenter(_view: View): Presenter {

    private var view: View = _view
    private var model: Model = MainActivityModel()

    init {
        view.initView()
    }

    override fun incrementValue() {
        model.incrementCounter()
        view.updateViewData()
    }

    override fun getCounter() = model.getCounter().toString()

}
package com.za.sbs.delivery.data

class ServicesFee {

    var sms_fee : Int
    var pickup_service_fee : Int
    var shipping_fee : Int

    constructor(sms_fee: Int, pickup_service_fee: Int, shipping_fee: Int) {
        this.sms_fee = sms_fee
        this.pickup_service_fee = pickup_service_fee
        this.shipping_fee = shipping_fee

    }
}
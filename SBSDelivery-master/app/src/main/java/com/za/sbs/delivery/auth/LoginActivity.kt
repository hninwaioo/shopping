package com.za.sbs.delivery.auth

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.za.sbs.delivery.MainActivity
import com.za.sbs.delivery.R
import com.za.sbs.delivery.activities.FontDetectorActivity
import com.za.sbs.delivery.model.LoginModel
import com.za.sbs.delivery.service.NetworkService
import com.za.sbs.delivery.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert

class LoginActivity : AppCompatActivity() , OnMapReadyCallback {

    var disposable = CompositeDisposable()
    // private var mPermissionUtils: MarshMallowPermissionUtils? = null
    private var mLat = 0.0
    private var mLon = 0.0
    var mMap : GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //  mPermissionUtils = MarshMallowPermissionUtils(this)

        var mIsZawgyi = Storage.make(this).isZawgyi

        val token = Storage.make(this).authToken
//        if auth token is already exist, return home page
        if (token != null) {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        if (Storage.make(this).isFirstTime) {
            val intent = Intent(this, FontDetectorActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            return
        }

        etUserPwd.hint = ViewUtil.getString(this,"စကားဝှက်")
        etUserEmail.hint = ViewUtil.getString(this,"အီးမေးလ်")

        setupLocationManager()

        btnSignIn.setOnClickListener {

            etUserEmail.error = null
            etUserPwd.error = null

            if (!validateInputs()) return@setOnClickListener

            LoginAccount()
        }

//        passwordShowCheck.text = ViewUtil.getString(this, "Show Password")
//
//        passwordShowCheck.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, checked ->
//            if (checked) {
//                etUserPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
//            } else {
//                etUserPwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT)
//            }
//        })
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        if (mLat != 0.0 && mLon != 0.0) {
            Log.e("Lat",mLat.toString())
            Log.e("Lon",mLon.toString())
            setCurrentLocationOnMap(mLat, mLon)
        }
    }

    private fun setCurrentLocationOnMap(latitude: Double, longitude: Double) {
        if (mMap != null) {
            val location = LatLng(latitude, longitude)
            mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12.0f))
        } else {
            mLat = latitude
            mLon = longitude
        }
    }

    private fun setupLocationManager() {

        if (ActivityCompat.checkSelfPermission(
                this!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) === PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this!!, Manifest.permission.ACCESS_COARSE_LOCATION
            ) === PackageManager.PERMISSION_GRANTED
        ) {
//            showLoading(resources.getString(R.string.message_getting_your_location))
//            SingleShotLocationUtils.requestSingleUpdate(this,
//                object : SingleShotLocationUtils.LocationCallback {
//                    override fun onNewLocationAvailable(location: SingleShotLocationUtils.GPSCoordinates) {
//                        mLat = location.latitude.toDouble()
//                        mLon = location.longitude.toDouble()
//                        Log.e("latitude",mLat.toString())
//                        Log.e("Longitude",mLon.toString())
//                        setCurrentLocationOnMap(mLat, mLon)
////                        PostBox()
//                    }
//                })

        } else {

            //mPermissionUtils!!.requestPermissions()
        }
    }

    fun LoginAccount(){

        val progressDialog = progressDialog("Logging data...").show()
        var loginModel = LoginModel(etUserEmail.text.toString(),etUserPwd.text.toString(),mLat,mLon)

        availableConnection {

            disposable.add(
                NetworkService.getInstance(this).apiService.LoginAccount(loginModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext {

                        progressDialog.dismiss()
                    }
                    .doOnComplete {

                        progressDialog.dismiss()

                    }
                    .subscribe({
                        progressDialog.dismiss()

                        if (it.code() == 200){

                            if (it.body() != null) {

                                Log.d("Success Role",  it.body()!!.user!!.role!!.name!!.name_en)
                                var role = it.body()!!.user!!.role!!.name!!.name_en


                                Log.d("Success", "Successful")
                                Storage.make(applicationContext).let { storage ->
                                    storage.authToken = it.body()!!.token
                                }

                                Log.d("TOKEN LOGIN SUCCESS ", it.body()!!.token)

                                savelogin(it.body()!!)

                                var intent = Intent(this, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                                startActivity(intent)
                                finish()


                            } else {
                                progressDialog.dismiss()
                                Log.e("ItMessage",it.message())
                                alert("", it.message()).show()

                            }
                        }
                        else if (it.code() == 422){

//                                val res = it.errorBody()?.string()
//                                if(res!=null){
//                                    val message  = JSONObject(res)
//                                    Log.e("RES",res.toString())
//
//                                    if(message.has("message")){
//                                        Throwable(message = message.getString("message"))
//                                        Log.e("ERRORMessage",Throwable(message = message.getString("message")).toString())
//
////                                        ErrorMessageShow(message.getString("message"))
//                                    }
//                                }
//                            showAlertDialog()
                        }

                        else {

                            progressDialog.dismiss()
                            Log.e("It_Message",it.message())

                            alert("These credentials do not match our records.", "").show()


                        }
                        progressDialog.dismiss()

                    }, {

                        Log.d("Denied", it.localizedMessage)

                    })
            )
        }

    }

//    private fun showAlert() {
//
//        val mDialogView2 = LayoutInflater.from(this).inflate(R.layout.not_available_role_layout, null)
//        val mBuilder2 = AlertDialog.Builder(this)
//            .setView(mDialogView2)
//        val  mAlertDialog2 = mBuilder2.show()
//        mAlertDialog2.setCancelable(true)
//    }

//    private fun showAlertDialog() {
//
//        val mDialogView = LayoutInflater.from(this).inflate(R.layout.not_found_trackingcode_layout, null)
//        val mBuilder = AlertDialog.Builder(this)
//            .setView(mDialogView)
//        val  mAlertDialog = mBuilder.show()
//        mAlertDialog.setCancelable(false)
//        mDialogView.text_label.text = "These credentials do not match our records."
//        mDialogView.cancel.visibility = View.GONE
//        mDialogView.no_ok.setOnClickListener {
//            //dismiss dialog
//            mAlertDialog.dismiss()
//
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        setupLocationManager()
    }

    private fun validateInputs(): Boolean {
        var result = true
        val email = etUserEmail.text.toString().trim { it <= ' ' }
        val pwd = etUserPwd.text.toString().trim { it <= ' ' }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etUserEmail.error = "Please enter a valid email address"
            result = false
        }

        //Password
        if (pwd.isEmpty()) {
            etUserPwd.error = "Please enter a password to login"
            result = false
        }

        return result
    }
}

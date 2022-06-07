package com.za.sbs.delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.za.sbs.delivery.activities.FontDetectorActivity
import com.za.sbs.delivery.auth.LoginActivity
import com.za.sbs.delivery.fragment.AcceptNewParcelFragment
import com.za.sbs.delivery.fragment.DeliveredDailyMonthlyFragment
import com.za.sbs.delivery.fragment.ProgressDeliverFragment
import com.za.sbs.delivery.noti.CameraPermissionActivity
import com.za.sbs.delivery.noti.FilePermissionActivity
import com.za.sbs.delivery.noti.LocationPermissionActivity
import com.za.sbs.delivery.noti.NoInternetActivity
import com.za.sbs.delivery.utils.MarshMallowPermissionUtils
import com.za.sbs.delivery.utils.Storage
import com.za.sbs.delivery.utils.isInternetAvailable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.rabbitconverter.rabbit.Rabbit

class MainActivity : AppCompatActivity() {

    var disposable = CompositeDisposable()
    private var mCurrentItem: Int = 0
    private var mIsZawgyi = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Storage.make(this).isFirstTime) {
//            startActivity<FontDetectorActivity>()
            val intent = Intent(this, FontDetectorActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            return
        }

        var token_token = Storage.make(this).authToken

        if (token_token == null || token_token.isEmpty()) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            return
        }

        mCurrentItem = R.id.progress_deliver_nav
        replaceFragment(ProgressDeliverFragment.newInstance("pending"))

        bottom_navigation_view.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {

                if (mCurrentItem == item.itemId) {
                    return false
                }
                when (item.itemId) {
                    R.id.progress_deliver_nav -> {
                        replaceFragment(ProgressDeliverFragment.newInstance("pending"))
                    }
                    R.id.complete_deliver_nav -> {
                        replaceFragment(DeliveredDailyMonthlyFragment.newInstance("process"))

                    }
                    R.id.accept_parcel_nav -> {
                        replaceFragment(AcceptNewParcelFragment.newInstance("complete"))
                    }
                }
                mCurrentItem = item.itemId
                return true
            }
        })

        if (Storage.make(this).isZawgyi) {
            val menu = bottom_navigation_view.menu
            val total = menu.size()

            // For group title
            for (i in 0 until total) {
                val item = menu.getItem(i)
                var title = item.title.toString()
                title = Rabbit.uni2zg(title)
                item.title = title
            }
        }

        val permissionUtils = MarshMallowPermissionUtils(this)

        if(!this.isInternetAvailable()){
            startActivity(Intent(this, NoInternetActivity::class.java))
        } else if(!permissionUtils.checkPermissionForCamera()){
            startActivity(Intent(this, CameraPermissionActivity::class.java))
        }else if (!permissionUtils.checkPermissionForLocation()){
            startActivity(Intent(this, LocationPermissionActivity::class.java))
        }else if (!permissionUtils.checkPermissionForExternalStorage()){
            startActivity(Intent(this, FilePermissionActivity::class.java))
        }

        mIsZawgyi = Storage.make(this).isZawgyi
    }

    override fun onResume() {
        super.onResume()

        val permissionUtils = MarshMallowPermissionUtils(this)

        if(!this.isInternetAvailable()){
            startActivity(Intent(this, NoInternetActivity::class.java))
        } else if(!permissionUtils.checkPermissionForCamera()){
            startActivity(Intent(this, CameraPermissionActivity::class.java))
        }else if (!permissionUtils.checkPermissionForLocation()){
            startActivity(Intent(this, LocationPermissionActivity::class.java))
        }else if (!permissionUtils.checkPermissionForExternalStorage()){
            startActivity(Intent(this, FilePermissionActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("start", "start")

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_container, fragment)
        fragmentTransaction.commit()
    }


    private fun startScan() {

        val materialBarcodeScanner = MaterialBarcodeScannerBuilder()
            .withActivity(this)
            .withEnableAutoFocus(true)
            .withBleepEnabled(true)
            .withBackfacingCamera()
            .withText("Launching Scan")
            .withResultListener {

                var code = it!!.rawValue
                Log.e("ResultCode", code)
//                searchTrackingcode(code, true)
            }
            .build()

        materialBarcodeScanner.startScan()

    }
}

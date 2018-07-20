package com.goodmorningvoca.gmv

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.internal.FirebaseAppHelper.getToken
import com.google.firebase.iid.InstanceIdResult
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.iid.FirebaseInstanceId



class MainActivity : AppCompatActivity() {
    val TAG ="###MainActivity"

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   // cgHH-ilU_Q8:APA91bEKoU8u7AhbRwW1FgrU55fq_r96xYHR2VDzY7zMRtkbGpJ0oG4lo2r624evkJvWQddAi0r-I327cnYvAtbf7d6fVMd2-IWRrYIZLXtQRs-j58rPEcq2pksYZ7dr1zXfLsDgC16t1fBTVPBuf6MFfvkcskF0sA
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(this@MainActivity, OnSuccessListener<InstanceIdResult> { instanceIdResult ->
            val updatedToken = instanceIdResult.token
            Log.e(TAG , updatedToken)
        })


        Log.e( TAG , "######")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

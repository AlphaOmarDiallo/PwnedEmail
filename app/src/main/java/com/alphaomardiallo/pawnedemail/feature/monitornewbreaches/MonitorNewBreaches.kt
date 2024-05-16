package com.alphaomardiallo.pawnedemail.feature.monitornewbreaches

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import timber.log.Timber

@Composable
fun MonitorNewBreaches() {
    val context = LocalContext.current
    val activity = (LocalContext.current as? ComponentActivity)
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            Timber.d("IS GRANTED")
        } else {
            Timber.e("IS NOT GRANTED")
        }
    }

    Button(onClick = {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(
                    activity!!,
                    Manifest.permission.POST_NOTIFICATIONS
                )
            ) {
                Timber.d("ACCEPT THE BLOODY THING THO")
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }) {
        Text(text = "PERMISSION")
    }


}
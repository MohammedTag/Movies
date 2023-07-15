package com.task.remote.di.device_info

import android.content.Context
import github.nisrulz.easydeviceinfo.base.EasyAppMod
import java.util.*
import kotlin.collections.HashMap

class Headers(val context: Context) {
    fun getHeaders(): Map<String, String> {
        val easyAppMod = EasyAppMod(context)

        val map = HashMap<String, String>()
        map["language"] = "ar" //getDeviceLanguage()  forcing arabic language for now
        map["version"] = getAppVersion(easyAppMod)

        return map
    }

    private fun getDeviceLanguage(): String = Locale.getDefault().language
    private fun getAppVersion(easyAppMod: EasyAppMod) = easyAppMod.appVersionCode
}
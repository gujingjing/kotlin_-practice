package gjj.kotlin.practice

import android.util.Log

/**
 * 作者：jingjinggu on 2019/1/10 11:43
 * 邮箱：jingjinggu@pptv.com
 */

/**
 * 日志打印
 */
fun Any?.logE(tag:Any?,any: Any?){

    Log.e(tag?.toStringNoNull()?:"null",any?.toStringNoNull()?:"null")
}

/**
 *
 */
fun Any?.toStringNoNull():String{
    return this?.toString()?:"null"
}
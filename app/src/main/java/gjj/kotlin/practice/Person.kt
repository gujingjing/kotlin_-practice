package gjj.kotlin.practice

import android.util.Log
import kotlin.properties.Delegates

/**
 * 作者：jingjinggu on 2019/1/10 11:04
 * 邮箱：jingjinggu@pptv.com
 */
class Person {

    var name:String by Delegates.observable(""){
        property, oldValue, newValue ->
        Log.e("Person-","oldValue-$oldValue-newValue-$newValue")
    }
    var age:Int=0

    constructor()
    constructor(name:String?="",age:Int=0){
        this.name=name?:""
        this.age=age
    }


    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}
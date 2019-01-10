package gjj.kotlin.practice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {

//    val person:Person by Delegates.observable()
    var person:Person by MyDelegate(Person())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        delegateTest()
    }

    /**
     * 委托测试
     */
    fun delegateTest(){

        person.name="name"
        person=Person("test",10)
    }

    class MyDelegate<in R, T> (initialValue: T){

        var value:T = initialValue

        operator fun getValue(thisRef: R, property: KProperty<*>): T {
            println(this.value?.toString())
            Log.e("MyDelegate-getValue-",this.value.toString())
            return this.value
        }

        operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {

            this.value=value
            Log.e("MyDelegate-setValue-",this.value.toString())
            println("$value has been assigned to '${property.name} in $thisRef.'")
        }

    }
}

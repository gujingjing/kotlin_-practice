package gjj.kotlin.practice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var person:Person by MyDelegate(Person())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        proptyDele.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if(v==null) return

        when(v.id){
            //属性委托
            R.id.proptyDele->{
                delegateTest()
            }

        }
    }

    /**
     * 委托测试
     */
    fun delegateTest(){

        person.name="name"
        person=Person("test",10)
    }

    inner class MyDelegate<in R, T> (initialValue: T){

        var value:T = initialValue

        operator fun getValue(thisRef: R, property: KProperty<*>): T {
            logE(this@MainActivity,this.value.toStringNoNull())
            return this.value
        }

        operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {

            this.value=value
            logE(this@MainActivity,this.value.toStringNoNull())
        }

    }
}

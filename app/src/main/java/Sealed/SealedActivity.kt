package Sealed



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.allaboutkotlin.R
import kotlinx.android.synthetic.main.activity_sealed.*

class SealedActivity : AppCompatActivity() {
final val TAG = javaClass.name
val operation = Operation.Add(1);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed)

    }
    fun addOnClick(view : View){
if(valueEditText.text.length > 0 &&  XEditText.text.length > 0){
    resulttextView.text=""
    resulttextView.setText("Result ${  execute(x =  XEditText.text.toString().toInt() , op = Operation.Add(value = valueEditText.text.toString().toInt())).toString()}")
}
    }
    fun subsOnClick(view : View){
        if(valueEditText.text.length > 0 &&  XEditText.text.length > 0){
            resulttextView.setText("")
            val num = execute(x =  XEditText.text.toString().toInt() , op = Operation.Substract(value = valueEditText.text.toString().toInt() )).toString().toInt()
            resulttextView.setText ("Result $num")


        }
    }
    fun divOnClick(view : View){
        if(valueEditText.text.length > 0 &&  XEditText.text.length > 0){
            resulttextView.text=""
           resulttextView.setText("Result ${ execute(x =  XEditText.text.toString().toInt() , op = Operation.Divide(value = valueEditText.text.toString().toInt())).toString()}")

        }
    }
    fun multiOnClick(view : View){
        if(valueEditText.text.length > 0 &&  XEditText.text.length > 0){
            resulttextView.text=""
            resulttextView.setText("Result ${ execute(x =  XEditText.text.toString().toInt() , op = Operation.Multiply(value = valueEditText.text.toString().toInt())).toString()}")


        }
    }

    fun execute(x: Int, op: Operation) = when (op) {
        is Operation.Add -> (x + op.value)
        is Operation.Substract -> (x - op.value)
        is Operation.Multiply ->( x * op.value)
        is Operation.Divide -> (x / op.value)
    }
}

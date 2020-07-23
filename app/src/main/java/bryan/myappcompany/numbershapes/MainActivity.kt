package bryan.myappcompany.numbershapes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    class Number {
        var number = 0
        fun isSquare(): Boolean {
            var squareRoot = Math.sqrt(number.toDouble())
            return squareRoot == Math.floor(squareRoot)
        }
        fun isTriangular(): Boolean {
            var x = 1
            var triangularNumber = 1;
            while (triangularNumber < number) {
                x++
                triangularNumber += x;
            }
            return triangularNumber == number
        }
    }
    fun testNumber(view: View) {
        val editText: EditText = findViewById(R.id.editTextNumber)
        var message = ""
        if(editText.text.toString().isEmpty()) {
            message = "Please enter a number."
        } else {
            var myNumber = Number()
            myNumber.number = editText.text.toString().toInt()
            message = if (myNumber.isSquare() && myNumber.isTriangular()){
                "${myNumber.number} is square and triangular."
            } else if(myNumber.isSquare()){
                "${myNumber.number} is square."
            } else if(myNumber.isTriangular()) {
                "${myNumber.number} is triangular."
            } else{
                "${myNumber.number} is neither triangular nor square."
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
package it.uniparthenope.studenti.francescobottino001.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.TipoTasto
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    private lateinit var calculator: Calculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = Calculator(
            findViewById<TextView>(R.id.screen_num_1),
            findViewById<TextView>(R.id.screen_num_2),
            findViewById<TextView>(R.id.screen_op)
        )
    }

    fun onEquals(v: View?) {
        calculator.onBottonePremuto( TipoTasto.UGUALE, (v as MaterialButton).text.toString() )
    }

    fun onNumber(v: View?) {
        calculator.onBottonePremuto( TipoTasto.NUMERO, (v as MaterialButton).text.toString() )
    }

    fun onFunction(v: View?) {
        calculator.onBottonePremuto( TipoTasto.FUNZIONE, (v as MaterialButton).text.toString() )
    }

    fun onOperator(v: View?) {
        calculator.onBottonePremuto( TipoTasto.OPERATORE, (v as MaterialButton).text.toString() )
    }
}

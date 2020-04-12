package it.uniparthenope.studenti.francescobottino001.calculatorapp

import android.widget.TextView
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorState
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorStates
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.TipoTasto
import java.math.MathContext

class Calculator( private val screen_num_1: TextView,
                  private val screen_num_2: TextView,
                  private val screen_op: TextView ) {

    lateinit var stato: CalculatorState

    lateinit var num_1: String
    lateinit var num_2: String
    lateinit var op: String

    init{
        clear()
    }

    fun cambiaStato(nuovoStato: CalculatorStates) {
        this.stato = nuovoStato.instanciate(this)
    }

    fun onBottonePremuto(tipo: TipoTasto, valore: String) {
        var consumedEvent: Boolean
        do {
            consumedEvent = stato.pressione_tasto(tipo, valore)
        } while (!consumedEvent)
        aggiornaDisplay()
    }

    fun aggiornaDisplay() {
        screen_num_1.text = num_1
        screen_num_2.text = num_2
        screen_op.text = op
    }

    fun clear() {
        num_1 = ""
        num_2 = ""
        op = ""

        cambiaStato(CalculatorStates.VUOTO)
        aggiornaDisplay()
    }

    fun sign() {
        fun changeSign(n: String):String = n.toBigDecimal().negate(MathContext.DECIMAL128).toString()
        if(num_1 != "" && num_1 != "0") num_1 = changeSign(num_1)
    }

    fun percent() {
        fun percent(num:String, percent: String):String = (num.toBigDecimal().multiply(percent.toBigDecimal(), MathContext.DECIMAL128).divide((100).toBigDecimal(), MathContext.DECIMAL128)).toString()
        if(num_1 != "" && num_1 != "0") num_1 = percent(num_2, num_1)
    }

    fun result() {
        val y = num_1.toBigDecimal()
        val x = num_2.toBigDecimal()
        when(op) {
            "+" -> num_2 = (x.add(y, MathContext.DECIMAL128)).toString()
            "-" -> num_2 = (x.subtract(y, MathContext.DECIMAL128)).toString()
            "÷" -> num_2 = (x.divide(y, MathContext.DECIMAL128)).toString()
            "×" -> num_2 = (x.multiply(y, MathContext.DECIMAL128)).toString()
            else -> return
        }
    }
}
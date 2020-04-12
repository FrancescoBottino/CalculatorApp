package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.states

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorState
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorStates

class Operatore(private val calculator: Calculator) : CalculatorState(calculator) {
    override fun gestisci_operatore(valore: String): Boolean {
        calculator.op = valore
        return true
    }

    override fun gestisci_funzione(valore: String): Boolean {
        when(valore) {
            "AC" -> calculator.clear()
            "." -> {
                calculator.num_1 = "0."
                calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_2)
            }
            else -> {}
        }
        return true
    }

    override fun gestisci_numero(valore: String): Boolean {
        calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_2)
        return false
    }

    override fun gestisci_uguale(valore: String): Boolean {
        calculator.num_1 = "0"
        calculator.cambiaStato(CalculatorStates.FINALE)
        return false
    }

}

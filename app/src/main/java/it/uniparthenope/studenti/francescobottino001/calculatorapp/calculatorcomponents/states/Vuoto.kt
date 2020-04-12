package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.states

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorState
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorStates

class Vuoto(private val calculator: Calculator) : CalculatorState(calculator) {
    override fun gestisci_operatore(valore: String): Boolean {
        calculator.num_2 = "0"
        calculator.cambiaStato(CalculatorStates.OPERATORE)
        return false
    }

    override fun gestisci_funzione(valore: String): Boolean {
        when(valore) {
            "." -> {
                calculator.num_1 = "0."
                calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_1)
            }
            else -> {}
        }
        return true
    }

    override fun gestisci_numero(valore: String): Boolean {
        calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_1)
        return false
    }

    override fun gestisci_uguale(valore: String): Boolean {
        return true
    }
}
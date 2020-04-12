package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.states

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorState
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.CalculatorStates

class Finale(private val calculator: Calculator) : CalculatorState(calculator) {
    override fun gestisci_operatore(valore: String): Boolean {
        calculator.num_1 = ""
        calculator.cambiaStato(CalculatorStates.OPERATORE)
        return false
    }

    override fun gestisci_funzione(valore: String): Boolean {
        return when(valore) {
            "AC" -> {
                calculator.clear()
                true
            }
            "+/-" -> {
                calculator.num_1 = calculator.num_2
                calculator.num_2 = ""
                calculator.op = ""

                calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_1)
                false
            }
            "." -> {
                if (!calculator.num_1.contains('.')) {
                    calculator.num_1 = calculator.num_2
                    calculator.num_2 = ""
                    calculator.op = ""

                    calculator.cambiaStato(CalculatorStates.ACCUMULA_CIFRE_1)
                    false
                } else
                    true
            }
            else -> true
        }
    }

    override fun gestisci_numero(valore: String): Boolean {
        calculator.clear()
        return false
    }

    override fun gestisci_uguale(valore: String): Boolean {
        calculator.result()
        return true
    }
}

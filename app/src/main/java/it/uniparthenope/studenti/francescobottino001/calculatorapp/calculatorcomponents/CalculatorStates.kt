package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator
import it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents.states.*

enum class CalculatorStates {
    VUOTO {
        override fun instanciate(calculator: Calculator): CalculatorState {
            return Vuoto(
                calculator
            )
        }
    },
    ACCUMULA_CIFRE_1 {
        override fun instanciate(calculator: Calculator): CalculatorState {
            return AccumulaCifre1(
                calculator
            )
        }
    },
    OPERATORE {
        override fun instanciate(calculator: Calculator): CalculatorState {
            return Operatore(
                calculator
            )
        }
    },
    ACCUMULA_CIFRE_2 {
        override fun instanciate(calculator: Calculator): CalculatorState {
            return AccumulaCifre2(
                calculator
            )
        }
    },
    FINALE {
        override fun instanciate(calculator: Calculator): CalculatorState {
            return Finale(
                calculator
            )
        }
    };

    abstract fun instanciate(calculator: Calculator): CalculatorState
}
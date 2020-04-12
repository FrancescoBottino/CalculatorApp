package it.uniparthenope.studenti.francescobottino001.calculatorapp.calculatorcomponents

import it.uniparthenope.studenti.francescobottino001.calculatorapp.Calculator

abstract class CalculatorState(private val calculator: Calculator) {
    fun pressione_tasto(tipo: TipoTasto, valore: String ): Boolean {
        return when( tipo ) {
            TipoTasto.NUMERO -> gestisci_numero(valore)
            TipoTasto.FUNZIONE -> gestisci_funzione(valore)
            TipoTasto.OPERATORE -> gestisci_operatore(valore)
            TipoTasto.UGUALE -> gestisci_uguale(valore)
        }
    }

    abstract fun gestisci_operatore(valore: String): Boolean

    abstract fun gestisci_funzione(valore: String): Boolean

    abstract fun gestisci_numero(valore: String): Boolean

    abstract fun gestisci_uguale(valore: String): Boolean
}
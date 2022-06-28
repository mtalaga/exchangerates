package pl.mt.exchange.provider.openexchangerates

import java.math.BigDecimal
import java.math.RoundingMode

class USDToCurrenciesConverter {

    fun convert(
        usdRates: Map<String, BigDecimal>,
        fromCurrency: String,
        toCurrency: String,
        value: BigDecimal
    ): ConvertResult {
        if (fromCurrency != "USD" && !usdRates.containsKey(fromCurrency)) {
            return ConvertResult.error("Did not found currency from which you would like convert in provided rates")
        }

        if (toCurrency != "USD" && !usdRates.containsKey(toCurrency)) {
            return ConvertResult.error("Did not found currency to which you would like convert in provided rates")
        }

        if (fromCurrency == toCurrency) {
            return ConvertResult.successful(value, fromCurrency)
        }

        if ("USD" == fromCurrency) {
            return ConvertResult.successful(
                value.times(usdRates[toCurrency]!!).setScale(2, RoundingMode.HALF_EVEN),
                toCurrency
            )
        }

        if ("USD" == toCurrency) {
            return ConvertResult.successful(
                value.divide(usdRates[fromCurrency]!!, 2, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN),
                toCurrency
            )
        }

        return ConvertResult.successful(
            value.divide(usdRates[fromCurrency], 2, RoundingMode.HALF_EVEN).times(usdRates[toCurrency]!!)
                .setScale(2, RoundingMode.HALF_EVEN), toCurrency
        )
    }
}

data class ConvertResult(val value: BigDecimal?, val currencyCode: String?, val errorMessage: String?) {
    companion object {
        fun successful(value: BigDecimal, currencyCode: String): ConvertResult {
            return ConvertResult(value, currencyCode, null)
        }

        fun error(errorMessage: String): ConvertResult {
            return ConvertResult(null, null, errorMessage)
        }
    }
}
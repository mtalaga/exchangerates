package pl.mt.exchange.provider

import java.math.BigDecimal

data class ExchangeProviderResponse(val value: BigDecimal?, val currencyCode: String?, val errorMessage: String?) {
    companion object {
        fun successful(value: BigDecimal, currencyCode: String): ExchangeProviderResponse {
            return ExchangeProviderResponse(value, currencyCode, null)
        }

        fun error(errorMessage: String): ExchangeProviderResponse {
            return ExchangeProviderResponse(null, null, errorMessage)
        }
    }
}
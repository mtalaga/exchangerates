package pl.mt.exchange.provider

import pl.mt.exchange.ExchangeRequest
import java.math.BigDecimal

data class ExchangeProviderRequest(val value: BigDecimal, val currencyCodeFrom: String, val currencyCodeTo: String) {
    companion object {
        fun from(exchangeRequest: ExchangeRequest): ExchangeProviderRequest {
            return ExchangeProviderRequest(
                exchangeRequest.value,
                exchangeRequest.currencyFrom,
                exchangeRequest.currencyTo
            )
        }
    }
}
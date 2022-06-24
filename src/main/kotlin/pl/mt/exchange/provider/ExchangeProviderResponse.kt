package pl.mt.exchange.provider

import java.math.BigDecimal

data class ExchangeProviderResponse(val value: BigDecimal, val currencyCode: String) {
}
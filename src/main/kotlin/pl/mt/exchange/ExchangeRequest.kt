package pl.mt.exchange

import java.math.BigDecimal

data class ExchangeRequest(val value: BigDecimal, val currencyFrom: String, val currencyTo: String)
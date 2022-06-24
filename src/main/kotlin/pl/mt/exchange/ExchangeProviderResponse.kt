package pl.mt.exchange

import java.math.BigDecimal

data class ExchangeProviderResponse(val value: BigDecimal, val currency: String)
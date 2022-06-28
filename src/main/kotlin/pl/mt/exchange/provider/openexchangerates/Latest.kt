package pl.mt.exchange.provider.openexchangerates

import java.math.BigDecimal

data class Latest(val timestamp: Number, val base: String, val rates: Map<String, BigDecimal>)
package pl.mt.exchange.provider.openexchangerates

data class Latest(val timestamp: Number, val base: String, val rates: Map<String, Number>)
package pl.mt.exchange.provider.openexchangerates

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(OpenExchangeRatesConfiguration.PREFIX)
@Requires(property = OpenExchangeRatesConfiguration.PREFIX)
data class OpenExchangeRatesConfiguration(val apiUrl: String, val appId: String) {

    companion object {
        const val PREFIX = "openexchangerates"
    }
}
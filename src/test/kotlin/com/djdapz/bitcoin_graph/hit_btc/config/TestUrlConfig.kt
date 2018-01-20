package com.djdapz.bitcoin_graph.hit_btc.config

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.net.URL

@Component
@Profile("test")
class TestUrlConfig() : UrlConfig {
    private val AVAILABLE_PORT = 8901

    override fun getSymbolsUrl(): URL = URL("http://localhost:${AVAILABLE_PORT}/symbol")

    override fun getTickerUrl(): URL = URL("http://localhost:${AVAILABLE_PORT}/ticker")

    override fun getCurrencyUrl(): URL = URL("http://localhost:${AVAILABLE_PORT}/currency")
}
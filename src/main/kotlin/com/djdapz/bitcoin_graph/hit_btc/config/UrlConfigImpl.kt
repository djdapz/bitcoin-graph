package com.djdapz.bitcoin_graph.hit_btc.config

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.net.URL

@Component
@Profile("!test")
class UrlConfigImpl : UrlConfig {
    override fun getCurrencyUrl(): URL = URL("https://api.hitbtc.com/api/2/public/currency")
    override fun getTickerUrl(): URL = URL("https://api.hitbtc.com/api/2/public/ticker")
    override fun getSymbolsUrl(): URL = URL("https://api.hitbtc.com/api/2/public/symbol")
}
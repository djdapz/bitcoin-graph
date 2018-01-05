package com.djdapz.bitcoin_graph.hit_btc.config

import org.springframework.stereotype.Component
import java.net.URL

@Component
class UrlConfigImpl : UrlConfig {
    override fun getTickerUrl(): URL = URL("https://api.hitbtc.com/api/2/public/tickers")
    override fun getSymbolsUrl(): URL = URL("https://api.hitbtc.com/api/2/public/symbols")
}
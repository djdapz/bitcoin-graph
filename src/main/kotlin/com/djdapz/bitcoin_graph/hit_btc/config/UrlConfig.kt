package com.djdapz.bitcoin_graph.hit_btc.config

import java.net.URL

interface UrlConfig {
    fun getSymbolsUrl() : URL
    fun getTickerUrl(): URL
}
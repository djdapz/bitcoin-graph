package com.djdapz.bitcoin_graph.hit_btc.client

import com.djdapz.bitcoin_graph.hit_btc.config.UrlConfig
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import com.djdapz.bitcoin_graph.util.getJsonList
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class HitBtcClient(val restTemplate: RestTemplate, val urlConfig: UrlConfig){
    fun getSymbols(): List<HitBtcSymbol> = getJsonList(restTemplate, urlConfig.getSymbolsUrl().toExternalForm())

    fun getTickers(): List<HitBtcTicker> = getJsonList(restTemplate, urlConfig.getTickerUrl().toExternalForm())
}
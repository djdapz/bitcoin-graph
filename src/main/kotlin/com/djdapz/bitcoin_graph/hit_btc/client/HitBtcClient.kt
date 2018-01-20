package com.djdapz.bitcoin_graph.hit_btc.client

import com.djdapz.bitcoin_graph.hit_btc.config.UrlConfig
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcCurrency
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import com.djdapz.bitcoin_graph.util.getHeaders
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class HitBtcClient(val restTemplate: RestTemplate, val urlConfig: UrlConfig) {

    fun getSymbols(): List<HitBtcSymbol> = restTemplate.exchange(
            urlConfig.getSymbolsUrl().toExternalForm(),
            HttpMethod.GET,
            HttpEntity<Any>(getHeaders()),
            object : ParameterizedTypeReference<List<HitBtcSymbol>>() {}
    ).body

    fun getTickers(): List<HitBtcTicker> = restTemplate.exchange(
            urlConfig.getTickerUrl().toExternalForm(),
            HttpMethod.GET,
            HttpEntity<Any>(getHeaders()),
            object : ParameterizedTypeReference<List<HitBtcTicker>>() {}
    ).body

    fun getCurrencies(): List<HitBtcCurrency> = restTemplate.exchange(
            urlConfig.getCurrencyUrl().toExternalForm(),
            HttpMethod.GET,
            HttpEntity<Any>(getHeaders()),
            object : ParameterizedTypeReference<List<HitBtcCurrency>>() {}
    ).body
}
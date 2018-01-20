package com.djdapz.bitcoin_graph.hit_btc.service

import com.djdapz.bitcoin_graph.graph.domain.CryptoQuote
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker

interface CryptoQuoteService {
    fun getTickersHash(): HashMap<String, HitBtcTicker>
    fun getSymbolsHash(): HashMap<String, HitBtcSymbol>
    fun getTickers(): List<HitBtcTicker>
    fun getSymbols(): List<HitBtcSymbol>
    fun getCurrencies(): List<String>
    fun getCryptoQuotes(): List<CryptoQuote>
}
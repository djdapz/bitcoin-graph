package com.djdapz.bitcoin_graph.hit_btc.service

import com.djdapz.bitcoin_graph.hit_btc.client.HitBtcClient
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import org.springframework.stereotype.Service

@Service
class CryptoQuoteServiceImpl(private val hitBtcClient: HitBtcClient) : CryptoQuoteService {
    override fun getCurrencies(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTickersHash(): HashMap<String, HitBtcTicker> =
            HashMap<String, HitBtcTicker>().apply {
                getTickers().forEach { this.put(it.symbol, it) }
            }

    override fun getSymbolsHash(): HashMap<String, HitBtcSymbol> =
            HashMap<String, HitBtcSymbol>().apply {
                getSymbols().forEach { this.put(it.id, it) }
            }

    override fun getTickers(): List<HitBtcTicker> = hitBtcClient.getTickers()

    override fun getSymbols(): List<HitBtcSymbol> = hitBtcClient.getSymbols()
}
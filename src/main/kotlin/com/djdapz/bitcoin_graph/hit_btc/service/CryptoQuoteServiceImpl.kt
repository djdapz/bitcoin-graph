package com.djdapz.bitcoin_graph.hit_btc.service

import com.djdapz.bitcoin_graph.graph.domain.CryptoQuote
import com.djdapz.bitcoin_graph.hit_btc.client.HitBtcClient
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import org.springframework.stereotype.Service

@Service
class CryptoQuoteServiceImpl(private val hitBtcClient: HitBtcClient) : CryptoQuoteService {
    override fun getCryptoQuotes(): List<CryptoQuote> {
        val symbols = getSymbolsHash()
        return getTickers().map {
            val symbol = symbols.getValue(it.symbol)
            CryptoQuote(
                    ask = it.ask,
                    bid = it.bid,
                    last = it.last,
                    open = it.open,
                    volume = it.volume,
                    timestamp = it.timestamp,
                    symbol = it.symbol,
                    baseCurrency = symbol.baseCurrency,
                    quoteCurrency = symbol.quoteCurrency
            )

        }
    }

    override fun getTickersHash(): HashMap<String, HitBtcTicker> =
            HashMap<String, HitBtcTicker>().apply {
                getTickers().forEach {
                    put(it.symbol, it)
                }
            }

    override fun getSymbolsHash(): HashMap<String, HitBtcSymbol> =
            HashMap<String, HitBtcSymbol>().apply {
                getSymbols().forEach {
                    put(it.id, it)
                }
            }

    override fun getTickers(): List<HitBtcTicker> = hitBtcClient.getTickers()

    override fun getSymbols(): List<HitBtcSymbol> = hitBtcClient.getSymbols()

    override fun getCurrencies(): List<String> = hitBtcClient.getCurrencies().map { it.id }
}
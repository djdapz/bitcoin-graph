package com.djdapz.bitcoin_graph.graph

import com.djdapz.bitcoin_graph.graph.domain.Graph
import com.djdapz.bitcoin_graph.hit_btc.service.CryptoQuoteService
import org.springframework.stereotype.Service

@Service
class GraphService(val cryptoQuoteService: CryptoQuoteService) {

    fun generateGraph(): Graph {
        val graph = Graph(cryptoQuoteService.getCryptoQuotes(), cryptoQuoteService.getCurrencies())

        return graph
    }
}

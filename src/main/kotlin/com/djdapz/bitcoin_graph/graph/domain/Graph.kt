package com.djdapz.bitcoin_graph.graph.domain

class Graph(
        quotes: List<CryptoQuote>,
        currencies: List<String>
) {
    val nodes: HashMap<String, Node> = HashMap()

    init {
        currencies.forEach {
            Node(it).apply {
                nodes.put(it, this)
            }
        }

        quotes.forEach {
            val baseNode = nodes.getValue(it.baseCurrency)
            val quoteNode = nodes.getValue(it.quoteCurrency)

            val baseToQuote = CryptoNodeConnection(quoteNode, it.ask)
            val quoteToBase = CryptoNodeConnection(baseNode, 1 / it.bid)

            baseNode.connections.put(quoteNode.currency, baseToQuote)
            quoteNode.connections.put(baseNode.currency, quoteToBase)
        }
    }

}
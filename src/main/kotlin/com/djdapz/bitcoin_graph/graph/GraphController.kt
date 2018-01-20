package com.djdapz.bitcoin_graph.graph

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GraphController(val graphService: GraphService) {

    @RequestMapping("/graph")
    fun triggerGraphBuild() {
        graphService.generateGraph()
    }


}
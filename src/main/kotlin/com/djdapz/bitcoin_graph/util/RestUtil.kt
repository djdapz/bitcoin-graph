package com.djdapz.bitcoin_graph.util

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate

fun <T> getJsonList(restTemplate: RestTemplate, url: String): List<T> {
    val headers = LinkedMultiValueMap<String, String>()
    headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE)

    return restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(headers), ReturnType<T>()).body
}

fun <T> getJsonObject(restTemplate: RestTemplate, url: String, klass: Class<T>): T {
    val headers = LinkedMultiValueMap<String, String>()
    headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE)
    return restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(headers), klass).body
}




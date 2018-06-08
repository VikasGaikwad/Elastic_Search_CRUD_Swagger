/**
 * 
 */
package com.fundoonotes.searchService;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vikas gaikwad
 *
 */

@Configuration

public class ElasticSearchConfiguration {

	/*
	 * @Value :- Annotation at the field or method/constructor parameter level that
	 * indicates a default value expression for the affected argument.
	 */

	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;
	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;
	/* ======================================================================= */

	/*
	 * RestHighLevelClient :- High level REST client that wraps an instance of the
	 * low level RestClient and allows to build requests and read responses. The
	 * RestClient instance is internally built based on the provided
	 * RestClientBuilder and it gets closed automatically when closing the
	 * RestHighLevelClient instance that wraps it. In case an already existing
	 * instance of a low-level REST client needs to be provided, this class can be
	 * subclassed and the RestHighLevelClient(RestClient, CheckedConsumer, List)
	 * constructor can be used. This class can also be sub-classed to expose
	 * additional client methods that make use of endpoints added to Elasticsearch
	 * through plugins, or to add support for custom response sections, again added
	 * to Elasticsearch through plugins.
	 */
	private RestHighLevelClient restHighLevelClient;

	/* ======================================================================= */
	@Bean
	public RestHighLevelClient buildClient() {
		try {

			/*
			 * RestClient :-Client that connects to an Elasticsearch cluster through HTTP.
			 * Must be created using RestClientBuilder, which allows to set all the
			 * different options or just rely on defaults. The hosts that are part of the
			 * cluster need to be provided at creation time, but can also be replaced later
			 * by calling setHosts(HttpHost).
			 */

			/*
			 * builder() :- Client that connects to an Elasticsearch cluster through HTTP.
			 * Must be created using RestClientBuilder, which allows to set all the
			 * different options or just rely on defaults. The hosts that are part of the
			 * cluster need to be provided at creation time, but can also be replaced later
			 * by calling setHosts(HttpHost).
			 */

			/*
			 * HttpHost():-Creates HttpHost instance with the given scheme, hostname and
			 * port. Parameters: hostname the hostname (IP or DNS name) port the port
			 * number. -1 indicates the scheme default port. scheme the name of the scheme.
			 * null indicates the default scheme
			 */
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		} catch (Exception e) {

		}
		return restHighLevelClient;
	}
	/* ======================================================================= */
}

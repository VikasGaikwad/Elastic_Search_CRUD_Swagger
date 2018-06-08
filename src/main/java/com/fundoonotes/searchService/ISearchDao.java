package com.fundoonotes.searchService;

import java.util.Map;

import org.elasticsearch.search.SearchHits;

/**
 * @author vikas gaikwad
 * @param <T>
 *
 */
public interface ISearchDao<T> {

	/* ======================================================================= */

	Map<String, Object> get(String id);

	/* ======================================================================= */

	Note save(Note note);

	/* ======================================================================= */

	Map<String, Object> update(String id, Note note);

	/* ======================================================================= */

	void delete(String id);

	/* ======================================================================= */

	/*SearchHits searchByIdAndText(String index, String type, Map<String, Object> restrictions, String text,
			Map<String, Float> fields);
*/
	/* ======================================================================= */

}

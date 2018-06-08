/**
 * 
 */
package com.fundoonotes.searchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author vikas gaikwad
 * @param <T>
 *
 */
@Service
public class SearchServiceImpl<T> implements ISearchService {

	@SuppressWarnings("rawtypes")
	@Autowired
	ISearchDao searchDao;
	/* ======================================================================= */

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getNoteById(String id) {
		
		return searchDao.get(id);
	}
	/* ======================================================================= */

	@Override
	public Note insertNote(Note note) {
		searchDao.save(note);
		return null;
	}
	/* ======================================================================= */

	@Override
	public Map<String, Object> updateNoteById(String id, Note note) {
		searchDao.update(id, note);
		return null;
	}
	/* ======================================================================= */

	@Override
	public void deleteNoteById(String id) {
		searchDao.delete(id);
	}
	/* ======================================================================= */

	/*public <T> List<T> searchByIdAndText(String index, String type, Class<T> classType,
			Map<String, Object> restrictions, String text, Map<String, Float> fields) throws JsonParseException, JsonMappingException, IOException  {
		text = "*" + text + "*";

		SearchHits hits = searchDao.searchByIdAndText(index, type, restrictions, text, fields);

		List<T> results = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		for (SearchHit hit : hits) {
			results.add(mapper.readValue(hit.getSourceAsString(), classType));
		}
		
		return results;

	}*/

/*public  Map searchByIdAndText(String text) throws JsonParseException, JsonMappingException, IOException {
	text = "*" + text + "*";
	String index = null; 
	String type = null;
	Class classType = null;
	Map restrictions = null; 
	Map fields = null;
	SearchHits hits = searchDao.searchByIdAndText(index, type, restrictions, text, fields);

	List<T> results = new ArrayList<>();
	ObjectMapper mapper = new ObjectMapper();
	
	for (SearchHit hit : hits) {
		results.add((T) mapper.readValue(hit.getSourceAsString(), classType));
	}
	
	return (Map) results;
}*/

	
}

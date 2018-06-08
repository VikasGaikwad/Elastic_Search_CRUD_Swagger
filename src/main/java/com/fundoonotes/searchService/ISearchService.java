/**
 * 
 */
package com.fundoonotes.searchService;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author vikas gaikwad
 * @param <T>
 *
 */
@Repository
public interface ISearchService<T> {
	
	/* ======================================================================= */
	
	Map<String, Object> getNoteById(String id);

	/* ======================================================================= */
	
	Note insertNote(Note note);

	/* ======================================================================= */
	
	Map<String, Object> updateNoteById(String id, Note note);

	/* ======================================================================= */
	
	void deleteNoteById(String id);
	
	/* ======================================================================= */
	
	/*Map<String, Object> searchByIdAndText(String index, String type, Class<T> classType,
			Map<String, Object> restrictions, String text, Map<String, Float> fields);*/


//	Map searchByIdAndText(String text) throws JsonParseException, JsonMappingException, IOException;

	
	
	/* ======================================================================= */
}

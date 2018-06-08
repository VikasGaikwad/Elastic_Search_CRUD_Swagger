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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author vikas gaikwad
 *
 */
@RestController
@RequestMapping("/note")
@Api(value="onlinestore", description="CRUD operations for elastic search")
public class SearchController {

	@Autowired
	ISearchService searchService;
	@Autowired
	ISearchDao searchDao;
	/* ======================================================================= */
	public SearchController(ISearchService searchService) {
		this.searchService = searchService;
	}

	/* ======================================================================= */
	@GetMapping("/get/{id}")
	@ApiOperation(value = "Find student by id",
    notes = "Also returns a link to retrieve all notes with rel - all-notes")
	public Map<String, Object> getNoteById(@PathVariable String id) {
		return searchService.getNoteById(id);
	}

	/* ======================================================================= */
	@PostMapping("/post")
	public Note insertNote(@RequestBody Note note) throws Exception {
		
		return searchService.insertNote(note);
	}
	/* ======================================================================= */

	@PutMapping("update/{id}")
	public Map<String, Object> updateNoteById(@RequestBody Note note, @PathVariable String id) {
		return searchService.updateNoteById(id, note);
	}
	/* ======================================================================= */
	
	@DeleteMapping("/delete/{id}")
	public void deleteNoteById(@PathVariable String id) {
		searchService.deleteNoteById(id);
	}
	/* ======================================================================= */
	/*@GetMapping("/get/{text}")
	public Map<String, Object> searchByIdAndText(@PathVariable String text) throws JsonParseException, JsonMappingException, IOException {
		return searchService.searchByIdAndText(text);
	}
	*/

}

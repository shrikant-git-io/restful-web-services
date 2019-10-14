package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	/**
	 * filter few fields of SomeBean based on incoming request in the output
	 * @return
	 */
	@GetMapping("/dynamicFiltering")
	public MappingJacksonValue dynamicFiltering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value1");
		
		//3. define filter
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		//2. provide filter to provider, SomeBeanFilterId needs to be configured on Bean
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilterId", filter);
		//1. add filter and bean to be filtered
		MappingJacksonValue mapping= new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
		
	}

}

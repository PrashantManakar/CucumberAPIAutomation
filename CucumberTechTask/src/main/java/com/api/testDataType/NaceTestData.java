/**
 * 
 */
package com.api.testDataType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is POJO class to map JSON file
 * 
 * @author Prashant Mankar
 *
 */
public class NaceTestData {
	@JsonProperty("Order")
	public int order;
	@JsonProperty("Level")
	public int level;
	@JsonProperty("Code")
	public String code;
	@JsonProperty("Parent")
	public String parent;
	@JsonProperty("Description")
	public String description;
	@JsonProperty("This item includes")
	public String thisItemIncludes;
	@JsonProperty("This item also includes")
	public String thisItemAlsoIncludes;
	@JsonProperty("Rulings")
	public String rulings;
	@JsonProperty("This item excludes")
	public String thisItemExcludes;
	@JsonProperty("Reference to ISIC Rev. 4")
	public String referenceToISICRev4;
}

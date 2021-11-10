package com.regram.ai.data.database

data class We (
	val weather : List<Weather>,
	val base : String,
	val main : Main,
//	@SerializedName("visibility") val visibility : Int,
//	@SerializedName("wind") val wind : Wind,
	val clouds : Clouds
//	@SerializedName("dt") val dt : Int,
//	@SerializedName("sys") val sys : Sys,
//	@SerializedName("timezone") val timezone : Int,
//	@SerializedName("id") val id : Int
//	@SerializedName("name") val name : String,
//	@SerializedName("cod") val cod : Int
)
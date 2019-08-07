package com.pcsell.vo;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Photo {

	private String pcCode;
	private String userFileName;
	private String savedFileName;
	private Product product;
}

package com.pcsell.mapper; 

import java.util.List;
import java.util.Map;

import com.pcsell.vo.Upload;
import com.pcsell.vo.UploadFile;


public interface CartMapper {
	
	List<Upload> count();

	List<Upload> findCheckList();

}
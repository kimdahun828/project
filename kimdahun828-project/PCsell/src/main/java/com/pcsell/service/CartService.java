package com.pcsell.service;

import java.util.List;

import com.pcsell.vo.Upload;
import com.pcsell.vo.UploadFile;

public interface CartService {

	List<Upload> count();

	List<Upload> findCheckList();

}
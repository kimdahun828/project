package com.pcsell.dao;

import java.util.ArrayList;
import java.util.List;

import com.pcsell.vo.Upload;
import com.pcsell.vo.UploadFile;

public interface CartDao {

	ArrayList<Upload> count(); // list 총 합계권수

	ArrayList<Upload> findCheckList();
}

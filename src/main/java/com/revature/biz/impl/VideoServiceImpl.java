package com.revature.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.VideoService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.VideoDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.vo.VideoVO;

@Service
public class VideoServiceImpl implements VideoService {
  @Autowired
  private VideoDAO videoDAO;

  @Override
  public List<VideoVO> doGetVideos() throws BusinessServiceException {
    try {
      return videoDAO.getVideos();
    } catch (DataServiceException e) {
      throw new BusinessServiceException(e.getMessage(), e);
    }
  }
}

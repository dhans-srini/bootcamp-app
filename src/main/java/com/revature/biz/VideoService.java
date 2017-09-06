package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.vo.VideoVO;

/**
 * Created on 05/09/2017
 */
public interface VideoService {
  /**
   * To get active videos.
   * 
   * @return {@link List}
   * @throws BusinessServiceException
   */
  List<VideoVO> doGetVideos() throws BusinessServiceException;
}

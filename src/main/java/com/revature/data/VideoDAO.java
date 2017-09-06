package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.vo.VideoVO;

/**
 * Created on 05/09/2017
 */
public interface VideoDAO {
  /**
   * To get active videos.
   * 
   * @return {@link List}
   * @throws DataServiceException
   */
  List<VideoVO> getVideos() throws DataServiceException;
}

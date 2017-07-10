package com.audio.electric.service;

import com.audio.electric.domain.Picture;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/6 0006 15:50
 */
public interface IPictureService {
    List<Picture> listBackground();

    int savePicture(Picture picture);

    Picture getPictureById(Integer id);
}

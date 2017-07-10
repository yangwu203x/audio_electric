package com.audio.electric.service.impl;

import com.audio.electric.domain.Picture;
import com.audio.electric.domain.PictureExample;
import com.audio.electric.mapper.PictureMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IPictureService;
import com.audio.electric.util.enums.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/6 0006 15:50
 */
@Component
public class PictureServiceImpl extends BaseService implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> listBackground() {
        try {
            return pictureMapper.selectByExample(new PictureExample());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int savePicture(Picture picture) {
        try {
            picture.setUpdateDate(new Date());
            return pictureMapper.insertSelective(picture);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return RetCode.FAILED.getCode();
    }

    @Override
    public Picture getPictureById(Integer id) {
        try {
            return pictureMapper.selectByPrimaryKey(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

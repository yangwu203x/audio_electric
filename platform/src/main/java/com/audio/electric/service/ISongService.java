package com.audio.electric.service;

import com.audio.electric.domain.Song;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/3 0003 10:21
 */
public interface ISongService {
    Song findSingleSong(Song song);

    int updateSong(Song song);

    int addSong(Song song);

    List<Song> rankList();

    int deleteSong(String ids);

    int updateStatus(Song song);

    List<String> autoSearch(Song song);

    List<String> obtainSongIdByName(Song song);

    List<Song> listSong(Song song);

    List<Song> listAllSong();

    Object addSongList(MultipartFile excelFile);

    void exportSong(OutputStream output);
}

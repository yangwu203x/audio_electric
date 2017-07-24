package com.audio.electric.service;

import com.audio.electric.domain.Singer;
import com.audio.electric.service.impl.SingerServiceImpl;
import com.audio.electric.service.impl.SongServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/12 0012 10:25
 */
public class InSertThread implements Runnable{
    private List<Map<Integer,Object>> tempList;
    private SingerServiceImpl singerService;

    public InSertThread(List<Map<Integer, Object>> tempList ,SingerServiceImpl singerService) {
        this.tempList = tempList;
        this.singerService = singerService;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < tempList.size(); i++) {
//                System.out.println(Thread.currentThread() + "=============" + i +  "==========" + tempList.get(i).toString());
                String singerName = "" +  tempList.get(i).get(0);
                String singerType = "" + tempList.get(i).get(1);
                String singerPinyin = "" + tempList.get(i).get(2);
                String orderTime = ""+ tempList.get(i).get(3);
                String singerZs = "" +  tempList.get(i).get(4);
                String header_path = "" +  tempList.get(i).get(5);
                String singerVersion = "" +  tempList.get(i).get(6);
//                System.out.println(singerName + "=" + singerType + "=" + singerPinyin + "=" + orderTime + "=" + singerZs + "=" + header_path + "=" + singerVersion);
                Singer singer = new Singer();
                singer.setSingerName(singerName);
                singer.setSingerZs(Double.valueOf(singerZs).intValue());
                singer.setHeaderPath(header_path.split("/")[1]);
                singer.setPrefixPath("/opt/vodfile/image/");
                singer.setServerUrl("http://192.168.1.254:8085/file/getFileByPath?path=");
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String [] strs = singerVersion.split("-");
                strs[1] = SongServiceImpl.formatDigit2(strs[1]);
                singerVersion = strs[0] +"-" + strs[1] + "-" + strs[2];
                singer.setSingerVersion(df.parse(singerVersion));
                singer.setSingerOdertimes(Double.valueOf(orderTime).intValue());
                singer.setSingerPinyin(singerPinyin);
                singer.setSingerType(formatSingerType(Double.valueOf(singerType).intValue())+"");
//                System.out.println(singer.toString());
                singerService.addOrUpdateSinger(singer);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * enter表中歌手类型转换为appserver表中的歌手类型
     * @param singerType
     * @return
     */
    public static int formatSingerType(int singerType){
        if (singerType == 1)
            singerType = 11;
        if (singerType == 2)
            singerType = 14;
        if (singerType == 3)
            singerType = 15;
        if (singerType == 4)
            singerType = 17;
        if (singerType == 5)
            singerType = 13;
        if (singerType == 6)
            singerType = 16;
        if (singerType == 7)
            singerType = 18;
        if (singerType == 8)
            singerType = 19;
        if (singerType == 9)
            singerType = 12;
        if (singerType == 10)
            singerType = 20;
        if (singerType == 11)
            singerType = 140;
        if (singerType == 12)
            singerType = 141;
        if (singerType == 13)
            singerType = 142;
        return singerType;
    }
}

package org.yida.attendanceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import position.utils.BaiDuMapUtil;

@RestController
public class TestController {
    @RequestMapping("/getName")
    public String getName(){
        return "Hello SpringBoot";
    }
    @RequestMapping("/testBaiDuMap")
    public void testBaiDuMap(){
        String lat="31.931349213122";
        String lng="120.96189745647";

        //  System.out.println(System.getProperty("file.encoding"));
        BaiDuMapUtil baiDuMapUtil=new BaiDuMapUtil();
        try {
            String s=baiDuMapUtil.getPositionByLongitude(lng, lat);
            System.out.println(s);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package me.piebridge;

import org.testng.annotations.Test;

/**
 * Created by Liu DongMiao &lt;liudongmiao@gmail.com&gt; on 2016/04/29.
 *
 * @author thom
 */
public class IctclasSegmentationTest {

    @Test
    public void parse() {
        Segmentation segmentation = new IctclasSegmentation();
        segmentation.addUserWord("工信处");
        segmentation.addUserWord("女干事");
        System.out.println(segmentation.parse("工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", true));
    }

}

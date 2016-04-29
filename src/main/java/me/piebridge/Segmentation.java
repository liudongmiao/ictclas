package me.piebridge;

/**
 * Created by Liu DongMiao &lt;liudongmiao@gmail.com&gt; on 2016/04/29.
 *
 * @author thom
 */
public interface Segmentation {

    String USER_DEFINE = "x";

    void addUserWord(String userWord);

    String parse(String paragraph, boolean showNature);

}

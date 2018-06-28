package com.piratebrook.algorithm;

/**
 * @Author Pirate Brook
 * @Data 2018/6/28
 */
public interface IBlockView {

    void startAnimation();

    void pauseAnimation();

    void resumeAnimation();

    void stopAnimation();

    void toProgress(float progress);
}

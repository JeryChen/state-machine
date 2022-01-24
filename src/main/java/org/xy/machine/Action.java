package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <动作>
 * 到达某个状态之后，可以做什么
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Action<S, E, C> {

    /**
     * 执行任务
     *
     * @param from    来源状态
     * @param to      目标状态
     * @param event   事件
     * @param context 上下文信息
     */
    void execute(S from, S to, E event, C context);
}

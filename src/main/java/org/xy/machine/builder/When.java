package org.xy.machine.builder;

import org.xy.machine.Action;

/**
 * <功能介绍><br>
 * <p>
 * <"当"子句生成器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface When<S, E, C> {

    /**
     * 定义过渡期间要执行的操作
     *
     * @param action 执行的动作
     */
    void perform(Action<S, E, C> action);
}

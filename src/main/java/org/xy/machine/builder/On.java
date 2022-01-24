package org.xy.machine.builder;

import org.xy.machine.Condition;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface On<S, E, C> extends When<S, E, C> {

    /**
     * 为过渡添加条件
     *
     * @param condition 过渡条件
     *
     * @return 当子句生成器
     */
    When<S, E, C> when(Condition<C> condition);
}

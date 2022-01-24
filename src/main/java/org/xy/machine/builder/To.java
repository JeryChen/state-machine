package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <"到"子句生成器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface To<S, E, C> {

    /**
     * 构建过度事件
     *
     * @param event 过度事件
     *
     * @return 关于子句生成器
     */
    On<S, E, C> on(E event);
}
